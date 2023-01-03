<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>FG_ValutaClasse</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="static/css/adminlte.min.css">
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
  <!-- Bootstrap 5 -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
	
  
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
            <a href="#" class="nav-link">
              <i class="nav-icon fa-solid fa-square-plus"></i>
              <p>
                Crea
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="creaClasse" class="nav-link">
                  <i class="fa-solid fa-users-line nav-icon"></i>
                  <p>Crea Classe</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="creaConsegna" class="nav-link">
                  <i class="fa-solid fa-calendar-plus nav-icon"></i>
                  <p>Crea Consegna</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="creaStudente" class="nav-link">
                  <i class="fa-solid fa-user-plus nav-icon"></i>
                  <p>Crea Studente</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
            <a href="daiVoti" class="nav-link">
              <i class="nav-icon fa-solid fa-check-to-slot"></i>
              <p>Assegna Voti</p>
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
            <h1>Home</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href=".">Home</a></li>
              <li class="breadcrumb-item active">ValutaClasse</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

	<div class="clearfix">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
			<form:form method="post" action="creazioneCl" modelAttribute="classeForm">
			<div class="row">
				<div class="col-sm-6">
					<form:label class="form-label" path="classe.nome">Nome classe</form:label><form:input class="form-control" path="classe.nome" placeholder="nome classe"/>
				</div>
				<div class="col-sm-6">
					<form:label class="form-label" path="classe.anno">Anno</form:label>
					<form:select path="classe.anno" class="form-select">
					   	<form:option value="" label="sel anno"/>
					   	 <c:forEach var = "y" begin = "2020" end = "2023">
					        <form:option value="${y}">${y}</form:option>
					     </c:forEach>
					</form:select>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
						<form:label class="form-label" path="classe.descrizione">Descrizione</form:label><form:textarea rows="3" class="form-control" path="classe.descrizione" placeholder="descrizione del corso"/>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div id="altroStud">			
						<form:label class="form-label" path="nomiStudenti">Aggiungi studente</form:label><form:input class="form-control" path="nomiStudenti" placeholder="nome studente"/>
					</div>
				</div>
			</div>
			<div class="row">	
				<div class="col-sm-12">
					<button id="addStud" type="button" class="btn btn-sm btn-primary"><i class="fa-solid fa-plus">Aggiungi studente</i></button>
				</div>
			</div>
			<div class="row">	
				<div class="col-sm-12 d-flex justify-content-center">
					<button type="submit" class="btn btn-lg btn-success"><i class="fa-solid fa-square-check"> Crea la classe</i></button>
				</div>
			</div>
			</form:form>
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
    <strong>template</strong>
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- AdminLTE App -->
<script src="static/js/adminlte.min.js"></script>
<!-- Demo Template -->
<script src="static/js/fireAjax.js"></script>
<script src="static/js/demoTemplate.js"></script>

<script type="text/javascript">
	$("#addStud").click(function(){
		var htmlStr='<input id="nomiStudenti" name="nomiStudenti" placeholder="nome studente" class="form-control" type="text" value="">';
		$("#altroStud").append(htmlStr);
	})
</script>
</body>
</html>
