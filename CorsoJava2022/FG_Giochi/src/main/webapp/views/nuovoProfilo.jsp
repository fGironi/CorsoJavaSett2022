<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>FG_Giochi - Nuovo Profilo</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Theme style -->
<link rel="stylesheet" href="static/css/adminlte.min.css">
<!-- Script gioco -->
<link rel="stylesheet" href="static/css/stileParola.css">


<!-- jQuery -->
<script src="static/js/plugins/jquery/jquery.min.js"></script>

<!-- Bootstrap 4 -->
	<script src="static/js/plugins/bootstrap/js/bootstrap.bundle.min.js"
		type="text/javascript"></script>

<script src="static/js/parolaScript.js"></script>


</head>
<body class="hold-transition sidebar-mini">
	<!-- Site wrapper -->
	<div class="wrapper">
		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#" role="button"><i class="fas fa-bars"></i></a></li>
				<li class="nav-item d-none d-sm-inline-block"><a
					href="/FG_Giochi" class="nav-link">Home</a></li>
			</ul>

			<!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">

			</ul>
		</nav>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a class="brand-link"> <span class="brand-text font-weight-light">neotech</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user (optional) -->

				<!-- SidebarSearch Form -->

				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
						<li class="nav-item"><a href="parolaIntro" class="nav-link"> <i
								class="fa-solid fa-book"></i>
								<p>
									Indovina la parola <span class="right badge badge-danger">New</span>
								</p>
						</a></li>
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
          <li class="nav-item">
            <a href="profiloUtente" class="nav-link">
             <i class="fa-solid fa-user"></i>
              <p>
                Il tuo profilo
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
							<h1>Crea il tuo profilo</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="/FG_Giochi">Home</a></li>
								<li class="breadcrumb-item active">Nuovo Profilo</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<!-- /.stuff -->
				<div class="clearfix">
				<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6" style="text-align: center">
				<h4>Sei già un utente? metti il tuo ID e accedi!</h4>
				<form method="get" action="/FG_Giochi/login">
				<input name="id" type="text"></input><button type="submit" class="btn btn-sm btn-primary" id="login" value="submit">Accedi</button>
				</form>
				</div>
				<div class="col-sm-3"></div>
				</div>
				<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4" style="text-align: center">
				<h2 style="color: red">${errore}</h2>
				<h1>Iscriviti al sito!</h1>
				<p>piccola nota: il sito non fornisce alcun tipo di protezione reale, non mettere nessun dato sensibile!</p>
				</div>
				<div class="col-sm-4"></div>
				</div>
				<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4 d-flex justify-content-center">	
					<form:form action="/FG_Giochi/creaProfiloGiocatore" method="POST" id="formNuovoUtente" modelAttribute="giocatoreDTO">
						<div class="row">
						<form:label id="labelNome" path="nome">Scrivi il tuo nome</form:label>
						<form:input id="inputNome" path="nome"></form:input>
						</div><div class="row">
						<form:label id="labelIcona" path="icona">Scegli la tua icona</form:label><br>					
						<form:radiobutton id="iconaStella" path="icona" value="fa-star"></form:radiobutton><i class="fa-solid fa-star"></i>
						<form:radiobutton id="iconaCacca" path="icona" value="fa-poo"></form:radiobutton><i class="fa-solid fa-poo"></i>
						<form:radiobutton id="iconaIppo" path="icona" value="fa-hippo"></form:radiobutton><i class="fa-solid fa-hippo"></i>
						<form:radiobutton id="iconaFulmine" path="icona" value="fa-bolt"></form:radiobutton><i class="fa-solid fa-bolt"></i>
						<form:radiobutton id="iconaLontra" path="icona" value="fa-otter"></form:radiobutton><i class="fa-solid fa-otter"></i>
						<form:radiobutton id="iconaFantasma" path="icona" value="fa-ghost"></form:radiobutton><i class="fa-solid fa-ghost"></i>
						</div>
						<button class="btn btn-primary" value="submin">Iscriviti</button>
					</form:form>
				
				</div>
				<div class="col-sm-4"></div>
				</div>
				
				
				
				
				
				
				</div>			
				
			</section>
		</div>


						




		<section></section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->


	<footer class="main-footer">
		<div class="float-right d-none d-sm-block">
			<a href="www.neotech.srl">www.neotech.srl</a>
		</div>
		<strong>template</strong>
	</footer>

	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark">
		<!-- Control sidebar content goes here -->
	</aside>
	<!-- /.control-sidebar -->
	<div></div>
	<!-- ./wrapper -->


	<!-- AdminLTE App -->
	<script src="static/js/adminlte.min.js" type="text/javascript"></script>
	<!-- Demo Template -->
	<script src="static/js/fireAjax.js" type="text/javascript"></script>
	<script src="static/js/demoTemplate.js" type="text/javascript"></script>
	
	

</body>
</html>
