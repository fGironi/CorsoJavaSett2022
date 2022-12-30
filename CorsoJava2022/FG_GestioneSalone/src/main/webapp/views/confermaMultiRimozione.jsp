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
  
  	<link rel="stylesheet" href="static/css/autoSaloneStyle.css">
  
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
            <h1>Conferma rimozione</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Conferma rimozione</li>
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
      		<div class="col-sm-3"></div>
      		<div class="col-sm-6" style="text-align:center">
      			<h2 style="color: crimson">Vuoi rimuovere queste auto?</h2>
      		</div>
      		<div class="col-sm-3"></div>
      	</div>
      	
      	<c:forEach items="${listaRimozione}" var="automobile">
      	<div class="row">
      		<div class="col-md-3"></div>
      		<div class="col-md-6 d-flex justify-content-center" style="text-align:center">
      				<table class="table table-striped table-hover table-bordered">
      					<tr>
      						<th class="table-dark" colspan="2">Dettagli Auto</th>
      					</tr>
      					<tr>
      						<td>ID Auto</td>
      						<td>${automobile.id}</td>
      					</tr>
      					<tr>
      						<td>Targa</td>
      						<td>${automobile.targa}</td>
      					</tr>
      					<tr>
      						<td>Costruttore</td>
      						<td>${automobile.costruttore}</td>
      					</tr>
      					<tr>
      						<td>Modello</td>
      						<td>${automobile.modello}</td>
      					</tr>
      					<tr>
      						<td>Anno</td>
      						<td>${automobile.annoCostruzione}</td>
      					</tr>
      					<tr>
      						<td>Costo Base</td>
      						<td>${automobile.costoBase}</td>
      					</tr>
      					<tr>
      						<td>Costo totale</td>
      						<td>${automobile.costo}</td>
      					</tr>
      					<tr>
      						<td>Alimentazione</td>
      						<td>${automobile.alimentazione}</td>
      					</tr>
      					<tr>
      						<td>Colore</td>
      						<td>${automobile.colore}</td>
      					</tr>
      					
      				<tr><th class="table-dark" colspan="2">Accessori</th></tr>
      				<c:forEach items="${automobile.accessori}" var="accessorio">
      					<tr>
      						<td>${accessorio.tipologia} - ${accessorio.descrizione}</td>
      						<td>${accessorio.costo} €</td>
      					</tr>
					</c:forEach>	
      				</table>
      		</div>
      		<div class="col-md-3"></div>
      	</div>
      	</c:forEach>
      	<div class="row" >
      		<div class="col-md-12 d-flex justify-content-center">
      			<div class="dangerSpace" style="margin-top: 20px; margin-bottom:15px">
      				<i class="fa-solid fa-triangle-exclamation">ATTENZIONE: l'operazione non puo' essere annullata</i>
      			</div>
      		</div>
      	</div>  
      	<div class="row">
      		<div class="col-md-12 d-flex justify-content-center">
      		<form:form method="post" action="rimozioneMultiplaConfermata" modelAttribute="multiRemoverConfirmed">
      		<c:forEach items="${listaRimozione}" var="automobile">
      		<form:hidden path="removeIdList" value="${automobile.id}"/>
      		
      		</c:forEach>
      		
      		
      			<button type="submit" class="btn btn-lg btn-danger"><b>RIMUOVI</b></button>
      		</form:form>
      		</div>
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
