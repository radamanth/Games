<html>
<head>
<title>RadaDiceRoller</title>

<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" href="scripts/libs/jquery.mobile-1.3.2.css" ></link>
<script src="scripts/libs/jquery-2.0.3.js" ></script>
<script src="scripts/libs/jquery.mobile-1.3.2.js"></script>
<script src="scripts/libs/jsrender.js"></script>
<script src="scripts/libs/jsviews.js"></script>
<script src="scripts/diceRoller.js"></script>
<script id="diceTpl" type="text/x-jsrender">
    <div id=results>

    </div>
	<div data-role="collapsible" data-collapsed="false" data-theme="a">
		<h3>{{:title}}</h3>
		<fieldset>
			<label for={{:nbRollsName}} data-theme="a" >Nombre de roll :</label> 
			<input type="range" name={{:nbRollsName}} id={{:nbRollsId}} data-link="nbRoll" value="1" min="1" max="20" data-theme="a" />
			<label for={{:rollName}} data-theme="a">Roll :</label> 
			<input type="text" name={{:rollName}} 
				id={{:rollId}} value="" placeholder="Ex : 3D6+12R1B2"   data-theme="a" data-link="dice"/>
			<label for={{:rollTitleName}} data-theme="a">Titre du roll : </label> 
			<input type="text" name={{:rollTitleName}} data-id={{:rollTitleId}} value="" data-theme="a" data-link="comment" />
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
			<div data-role="controlgroup">
				<a href="#" id="adddices" data-theme="a" data-role="button" >Add Dice</a>
				<a href="#" id="btnRoll" data-theme="a" data-role="button" >Roll the Dice !</a>
			</div>
			
			
			<!-- /content -->
		</form>
	</div>
	<!-- /page -->
</body>
</html>
