<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>FG_Giochi - Indovina la Parola</title>

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


<script src="static/js/parolaSpiegazioneScript.js"></script>

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
							<h1>Indovina la parola</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="/FG_Giochi">Home</a></li>
								<li class="breadcrumb-item active">Indovina la parola</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<!-- /.stuff -->
				
				
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6 d-flex justify-content-center">
									<select class="form-select" id="mode">
										<option selected>Scegli una modalita'...</option>
										<option value="capitale">Geografia - Capitale</option>>
										<option value="animaliENG">Inglese - Animali</option>
										<option value="pokemon">Pokemon - nome</option>
										<option value="lol">League of Legends - Campioni</option>
										<option value="rock">Rock - nome band</option>
									</select>
								
								<a id="genera"><button disabled="true" class="btn btn-primary" id="generaPuls" type="button">Nuova
										Partita</button></a>
								</div>	
					<div class="col-sm-3"></div>	
					</div>
				<div class="row">
				<div class="col-sm-10"></div>
				<div class="col-sm-2">
				<a href="profiloUtente"><i class="fa-solid ${iconaUser}">${nomeUser}</i></a>
				</div>
				
				
				</div>	
				
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
					
						<div id="istruzioni">
							<c:choose>
							<c:when test="${id=='null'}"><h4>Benvenuto!</h4></c:when>
							<c:otherwise>Bentornato!</c:otherwise>
							</c:choose>
							<h2>Indovina la parola!</h2>
							<p>seleziona la modalita' di gioco, quindi premi su nuova partita</p>
							<p>puoi selezionare una lettera dalla tastiera virtuale o usando la tua tastiera reale</p>
							<p>per confermare la lettera puoi premere invio, il segno di conferma o l'enorme lettera al centro dello schermo</p>
							<p>Ad ogni errore perderai una vita(<i class="vitG fa-solid fa-heart"></i>), cerca di indovinare prima di finirle!</p>
							<p>Se la "parola" è composta da più di una parola lo spazio sarà indicato con un trattino basso (_)</p>
							<p>allo stesso modo, se c'è un apostrofo sarà già presente nella tabella!</p>
							<p>se ti senti particolarmente bravo, puoi indovinare più parole di seguito recuperando una sola vita per volta, basta cliccare su "STREAK" quando indovini</p>
							<p>Buona fortuna!</p>
						</div>	
					</div>
					<div class="col-sm-2"></div>
				</div>
							
				
				
					
					
					<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
						<h3>TODO:</h3>
						<ul>
						<li>possibilita' di inserire la parola completa</li>
						<li>sistema di registrazione utente & highscore</li>  
						</ul>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
					</div>
					<div class="col-sm-2"></div>
				</div>
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
