<html>
<head>
<title>RadaDiceRoller</title>

<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" href="scripts/libs/jquery.mobile-1.3.2.css" ></link>
<script src="scripts/libs/jquery-2.0.3.js" ></script>
<script src="scripts/libs/jquery.mobile-1.3.2.js"></script>
<script src="scripts/libs/knockout-3.0.0.js"></script>
<script src="scripts/diceRoller.js"></script>

</head>

<body>


	<div data-role="page">

		<div data-role="header">
			<h1>Rada Dice Roller</h1>
		</div>
		<!-- /header -->

		<form id="diceRollForm" name="diceRollForm" method="post">
			<!-- <div id="results" data-role="panel" data-position="top" data-display="push">
			
			</div> -->
			<div id="diceSet" data-role="content" data-theme="a" data-content-theme="a" >

                <div data-role="collapsible" data-collapsed="false" data-theme="a" data-bind="foreach: rolls, jqmRefreshCollapsible: rolls">
					<h3><span data-bind="text: title"></span></h3>
					<fieldset>
                        <label data-bind="attr: {for: nbRollsId}" data-theme="a" >Nombre de roll :</label>
						<input type="range" data-bind="attr: {name: nbRollsName, id: nbRollsId}, value: rollData().nbRoll"  min="1" max="20" data-theme="a" />

						<label data-bind="attr :{for: rollId}" data-theme="a">Roll :</label>
						<input type="text" data-bind="attr : {name: rollName, id: rollId}, value: rollData().dice" placeholder="Ex : 3D6+12R1B2"   data-theme="a" />

						<label data-bind="attr : {for: rollTitleId}" data-theme="a">Titre du roll : </label>
						<input type="text" data-bind="attr {name: rollTitleName, id: rollTitleId}, value: rollData().comment " data-theme="a"  />
						<span data-bind="value: rollData().results")></span>
					</fieldset>
				</div>
			</div>

            <div id="diceSet2" data-role="collapsible-set" data-theme="a" data-content-theme="a" >

                <div data-role="collapsible" data-collapsed="false" data-theme="a" >
                    <h3>Waya</h3>
                    <fieldset>
                        <label for="toto" data-theme="a" >Nombre de roll :</label>
                        <input type="range" id="toto" value=4  min="1" max="20" data-theme="a" />
                   </fieldset>
                </div>
            </div>
            <div data-role="controlgroup">
				<a href="#" id="adddices" data-theme="a" data-role="button" data-bind="click: addOneDiceRoll" >Add Dice</a>
				<a href="#" id="btnRoll" data-theme="a" data-role="button" >Roll the Dice !</a>
			</div>
			
			
			<!-- /content -->
		</form>
	</div>
	<!-- /page -->
</body>
</html>
