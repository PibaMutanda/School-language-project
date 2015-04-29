<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<a class="navbar-brand" href="home">School of Languages</a>
			<div class="navbar-header">
				<ul class="nav navbar-nav">
					<li><a href="home"><span class="glyphicon glyphicon-home"
							aria-hidden="true"></span></a></li>
					<li><a href="formationlist">Consulter les formations</a></li>
					<li><a href="#">Contact us</a></li>
					<li><a href="#">About</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Dropdown
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container">
		<div class="jumbotron">
			<h1><center> Hello World</center></h1>
		    <center><a href="#" id="lien"><img src="resources/images/imageLangue1.gif" alt="livre"></a></center>
		</div>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="resources/images/livre.gif" alt="livre">
      <div class="carousel-caption">
        ...
      </div>
    </div>
    <div class="item">
      <img src="resources/images/imageLangue2.gif" alt="langue"> 
      <div class="carousel-caption">
        ...
      </div>
    </div>
    <div class="item">
      <img src="resources/images/salleLangue.jpg" alt="sale">
      <div class="carousel-caption">
        ...
      </div>
    </div>
    ...
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
		
		<div id="notification-message">
	      <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
             <div class="modal-dialog modal-lg">
                <div class="modal-content">
                 <h4 style="color: green;">${messageSuccess}</h4>
                </div>
             </div>
          </div>	
		</div>
	</div>