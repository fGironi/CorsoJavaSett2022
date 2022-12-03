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
	'KABUL','TIRANA','ALGERI','LA VELLA','LUANDA','SAINT JOHN\'S','RIAD',	'BUENOS AIRES',	'EREVAN','CANBERRA','VIENNA','BAKU','NASSAU',
	'MANAMA','DACCA','BRIDGETOWN','BRUXELLES','BELMOPAN','PORTO NOVO',	'THIMPHU',	'MINSK',	'SUCRE',	'LA PAZ',	'SARAJEVO',	'GABORONE',	'BRASILIA',	'BANDAR SERI BEGAWAN',
	'SOFIA',	'OUAGADOUGOU',	'GITEGA',	'PHNOM PENH',	'YAOUNDE',	'OTTAWA',	'PRAIA',	'PRAGA',	'BANGUI',	'N\'DJAMENA',	'SANTIAGO',
	'PECHINO',	'NICOSIA',	'BOGOTA',	'MORONI',	'BRAZZAVILLE',	'KINSHASA',	'PYONGYANG',	'SEUL',	'YAMOUSSOUKRO',	'SAN JOSE',	'ZAGABRIA',	'L\'AVANA',	'COPENAGHEN',	'ROSEAU',	'SANTO DOMINGO',
	'QUITO',	'IL CAIRO',	'SAN SALVADOR',	'ABU DHABI',	'ASMARA',	'TALLINN',	'ADDIS ABEBA',	'SUVA',	'MANILA',	'HELSINKI',	'PARIGI',	'LIBREVILLE',	'BANJUL',	'TBILISI',	'BERLINO',	'ACCRA',
	'KINGSTON',	'TOKYO',	'GIBUTI',	'AMMAN',	'ATENE',	'SAINT GEORGE\'S',	'CITTA DEL GUATEMALA',	'CONAKRY',	'BISSAU',	'MALABO',	'GEORGETOWN',	'PORT AU PRINCE',	'TEGUCIGALPA',
	'NUOVA DELHI',	'GIACARTA',	'TEHERAN',	'BAGHDAD',	'DUBLINO',	'REYKJAVIK',	'MAJURO',	'GERUSALEMME',	'ROMA',	'NAIROBI',	'ASTANA',	'BISKEK',	'TARAWA SUD',	'AL KUWAIT',
	'VIENTIANE',	'MASERU',	'RIGA',	'BEIRUT',	'MONROVIA',	'TRIPOLI',	'VADUZ',	'VILNIUS',	'LUSSEMBURGO',	'SKOPJE',	'ANTANANARIVO',	'LILONGWE',	'KUALA LUMPUR',	'MALE',	'BAMAKO',
	'LA VALLETTA',	'RABAT',	'NOUAKCHOTT',	'PORT LOUIS',	'CITTA DEL MESSICO',	'PALIKIR',	'CHISINAU',	'MONACO',	'ULAN BATOR',	'PODGORICA',	'MAPUTO',	'WINDHOEK',	'KATMANDU',	'MANAGUA',
	'NIAMEY',	'ABUJA',	'OSLO',	'WELLINGTON',	'MASCATE',	'AMSTERDAM',	'ISLAMABAD',	'NGERULMUD',	'RAMALLAH',	'PORT MORESBY',	'ASUNCION',	'LIMA',	'VARSAVIA',	'LISBONA',	'DOHA',	'LONDRA',
	'BUCAREST',	'KIGALI',	'HONIARA',	'APIA',	'SAN MARINO',	'CASTRIES',	'DAKAR',	'SAO TOME',	'BELGRADO',	'VICTORIA',	'FREETOWN',	'SINGAPORE',	'DAMASCO',	'BRATISLAVA',	'LUBIANA',	'MOGADISCIO',	'MADRID',
	'SRI JAYAWARDENAPURA',	'WASHINGTON',	'BLOEMFONTEIN',	'CITTA DEL CAPO',	'PRETORIA',	'KHARTUM',	'GIUBA',	'PARAMARIBO',	'STOCCOLMA',	'BERNA',	'MBABANE',
	'DUSANBE',	'DODOMA',	'BANGKOK',	'DILI',	'LOME',	'NUKU\'ALOFA',	'PORT OF SPAIN',	'TUNISI',	'ANKARA',	'ASGABAT',	'FUNAFUTI',	'KIEV',	'KAMPALA',
	'BUDAPEST',	'MONTEVIDEO',	'TASHKENT',	'PORT VILA',	'CITTA DEL VATICANO',	'CARACAS',	'HANOI',	'SANA\'A',	'LUSAKA',	'HARARE'
	]
	
const lisTest =[
	'TEST TEST',
	'ALL\'ORA'	
]

$("#genera").click(function(){
	
	lettereIndovinate=0;
	errori=0;
	$("*[id*=vita]").attr('class', 'fa-solid fa-heart');
	$("*[id*=lLet]").attr('class', 'btn btn-light');
	$("#scegliLet").prop("disabled",false);
	$("*[id*=pLet]").prop("disabled",false);
	if (modScelta==="parola") {
		parolaScelta = lisPar[Math.floor(Math.random() * lisPar.length)];

		}
		
	if (modScelta==='capitale') {
		parolaScelta = lisCap[Math.floor(Math.random() * lisCap.length)];

		}
	if (modScelta==='dragonball') {
		parolaScelta = lisDB[Math.floor(Math.random() * lisDB.length)];

		}
		
	if (modScelta==='test') {
		parolaScelta = lisTest[Math.floor(Math.random() * lisTest.length)];

		}

	var htmlStr="<table class=\"spazioParola\"><tr>";
	for (var i=0; i<parolaScelta.length; i++ ){
		var rndC= parolaScelta.charAt(i);
		if (rndC===' ') {
			htmlStr+="<td border=\"1px, solid, black\" class=\"spazioLet\" id=\"seg"+i+"\">_</td>";
			lettereIndovinate++;
		} 
		else htmlStr+="<td border=\"1px, solid, black\" class=\"spazioLet\"> <h2 id=\"seg"+i+"\" class=\"letSegr\">"+rndC+"</h2> </td>"
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
					
					var idLetDaMostrare="seg"+i;
					$("*[id=" + idLetDaMostrare + "]").show();
					letIndovinata=true;
					lettereIndovinate++;
				}
				
			}
				
		var butDaColorare="lLet"+letScelta;		
		var butDaSpegnere="pLet"+letScelta;
		if (letIndovinata===true){
			$("*[id*=" + butDaColorare + "]").attr('class', 'btn btn-success');
		}
		if (letIndovinata===false){
			$("*[id*=" + butDaColorare + "]").attr('class', 'btn btn-danger')
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
			alert("niente più vite, hai perso! la parola era "+parolaScelta)
			$("#scegliLet").prop("disabled",true);
		}
		}
		
	});
	
	
	});