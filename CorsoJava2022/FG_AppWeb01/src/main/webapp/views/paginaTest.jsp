<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>FG_AppWeb01 - pagina di testing</title>
	 <!-- Google Font: Source Sans Pro -->
  	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  	<!-- Font Awesome -->
	  <link rel="stylesheet" href="static/js/plugins/fontawesome-free/css/all.min.css">
 	 <!-- Theme style -->
  <link rel="stylesheet" href="static/css/adminlte.min.css">
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
        <a href="/FG_AppWeb01/" class="nav-link">Home</a>
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
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                GetDatas
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="list" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>getList</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="count" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>getCount</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
            <a href="insertData" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Insert data
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="test" class="nav-link">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Sondaggio Test
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
            <h1>Titolo della pagina di testing</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Blank Page</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
          <h3 class="card-title">Test Sondaggio</h3>

          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
              <i class="fas fa-minus"></i>
            </button>
            <button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
              <i class="fas fa-times"></i>
            </button>
          </div>
        </div>
        <div class="card-body">
          	<h2>un modo pigro per provare la visualizzazione della pagina</h2>
			<img src="static/assets/firma.jpg" width=400 alt="immagine_firma">
		<div>
		<p>
			questo è un testo poco importante, praticamente un lorem ipsum<br>
			non ha alcuno scopo reale ma mi aiuta a capire gli spazi all'interno della pagina<br>
			<b>daje</b><br>
			A seguire un form per un sondaggio di pari importanza al testo sopra riportato:
		<p>
		
	</div>
	<div>
	<form name="form iscrizione" method="get">
		<label for="nome">inserisci il tuo nome</label>
		<input type="text" name="nome" value="" placeholder="nome"><br>
		<label for="privacy">confermi di aver letto e di accettare <a href="https://s3.memeshappen.com/memes/SAY-PRIVACY-POLICY-ONE-MORE-TIME.jpg" target="_blank">l'informativa sulla privacy</a></label>
		<input type="checkbox" name="privacy" value="accettata"><br>
		<label for="radio">quanto sei bravo?</label>
		poco <input type="radio" name="bravura" value=poco">  
		medio <input type="radio" name="bravura" value=medio">  
		tanto <input type="radio" name="bravura" value=tanto">
		<br>
		<label for="radio">quanto apprezzi questa pagina?</label>
		poco <input type="radio" name="apprezzamento" value=poco">  
		medio <input type="radio" name="apprezzamento" value=medio">  
		tanto <input type="radio" name="apprezzamento" value=tanto">
		<br>
		<label for="radio">pensi che l'HTML sia interessante?</label>
		poco <input type="radio" name="interesse" value=poco">  
		medio <input type="radio" name="interesse" value=medio">  
		tanto <input type="radio" name="interesse" value=tanto">
		<br>
		<button type="submit" class="btn btn-info" id="btnSend" name="invia" value="ok">Invia</button>
		<button type="button" class="btn btn-info" id="btnAnn" name="annulla" value="ko">Annulla</button><br>
		
	</form>
	</div>
        </div>
        <!-- /.card-body -->
        <div class="card-footer">
          Footer
        </div>
        <!-- /.card-footer-->
      </div>
      <!-- /.card -->

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

<!-- jQuery -->
<script src="static/js/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="static/js/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="static/js/adminlte.min.js"></script>
<!-- Demo Template -->
<script src="static/js/fireAjax.js"></script>
<script src="static/js/demoTemplate.js"></script>

</html>