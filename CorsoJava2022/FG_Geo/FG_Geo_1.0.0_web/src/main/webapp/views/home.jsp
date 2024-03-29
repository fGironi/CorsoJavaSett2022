<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- jQuery -->
	<script  src="https://code.jquery.com/jquery-3.6.3.min.js"  integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="  crossorigin="anonymous"></script>
	<!-- Bootstrap --> 
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script> 
	<!-- jQuery UI -->
	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.min.js"  integrity="sha256-eTyxS0rkjpLEo16uXTS0uVCS4815lc40K2iVpWDvdSY=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<!-- Fontawesome -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<!-- fireAjax -->
	<script src="static/js/fireAjax.js"></script>
	<style>
		body {
		background: powderblue;
		}
		body.background {
		opacity: -2;
		}
		html {
		background-image: url("https://img.freepik.com/free-vector/gorgeous-clouds-background-with-blue-sky-design_1017-25501.jpg?w=1380&t=st=1674827139~exp=1674827739~hmac=2f28911ca22780d757c4dd127f0debd26a2eda34f6312492675fcc70eafdd00f");
		background-size: cover;
		background-repeat: no-repeat;
		}
		
	</style>
	
	
	<title>FG_Meteo</title>
</head>
<body>
	<div class="clearfix" style="margin: 15px">
		<div class="row">
			<div class="col-md-12 text-center">
				<h1>App meteo</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<select id="reg_select" class="form-select" aria-label="default Selezione Regioni">
					<option selected>Seleziona una regione</option>
				</select>
			</div>
			<div class="col-sm-3">
				<select id="pro_select" class="form-select" aria-label="Selezione province">
				  <option selected>Seleziona una provincia</option>
				  
				</select>
			</div>
			<div class="col-sm-3">
				<select id="com_select" class="form-select" aria-label="Selezione comuni">
				  <option selected>Seleziona un comune</option>
				  
				</select>
			</div>
			<div class="col-sm-3"></div>
		</div>	
		<div class="row text-center" style="margin: 20px">
			<div class="col-sm-9">
				<div class="ui-widget">
  					<input type="text" class="form-control" id="autoCom_select" placeholder="inserisci il comune..." autocomplete="off"></select>
				</div>
			</div>
			<div class="col-sm-3">
				<button type="button" id="btnPrevisioni" class="btn btn-lg btn-primary">Previsioni</button>
			</div>
		</div>
		<div class="row text-center" style="margin: 20px">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<table id="previsioniTab" class="table table-light table-striped table-bordered">
					
				</table>
			</div>
			<div class="col-sm-2"></div>
		</div>
		
		
		
	</div>
</body>
<script>
var istat;
$(document).ready(function(){
	$("#btnPrevisioni").prop("disabled", true);
	var listaReg;
	listaReg=fire_ajax_get("/FG_Geo_1.0.0_ms/listaRegioni");
	listaReg.regioni.forEach(function(regione) {
	    $("#reg_select").append(new Option(regione.nome, regione.id));
	});
	
	$("#autoCom_select").autocomplete({
	      source: function( request, response ) {
	        $.ajax( {
	          url: "/FG_Geo_1.0.0_ms/listaComuniAuto",
	          contentType: "application/json",
	          data: {
	            term: request.term
	          },
	          success: function( data ) {
	            response( data.nomiComuni );
	          }
	        } );
	      },
	      minLength: 2,
	      select: function( event, ui ) {
	    	$("#btnPrevisioni").prop("disabled", false);
	    	istat=ui.item.id;
	      }
	});
});
	
$("#reg_select").change(function(){
	var idReg=$("#reg_select").val();
	var listaProv;
	$("#pro_select").empty();
	$("#pro_select").append(new Option("Seleziona una provincia", null));
	listaProv=fire_ajax_get("/FG_Geo_1.0.0_ms/listaProvince?idReg="+idReg)
	listaProv.province.forEach(function(provincia) {
	    $("#pro_select").append(new Option(provincia.nome, provincia.sigla));
	});
})
$("#pro_select").change(function(){
	var siglaProv=$("#pro_select").val();
	var listaComuni;
	$("#com_select").empty();
	$("#com_select").append(new Option("Seleziona un comune", null));
	listaComuni=fire_ajax_get("/FG_Geo_1.0.0_ms/listaComuni?siglaProv="+siglaProv)
	listaComuni.comuni.forEach(function(comune) {
	    $("#com_select").append(new Option(comune.nome+"("+comune.siglaProv+")", comune.istat));
	});
})

$("#com_select").change(function(){
	istat=$("#com_select").val();
	$("#btnPrevisioni").prop("disabled", false);
})
	
$("#btnPrevisioni").click(function(){
	var previsioni=fire_ajax_get("/FG_Geo_1.0.0_ms/previsioni?istat="+istat);
	var iconaMeteo;
	var html="<tbody><tr><th><i class='fa-regular fa-calendar'></i> Giorno</th><th><i class='fa-solid fa-cloud-sun'></i> Previsioni</th><th><i class='fa-solid fa-temperature-arrow-up'></i> Temp max(C°)</th><th><i class='fa-solid fa-temperature-arrow-down'></i> Temp min(C°)</th><th><i class='fa-solid fa-umbrella'></i> Precipitazioni(mm)</th></tr>"
	
	previsioni.previsioni.forEach(function(previsione){
		if (previsione.weathercode==0 || previsione.weathercode==1) iconaMeteo="<i class='fa-solid fa-sun'></i> soleggiato";
		else if (previsione.weathercode==2 || previsione.weathercode==3) iconaMeteo="<i class='fa-solid fa-cloud'></i> nuvoloso";
		else if (previsione.weathercode<60) iconaMeteo="<i class='fa-solid fa-smog'></i> nebbia";
		else if (previsione.weathercode<70) iconaMeteo="<i class='fa-solid fa-cloud-rain'></i> pioggia";
		else if (previsione.weathercode<80) iconaMeteo="<i class='fa-regular fa-snowflake'></i> neve"
		else if (previsione.weathercode<85) iconaMeteo="<i class='fa-solid fa-cloud-showers-heavy'></i> rovesci";
		else if (previsione.weathercode<90) iconaMeteo="<i class='fa-solid fa-cloud-meatball'></i> bufera";
		else iconaMeteo="<i class='fa-solid fa-cloud-bolt'> temporale</i>";
		
		html=html+"<tr><td>"+previsione.time+"</td><td>"+iconaMeteo+"</td><td>"+previsione.temperature_2m_max+"</td><td>"+previsione.temperature_2m_min+"</td><td>"+previsione.rain_sum+"</td></tr>";
	})
	html=html+"</tbody>";
	$("#previsioniTab").empty();
	$("#previsioniTab").append(html);
})
	

</script>

</html>