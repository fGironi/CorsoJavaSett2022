$(document).ready(function() {
	$("#streakPuls").hide();
	var parolaScelta;
	var lettereIndovinate=0;
	var letTentate=[];
	var tastoPrem;
	var errori = 0;
	parolaScelta = parola;
	
	//cambio modalità
	$("#mode").on('change',function(){
		var modSpieg = $("#mode option:selected").val();
		var new_href = 'parola?mode=' + modSpieg;
  		$("#genera").attr('href', new_href);
  		$("#generaPuls").prop("disabled", false);
	})
	
	$("#streakPuls").hide();

	//Costruttore tabella parola:
	var doppiariga=false;
	var triplariga=false
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
			if (i>20 && triplariga==false){
				htmlStr+="<table class=\"spazioParola\"><tr>";
				triplariga=true;
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
		
		
	//Colorazione vite:
	for (var i=1; i<=startVita; i++){
		var vitaDaAccendere = "vita" + i;
		$("*[id=" + vitaDaAccendere + "]").removeClass('fa-regular ');
		$("*[id=" + vitaDaAccendere + "]").addClass('fa-solid');
	}	
		
	
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
				var viteRimaste=startVita-errori;
				errori++;
				var vitaDaTogliere = "vita" + viteRimaste;
				$("*[id=" + vitaDaTogliere + "]").removeClass('fa-solid ');
				$("*[id=" + vitaDaTogliere + "]").addClass('fa-regular');
			}
			$("*[id*=" + butDaSpegnere + "]").prop('disabled', true);

			if (lettereIndovinate === parolaScelta.length) {
				alert("hai vinto!");
				$(".scegliLet").prop('disabled', true);
				var newStreakLink=$("#streakLink").attr("href")+errori;
				$("#streakLink").attr("href", newStreakLink);
				if (idUser!=null) $("#streakPuls").show();
			}
			if (viteRimaste===1) {
				alert("niente piu' vite, hai perso! la parola era " + parolaScelta)
				$(".scegliLet").prop('disabled', true);
				$("#linkRecap").attr("href", $("#linkRecap").attr("href") + errori);
				$("#streakPuls").hide();
				$(".pulsLet").hide();
				$(".scegliLet").hide();
				if (idUser!=null) $(".gameRecap").show();
				$("#parolaSconfitta").text(parolaScelta);
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

})
	