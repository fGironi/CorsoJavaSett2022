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
	<!-- Bootstrap Autocomplete -->
	<script src="https://cdn.jsdelivr.net/gh/xcash/bootstrap-autocomplete@v2.3.7/dist/latest/bootstrap-autocomplete.min.js"></script>
	<!-- Fontawesome -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<!-- fireAjax -->
	<script src="static/js/fireAjax.js"></script>
	
	<title>FG_Meteo</title>
</head>
<body>
	<div class="clearfix" style="margin: 15px; background-color: lightblue">
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
				<input class="form-control" id="autoCom_Select" placeholder="inserisci il comune..."  list="opzioniComuni" autocomplete="off"></select>
				<datalist id="opzioniComuni">
				</datalist>
			</div>
			<div class="col-sm-3">
				<button type="button" class="btn btn-lg btn-primary">Previsioni</button>
			</div>
		</div>
	</div>
</body>
<script>
$(document).ready(function(){
	var listaReg;
	listaReg=fire_ajax_get("http://localhost:8080/FG_Geo_1.0.0_ms/listaRegioni");
	listaReg.regioni.forEach(function(regione) {
	    $("#reg_select").append(new Option(regione.nome, regione.id));
	});
		
	$("#reg_select").change(function(){
		var idReg=$("#reg_select").val();
		var listaProv;
		listaProv=fire_ajax_get("http://localhost:8080/FG_Geo_1.0.0_ms/listaProvince?idReg="+idReg)
		listaProv.province.forEach(function(provincia) {
		    $("#pro_select").append(new Option(provincia.nome, provincia.sigla));
		});
	})
	$("#pro_select").change(function(){
		var siglaProv=$("#pro_select").val();
		var listaComuni;
		listaComuni=fire_ajax_get("http://localhost:8080/FG_Geo_1.0.0_ms/listaComuni?siglaProv="+siglaProv)
		listaComuni.comuni.forEach(function(comune) {
		    $("#com_select").append(new Option(comune.nome+"("+comune.siglaProv+")", comune.istat));
		});
	})
	
	$("#autoCom_select").keydown(function(){
		var autoListaComuni;
		var input=$("#autoCom_select").val();
		autoListaComuni=fire_ajax_get("http://localhost:8080/FG_Geo_1.0.0_ms/listaComuniAuto?input="+input)
		autoListaComuni.comuni.forEach(function(comune) {
		    $("#opzioniComuni").append(new Option(comune.nome+"("+comune.siglaProv+")", comune.istat));
		});
	})
});
</script>

</html>