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
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
	<!-- AdminLTE App -->
	<script src="static/js/adminlte.min.js"></script>
	<!-- Demo Template -->
	<script src="static/js/fireAjax.js"></script>
	<script src="static/js/demoTemplate.js"></script>
	<!-- Validate -->
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
	<script src="static/js/searchValidation.js"></script>
  
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
        <a href="." class="nav-link">Home</a>
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
            <h1>Cerca automobile</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href=".">Home</a></li>
              <li class="breadcrumb-item active">Cerca automobile</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Qua la roba -->
      <div class="clearfix">
	      <div class="row">
	      	<div class="col-md-2"></div>
	      	<div class="col-md-8" style="border:2px solid black; padding:10px">
	      		<form:form action="cerca" method="post" modelAttribute="paragoneRicerca" id="formCercaAuto">
	      		<div class="row">
	      			<div class="col-md-4">
	      				<form:input placeholder="Targa" class="form-control" path="targa"/>
	      			</div>
	      			<div class="col-md-4">
	      				<form:select id="paragCostruttore" path="costruttore" class="form-select">
					    	<form:option value="" label="sel costruttore"/>
					    	<form:options items="${costruttori}" />
						</form:select>
	      			</div>
	      			<div class="col-md-4">
	      				<form:input placeholder="Modello" class="form-control" path="modello"/>
	      			</div>
	      		</div>
	      		<div class="row">
	      			<div class="col-md-3">
		      			<form:select id="annoMin" path="annoCostrMin" class="form-select">
					    	<form:option value="" label="anno minimo"/>
					    	 <c:forEach var = "anno" begin = "1900" end = "2022">
						        <form:option value="${anno}">${anno}</form:option>
						     </c:forEach>
						</form:select>
					</div>
					<div class="col-md-3">
		      			<form:select id="annoMax" path="annoCostrMax" class="form-select">
					    	<form:option value="" label="anno massimo"/>
					    	 <c:forEach var = "anno" begin = "1900" end = "2022">
						        <form:option value="${anno}">${anno}</form:option>
						     </c:forEach>
						</form:select>
					</div>
	      			<div class="col-md-3">
	      				<form:select id="paragAlimentazione" path="alimentazione" class="form-select">
					    	<form:option value="" label="sel alimentazione"/>
					    	<form:options items="${alimentazioni}" />
						</form:select>
	      			</div>
	      			<div class="col-md-3">
	      				<form:select id="paragColore" path="colore" class="form-select">
					    	<form:option value="" label="sel colore"/>
					    	<form:options items="${colori}" />
						</form:select>
	      			</div>
	      		</div>
	      		<div class="row">
		      		<div class="col-md-3">
						<form:input placeholder="Costo Base Min" class="form-control" path="costoBaseMin"/>
		      		</div>
		      		<div class="col-md-3">
						<form:input placeholder="Costo Base Max" class="form-control" path="costoBaseMax"/>
		      		</div>
		      		<div class="col-md-3">
						<form:input placeholder="Costo Tot Min" class="form-control" path="costoMin"/>
		      		</div>
		      		<div class="col-md-3">
						<form:input placeholder="Costo Tot Max" class="form-control" path="costoMax"/>
		      		</div>
		      	</div>
		      	<div class="row">
			      	<div class="col-md-12" style="text-align:center">
			      		<button type="submit" class="btn btn-lg btn-primary">Cerca</button>	
			      	</div>
		      	</div>
	      		</form:form>
	      	</div>
	      	<div class="col-md-2"></div>
	      </div>
	      
	      <div class="row">
		      <div class="col-sm-2"></div>
		      <div class="col-sm-8" style="text-align:center">
		      	<h2>Risultati ricerca</h2>
		      </div>
	    	  <div class="col-sm-2"></div>
	      </div>
	      
	      <div class="row">
		      <div class="col-sm-2"></div>
		      <div class="col-sm-8 d-flex justify-content-center">
		      	<div class="table-responsive overflow-auto" id="tabSpace">
		      	<table id="tabAuto" class="table table-striped table-hover table-bordered">
		      		<tr class="table-dark">
		      			<th hidden class="autoDataCel"><b>ID</b></th>
		      			<th class="autoDataCel"><b>Targa</b></th>
		      			<th class="autoDataCel"><b>Costruttore</b></th>
		      			<th class="autoDataCel"><b>Modello</b></th>
		      			<th class="autoDataCel"><b>Anno</b></th>
		      			<th class="autoDataCel"><b>Costo base</b></th>
		      			<th class="autoDataCel"><b>Costo totale</b></th>
		      			<th class="autoDataCel"><b>Alimentazione</b></th>
		      			<th class="autoDataCel"><b>Colore</b></th>
		      			<th class="autoDataCel"><b>Accessori</b></th>
		      			<th class="autoDataCel"><b>Azioni</b></th>
		      		</tr>	
		      	<c:forEach items="${autoTrovate}" var="auto">
		      		<tr>
		      			<td hidden class="autoDataCel">${auto.id}</td>
		      			<td class="autoDataCel">${auto.targa}</td>
		      			<td class="autoDataCel">${auto.costruttore}</td>
		      			<td class="autoDataCel">${auto.modello}</td>
		      			<td class="autoDataCel">${auto.annoCostruzione}</td>
		      			<td class="autoDataCel">${auto.costoBase}</td>
		      			<td class="autoDataCel">${auto.costo}</td>
		      			<td class="autoDataCel">${auto.alimentazione}</td>
		      			<td class="autoDataCel">${auto.colore}</td>
		      			<td class="autoDataCel"><div class="dropdown">
							<button class="btn btn-light btn-sm dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
							   Accessori
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<c:forEach items="${auto.accessori}" var="accessorio">
				      				<li><p class="dropdown-item">${accessorio.descrizione}</p></li>
				      			</c:forEach>
							</ul>
						</div></td>
		      			<td class="autoDataCel"><div class="btn-group" role="group" >
		      				<a href="dettaglioAuto?idAuto=${auto.id}"<button type="button" class="btn btn-dark"><i class="fa-solid fa-circle-info"></i></button></a>
		      				<a href="modifica?idAuto=${auto.id}"<button type="button" class="btn btn-dark" title="Modifica"><i class="fa-solid fa-pen-to-square"></i></button></a>
      						<a href="confermaRimozione?idAuto=${auto.id}"<button type="button" class="btn btn-dark" title="Rimuovi"><i class="fa-solid fa-trash"></i></button></a>
		      			</div></td>
		      		</tr>	
		
		 	    </c:forEach>
		      			
		      	</table></div>
		      	
		      </div>
	    	  <div class="col-sm-2"></div>
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
