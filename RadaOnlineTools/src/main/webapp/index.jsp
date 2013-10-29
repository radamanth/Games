<html>
<head>
<title>RadaDiceRoller</title>

<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" ></link>
<script src="scripts/jquery-2.0.3.min.js" ></script>
<script src="scripts/jquery.mobile-1.3.2.min.js"></script>
<script src="http://www.jsviews.com/download/jsrender.js"></script>
<script src="scripts/diceRoller.js"></script>
<script id="diceTpl" type="text/x-jsrender"> 
	<div data-role="collapsible" data-collapsed="false" data-theme="a">
		<h3>{{:title}}</h3>
		<fieldset>
			<label for={{:nbRollsName}} data-theme="a" >Nombre de roll :</label> 
			<input type="range" name={{:nbRollsName}} id={{:nbRollsId}} value="1" min="1" max="20" data-theme="a" /> 
			<label for={{:rollName}} data-theme="a">Roll :</label> 
			<input type="text" name={{:rollName}} 
				id={{:rollId}} value="" placeholder="Ex : 3D6+12R1B2"   data-theme="a" /> 
			<label for={{:rollTitleName}} data-theme="a">Titre du roll : </label> 
			<input type="text" name={{:rollTitleName}} data-id={{:rollTitleId}} value="" data-theme="a" />
		</fieldset>
	</div>
</script>

</head>

<body>


	<div data-role="page">

		<div data-role="header">
			<h1>Rada Dice Roller</h1>
		</div>
		<!-- /header -->

		<form id="diceRollForm" name="diceRollForm" method="post">
			<div id="diceSet" data-role="collapsible-set" data-theme="a" data-content-theme="a">
			</div>			
			<button  id="adddices" data-theme="a" >Ajouter un roll</button>
			<button  id="btnRoll" data-theme="a" >Roll the Dice !</button>
			<!-- /content -->
		</form>
	</div>
	<!-- /page -->
</body>
</html>
