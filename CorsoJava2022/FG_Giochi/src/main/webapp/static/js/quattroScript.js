$(document).ready(function () {
	
	var colonne=[];
	var gettoniMessi=[];
	const victoryReq=4;
	
	for (var i=0; i<7; i++){
		var col=0;
		colonne.push(col);
	}
	
	$(".pulsPl").click(function(){
		var colore;
		if ($(this).hasClass("pulsR")){
			colore="red";
		}
		else if ($(this).hasClass("pulsG")){
			colore="orange";
		}
		var colGet=$(this).val();
		var rigaGet=colonne[colGet];
		var gettone=[colore, colGet, rigaGet];
		gettoniMessi.push(gettone);
		colonne[colGet]++; 
		$("#"+colGet+"_"+rigaGet).css("background-color", colore);
		if (colonne[colGet]>5){
			$(".puls"+colGet).prop("disabled",true);
		};
		
		
		victoryCheck();
	})


	function victoryCheck(){
		var vicStreak;
		var vittoria=false;
		for (var i=0; i<gettoniMessi.length; i++){ //per ogni gettone messo
			console.log("controllo gettone "+i+": "+gettoniMessi[i])
			vicStreak=1; //fila da 1
			var horChecking=true; //sto controllando le streak orizzontali
			while (horChecking===true){ //mentre sto controllando
				var horFound=false;
				for (var j=0; j<gettoniMessi.length; j++){ //per ogni gettone messo
					console.log("paragono gettone "+i+": "+gettoniMessi[i]+" e gettone "+j+": "+gettoniMessi[j])
					if (gettoniMessi[i][0]===gettoniMessi[j][0]){ //se ha lo stesso colore
					console.log("gettone "+i+" "+gettoniMessi[i][0]+" e gettone "+j+" "+gettoniMessi[j][0]+ " hanno lo stesso colore")
						if (gettoniMessi[i][2]===gettoniMessi[j][2]) {
							console.log("gettone "+i+" "+gettoniMessi[i][2]+" e gettone "+j+" "+gettoniMessi[j][2]+ " hanno la stessa y")
							var getVicinoX=parseInt(gettoniMessi[i][1])+vicStreak;
							console.log(getVicinoX)
							if (parseInt(gettoniMessi[j][1])===getVicinoX) {
								vicStreak++;
								console.log("gettone "+i+" "+gettoniMessi[i][1]+" e gettone "+j+" "+gettoniMessi[j][1]+ " sono vicini sulle x, streak="+vicStreak)
								horFound=true;
								if (vicStreak===4){
									horChecking=false;
									vittoria=true;
									alert("ha vinto "+gettoniMessi[i][0])
									$(".pulsPl").prop("disabled",true);
								}
							}
							
						}
					}
				}
				if (horFound===false) {
					horChecking=false
				}
			}
		}
		for (var i=0; i<gettoniMessi.length; i++){ //per ogni gettone messo
			console.log("controllo gettone "+i+": "+gettoniMessi[i])
			vicStreak=1; //fila da 1
			var verChecking=true; //sto controllando le streak verticali
			while (verChecking===true){ //mentre sto controllando
				var verFound=false;
				for (var j=0; j<gettoniMessi.length; j++){ //per ogni gettone messo
					console.log("paragono gettone "+i+": "+gettoniMessi[i]+" e gettone "+j+": "+gettoniMessi[j])
					if (gettoniMessi[i][0]===gettoniMessi[j][0]){ //se ha lo stesso colore
					console.log("gettone "+i+" "+gettoniMessi[i][0]+" e gettone "+j+" "+gettoniMessi[j][0]+ " hanno lo stesso colore")
						if (parseInt(gettoniMessi[i][1])===parseInt(gettoniMessi[j][1])) {
							console.log("gettone "+i+" "+gettoniMessi[i][1]+" e gettone "+j+" "+gettoniMessi[j][1]+ " hanno la stessa x")
							var getVicinoY=parseInt(gettoniMessi[i][2])+vicStreak;
							console.log(getVicinoY)
							if (parseInt(gettoniMessi[j][2])===getVicinoY) {
								vicStreak++;
								console.log("gettone "+i+" "+gettoniMessi[i][2]+" e gettone "+j+" "+gettoniMessi[j][2]+ " sono vicini sulle y, streak="+vicStreak)
								verFound=true;
								if (vicStreak===4){
									verChecking=false;
									vittoria=true;
									alert("ha vinto "+gettoniMessi[i][0])
									$(".pulsPl").prop("disabled",true);
								}
							}
							
						}
					}
				}
				if (verFound===false) {
					verChecking=false
				}
			
			}
		}
		for (var i=0; i<gettoniMessi.length; i++){ //per ogni gettone messo
			console.log("controllo gettone "+i+": "+gettoniMessi[i])
			vicStreak=1; //fila da 1
			var diagChecking=true; //sto controllando le streak diagonali
			while (diagChecking===true){ //mentre sto controllando
				var diagFound=false;
				for (var j=0; j<gettoniMessi.length; j++){ //per ogni gettone messo
					console.log("paragono gettone "+i+": "+gettoniMessi[i]+" e gettone "+j+": "+gettoniMessi[j])
					if (gettoniMessi[i][0]===gettoniMessi[j][0]){ //se ha lo stesso colore
					console.log("gettone "+i+" "+gettoniMessi[i][0]+" e gettone "+j+" "+gettoniMessi[j][0]+ " hanno lo stesso colore")
						if ((gettoniMessi[i][2]+vicStreak)===gettoniMessi[j][2]) {
							console.log("gettone "+i+" "+gettoniMessi[i][2]+" e gettone "+j+" "+gettoniMessi[j][2]+ " sono su y vicine")
							var getVicinoX=parseInt(gettoniMessi[i][1])+vicStreak;
							console.log(getVicinoX)
							if (parseInt(gettoniMessi[j][1])===getVicinoX) {
								vicStreak++;
								console.log("gettone "+i+" "+gettoniMessi[i][1]+" e gettone "+j+" "+gettoniMessi[j][1]+ " sono vicini sulle x, streak="+vicStreak)
								diagFound=true;
								if (vicStreak===4){
									diagChecking=false;
									vittoria=true;
									alert("ha vinto "+gettoniMessi[i][0])
									$(".pulsPl").prop("disabled",true);
								}
							}
							
						}
					}
				}
				if (diagFound===false) {
					diagChecking=false
				}
			}
		}
		for (var i=0; i<gettoniMessi.length; i++){ //per ogni gettone messo
			console.log("controllo gettone "+i+": "+gettoniMessi[i])
			vicStreak=1; //fila da 1
			var revDiagChecking=true; //sto controllando le streak diagonali al contrario
			while (revDiagChecking===true){ //mentre sto controllando
				var revDiagFound=false;
				for (var j=0; j<gettoniMessi.length; j++){ //per ogni gettone messo
					console.log("paragono gettone "+i+": "+gettoniMessi[i]+" e gettone "+j+": "+gettoniMessi[j])
					if (gettoniMessi[i][0]===gettoniMessi[j][0]){ //se ha lo stesso colore
					console.log("gettone "+i+" "+gettoniMessi[i][0]+" e gettone "+j+" "+gettoniMessi[j][0]+ " hanno lo stesso colore")
						if ((gettoniMessi[i][2]+vicStreak)===gettoniMessi[j][2]) {
							console.log("gettone "+i+" "+gettoniMessi[i][2]+" e gettone "+j+" "+gettoniMessi[j][2]+ " sono su y vicine")
							var getVicinoX=parseInt(gettoniMessi[i][1])-vicStreak;
							console.log(getVicinoX)
							if (parseInt(gettoniMessi[j][1])===getVicinoX) {
								vicStreak++;
								console.log("gettone "+i+" "+gettoniMessi[i][1]+" e gettone "+j+" "+gettoniMessi[j][1]+ " sono vicini sulle x, streak="+vicStreak)
								revDiagFound=true;
								if (vicStreak===4){
									revDiagChecking=false;
									vittoria=true;
									alert("ha vinto "+gettoniMessi[i][0])
									$(".pulsPl").prop("disabled",true);
								}
							}
							
						}
					}
				}
				if (revDiagFound===false) {
					revDiagChecking=false
				}
			}
		}
		
	}
	
})