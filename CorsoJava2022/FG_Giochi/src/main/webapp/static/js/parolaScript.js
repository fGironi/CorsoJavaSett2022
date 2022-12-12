$(document).ready(function() {
	$("#streakPuls").hide();
	var modScelta;
	var possibiliParole;
	var parolaScelta;
	var lettereIndovinate;
	var errori;
	var letTentate;
	var streak;
	var tastoPrem;
	var paroleIndov;
	var startingErr;

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
		'BASIL', 'BAYMAX', 'BESTIA', 'BIAGIO', 'BIANCA', 'BERNIE', 'BIANCANEVE', 'BIANCONIGLIO', 'BIZET', 'BOLLY BONES', 'BRUCALIFFO', 'CAPITAN UNCINO', 'CENERENTOLA', 'CHICKEN LITTLE',
		'CLAYTON', 'CRUDELIA DE MON', 'DUCHESSA', 'ELSA', 'ESMERALDA', 'FEBO', 'FATA AZZURRA', 'FATA SMEMORINA', 'FATA MADRINA',
		'FIDO', 'FILOTTETE', 'FLOUNDER', 'FRA TUCK', 'GAS', 'GASTON', 'HANS', 'IAGO', 'IH OH', 'JAFAR', 'JANE', 'JIM HAWKINS', 'JOHN SMITH', 'KAA', 'KALA', 'KERCHAK', 'KRONK',
		'KUZKO', 'LADY MARIAN', 'LILO', 'LILLI', 'LITTLE JOHN', 'LOUIS', 'LUMIERE', 'LUCIGNOLO',
		'GEPPETTO', 'MERLINO', 'MALEFICA', 'MANGIAFUOCO', 'MATISSE', 'MAUI', 'MEGARA', 'MINOU', 'MOWGLI', 'MUFASA', 'MULAN', 'MUSHU', 'NALA', 'OLAF',
		'OLIVER', 'PEGGY', 'PETER PAN', 'POCAHONTAS', 'PONGO', 'FILIPPO', 'JASMINE', 'PRINCIPE GIOVANNI', 'PUMBAA',
		'QUASIMODO', 'RALPH', 'GRIMILDE', 'ROBIN HOOD', 'ROMEO', 'SEBASTIAN', 'SEMOLA', 'SHERE KHAN', 'SIMBA', 'STITCH', 'SPUGNA', 'TARZAN', 'TARON', 'TAMBURINO', 'TIGRO', 'TOPOLINO', 'PAPERINO', 'PIPPO', 'PLUTO', 'MINNIE', 'DUMBO', 'PIMPI', 'PAPERINA', 'PAPERON DE\'PAPERONI', 'TRILLI',
		'URSULA', 'WHISKY', 'WINNIE THE POOH', 'ZEUS', 'VAIANA', 'RAPUNZEL'
	]

	const lisCap = [
		'KABUL', 'TIRANA', 'ALGERI', 'LA VELLA', 'LUANDA', 'SAINT JOHN\'S', 'RIAD', 'BUENOS AIRES', 'EREVAN', 'CANBERRA', 'VIENNA', 'BAKU', 'NASSAU',
		'MANAMA', 'DACCA', 'BRIDGETOWN', 'BRUXELLES', 'BELMOPAN', 'PORTO NOVO', 'THIMPHU', 'MINSK', 'SUCRE', 'LA PAZ', 'SARAJEVO', 'GABORONE', 'BRASILIA', 'BANDAR SERI BEGAWAN',
		'SOFIA', 'OUAGADOUGOU', 'GITEGA', 'PHNOM PENH', 'YAOUNDE', 'OTTAWA', 'PRAIA', 'PRAGA', 'BANGUI', 'N\'DJAMENA', 'SANTIAGO',
		'PECHINO', 'NICOSIA', 'BOGOTA', 'MORONI', 'BRAZZAVILLE', 'KINSHASA', 'PYONGYANG', 'SEUL', 'YAMOUSSOUKRO', 'SAN JOSE', 'ZAGABRIA', 'L\'AVANA', 'COPENAGHEN', 'ROSEAU', 'SANTO DOMINGO',
		'QUITO', 'IL CAIRO', 'SAN SALVADOR', 'ABU DHABI', 'ASMARA', 'TALLINN', 'ADDIS ABEBA', 'SUVA', 'MANILA', 'HELSINKI', 'PARIGI', 'LIBREVILLE', 'BANJUL', 'TBILISI', 'BERLINO', 'ACCRA',
		'KINGSTON', 'TOKYO', 'GIBUTI', 'AMMAN', 'ATENE', 'SAINT GEORGE\'S', 'CITTA DEL GUATEMALA', 'CONAKRY', 'BISSAU', 'MALABO', 'GEORGETOWN', 'PORT AU PRINCE', 'TEGUCIGALPA',
		'NUOVA DELHI', 'GIACARTA', 'TEHERAN', 'BAGHDAD', 'DUBLINO', 'REYKJAVIK', 'MAJURO', 'GERUSALEMME', 'ROMA', 'NAIROBI', 'ASTANA', 'BISKEK', 'TARAWA SUD', 'AL KUWAIT',
		'VIENTIANE', 'MASERU', 'RIGA', 'BEIRUT', 'MONROVIA', 'TRIPOLI', 'VADUZ', 'VILNIUS', 'LUSSEMBURGO', 'SKOPJE', 'ANTANANARIVO', 'LILONGWE', 'KUALA LUMPUR', 'MALE', 'BAMAKO',
		'LA VALLETTA', 'RABAT', 'NOUAKCHOTT', 'PORT LOUIS', 'CITTA DEL MESSICO', 'PALIKIR', 'CHISINAU', 'MONACO', 'ULAN BATOR', 'PODGORICA', 'MAPUTO', 'WINDHOEK', 'KATMANDU', 'MANAGUA',
		'NIAMEY', 'ABUJA', 'OSLO', 'WELLINGTON', 'MASCATE', 'AMSTERDAM', 'ISLAMABAD', 'NGERULMUD', 'RAMALLAH', 'PORT MORESBY', 'ASUNCION', 'LIMA', 'VARSAVIA', 'LISBONA', 'DOHA', 'LONDRA',
		'BUCAREST', 'KIGALI', 'HONIARA', 'APIA', 'SAN MARINO', 'CASTRIES', 'DAKAR', 'SAO TOME', 'BELGRADO', 'VICTORIA', 'FREETOWN', 'SINGAPORE', 'DAMASCO', 'BRATISLAVA', 'LUBIANA', 'MOGADISCIO', 'MADRID',
		'SRI JAYAWARDENAPURA', 'WASHINGTON', 'BLOEMFONTEIN', 'CITTA DEL CAPO', 'PRETORIA', 'KHARTUM', 'GIUBA', 'PARAMARIBO', 'STOCCOLMA', 'BERNA', 'MBABANE',
		'DUSHANBE', 'DODOMA', 'BANGKOK', 'DILI', 'LOME', 'NUKU\'ALOFA', 'PORT OF SPAIN', 'TUNISI', 'ANKARA', 'ASGABAT', 'FUNAFUTI', 'KIEV', 'KAMPALA',
		'BUDAPEST', 'MONTEVIDEO', 'TASHKENT', 'PORT VILA', 'CITTA DEL VATICANO', 'CARACAS', 'HANOI', 'SANA\'A', 'LUSAKA', 'HARARE'
	]

	const lisAni = [
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

	const lisTest = [
		'TEST TEST',
		'ALL\'ORA',
		'CACCA & PUPU',
		'??Ò@E7!,8+',
		'SUPERCALIFRAGILE ISTICHESPIRALITOSO'
	]
	
//	$("#mode").change(function(){
//		modSpieg = $("#mode option:selected").val();
//		if (modSpieg === "ita") {
//			$("#istruzioni").html(
//				"<h2>Parola casuale italiana</h2>"+
//				"<p> indovina una parola casuale da una (breve) lista fatta a mano </p>"+
//				"<p> attualmente non è particolarmente lunga e interessante, verrà espansa più avanti</p>"+
//				"<p> la lista contiene solo nomi comuni, aggettivi e verbi all'infinito </p>")
//			
//		
//		}
//		else if (modSpieg === 'capitale') {
//			$("#istruzioni").html(
//				"<h2>Capitali del mondo</h2>"+
//				"<p> indovina una parola casuale da una (breve) lista fatta a mano </p>"+
//				"<p> attualmente non è particolarmente lunga e interessante, verrà espansa più avanti</p>"+
//				"<p> la lista contiene solo nomi comuni, aggettivi e verbi all'infinito </p>")
//			 
//			
//		}
//		else if (modSpieg === 'disney')  {
//			$("#istruzioni").html(
//				"<h2>Personaggi Disney</h2>"+
//				"<p> indovina una parola casuale da una (breve) lista fatta a mano </p>"+
//				"<p> attualmente non è particolarmente lunga e interessante, verrà espansa più avanti</p>"+
//				"<p> la lista contiene solo nomi comuni, aggettivi e verbi all'infinito </p>")
//			
//		}
//		else if (modSpieg === 'animali') {
//			$("#istruzioni").html(
//				"<h2>Animali</h2>"+
//				"<p> indovina una parola casuale da una (breve) lista fatta a mano </p>"+
//				"<p> attualmente non è particolarmente lunga e interessante, verrà espansa più avanti</p>"+
//				"<p> la lista contiene solo nomi comuni, aggettivi e verbi all'infinito </p>")
//		} 
//		else if (modSpieg === 'test') {
//			$("#istruzioni").html(
//				"<h2>Testing</h2>"+
//				"<p> indovina una parola casuale da una (breve) lista fatta a mano </p>"+
//				"<p> attualmente non è particolarmente lunga e interessante, verrà espansa più avanti</p>"+
//				"<p> la lista contiene solo nomi comuni, aggettivi e verbi all'infinito </p>")
//		}
//		else { 
//			$("#istruzioni").html(
//			"<h2>Indovina la parola!</h2>"+
//			"<p>seleziona la modalita' di gioco, quindi premi su nuova partita</p>"+
//			"<p>puoi selezionare una lettera dalla tastiera virtuale o usando la tua tastiera reale</p>"+
//			"<p>per confermare la lettera puoi premere invio, il segno di conferma o l'enorme lettera al centro dello schermo</p>"+
//			"<p>Ad ogni errore perderai una vita(<i class=\"vitG fa-solid fa-heart\"></i>), cerca di indovinare prima di finirle!</p>"+
//			"<p>Se la \"parola\" è composta da più di una parola lo spazio sarà indicato con un trattino basso (_)</p>"+
//			"<p>allo stesso modo, se c'è un apostrofo sarà già presente nella tabella!</p>"+
//			"<p>se ti senti particolarmente bravo, puoi indovinare più parole di seguito recuperando una sola vita per volta, basta cliccare su \"STREAK\" quando indovini</p>"+
//			"<p>Buona fortuna!</p>")
//			}
//		var new_href = 'parola?mode=' + modSpieg;
//  		$("#genera").attr('href', new_href);
//  		$("#generaPuls").prop("disabled", false);
//	})
	
	
	//versione del codice per vecchi cellulari, forse funziona
		$("#mode").on('change',function(){
		modSpieg = $("#mode option:selected").val();
		if (modSpieg === "ita") {
			$("#istruzioni").html(
				"<h2>Parola casuale italiana</h2>"+
				"<p> indovina una parola casuale da una (breve) lista fatta a mano </p>"+
				"<p> attualmente non è particolarmente lunga e interessante, verrà espansa più avanti</p>"+
				"<p> la lista contiene solo nomi comuni, aggettivi e verbi all'infinito </p>")
			
		
		}
		else if (modSpieg === 'capitale') {
			$("#istruzioni").html(
				"<h2>Capitali del mondo</h2>"+
				"<p> indovina una delle capitali del mondo (ci sono tutte!) </p>"+
				"<p> il nome utilizzato è quello ufficiale in lingua italiana</p>"+
				"<p> magari ne sai abbastanza per indovinarle tutte in una streak... </p>")
			 
			
		}
		else if (modSpieg === 'disney')  {
			$("#istruzioni").html(
				"<h2>Personaggi Disney</h2>"+
				"<p> indovina uno dei tantissimi personaggi dei film d'animazione Disney' </p>"+
				"<p> Si va dagli originali Disney ai grandi classici delle fiabe, passando per tanto altro</p>"+
				"<p> \"So you're a disney fan, uh?\"</p>")
			
		}
		else if (modSpieg === 'animali') {
			$("#istruzioni").html(
				"<h2>Animali</h2>"+
				"<p> indovina il nome dell'animale! </p>"+
				"<p> ovviamente si intende nome comune, non Fido o cose del genere</p>"+
				"<p> C'è un po' di miscuglio tra specie e razze e altro, ma sono sicuro che non sarà un problema </p>")
		} 
		else if (modSpieg === 'test') {
			$("#istruzioni").html(
				"<h2>Testing</h2>"+
				"<p> Testando le teste si testano i testaggi delle testuggini </p>"+
				"<p> Te stai testando test a 'ndo te sta</p>"+
				"<p> Breve lista per poter testare le funzionalità dello script </p>")
		}
		else if (modSpieg === 'lol') {
			$("#istruzioni").html(
				"<h2>League of Legends Champions</h2>"+
				"<p> Indovina i nomi dei campioni di LoL</p>"+
				"<p> tutti i nomi sono generati usando la libreria JavaFaker</p>"+
				"<p> nota: alcuni sono sbagliati (ex: AlistEr), mi dispiace non posso farci nulla :D </p>")
		}
		else if (modSpieg === 'pokemon') {
			$("#istruzioni").html(
				"<h2>Pokémon</h2>"+
				"<p> indovina il nome di un Pokémon </p>"+
				"<p> tutti i nomi sono generati usando la libreria JavaFaker</p>"+
				"<p> non so quali generazioni prenda in considerazione, ma sicuramente c'è pikachu</p>")
		}
		else if (modSpieg === 'rock') {
			$("#istruzioni").html(
				"<h2>Rock Band</h2>"+
				"<p> Indovina il nome delle rock band </p>"+
				"<p> tutti i nomi sono generati usando la libreria JavaFaker</p>"+
				"<p> Alcuni nomi sono particolarmente lunghi, non per questo sono più difficli </p>")
		}
		else { 
			$("#istruzioni").html(
			"<h2>Indovina la parola!</h2>"+
			"<p>seleziona la modalita' di gioco, quindi premi su nuova partita</p>"+
			"<p>puoi selezionare una lettera dalla tastiera virtuale o usando la tua tastiera reale</p>"+
			"<p>per confermare la lettera puoi premere invio, il segno di conferma o l'enorme lettera al centro dello schermo</p>"+
			"<p>Ad ogni errore perderai una vita(<i class=\"vitG fa-solid fa-heart\"></i>), cerca di indovinare prima di finirle!</p>"+
			"<p>Se la \"parola\" è composta da più di una parola lo spazio sarà indicato con un trattino basso (_)</p>"+
			"<p>allo stesso modo, se c'è un apostrofo sarà già presente nella tabella!</p>"+
			"<p>se ti senti particolarmente bravo, puoi indovinare più parole di seguito recuperando una sola vita per volta, basta cliccare su \"STREAK\" quando indovini</p>"+
			"<p>Buona fortuna!</p>")
			}
		var new_href = 'parola?mode=' + modSpieg;
  		$("#genera").attr('href', new_href);
  		$("#generaPuls").prop("disabled", false);
	})
	

	
	$("#inizia").click(function(){
		var modParola=$(this).val();
		streak = 0;
		paroleIndov=[];
		$("#streakPuls").hide();
		lettereIndovinate = 0;
		errori = 0;
		startingErr=0;
		letTentate = [];
		$("#streak").html(streak)
		$("*[id*=vita]").removeClass('fa-regular');
		$("*[id*=vita]").addClass('fa-solid');
	
		$("*[id*=pLet]").removeClass('btn-success');
		$("*[id*=pLet]").removeClass('btn-danger');
		$("*[id*=pLet]").addClass('btn-light');
		$(".scegliLet").prop("disabled", false);
		$("*[id*=pLet]").prop("disabled", false);
		possibiliParole = [];
		if (modParola === "ita") { possibiliParole = Array.from(lisPar); }
		if (modParola === 'capitale') { possibiliParole = Array.from(lisCap); }
		if (modParola === 'disney') { possibiliParole = Array.from(lisDisney); }
		if (modParola === 'animali') { possibiliParole = Array.from(lisAni); }
		if (modParola === 'test') { possibiliParole = Array.from(lisTest); }
		if (modParola === "lol" || modParola === "pokemon" || modParola === "rock") { possibiliParole = listaPrl;}
	
		parolaScelta = possibiliParole[Math.floor(Math.random() * possibiliParole.length)];
		var doppiariga=false;
		var htmlStr = " </tr></table><table class=\"spazioParola\"><tr>";
		
		for (var i = 0; i < parolaScelta.length; i++) {
			var rndC = parolaScelta.charAt(i);
			if (rndC === ' ') {
				htmlStr += "<td class=\"spazioLet\" id=\"seg" + i + "\"><h2>_</h2></td>";
				lettereIndovinate++;
				if (i>10 && doppiariga==false){
					htmlStr+="<table class=\"spazioParola\"><tr>";
					doppiariga=true;
				}
			}
			else if ((/^[a-zA-Z]+$/.test(rndC))){
					htmlStr += "<td class=\"spazioLet\"> <h2 id=\"seg" + i + "\" class=\"letSegr\">" + rndC + "</h2> </td>"
				}
				else {
					htmlStr += "<td class=\"spazioLet\" id=\"seg" + i + "\"><h2>"+rndC+"</h2></td>";
					lettereIndovinate++;
				}
		}
		htmlStr += " </tr></table>";
		$("#parolaRnd").html(htmlStr);
		$(".letSegr").hide();
		
	});
	
	$(".pulsLet").click(function() {
		$(".scegliLet").val($(this).val());
	})

	function checkLettera(letScelta) {
		var letIndovinata = false;
		if (letScelta.length < 1) { alert("Scegli una lettera per continuare!"); }
		else if (letTentate.indexOf(letScelta) !== -1) { alert("hai gia' messo questa lettera") }
		else {
			letTentate.push(letScelta);
			for (var i = 0; i < parolaScelta.length; i++) {
				var letPar = parolaScelta.charAt(i);
				if (letPar === letScelta) {

					var idLetDaMostrare = "seg" + i;
					$("*[id=" + idLetDaMostrare + "]").show();
					letIndovinata = true;
					lettereIndovinate++;
				}

			}

			var butDaColorare = "pLet" + letScelta;
			var butDaSpegnere = "pLet" + letScelta;
			if (letIndovinata === true) {
				$("*[id=" + butDaColorare + "]").removeClass('btn-light');
				$("*[id=" + butDaColorare + "]").addClass('btn-success');

			}
			if (letIndovinata === false) {
				$("*[id=" + butDaColorare + "]").removeClass('btn-light');
				$("*[id=" + butDaColorare + "]").addClass('btn-danger');
				errori++;
				var vitaDaTogliere = "vita" + errori;
				$("*[id=" + vitaDaTogliere + "]").removeClass('fa-solid ');
				$("*[id=" + vitaDaTogliere + "]").addClass('fa-regular');
			}
			$("*[id*=" + butDaSpegnere + "]").prop('disabled', true);

			if (lettereIndovinate === parolaScelta.length) {
				alert("hai vinto!");
				$(".scegliLet").prop('disabled', true);
				streak++;
				var indexParola = possibiliParole.indexOf(parolaScelta);
				if (indexParola > -1) { // only splice array when item is found
					possibiliParole.splice(indexParola, 1);
				}
				$("#streakPuls").show();
			}
			if (errori === 9) {
				alert("niente piu' vite, hai perso! la parola era " + parolaScelta)
				$(".scegliLet").prop('disabled', true);
				streak = 0;
				$("#streakPuls").hide();
				$(".pulsLet").hide();
				$(".scegliLet").hide();
				$(".gameRecap").show();
				$("#parolaSconfitta").text(parolaScelta);
				for (var i=0; i<paroleIndov.length; i++) {
					var htmlIndov="<li> "+paroleIndov[i][0]+": "+paroleIndov[i][1]+" errori</li>"
					$("#indovinate").append(htmlIndov);	
				}
				
				
				
				
			}
		}

	};

	$(".scegliLet").click(function(){
		var letScelta=$(".scegliLet").val()
		checkLettera(letScelta);
	});


	$(window).keydown(function(e) {
		tastoPrem=String(e.key).toUpperCase();
		
			if (tastoPrem === "ENTER") {
				var letScelta=$(".scegliLet").val()
				checkLettera(letScelta)
			}
			else if (tastoPrem.length>1) {
				console.log("l'utente ha premuto un tasto diverso da una lettera'")
			}

			else if (/^[a-zA-Z]+$/.test(tastoPrem)) {
				$(".scegliLet").val(tastoPrem)
				
			} 
			
	});

	$("#keepStreak").click(function() {
		var erroriFatti=errori-startingErr;
		var parolaRecord=[parolaScelta, erroriFatti];
		paroleIndov.push(parolaRecord)
			
		lettereIndovinate = 0;
		letTentate = [];
		$("#streakPuls").hide();
		$("#streak").html(streak)
		$("*[id*=pLet]").removeClass('btn-success')
		$("*[id*=pLet]").removeClass('btn-danger');
		$("*[id*=pLet]").addClass('btn-light');
		$(".scegliLet").prop("disabled", false);
		$("*[id*=pLet]").prop("disabled", false);
		if (errori > 0) {
			var vitaDaMettere = "vita" + errori;
			$("*[id=" + vitaDaMettere + "]").removeClass('fa-regular');
			$("*[id=" + vitaDaMettere + "]").addClass('fa-solid');
			errori--;
		}
		if (errori>0 && streak%10==0) {
			alert ("Complimenti! "+streak+" di seguito! Ti meriti una vita extra!")
			var vitaDaMettere = "vita" + errori;
			$("*[id=" + vitaDaMettere + "]").removeClass('fa-regular');
			$("*[id=" + vitaDaMettere + "]").addClass('fa-solid');
			errori--;
		}
			startingErr=errori;

		if (possibiliParole.length < 1) {
			alert("hai indovinato tutte le parole di questa categoria! SEI 'NA BRANDA");
		}
		else {
			parolaScelta = possibiliParole[Math.floor(Math.random() * possibiliParole.length)];
			var doppiariga=false;
			var htmlStr = "<table class=\"spazioParola\"><tr>";
			for (var i = 0; i < parolaScelta.length; i++) {
				var rndC = parolaScelta.charAt(i);
				if (rndC === ' ') {
					htmlStr += "<td class=\"spazioLet\" id=\"seg" + i + "\"><h2>_</h2></td>";
					lettereIndovinate++;
					if (i>10 && doppiariga==false){
					htmlStr+="<table class=\"spazioParola\"><tr>";
					doppiariga=true;
				}
				}
				else if ((/^[a-zA-Z]+$/.test(rndC))){
					htmlStr += "<td class=\"spazioLet\"> <h2 id=\"seg" + i + "\" class=\"letSegr\">" + rndC + "</h2> </td>"
				}
				else {
					htmlStr += "<td class=\"spazioLet\" id=\"seg" + i + "\"><h2>"+rndC+"</h2></td>";
					lettereIndovinate++;
				}
				
			}
			htmlStr += " </tr></table>";
			$("#parolaRnd").html(htmlStr);
			$(".letSegr").hide();
		}
	});


});

	