<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>FG_AppWeb01 - pagina di testing</title>
	 <!-- Google Font: Source Sans Pro -->
  	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  	<!-- Font Awesome -->
	  <link rel="stylesheet" href="static/js/plugins/fontawesome-free/css/all.min.css">
 	 <!-- Theme style -->
  <link rel="stylesheet" href="static/css/adminlte.min.css">
</head>
<body>
	<h1>Testo del test</h1>
	<h2>un modo pigro per provare la visualizzazione della pagina</h2>
	<div>
		<p>
			questo è un testo poco importante, praticamente un lorem ipsum<br>
			non ha alcuno scopo reale ma mi aiuta a capire gli spazi all'interno della pagina<br>
			<b>daje</b><br>
			A seguire un form di pari importanza al testo sopra riportato:
		<p>
		
	</div>
	<div>
	<form name="form iscrizione" method="get">
		<label for="nickname">inserisci il tuo nickname</label>
		<input type="text" name="nickname" value=""><br>
		<label for="privacy">privacy blablabla</label>
		<input type="checkbox" name="privacy" value="accettata"><br>
		<label for="radio">quanto sei bravo</label>
		poco <input type="radio" name="bravura" value=poco">  
		medio <input type="radio" name="bravura" value=medio">  
		tanto <input type="radio" name="bravura" value=tanto">
		<br>
		<button type="submit" name="invia" value="invia">Invia</button>
		<button type="button" name="annulla" value="annulla">Annulla</button><br>
		
	</form>
	</div>
</body>
</html>