<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
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
						<li class="nav-item"><a href="parola" class="nav-link"> <i
								class="fa-solid fa-book"></i>
								<p>
									Indovina la parola <span class="right badge badge-danger">New</span>
								</p>
						</a></li>
						</li>
           <li class="nav-item">
            <a href="dajequattro" class="nav-link">
             <i class="fa-solid fa-book"></i>
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
							<h1>Indovina la parola</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
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
										<option value="parola">Parola casuale - ITA</option>
										<option value="capitale">Geografia - Capitale</option>
										<option value="dragonball">Dragon Ball - Personaggio</option>
										<option value="test">TESTING</option>
									</select>
								
								<button class="btn btn-primary" type="button" id="genera">Genera
										Parola</button>
								</div>	
					<div class="col-sm-3"></div>	
					</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
						<div id="tentativi">
							<i id="vita7" class="fa-solid fa-heart"></i>
							<i id="vita6" class="fa-solid fa-heart"></i>
							<i id="vita5" class="fa-solid fa-heart"></i>
							<i id="vita4" class="fa-solid fa-heart"></i>
							<i id="vita3" class="fa-solid fa-heart"></i>
							<i id="vita2" class="fa-solid fa-heart"></i>
							<i id="vita1" class="fa-solid fa-heart"></i>
						</div>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
						<div id="parolaRnd">
							<h2> Indovina la parola!</h2>
							<p>seleziona la modalità di gioco, quindi premi su genera parola</p>
							<p>premi una lettera e poi il tasto di conferma per inviare</p>
							<p>se in una casella c'è _ vuol dire che là c'è uno spazio</p>
						</div>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4 d-flex justify-content-center align-items-center">
					<div data-toggle="buttons" id="tastiera">
						<div class="btn-group btn-group-toggle btn-group-justified" role="group">
					
							<label class="btn btn-light" id="lLetQ"> <input type="radio" value="Q"
								name="letter" id="pLetQ" autocomplete="off"> Q
							</label><label class="btn btn-light" id="lLetW"> <input type="radio" value="W"
								name="letter" id="pLetW" autocomplete="off"> W 
							</label><label class="btn btn-light" id="lLetE"> <input type="radio" value="E"
								name="letter" id="pLetE" autocomplete="off"> E
							</label><label class="btn btn-light" id="lLetR"> <input type="radio" value="R"
								name="letter" id="pLetR" autocomplete="off"> R
							</label><label class="btn btn-light" id="lLetT"> <input type="radio" value="T"
								name="letter" id="pLetT" autocomplete="off"> T
							</label><label class="btn btn-light" id="lLetY"> <input type="radio" value="Y"
								name="letter" id="pLetY" autocomplete="off"> Y
							</label><label class="btn btn-light" id="lLetU"> <input type="radio" value="U"
								name="letter" id="pLetU" autocomplete="off"> U
							</label><label class="btn btn-light" id="lLetI"> <input type="radio" value="I"
								name="letter" id="pLetI" autocomplete="off"> I
							</label><label class="btn btn-light" id="lLetO"> <input type="radio" value="O"
								name="letter" id="pLetO" autocomplete="off"> O
							</label><label class="btn btn-light" id="lLetP"> <input type="radio" value="P"
								name="letter" id="pLetP" autocomplete="off"> P
							</label>
							</div><div class="btn-group btn-group-toggle btn-group-justified" role="group">
							<label class="btn btn-light" id="lLetA"> <input type="radio" value="A"
								name="letter" id="pLetA" autocomplete="off"> A
							</label><label class="btn btn-light" id="lLetS"> <input type="radio" value="S"
								name="letter" id="pLetS" autocomplete="off"> S 
							</label><label class="btn btn-light" id="lLetD"> <input type="radio" value="D"
								name="letter" id="pLetD" autocomplete="off"> D
							</label><label class="btn btn-light" id="lLetF"> <input type="radio" value="F"
								name="letter" id="pLetF" autocomplete="off"> F
							</label><label class="btn btn-light" id="lLetG"> <input type="radio" value="G"
								name="letter" id="pLetG" autocomplete="off"> G
							</label><label class="btn btn-light" id="lLetH"> <input type="radio" value="H"
								name="letter" id="pLetH" autocomplete="off"> H
							</label><label class="btn btn-light" id="lLetJ"> <input type="radio" value="J"
								name="letter" id="pLetJ" autocomplete="off"> J
							</label><label class="btn btn-light" id="lLetK"> <input type="radio" value="K"
								name="letter" id="pLetK" autocomplete="off"> K
							</label><label class="btn btn-light" id="lLetL"> <input type="radio" value="L"
								name="letter" id="pLetL" autocomplete="off"> L
							</label><label class="btn btn-light" id="lLet'"><input type="radio" value="'"
								name="letter" id="pLet'" autocomplete="off"> '
							</label>
							</div><div class="btn-group btn-group-toggle btn-group-justified" role="group">
							<label class="btn btn-primary"> <input type="radio" value=""
								name="letter" id="cancel" autocomplete="off"> <i class="fa-solid fa-delete-left"></i> 
							</label><label class="btn btn-light" id="lLetZ"> <input type="radio" value="Z"
								name="letter" id="pLetZ" autocomplete="off"> Z 
							</label> <label class="btn btn-light" id="lLetX"> <input type="radio" value="X"
								name="letter" id="pLetX" autocomplete="off"> X
							</label> <label class="btn btn-light" id="lLetC"> <input type="radio" value="C"
								name="letter" id="pLetC" autocomplete="off"> C
							</label> <label class="btn btn-light" id="lLetV"> <input type="radio" value="V"
								name="letter" id="pLetV" autocomplete="off"> V
							</label> <label class="btn btn-light" id="lLetB"> <input type="radio" value="B"
								name="letter" id="pLetB" autocomplete="off"> B
							</label> <label class="btn btn-light" id="lLetN"> <input type="radio" value="N"
								name="letter" id="pLetN" autocomplete="off"> N
							</label> <label class="btn btn-light" id="lLetM"> <input type="radio" value="M"
								name="letter" id="pLetM" autocomplete="off"> M
							</label><button type="button" class="btn btn-primary" id="scegliLet"
							value="Submit"><i class="fa-solid fa-check"></i></button>
							</div>
							</div>
							</div>
						<div class="col-sm-4"></div>
					</div>
					
					<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
						<a href="parola" class="nav-link"><button type="button" class="btn btn-secondary">RESET</button></a>
					</div>
					<div class="col-sm-2"></div>
				</div>
					<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
						<h3>TODO:</h3>
						<ul>
						<li>fix della tastiera</li>
						<li>possibilita' di inserire la parola completa</li>
						<li>importazione delle liste di parole da file esterni</li> 
						<li>lettura da tastiera reale</li>
						<li>modalità streak</li>
						</ul>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
						<h3>BUG:</h3>
						<ul>
						<li>ci sono diverse parole accentate che non vengono (ovviamente) mostrate correttamente</li>
						</ul>
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

	<!-- Bootstrap 4 -->
	<script src="static/js/plugins/bootstrap/js/bootstrap.bundle.min.js"
		type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="static/js/adminlte.min.js" type="text/javascript"></script>
	<!-- Demo Template -->
	<script src="static/js/fireAjax.js" type="text/javascript"></script>
	<script src="static/js/demoTemplate.js" type="text/javascript"></script>

</body>
</html>
