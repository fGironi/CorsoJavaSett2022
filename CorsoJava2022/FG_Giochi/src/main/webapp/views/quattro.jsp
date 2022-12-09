<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>FG_Giochi - Home</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="static/css/adminlte.min.css">
  <!-- jQuery -->
<script src="static/js/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="static/js/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="static/js/adminlte.min.js"></script>
<!-- Demo Template -->
<script src="static/js/fireAjax.js"></script>
<script src="static/js/demoTemplate.js"></script>
  
  
  <!-- Stile&Codice Quattro -->
  <link rel="stylesheet" href="static/css/stileQuattro.css">
  <script src="static/js/quattroScript.js"></script>
  
  
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
        <a href="/FG_Giochi" class="nav-link">Home</a>
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
            <a href="parola" class="nav-link">
             <i class="fa-solid fa-book"></i>
              <p>
                Indovina la parola
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="dajequattro" class="nav-link">
             <i class="fa-solid fa-coins"></i>
              <p>
                DajeQuattro
                <span class="right badge badge-danger">New</span>
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
            <h1>DajeQuattro</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="/FG_Giochi">Home</a></li>
              <li class="breadcrumb-item active">DajeQuattro</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
		<div class="clearfix">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6 d-flex justify-content-center"><h2>Metti 4 gettoni in fila per vincere!</h2></div>
				<div class="col-sm-3"></div>
			</div>
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6 d-flex justify-content-center"">
					<a href="dajequattro" class="nav-link"><button type="button" class="btn btn-primary"><i class="fa-solid fa-coins"> NUOVA PARTITA</i></button></a>
				</div>
				<div class="col-sm-3"></div>
			</div>	
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6 d-flex justify-content-center"">
					<div id="players">
					<i class="fa-solid fa-otter redplayer">Hot Otter</i> vs	<i class="fa-solid fa-hippo yellowplayer">Happy Hippo</i>
					</div>
				</div>
				<div class="col-sm-3"></div>
			</div>			
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6 d-flex justify-content-center">
					<table id="freccegiu">
					<tr>
					<td><i class="fa-solid fa-arrow-down"></i></td>
					<td><i class="fa-solid fa-arrow-down"></i></td>
					<td><i class="fa-solid fa-arrow-down"></i></td>
					<td><i class="fa-solid fa-arrow-down"></i></td>
					<td><i class="fa-solid fa-arrow-down"></i></td>
					<td><i class="fa-solid fa-arrow-down"></i></td>
					<td><i class="fa-solid fa-arrow-down"></i></td>
					</tr>
					
					</table>


				</div>
				<div class="col-sm-3"></div>
			</div>
			
			
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6 d-flex justify-content-center">
					<table class="tabQuattro">
					<tr id="riga5">
					<td class="cellQuattro" id="0_5"></td>
					<td class="cellQuattro" id="1_5"></td>
					<td class="cellQuattro" id="2_5"></td>
					<td class="cellQuattro" id="3_5"></td>
					<td class="cellQuattro" id="4_5"></td>
					<td class="cellQuattro" id="5_5"></td>
					<td class="cellQuattro" id="6_5"></td>
					</tr>
					<tr id="riga4">
					<td class="cellQuattro" id="0_4"></td>
					<td class="cellQuattro" id="1_4"></td>
					<td class="cellQuattro" id="2_4"></td>
					<td class="cellQuattro" id="3_4"></td>
					<td class="cellQuattro" id="4_4"></td>
					<td class="cellQuattro" id="5_4"></td>
					<td class="cellQuattro" id="6_4"></td>
					</tr>
					<tr id="riga3">
					<td class="cellQuattro" id="0_3"></td>
					<td class="cellQuattro" id="1_3"></td>
					<td class="cellQuattro" id="2_3"></td>
					<td class="cellQuattro" id="3_3"></td>
					<td class="cellQuattro" id="4_3"></td>
					<td class="cellQuattro" id="5_3"></td>
					<td class="cellQuattro" id="6_3"></td>
					</tr>
					<tr id="riga2">
					<td class="cellQuattro" id="0_2"></td>
					<td class="cellQuattro" id="1_2"></td>
					<td class="cellQuattro" id="2_2"></td>
					<td class="cellQuattro" id="3_2"></td>
					<td class="cellQuattro" id="4_2"></td>
					<td class="cellQuattro" id="5_2"></td>
					<td class="cellQuattro" id="6_2"></td>
					</tr>
					<tr id="riga1">
					<td class="cellQuattro" id="0_1"></td>
					<td class="cellQuattro" id="1_1"></td>
					<td class="cellQuattro" id="2_1"></td>
					<td class="cellQuattro" id="3_1"></td>
					<td class="cellQuattro" id="4_1"></td>
					<td class="cellQuattro" id="5_1"></td>
					<td class="cellQuattro" id="6_1"></td>
					</tr>
					<tr id="riga0">
					<td class="cellQuattro" id="0_0"></td>
					<td class="cellQuattro" id="1_0"></td>
					<td class="cellQuattro" id="2_0"></td>
					<td class="cellQuattro" id="3_0"></td>
					<td class="cellQuattro" id="4_0"></td>
					<td class="cellQuattro" id="5_0"></td>
					<td class="cellQuattro" id="6_0"></td>
					</tr>
					</table>
				</div>
				<div class="col-sm-3"></div>
				</div>
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6 d-flex justify-content-center">
						<div id="baseQuattro"></div>
					</div>
					<div class="col-sm-3"></div>
				</div>
				<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6 d-flex justify-content-center">
				<table class="pulsQuattro">
				<tr id="pulsanti">
				<td class="celPuls"><button type="button" class="btn btn-danger pulsPl pulsR" id="puls0" value=0><i class="fa-solid fa-circle-up"></i></button></td>
				<td class="celPuls"><button type="button" class="btn btn-danger pulsPl pulsR" id="puls1" value=1><i class="fa-solid fa-circle-up"></i></button></td>
				<td class="celPuls"><button type="button" class="btn btn-danger pulsPl pulsR" id="puls2" value=2><i class="fa-solid fa-circle-up"></i></button></td>
				<td class="celPuls"><button type="button" class="btn btn-danger pulsPl pulsR" id="puls3" value=3><i class="fa-solid fa-circle-up"></i></button></td>
				<td class="celPuls"><button type="button" class="btn btn-danger pulsPl pulsR" id="puls4" value=4><i class="fa-solid fa-circle-up"></i></button></td>
				<td class="celPuls"><button type="button" class="btn btn-danger pulsPl pulsR" id="puls5" value=5><i class="fa-solid fa-circle-up"></i></button></td>
				<td class="celPuls"><button type="button" class="btn btn-danger pulsPl pulsR" id="puls6" value=6><i class="fa-solid fa-circle-up"></i></button></td>
				</tr>
				</table>
				</div>
				<div class="col-sm-3"></div>
				</div>


				
				
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



</body>
</html>
