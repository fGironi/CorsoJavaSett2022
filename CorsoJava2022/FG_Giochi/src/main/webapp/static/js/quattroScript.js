$(document).ready(function () {
	
	const colonne=[];
	var altezzeColonne=[];
	const victoryReq=4;
	var dajeQuattro=[];
	var colore;
	
	for (var i=0; i<7; i++){
		var col=[];
		for (var j=0; j<6; j++){
			col.push("blank");
		}
		colonne.push(col);
		var altCol=0
		altezzeColonne.push(altCol);
	}
	
	for (var i=0; i<colonne.length; i++)
		for (var j=0; j<colonne[i].length; j++){
			console.log("test"+i+"_"+j+": "+colonne[i][j]);
		}
	
	$(".pulsPl").click(function(){
		
		if ($(this).hasClass("pulsR")){
			colore="red";
		}
		else if ($(this).hasClass("pulsG")){
			colore="orange";
		}
		var colGet=$(this).val();
 		rigaGet=altezzeColonne[colGet];
		$("#"+colGet+"_"+rigaGet).css("background-color", colore);
		colonne[colGet][rigaGet]=colore;
		
		
	
		
		if ($(this).hasClass("pulsR")){
			$(".pulsPl").removeClass("pulsR");
			$(".pulsPl").removeClass("btn-danger");
			$(".pulsPl").addClass("pulsG");
			$(".pulsPl").addClass("btn-warning");
			$("#turnoG").html("<i class=\"fa-solid fa-hippo yellowplayer\">Happy Hippo</i>");
			
			
		}
		else if ($(this).hasClass("pulsG")){
			$(".pulsPl").removeClass("pulsG");
			$(".pulsPl").removeClass("btn-warning");
			$(".pulsPl").addClass("pulsR");
			$(".pulsPl").addClass("btn-danger");
			$("#turnoG").html("<i class=\"fa-solid fa-otter redplayer\">Hot Otter</i>");
		}
		
		victoryCheck2(colGet);
		altezzeColonne[colGet]++;
		if (altezzeColonne[colGet]>5){
		$("#puls"+colGet).prop("disabled",true);
		};
	})
	
 		



//	function victoryCheck(){
//		alert("vecchio vicCheck lanciato")
//		var vicStreak;
//		for (var i=0; i<gettoniMessi.length; i++){ //per ogni gettone messo
//			console.log("controllo gettone "+i+": "+gettoniMessi[i])
//			vicStreak=1; //fila da 1
//			var horChecking=true; //sto controllando le streak orizzontali
//			while (horChecking===true){ //mentre sto controllando
//				var horFound=false;
//				for (var j=1; j<gettoniMessi.length; j++){ //per ogni gettone messo
//					console.log("paragono gettone "+i+": "+gettoniMessi[i]+" e gettone "+j+": "+gettoniMessi[j])
//					if (gettoniMessi[i][0]===gettoniMessi[j][0]){ //se ha lo stesso colore
//					console.log("gettone "+i+" "+gettoniMessi[i][0]+" e gettone "+j+" "+gettoniMessi[j][0]+ " hanno lo stesso colore")
//						if (gettoniMessi[i][2]===gettoniMessi[j][2]) { //Se sono sulla stessa riga
//							console.log("gettone "+i+" "+gettoniMessi[i][2]+" e gettone "+j+" "+gettoniMessi[j][2]+ " hanno la stessa y")
//							var getVicinoX=parseInt(gettoniMessi[i][1])+vicStreak;
//							console.log(getVicinoX)
//							if (parseInt(gettoniMessi[j][1])===getVicinoX) { //Se sono a "vicStreak" caselle di distanza orizzontalmente
//								vicStreak++;
//								console.log("gettone "+i+" "+gettoniMessi[i][1]+" e gettone "+j+" "+gettoniMessi[j][1]+ " sono vicini sulle x, streak="+vicStreak)
//								horFound=true;
//								if (vicStreak===victoryReq){ //se è una fila da 4
//									horChecking=false;
//									dichiaraVit(gettoniMessi[i][0]);
//								}
//							}				
//						}
//					}
//				}
//				if (horFound===false) {	horChecking=false }
//			}
//			vicStreak=1; //fila da 1
//			var verChecking=true; //sto controllando le streak verticali
//			while (verChecking===true){ //mentre sto controllando
//				var verFound=false;
//				for (var j=1; j<gettoniMessi.length; j++){ //per ogni gettone messo
//					console.log("paragono gettone "+i+": "+gettoniMessi[i]+" e gettone "+j+": "+gettoniMessi[j])
//					if (gettoniMessi[i][0]===gettoniMessi[j][0]){ //se ha lo stesso colore
//					console.log("gettone "+i+" "+gettoniMessi[i][0]+" e gettone "+j+" "+gettoniMessi[j][0]+ " hanno lo stesso colore")
//						if (parseInt(gettoniMessi[i][1])===parseInt(gettoniMessi[j][1])) { //Se sono sulla stessa colonna
//							console.log("gettone "+i+" "+gettoniMessi[i][1]+" e gettone "+j+" "+gettoniMessi[j][1]+ " hanno la stessa x")
//							var getVicinoY=parseInt(gettoniMessi[i][2])+vicStreak;
//							console.log(getVicinoY)
//							if (parseInt(gettoniMessi[j][2])===getVicinoY) { //Se sono a "vicStreak" caselle di distanza verticalmente
//								vicStreak++;
//								console.log("gettone "+i+" "+gettoniMessi[i][2]+" e gettone "+j+" "+gettoniMessi[j][2]+ " sono vicini sulle y, streak="+vicStreak)
//								verFound=true;
//								if (vicStreak===victoryReq){
//									verChecking=false;
//									dichiaraVit(gettoniMessi[i][0]);
//								}
//							}
//						}
//					}
//				}
//				if (verFound===false) {	verChecking=false }
//			}
//			vicStreak=1; //fila da 1
//			var diagChecking=true; //sto controllando le streak diagonali
//			while (diagChecking===true){ //mentre sto controllando
//				var diagFound=false;
//				for (var j=1; j<gettoniMessi.length; j++){ //per ogni gettone messo
//					console.log("paragono gettone "+i+": "+gettoniMessi[i]+" e gettone "+j+": "+gettoniMessi[j])
//					if (gettoniMessi[i][0]===gettoniMessi[j][0]){ //se ha lo stesso colore
//					console.log("gettone "+i+" "+gettoniMessi[i][0]+" e gettone "+j+" "+gettoniMessi[j][0]+ " hanno lo stesso colore")
//						if ((gettoniMessi[i][2]+vicStreak)===gettoniMessi[j][2]) {
//							console.log("gettone "+i+" "+gettoniMessi[i][2]+" e gettone "+j+" "+gettoniMessi[j][2]+ " sono su y vicine")
//							var getVicinoX=parseInt(gettoniMessi[i][1])+vicStreak;
//							console.log(getVicinoX)
//							if (parseInt(gettoniMessi[j][1])===getVicinoX) {
//								vicStreak++;
//								console.log("gettone "+i+" "+gettoniMessi[i][1]+" e gettone "+j+" "+gettoniMessi[j][1]+ " sono vicini sulle x, streak="+vicStreak)
//								diagFound=true;
//								if (vicStreak===victoryReq){
//									diagChecking=false;
//									dichiaraVit(gettoniMessi[i][0]);
//								}
//							}
//						}
//					}
//				}
//				if (diagFound===false) {diagChecking=false}
//			}
//			vicStreak=1; //fila da 1
//			var revDiagChecking=true; //sto controllando le streak diagonali al contrario
//			while (revDiagChecking===true){ //mentre sto controllando
//				var revDiagFound=false;
//				for (var j=1; j<gettoniMessi.length; j++){ //per ogni gettone messo
//					console.log("paragono gettone "+i+": "+gettoniMessi[i]+" e gettone "+j+": "+gettoniMessi[j])
//					if (gettoniMessi[i][0]===gettoniMessi[j][0]){ //se ha lo stesso colore
//					console.log("gettone "+i+" "+gettoniMessi[i][0]+" e gettone "+j+" "+gettoniMessi[j][0]+ " hanno lo stesso colore")
//						if ((gettoniMessi[i][2]+vicStreak)===gettoniMessi[j][2]) {
//							console.log("gettone "+i+" "+gettoniMessi[i][2]+" e gettone "+j+" "+gettoniMessi[j][2]+ " sono su y vicine")
//							var getVicinoX=parseInt(gettoniMessi[i][1])-vicStreak;
//							console.log(getVicinoX)
//							if (parseInt(gettoniMessi[j][1])===getVicinoX) {
//								vicStreak++;
//								console.log("gettone "+i+" "+gettoniMessi[i][1]+" e gettone "+j+" "+gettoniMessi[j][1]+ " sono vicini sulle x, streak="+vicStreak)
//								revDiagFound=true;
//								if (vicStreak===victoryReq){
//									revDiagChecking=false;;
//									dichiaraVit(gettoniMessi[i][0]);
//								}
//							}
//						}
//					}
//				}
//				if (revDiagFound===false) {revDiagChecking=false}
//			}
//		}
//	}
	
	function victoryCheck2(colGet){
		var victoryFound=false;
		if (victoryFound==false){ //check ovviamente superfluo, puramente per avere ordine nel codice
		dajeQuattro=[];
		//Check verticale:
			if (altezzeColonne[colGet]>2){ //se nella colonna ci sono meno di 4 gettoni non ha senso fare il check verticale
				for (var i=(altezzeColonne[colGet]); i>=0; i--){
					console.log("controllo colonna"+colGet+"_"+i+":"+colonne[colGet][i])
					if (colonne[colGet][i]==colore){
						dajeQuattro.push(colGet+"_"+i)
						if (dajeQuattro.length==victoryReq){
							victoryFound=true;
							dichiaraVit(colore);
						}
					}
					else {
						dajeQuattro=[];
						i=0; //faccio finire subito il ciclo perché logicamente l'ultimo gettone verticale dovrebbe chiudere il dajeQuattro
					}
				}
			}		
		}
		//Check orizzontale:
		if (victoryFound==false){
			dajeQuattro=[];
			var rigaGet=altezzeColonne[colGet];
			if (colGet<3){
				var maxDist=parseInt(colGet)+3;
				for (var i=0; i<maxDist; i++){
					console.log("controllo colonna"+i+"_"+rigaGet+":"+colonne[i][rigaGet])
					if (colonne[parseInt(i)][parseInt(rigaGet)]==colore){
						dajeQuattro.push(i+"_"+rigaGet);
						if (dajeQuattro.length==victoryReq){
							victoryFound=true;
							dichiaraVit(colore);
						}
					}
					else {dajeQuattro=[];	}
				}
			}
			else {
				for (var i=parseInt(colGet)-3; i<7; i++) { //i dovrebbe partire da colGet-3)
					if (colonne[parseInt(i)][parseInt(rigaGet)]==colore){
						dajeQuattro.push(i+"_"+rigaGet);
						if (dajeQuattro.length==victoryReq){
							victoryFound=true;
							dichiaraVit(colore);
						}
					}
					else {
						dajeQuattro=[];
					}
				}
			}
		}	
		//Check Diagonale
		if (victoryFound==false){
			dajeQuattro=[];
			var rigaGet=parseInt(altezzeColonne[colGet]);
			var ridStart;
			if (colGet<rigaGet){ridStart=colGet;}
			else {ridStart=rigaGet};
			var colStart=parseInt(colGet)-ridStart; console.log(colGet+" - "+ridStart+" = "+colStart);
			var rigaStart=rigaGet-ridStart; console.log(rigaGet+" - "+ridStart+" = "+rigaStart);
			for (var i=0; i+colStart<7 && parseInt(rigaStart)+i<6; i++) {
				if (colonne[colStart+i][parseInt(rigaStart)+i]==colore){
					dajeQuattro.push((colStart+i)+"_"+(rigaStart+i)); console.log((colStart+i)+"_"+(rigaStart+i)+" aggiunto ai gettoni vincenti");
					if (dajeQuattro.length==victoryReq){
						victoryFound=true;
						dichiaraVit(colore);
					}
				}
				else {	dajeQuattro=[];
				}
			}	
		}	
		//Check Diagonale inverso
		if (victoryFound==false){
			dajeQuattro=[];
			var rigaGet=parseInt(altezzeColonne[colGet]);
			var ridStart;
			var invColGet=6-parseInt(colGet);
			if (invColGet<rigaGet){ridStart=invColGet;}
			else {ridStart=rigaGet};
			var colStart=parseInt(colGet)+ridStart; console.log(colGet+" - "+ridStart+" = "+colStart);
			var rigaStart=rigaGet-ridStart; console.log(rigaGet+" - "+ridStart+" = "+rigaStart);
			for (var i=0; colStart-i>=0 && parseInt(rigaStart)+i<6; i++) {
				if (colonne[colStart-i][parseInt(rigaStart)+i]==colore){
					dajeQuattro.push((colStart-i)+"_"+(rigaStart+i)); console.log((colStart-i)+"_"+(rigaStart+i)+" aggiunto ai gettoni vincenti");
					if (dajeQuattro.length==victoryReq){
						victoryFound=true;
						dichiaraVit(colore);
					}
				}
				else {	dajeQuattro=[];
				}
			}	
		}
	}
	function dichiaraVit(coloreGettone){
		var vincitore;
		var coloreVittoria;
		if (coloreGettone==="red"){ vincitore="Hot Otter"; coloreVittoria="mediumvioletred"}
		if (coloreGettone==="orange"){ vincitore="Happy Hippo"; coloreVittoria="yellow"}
		alert("ha vinto "+vincitore+" ("+coloreGettone+")")
		$(".pulsPl").prop("disabled",true);
		for (var i=0; i<4; i++) {
			$("#"+dajeQuattro[i]).css("background-color", coloreVittoria);
		}
	}
	
})