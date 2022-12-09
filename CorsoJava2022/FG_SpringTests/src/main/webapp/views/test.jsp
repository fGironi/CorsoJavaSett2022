<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
<script
  src="https://code.jquery.com/jquery-3.6.1.min.js"
  integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
  crossorigin="anonymous"></script>
</head>
<body>

<h1>Dovrebbe succedere roba nella console, glhf</h1>
<p>Benvenuto, il codice del tuo carrello è: ${codiceInv}</p>

<form action="testAdd" method="get">
<label for="idOgg">Oggetti disponibili:</label>
<select name="idOgg" id="idOgg">
  <option value="A1">Sfera</option>
  <option value="B2">Cubo</option>
  <option value="C3">Piramide</option>
 </select>
 <input type="submit" value="Prendi oggetto"></input>
 </form>
 
 
	<label for="idInv">Inserisci il tuo codice inventario:</label>
    <input type="text" name="idInv" id="idInv"></input><button id="confermaCod">Conferma</button><br>
 <a id="mostraOgg" href=""><button id="mostraOggPuls" disabled="true">Mostra oggetti</button></a>
<script>
	$(document).ready();
	$("#confermaCod").click(function(){
		$("#mostraOggPuls").prop('disabled', false)
		$("#mostraOgg").attr("href", "testPrint/"+$("#idInv").val());
	})
	
</script>





<a href="testCalc"><button>Somma valore oggetti</button></a>



</body>
</html>