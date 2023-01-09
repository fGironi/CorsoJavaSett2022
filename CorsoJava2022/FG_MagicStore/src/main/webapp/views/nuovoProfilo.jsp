<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Nuovo Profilo</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Theme style -->
  <link rel="stylesheet" href="static/css/adminlte.min.css">
   <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
	<!-- Bootstrap -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
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
            <a href="banco" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Banco
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="studio" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Studio
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="profilo" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Profilo
              </p>
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
            <h1>Creazione di un nuovo profilo</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href=".">Home</a></li>
              <li class="breadcrumb-item active">Nuovo Profilo</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

     <!-- qua la roba -->
	<div class="clearfix">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<form:form method="post" action="creaProfilo" modelAttribute="magoReq">
				<div class="row">
					<div class="col-sm-6">
						<div class="form-check">
						  <form:radiobutton class="form-check-input" path="avatarURL" id="maleAvatar" value="https://cdn-icons-png.flaticon.com/512/1205/1205647.png"/>
						  <form:label class="form-check-label" path="avatarURL">
						    <img src="https://cdn-icons-png.flaticon.com/512/1205/1205647.png" >
						  </form:label>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-check">
						  <form:radiobutton class="form-check-input" path="avatarURL" id="femaleAvatar" value="https://cdn-icons-png.flaticon.com/512/1205/1205659.png"/>
						  <form:label class="form-check-label" path="avatarURL">
						    <img src="https://cdn-icons-png.flaticon.com/512/1205/1205659.png" 
						  </form:label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col text-center">
						<form:input path="nome" class="form-control" type="text" placeholder="Nome Mago" aria-label="default input example"/>
						<button type="submit" class="btn btn-lg btn-success"><b>Crea</b></button>
					</div>
				</div>
				</form:form>
			</div>
			<div class="col-sm-2>"</div>
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

</body>
</html>
