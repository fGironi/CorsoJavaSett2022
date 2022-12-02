$(document).ready(function () {
	var modScelta;
	var parolaScelta;
	var lettereIndovinate;
	var errori;
	$("#mode").change(function () {
		modScelta = $("#mode option:selected").val();
		//alert("Hai scelto la modalita' " + modScelta);
	});

const lisPar = [
	'PROVA',
	'TENTATIVO',
	'INDOVINARE',
	'BARBAGIANNI',
	'COPIA',
	'ASTERISCO',
	'COMPLIMENTI',
	'LINGUAGGIO',
	'IDEA'
	]
	
const lisDB = [
	'GOKU',
	'VEGETA',
	'PICCOLO',
	'GOHAN',
]

const lisCap =[
	'ROMA',
	'PARIGI',
	'LONDRA',
	'DUBLINO',
	'MADRID',
	'PECHINO',
	]

$("#genera").click(function(){
	
	lettereIndovinate=0;
	errori=0;
	var spazioPar;
	if (modScelta==="parola") {
		parolaScelta = lisPar[Math.floor(Math.random() * lisPar.length)];

		}
		
	if (modScelta==='capitale') {
		parolaScelta = lisCap[Math.floor(Math.random() * lisCap.length)];
;
		}
	if (modScelta==='dragonball') {
		parolaScelta = lisDB[Math.floor(Math.random() * lisDB.length)];
;
		}

	var htmlStr="<table class=\"spazioParola\"><tr>";
	for (var i=0; i<parolaScelta.length; i++ ){
		var rndC= parolaScelta.charAt(i);
		if (rndC===' ') {
			htmlStr+="<td border=\"1px, solid, black\" class=\"spazioLet\" id=\"let"+i+"\"> </td>";
		} 
		else htmlStr+="<td border=\"1px, solid, black\" class=\"spazioLet\"> <h2 id=\"let"+i+"\" class=\"letSegr\">"+rndC+"</h2> </td>"
	}
	htmlStr+=" </tr></table>";
	$("#parolaRnd").html(htmlStr);
	$(".letSegr").hide();
})
	$("#scegliLet").click(function(){
		var letScelta=$("input[name='letter']:checked").val();
		var letIndovinata=false;
		if (letScelta.length<1) {alert("Scegli una lettera per continuare!");}
		else {
			for (var i=0; i<parolaScelta.length; i++){
				var letPar=parolaScelta.charAt(i);
				if (letPar===letScelta){
					
					var idLetDaMostrare="let"+i;
					$("*[id*=" + idLetDaMostrare + "]").show();
					letIndovinata=true;
					lettereIndovinate++;
				}
				
			}
				
		var butDaSpegnere="let"+letScelta;
		if (letIndovinata===true){
			$("*[id*=" + butDaSpegnere + "]").attr('class', 'btn btn-success');
		}
		if (letIndovinata===false){
			$("*[id*=" + butDaSpegnere + "]").attr('class', 'btn btn-danger')
			errori++;
			var vitaDaTogliere="vita"+errori;
			$("*[id*=" + vitaDaTogliere + "]").attr('class', 'fa-regular fa-heart');
		}
		$("*[id*=" + butDaSpegnere + "]").prop("disabled",true);
		
		if (lettereIndovinate===parolaScelta.length){
			alert("hai vinto!");
			$("#scegliLet").prop("disabled",true);
		}
		if (errori===7){
			alert("niente più vite, hai perso!")
			$("#scegliLet").prop("disabled",true);
		}
		}
		
	});
	
	
	});