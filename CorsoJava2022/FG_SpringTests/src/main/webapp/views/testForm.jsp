<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<div class="clearfix">
		<div class="row">
		<div class="col-md-2"></div>
			<div class="col-md-8">
				<form:form action="/FG_SpringTests/testPost" method="POST" id="formDiProva" modelAttribute="oggettoDTO">
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-4">	
						<form:label id="nomeOgg" path="nome">Nome Oggetto</form:label>
						<form:input id="labelNome" path="nome"></form:input>
					</div>
					<div class="col-sm-4">	
						<form:label id="valoreOgg" path="valore">Valore Oggetto</form:label>
						<form:select id="LabelValore" path="valore">
							<form:option id="valSel" value="">Seleziona un valore</form:option>
							<form:option id="valSel" value="0">0</form:option>
							<form:option id="valSel" value="1">1</form:option>
							<form:option id="valSel" value="2">2</form:option>
							<form:option id="valSel" value="3">3</form:option>
							<form:option id="valSel" value="4">4</form:option>
							<form:option id="valSel" value="5">5</form:option>
							<form:option id="valSel" value="6">6</form:option>
							<form:option id="valSel" value="7">7</form:option>
							<form:option id="valSel" value="8">8</form:option>
							<form:option id="valSel" value="9">9</form:option>					
						</form:select>						
					</div>
					<div class="col-sm-2"></div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-4">	
						<form:label id="labelNotes" path="note">Note</form:label>
						<form:textarea id="notes" path="note"></form:textarea>
					</div>
					<div class="col-sm-4">	
						<button value="submit">Crea Oggetto</button>
					</div>
					<div class="col-sm-2"></div>
				</div>
			</form:form>
				</div>
				<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>