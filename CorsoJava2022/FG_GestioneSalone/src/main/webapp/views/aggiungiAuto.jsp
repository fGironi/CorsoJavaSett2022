<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Template</title>

 	 <!-- Google Font: Source Sans Pro -->
 	 <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
 	 <!-- Font Awesome -->
 	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
 	 <!-- Theme style -->
  	<link rel="stylesheet" href="static/css/adminlte.min.css">
 	 <!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.2.min.js" integrity="sha256-2krYZKh//PcchRtd+H+VyyQoZ/e3EcrkxhM8ycwASPA=" crossorigin="anonymous"></script>
	<!-- Bootstrap -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
	<!-- AdminLTE App -->
	<script src="static/js/adminlte.min.js"></script>
	<!-- Demo Template -->
	<script src="static/js/fireAjax.js"></script>
	<script src="static/js/demoTemplate.js"></script>
  
</head>
<body class="hold-transition sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="" class="nav-link">Home</a>
      </li>
    </ul>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
    
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a  class="brand-link">
      <span class="brand-text font-weight-light">neotech</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->

      <!-- SidebarSearch Form -->

      <!-- Sidebar Menu -->
      <nav class="mt-2">
         <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
                    
          <li class="nav-item">
          	<a href="listaAuto" class="nav-link">
         		<i class="fa-solid fa-rectangle-list"></i>
          		<p>Lista automobili</p>
          	</a>
          </li>
          <li class="nav-item">
          	<a href="aggiuntaAuto" class="nav-link">
         		<i class="fa-solid fa-folder-plus"></i>
          		<p>Aggiungi automobili</p>
          	</a>
          </li>
          <li class="nav-item">
          	<a href="rimozioneAuto" class="nav-link">
         		<i class="fa-solid fa-folder-minus"></i>
          		<p>Rimuovi automobili </p>
          	</a>
          </li>
          <li class="nav-item">
          	<a href="cercaAuto" class="nav-link">
         		<i class="fa-solid fa-magnifying-glass"></i>
          		<p>Cerca automobile</p>
          	</a>
          </li>
          <li class="nav-item">
          	<a href="dettaglioAuto" class="nav-link">
         		<i class="fa-solid fa-circle-info"></i>
          		<p>Dettaglio automobile </p>
          	</a>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Gestione Autosalone - Home</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Aggiungi automobile</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Qua la roba -->
      <div class="clearfix">
      	<div class="formArea" style="width:80%">
     		<form:form method="post" action="aggiungi" modelAttribute="automobile">
       		<div class="row whiteRow" style="background-color:white">
    			<div class="col-md-4">
    				<form:label id="lblTarga" path="targa">Targa:</form:label>
    				<form:input id="inTarga" path="targa"></form:input>
    			</div>
      			<div class="col-md-4">
      				<form:label id="lblCostruttore" path="costruttore">Costruttore:</form:label>
      				<form:select path="costruttore">
				    	<form:option value="-" label="sel costruttore"/>
				    	<form:options items="${costruttori}" />
					</form:select>
      			</div>
      			<div class="col-md-4">
      				<form:label id="lblModello" path="modello">Modello:</form:label>
    				<form:input id="inModello" path="modello"></form:input>
      			</div>
      		</div>
      		<div class="row blueRow" style="background-color:lightblue">
    			<div class="col-md-3">
    				<form:label id="lblAlimentazione" path="alimentazione">Alimentazione:</form:label>
    				<form:select id="inAlimentazione" path="alimentazione">
				    	<form:option value="-" label="sel alimentazione"/>
				    	<form:options items="${alimentazioni}" />
					</form:select>
    			</div>
      			<div class="col-md-3">
      				<form:label id="lblAnno" path="annoCostruzione">Anno costruzione</form:label>
      				<form:select id="inAnno" path="annoCostruzione">
				    	<form:option value="-" label="sel anno"/>
				    	 <c:forEach var = "anno" begin = "1900" end = "2022">
					        <form:option value="${anno}">${anno}</form:option>
					     </c:forEach>
					</form:select>
      			</div>
      			<div class="col-md-3">
      				<form:label id="lblColore" path="colore">Colore:</form:label>
      				<form:select id="inColore" path="colore">
				    	<form:option value="-" label="sel colore"/>
				    	<form:options items="${colori}" />
					</form:select>
      			</div>
      			<div class="col-md-3">
      				<form:label id="lblCosto" path="costo">Costo:</form:label>
      				<form:input id="inCosto" path="costo"></form:input>
      			</div>
      		</div>
      		<div class="row whiteRow" style="background-color:white">
    			<div class="col-md-10">
    				QUI CI SARANNO GLI ACCESSORI
    			</div>
      			<div class="col-md-2">
      				<button id="btnAdd" type="submit" class="btn btn-primary">Aggiungi</button>
      			</div>
      			
      		</div>
      		
      	    </form:form>
      </div>
      
      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">
    <div class="float-right d-none d-sm-block"><a href="www.neotech.srl">www.neotech.srl</a></div>
    <strong>Gestione Autosalone</strong>
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->



</body>
</html>
