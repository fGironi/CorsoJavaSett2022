$(document).ready(function () {
	$("#streakPuls").hide();
	var modScelta;
	var possibiliParole;
	var parolaScelta;
	var lettereIndovinate;
	var errori;
	var letTentate;
	var streak;
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
	
const lisDisney = [
	'ABU', 'ADE', 'HERCULES', 'ALADDIN', 'AKELA', 'ALICE', 'ANACLETO', 'ANNA', 'ARIEL', 'AURORA', 'BAGHERA', 'BALOO', 'BAMBI',
	'BASIL', 'BAYMAX', 'BESTIA', 'BIAGIO', 'BIANCA', 'BERNIE', 'BIANCANEVE', 'BIANCONIGLIO', 'BIZET', 'BOLLY BONES', 'BRUCALIFFO', 'UNCINO', 'CENERENTOLA', 'CHICKEN LITTLE',
	'CLAYTON', 'CRUDELIA DE MON', 'DUCHESSA', 'ELSA', 'ESMERALDA', 'FEBO', 'FATA AZZURRA', 'FATA SMEMORINA',
	'FIDO', 'FILOTTETE', 'FLOUNDER', 'FLYNN RIDER', 'FRA TUCK', 'GAS', 'GASTON', 'HANS', 'IAGO', 'IH OH', 'JAFAR', 'JANE', 'JIM HAWKINS', 'JOHN SMITH', 'KAA', 'KALA', 'KERCHAK', 'KRONK',
	'KUZKO', 'LADY MARIAN', 'LILO', 'LILLI', 'LITTLE JOHN', 'LOUIS', 'LUMIERE', 'LUCIGNOLO', 
	'GEPPETTO', 'MERLINO', 'MALEFICA', 'MANGIAFUOCO', 'MATISSE', 'MAUI', 'MEGARA', 'MINOU', 'MOWGLI', 'MUFASA', 'MULAN', 'MUSHU', 'NALA', 'OLAF',
	'OLIVER', 'PEGGY', 'PETER PAN', 'POCAHONTAS', 'PONGO', 'FILIPPO', 'JASMINE', 'GIOVANNI', 'PUMBAA', 
	'QUASIMODO', 'RALPH', 'GRIMILDE', 'ROBIN HOOD', 'ROMEO', 'SEBASTIAN', 'SEMOLA', 'SHERE KHAN', 'SIMBA', 'STITCH', 'SPUGNA', 'TARZAN', 'TARON', 'TAMBURINO', 'TIGRO', 'TOPOLINO', 'PAPERINO', 'PIPPO', 'PLUTO', 'MINNIE', 'DUMBO', 'PIMPI', 'PAPERINA', 'PAPERON DE\'PAPERONI', 'TRILLI',
	'URSULA', 'WHISKY', 'WINNIE THE POOH', 'ZEUS', 'VAIANA'
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
	
const lisAni =[
	'ACCIUGA', 'AIRONE', 'ALBATRO', 'ALCE', 'ALLIGATORE', 'ALLODOLA', 'ALPACA', 'ANACONDA', 'ANGUILLA', 'ANTILOPE', 'AQUILA', 'ARA', 'ARINGA', 'ARAGOSTA', 'ARMADILLO', 'ASINO', 'AVERLA', 'AVVOLTOIO',
	'BABBUINO', 'BALENA', 'BARRACUDA', 'BECCACCINO', 'BISCIA', 'BOA', 'BONOBO', 'BRADIPO', 'BRANZINO', 'BUE', 'BUFALO',
	'CACATUA', 'CAMALEONTE', 'CAMMELLO', 'CAMOSCIO', 'CANE', 'CAPIBARA', 'CAPODOGLIO', 'CAPRA', 'CARDELLINO', 'CARIBU', 'CASTORO', 'CAVALLO', 'CERVO', 'CICOGNA', 'CIGNO', 'CIMICE', 'CINCILLA', 'CINGHIALE', 'COBRA', 'COCCODRILLO', 'COLIBRI', 'CONDOR', 'CONIGLIO', 'CORMORANO', 'CORNACCHIA', 'CORVO', 'COYOTE', 'CRICETO',
	'DAINO', 'DELFINO', 'DODO', 'DONNOLA', 'DRAGO DI KOMODO', 'DROMEDARIO', 'DUGONGO', 'ELEFANTE', 'EMU', 'ERMELLINO', 
	'FACOCERO', 'FAGIANO', 'FAINA', 'FALCO', 'FARAONA', 'FOCA', 'FORMICA', 'FORMICHIERE', 'FRINGUELLO', 'FURETTO', 'GABBIANO', 'GALLINA', 'GATTO', 'GAZZA', 'GAZZELLA', 'GECO', 'GIAGUARO', 'GIRAFFA', 'GERBILLO', 'GHEPARDO', 'GHIRO', 'GNU', 'GORILLA', 'GRANCHIO', 'GRILLO', 'GRU', 'GUFO', 
	'IBIS', 'IENA', 'IGUANA', 'IMPALA', 'IPPOPOTAMO', 'IPPOCAMPO', 'ISTRICE', 'KIWI', 'KOALA',
	'LEMMING', 'LEMURE', 'LEONE', 'LEOPARDO', 'LEPRE', 'LIBELLULA', 'LICAONE', 'LINCE', 'LONTRA', 'LUCCIOLA', 'LUCERTOLA', 'LUPO', 'MACACO', 'MAIALE', 'MAMMUT', 'MANDRILLO', 'MANGUSTA', 'MANTIDE', 'MARABU', 'MARMOTTA', 'MARTIN PESCATORE', 'MARTORA', 'MEDUSA', 'MEGATTERA', 'MERLO', 'MERLUZZO', 'MOFFETTA', 
	'MOSCA', 'MOSCARDINO', 'MOSCERINO', 'MUFLONE', 'MULO', 'MURENA', 'MUCCA', 'MONTONE',
	'NARVALO', 'NASELLO', 'NUTRIA', 'OCELOT', 'OPOSSUM', 'ORANGO', 'ORATA', 'ORCA', 'ORNITORINCO', 'ORSO',
	'PALOMBO', 'PANDA', 'PANGOLINO', 'PAPPAGALLO', 'PASSERO', 'PAVONE', 'PELLICANO', 'PESCE GATTO', 'PESCE SPADA', 'PESCE PALLA', 'PETTIROSSO', 'PICCHIO', 'PIPISTRELLO', 'PINGUINO', 'PITONE', 'PIRANHA', 'POLPO', 'PORCELLINO D\'INDIA', 'PROCIONE', 'PUMA', 'PUZZOLA',
	'QUAGGA', 'QUAGLIA', 'RAGNO', 'RAGANELLA', 'RAMARRO', 'RANA', 'RATTO', 'RICCIO', 'RINOCERONTE', 'ROMBO', 'RONDINE', 'ROSPO', 
	'SALMONE', 'SARDINA', 'SCARABEO', 'SCARAFAGGIO', 'SCIACALLO', 'SCIMMIA', 'SCIMPANZE', 'SCOIATTOLO', 'SEPENTE', 'SGOMBRO', 'SOGLIOLA', 'SQUALO BIANCO', 'SQUALO BALENA', 'SQUALO MARTELLO',
	'TACCHINO', 'TAFANO', 'TARTARUGA', 'TASSO', 'TESTUGGINE', 'TIGRE', 'TONNO', 'TOPO', 'TORDO', 'TROTA', 'TRIGLIA',
	'UPUPA', 'USIGNOLO', 'VESPA', 'VIPERA', 'VOLPE', 'YAK', 'ZEBRA'
	
]
	
const lisTest =[
	'TEST TEST',
	'ALL\'ORA'	
]

$("#genera").click(function(){
	streak=0;
	$("#streakPuls").hide();
	lettereIndovinate=0;
	errori=0;
	letTentate=[];
	$("#streak").html(streak)
	$("*[id*=vita]").removeClass('fa-regular');
	$("*[id*=vita]").addClass('fa-solid');
		
	$("*[id*=pLet]").removeClass('btn-success');
	$("*[id*=pLet]").removeClass('btn-danger');
	$("*[id*=pLet]").addClass('btn-light');
	$("#scegliLet").prop("disabled",false);
	$("*[id*=pLet]").prop("disabled",false);
	possibiliParole=[];
	if (modScelta==="parola") {possibiliParole = Array.from(lisPar);	}
	if (modScelta==='capitale') {possibiliParole = Array.from(lisCap);	}
	if (modScelta==='disney') {possibiliParole = Array.from(lisDisney);}
	if (modScelta==='animali') {possibiliParole = Array.from(lisAni);}
	if (modScelta==='test') {possibiliParole = Array.from(lisTest);}
	
	parolaScelta = possibiliParole[Math.floor(Math.random() * possibiliParole.length)];

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
});


	$(".pulsLet").click(function(){
		$("#scegliLet").val($(this).val());
	})

	$("#scegliLet").click(function(){
		var letScelta=$("#scegliLet").val();
		var letIndovinata=false;
		if (letScelta.length<1) {alert("Scegli una lettera per continuare!");}
		if (letTentate.indexOf(letScelta)!==-1){alert("hai gia' messo questa lettera")}
		else {
			letTentate.push(letScelta);
			for (var i=0; i<parolaScelta.length; i++){
				var letPar=parolaScelta.charAt(i);
				if (letPar===letScelta){
					
					var idLetDaMostrare="seg"+i;
					$("*[id=" + idLetDaMostrare + "]").show();
					letIndovinata=true;
					lettereIndovinate++;
				}
				
			}
				
		var butDaColorare="pLet"+letScelta;		
		var butDaSpegnere="pLet"+letScelta;
		if (letIndovinata===true){
			$("*[id=" + butDaColorare + "]").removeClass('btn-light');
			$("*[id=" + butDaColorare + "]").addClass('btn-success');
			
		}
		if (letIndovinata===false){
			$("*[id=" + butDaColorare + "]").removeClass('btn-light');
			$("*[id=" + butDaColorare + "]").addClass('btn-danger');
			errori++;
			var vitaDaTogliere="vita"+errori;
			$("*[id=" + vitaDaTogliere + "]").removeClass('fa-solid ');
			$("*[id=" + vitaDaTogliere + "]").addClass('fa-regular');
		}
		$("*[id*=" + butDaSpegnere + "]").prop('disabled',true);
		
		if (lettereIndovinate===parolaScelta.length){
			alert("hai vinto!");
			$("#scegliLet").prop('disabled',true);
			streak++;
			var indexParola = possibiliParole.indexOf(parolaScelta);
			if (indexParola > -1) { // only splice array when item is found
  				possibiliParole.splice(indexParola, 1);
  			}
  			$("#streakPuls").show();
		}
		if (errori===9){
			alert("niente piu' vite, hai perso! la parola era "+parolaScelta)
			$("#scegliLet").prop('disabled',true);
			streak=0;
			$("#streakPuls").hide();
		}
		}
		
	});
	
	$("#keepStreak").click(function(){
		lettereIndovinate=0;
		letTentate=[];
		$("#streakPuls").hide();
		$("#streak").html(streak)
		$("*[id*=pLet]").removeClass('btn-success')
		$("*[id*=pLet]").removeClass('btn-danger');
		$("*[id*=pLet]").addClass('btn-light');
		$("#scegliLet").prop("disabled",false);
		$("*[id*=pLet]").prop("disabled",false);
		if (possibiliParole.length<1){
			alert("hai indovinato tutte le parole di questa categoria! SEI 'NA BRANDA");
		}
		else {
		parolaScelta = possibiliParole[Math.floor(Math.random() * possibiliParole.length)];

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
		}
	});
		
		
	});