<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

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
<label id="labelIdOgg">Oggetti disponibili:</label>
<select name="idOgg" id="idOgg">
  "${oggetti}"

 </select>
 <button type="submit" value="Prendi oggetto">Prendi Oggetto</button>
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
<a href="testForm"><button>Crea un nuovo oggetto</button></a>



</body>
</html>