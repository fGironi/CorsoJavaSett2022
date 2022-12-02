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
							<p>premi una lettera e poi il tasto in basso a destra per inviare</p>
						</div>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<div class="row">
					<div class="col-sm-5"></div>
					<div class="col-sm-2 d-flex justify-content-center">
					<div data-toggle="buttons">
						<div class="btn-group btn-group-toggle btn-group-justified" role="group">
					
							<label class="btn btn-light" id="letQ"> <input type="radio" value="Q"
								name="letter" id="letQ" autocomplete="off"> Q
							</label><label class="btn btn-light" id="letW"> <input type="radio" value="W"
								name="letter" id="letW" autocomplete="off"> W 
							</label><label class="btn btn-light" id="letE"> <input type="radio" value="E"
								name="letter" id="letE" autocomplete="off"> E
							</label><label class="btn btn-light" id="letR"> <input type="radio" value="R"
								name="letter" id="letR" autocomplete="off"> R
							</label><label class="btn btn-light" id="letT"> <input type="radio" value="T"
								name="letter" id="letT" autocomplete="off"> T
							</label><label class="btn btn-light" id="letY"> <input type="radio" value="Y"
								name="letter" id="letY" autocomplete="off"> Y
							</label><label class="btn btn-light" id="letU"> <input type="radio" value="U"
								name="letter" id="letU" autocomplete="off"> U
							</label><label class="btn btn-light" id="letI"> <input type="radio" value="I"
								name="letter" id="letI" autocomplete="off"> I
							</label><label class="btn btn-light" id="letO"> <input type="radio" value="O"
								name="letter" id="letO" autocomplete="off"> O
							</label><label class="btn btn-light" id="letP"> <input type="radio" value="P"
								name="letter" id="letP" autocomplete="off"> P
							</label>
							</div><div class="btn-group btn-group-toggle btn-group-justified" role="group">
							<label class="btn btn-light" id="letA"> <input type="radio" value="A"
								name="letter" id="letA" autocomplete="off"> A
							</label><label class="btn btn-light" id="letS"> <input type="radio" value="S"
								name="letter" id="letS" autocomplete="off"> S 
							</label><label class="btn btn-light" id="letD"> <input type="radio" value="D"
								name="letter" id="letD" autocomplete="off"> D
							</label><label class="btn btn-light" id="letF"> <input type="radio" value="F"
								name="letter" id="letF" autocomplete="off"> F
							</label><label class="btn btn-light" id="letG"> <input type="radio" value="G"
								name="letter" id="letG" autocomplete="off"> G
							</label><label class="btn btn-light" id="letH"> <input type="radio" value="H"
								name="letter" id="letH" autocomplete="off"> H
							</label><label class="btn btn-light" id="letJ"> <input type="radio" value="J"
								name="letter" id="letJ" autocomplete="off"> J
							</label><label class="btn btn-light" id="letK"> <input type="radio" value="K"
								name="letter" id="letK" autocomplete="off"> K
							</label><label class="btn btn-light" id="letL"> <input type="radio" value="L"
								name="letter" id="letL" autocomplete="off"> L
							</label><label class="btn btn-light" id="let'"><input type="radio" value="'"
								name="letter" id="let'" autocomplete="off"> '
							</label>
							</div><div class="btn-group btn-group-toggle btn-group-justified" role="group">
							<label class="btn btn-primary"> <input type="radio" value=""
								name="letter" id="cancel" autocomplete="off"> &#x2B05 
							</label><label class="btn btn-light" id="letZ"> <input type="radio" value="Z"
								name="letter" id="letZ" autocomplete="off"> Z 
							</label> <label class="btn btn-light" id="letX"> <input type="radio" value="X"
								name="letter" id="letX" autocomplete="off"> X
							</label> <label class="btn btn-light" id="letC"> <input type="radio" value="C"
								name="letter" id="letC" autocomplete="off"> C
							</label> <label class="btn btn-light" id="letV"> <input type="radio" value="V"
								name="letter" id="letV" autocomplete="off"> V
							</label> <label class="btn btn-light" id="letB"> <input type="radio" value="B"
								name="letter" id="letB" autocomplete="off"> B
							</label> <label class="btn btn-light" id="letN"> <input type="radio" value="N"
								name="letter" id="letN" autocomplete="off"> N
							</label> <label class="btn btn-light" id="letM"> <input type="radio" value="M"
								name="letter" id="letM" autocomplete="off"> M
							</label><button type="button" class="btn btn-primary" id="scegliLet"
							value="Submit">&#x2714</button>
							</div>
							</div>
							</div>
						<div class="col-sm-5"></div>
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
						<li>reset del campo di gioco alla pressione del tasto "genera parola"</li>
						<li>importazione delle liste di parole da file txt esterni</li> 
						</ul>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
						<h3>BUG:</h3>
						<ul>
						<li>se la parola e' piu' lunga di 10 lettere rivelare la prima rivela anche quelle da 10 in poi</li>
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
