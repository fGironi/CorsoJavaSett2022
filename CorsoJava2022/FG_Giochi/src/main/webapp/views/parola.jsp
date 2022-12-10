<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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



<!-- jQuery -->
<script src="static/js/plugins/jquery/jquery.min.js"></script>

<!-- Bootstrap 4 -->
	<script src="static/js/plugins/bootstrap/js/bootstrap.bundle.min.js"
		type="text/javascript"></script>
<!-- Script gioco -->

	<link rel="stylesheet" href="static/css/stileParola.css">
	<script type="text/javascript">
	    var listaPrl = new Array();
	    <c:forEach var="prlMap" items="${lista}" >
	    	var prl=new String();
	    	prl="${prlMap}"
	  		console.log(prl);
		    listaPrl.push(prl.toUpperCase());
		</c:forEach>
	</script>
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
										<option value="ita">Parola casuale - ITA</option>
										<option value="capitale">Geografia - Capitale</option>
										<option value="disney">Disney - Personaggio</option>
										<option value="animali">Natura - Animali</option>
										<option value="zelda">Zelda - Personaggio</option>
										<option value="pokemon">Pokemon - nome</option>
										<option value="rock">Rock - nome band</option>
										<option value="test">TESTING</option>
									</select>
								
								<a href="parola?mode=${mode}" id="genera"><button class="btn btn-primary" type="button">Nuova
										Partita</button></a>
								</div>	
					<div class="col-sm-3"></div>	
					</div>
					<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
						<div id="streakSpace">
							<h4><i class="fa-regular fa-comment"> ${mode} - Streak: <span id="streak">0</span></i></h4>
							<span id="streakPuls"><button class="btn btn-success" type="button" id="keepStreak">STREAK!</button></span>
						</div>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
						<div id="tentativi">
							<i id="vita9" class="vitG fa-solid fa-heart"></i>
							<i id="vita8" class="vitG fa-solid fa-heart"></i>
							<i id="vita7" class="vitG fa-solid fa-heart"></i>
							<i id="vita6" class="vitG fa-solid fa-heart"></i>
							<i id="vita5" class="vitG fa-solid fa-heart"></i>
							<i id="vita4" class="vitG fa-solid fa-heart"></i>
							<i id="vita3" class="vitG fa-solid fa-heart"></i>
							<i id="vita2" class="vitG fa-solid fa-heart"></i>
							<i id="vita1" class="vitG fa-solid fa-heart"></i>
						</div>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
						<div id="parolaRnd">
							<button class="btn btn-primary" id="inizia" value="${mode}"><i class="fa-solid fa-pen"> Inizia a giocare</i></button>
						</div>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4 d-flex justify-content-center""><div class="guessSpace"><input type="button" class="btn btn-primary scegliLet" id="bgScLet"
							value=""/></div>
							</div>
					<div class="col-sm-4"></div>
				</div>				
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center align-items-center">
						<button type="button" class="pulsLet btn btn-light" value="Q" id="pLetQ" autocomplete="off">Q</button>
						<button type="button" class="pulsLet btn btn-light" value="W" id="pLetW" autocomplete="off">W</button>
						<button type="button" class="pulsLet btn btn-light" value="E" id="pLetE" autocomplete="off">E</button>
						<button type="button" class="pulsLet btn btn-light" value="R" id="pLetR" autocomplete="off">R</button>
						<button type="button" class="pulsLet btn btn-light" value="T" id="pLetT" autocomplete="off">T</button>
						<button type="button" class="pulsLet btn btn-light" value="Y" id="pLetY" autocomplete="off">Y</button>
						<button type="button" class="pulsLet btn btn-light" value="U" id="pLetU" autocomplete="off">U</button>
						<button type="button" class="pulsLet btn btn-light" value="I" id="pLetI" autocomplete="off">I</button>
						<button type="button" class="pulsLet btn btn-light" value="O" id="pLetO" autocomplete="off">O</button>
						<button type="button" class="pulsLet btn btn-light" value="P" id="pLetP" autocomplete="off">P</button>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center align-items-center">
						<button type="button" class="pulsLet btn btn-light" value="A" id="pLetA" autocomplete="off">A</button>
						<button type="button" class="pulsLet btn btn-light" value="S" id="pLetS" autocomplete="off">S</button>
						<button type="button" class="pulsLet btn btn-light" value="D" id="pLetD" autocomplete="off">D</button>
						<button type="button" class="pulsLet btn btn-light" value="F" id="pLetF" autocomplete="off">F</button>
						<button type="button" class="pulsLet btn btn-light" value="G" id="pLetG" autocomplete="off">G</button>
						<button type="button" class="pulsLet btn btn-light" value="H" id="pLetH" autocomplete="off">H</button>
						<button type="button" class="pulsLet btn btn-light" value="J" id="pLetJ" autocomplete="off">J</button>
						<button type="button" class="pulsLet btn btn-light" value="K" id="pLetK" autocomplete="off">K</button>
						<button type="button" class="pulsLet btn btn-light" value="L" id="pLetL" autocomplete="off">L</button>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center align-items-center">
						<button type="button" class="pulsLet btn btn-light" value="Z" id="pLetZ" autocomplete="off">Z</button>
						<button type="button" class="pulsLet btn btn-light" value="X" id="pLetX" autocomplete="off">X</button>
						<button type="button" class="pulsLet btn btn-light" value="C" id="pLetC" autocomplete="off">C</button>
						<button type="button" class="pulsLet btn btn-light" value="V" id="pLetV" autocomplete="off">V</button>
						<button type="button" class="pulsLet btn btn-light" value="B" id="pLetB" autocomplete="off">B</button>
						<button type="button" class="pulsLet btn btn-light" value="N" id="pLetN" autocomplete="off">N</button>
						<button type="button" class="pulsLet btn btn-light" value="M" id="pLetM" autocomplete="off">M</button>
						<button type="button" class="btn btn-primary scegliLet" id="smScLet" value=""><i class="fa-solid fa-check"></i></button>
					</div>
					<div class="col-sm-2"></div>
				</div>
				
					
					<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4 d-flex justify-content-right">
						<a href="parolaIntro" class="nav-link"><button type="button" class="btn btn-secondary">RESET</button></a>
					</div>
					<div class="col-sm-4"></div>
				</div>
					<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
						<h3>TODO:</h3>
						<ul>
						<li>possibilita' di inserire la parola completa</li>
						<li>importazione delle liste di parole da file esterni</li> 
						</ul>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 d-flex justify-content-center">
						<h3>BUG:</h3>
						<ul>
						<li>//</li>
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


	<!-- AdminLTE App -->
	<script src="static/js/adminlte.min.js" type="text/javascript"></script>
	<!-- Demo Template -->
	<script src="static/js/fireAjax.js" type="text/javascript"></script>
	<script src="static/js/demoTemplate.js" type="text/javascript"></script>

</body>
</html>
