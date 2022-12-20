$(document).ready(function() {
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
		else if (modSpieg === 'animaliENG') {
			$("#istruzioni").html(
				"<h2>Animali</h2>"+
				"<p> indovina il nome in inglese di un animale! </p>"+
				"<p> ovviamente si intende nome comune, non Fido o Pluto o cose del genere</p>"+
				"<p>verrà aggiunta a breve anche la traduzione in italiano del nome</p>")
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
				"<p> nota: alcuni sono sbagliati, segnalatelo se capita</p>")
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
})