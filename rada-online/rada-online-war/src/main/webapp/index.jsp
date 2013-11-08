<html>
<head>
<title>RadaDiceRoller</title>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="scripts/libs/jquery.mobile-1.3.2.min.css" ></link>

<script src="scripts/libs/jquery-1.10.2.min.js" ></script>
<script src="scripts/libs/jquery.mobile-1.3.2.min.js"></script>
<script src="scripts/libs/knockout-3.0.0.js"></script>
<script src="scripts/diceRoller.js"></script>

</head>

<body>
	<div data-role="page" id="home" data-theme="a">
		
		<div data-role="header">
			<h1>Rada Dice Roller</h1>
		</div><!-- /header -->
		  <!-- resultsPanel-->
		  <div data-role="panel" id="resultsPanel" data-position="right" data-display="overlay" data-swipe-close="true" data-theme="a" >	
		    <div class="panel-content">
		      <h3>Résultats</h3>
		      		<div data-bind="with: roll1">
						<h4><span data-bind="  text: title"></span></h4>
						<h5><span data-bind="  text: rollData().comment"></span></h5>
						<ul data-role="listview" data-theme="a" id="res1" data-bind=" foreach: rollData().results"> 
					  		<li data-bind="text: $data"></li>
						</ul>
					</div>
					<div data-bind="with: roll2">
						<h4><span data-bind="  text: title"></span></h4>
						<h5><span data-bind="  text: rollData().comment"></span></h5>
						<ul data-role="listview" data-theme="a" id="res1" data-bind=" foreach: rollData().results"> 
					  		<li data-bind="text: $data"></li>
						</ul>
					</div>
					<div data-bind="with: roll3">
						<h4><span data-bind="  text: title"></span></h4>
						<h5><span data-bind="  text: rollData().comment"></span></h5>
						<ul data-role="listview" data-theme="a" id="res1" data-bind=" foreach: rollData().results"> 
					  		<li data-bind="text: $data"></li>
						</ul>
					</div>
					<div data-bind="with: roll4">
						<h4><span data-bind="  text: title"></span></h4>
						<h5><span data-bind="  text: rollData().comment"></span></h5>
						<ul data-role="listview" data-theme="a" id="res1" data-bind=" foreach: rollData().results"> 
					  		<li data-bind="text: $data"></li>
						</ul>
					</div>
					<div data-bind="with: roll5">
						<h4><span data-bind="  text: title"></span></h4>
						<h5><span data-bind="  text: rollData().comment"></span></h5>
						<ul data-role="listview" data-theme="a" id="res1" data-bind=" foreach: rollData().results"> 
					  		<li data-bind="text: $data"></li>
						</ul>
					</div>
				
		    </div><!-- /content wrapper for padding -->
		  </div><!-- /resultsPanel -->
		
		<div data-role="content">
		    <form id="diceRollForm" name="diceRollForm" method="post">
	
				<div id="diceSet" data-role="collapsible-set" data-theme="a" data-content-theme="a" >
	
	                <div data-role="collapsible" data-collapsed="false" data-theme="a" data-bind="with: roll1">
						<h3><span data-bind="text: title"></span></h3>
						<fieldset>
	                        <label data-bind="attr: {for: nbRollsId}" data-theme="a" >Nombre de roll :</label>
							<input type="range" data-bind="attr: {name: nbRollsName, id: nbRollsId}, value: rollData().nbRoll" min="0"  max="20" data-theme="a" />
	
							<label data-bind="attr :{for: rollId}" data-theme="a">Roll :</label>
							<input type="text" data-bind="attr : {name: rollName, id: rollId}, value: rollData().dice" placeholder="Ex : 3D6+12R1B2"   data-theme="a" />
	
							<label data-bind="attr : {for: rollTitleId}" data-theme="a">Titre du roll : </label>
							<input type="text" data-bind="attr {name: rollTitleName, id: rollTitleId}, value: rollData().comment " data-theme="a"  />
							<div data-role="collapsible" data-collapsed="true" data-theme="a" ">
								<h1>results</h1>
								<ul data-role="listview" data-theme="a" id="res1" data-bind="foreach: rollData().results"> 
								  <li data-bind="text: $data"></li>
								</ul>
							</div>
						</fieldset>
					</div>
					<div data-role="collapsible" data-collapsed="true" data-theme="a" data-bind="with: roll2">
						<h3><span data-bind="text: title"></span></h3>
						<fieldset>
	                        <label data-bind="attr: {for: nbRollsId}" data-theme="a" >Nombre de roll :</label>
							<input type="range" data-bind="attr: {name: nbRollsName, id: nbRollsId}, value: rollData().nbRoll" min="0"  max="20" data-theme="a" />
	
							<label data-bind="attr :{for: rollId}" data-theme="a">Roll :</label>
							<input type="text" data-bind="attr : {name: rollName, id: rollId}, value: rollData().dice" placeholder="Ex : 3D6+12R1B2"   data-theme="a" />
	
							<label data-bind="attr : {for: rollTitleId}" data-theme="a">Titre du roll : </label>
							<input type="text" data-bind="attr {name: rollTitleName, id: rollTitleId}, value: rollData().comment " data-theme="a"  />
							<div data-role="collapsible" data-collapsed="true" data-theme="a" ">
								<h1>results</h1>
								<ul data-role="listview" data-theme="a" id="res1" data-bind="foreach: rollData().results"> 
								  <li data-bind="text: $data"></li>
								</ul>
							</div>
						</fieldset>
					</div>
					<div data-role="collapsible" data-collapsed="true" data-theme="a" data-bind="with: roll3">
						<h3><span data-bind="text: title"></span></h3>
						<fieldset>
	                        <label data-bind="attr: {for: nbRollsId}" data-theme="a" >Nombre de roll :</label>
							<input type="range" data-bind="attr: {name: nbRollsName, id: nbRollsId}, value: rollData().nbRoll" min="0"  max="20" data-theme="a" />
	
							<label data-bind="attr :{for: rollId}" data-theme="a">Roll :</label>
							<input type="text" data-bind="attr : {name: rollName, id: rollId}, value: rollData().dice" placeholder="Ex : 3D6+12R1B2"   data-theme="a" />
	
							<label data-bind="attr : {for: rollTitleId}" data-theme="a">Titre du roll : </label>
							<input type="text" data-bind="attr {name: rollTitleName, id: rollTitleId}, value: rollData().comment " data-theme="a"  />
							<div data-role="collapsible" data-collapsed="true" data-theme="a" ">
								<h1>results</h1>
								<ul data-role="listview" data-theme="a" id="res1" data-bind="foreach: rollData().results"> 
								  <li data-bind="text: $data"></li>
								</ul>
							</div>
						</fieldset>
					</div>
					<div data-role="collapsible" data-collapsed="true" data-theme="a" data-bind="with: roll4">
						<h3><span data-bind="text: title"></span></h3>
						<fieldset>
	                        <label data-bind="attr: {for: nbRollsId}" data-theme="a" >Nombre de roll :</label>
							<input type="range" data-bind="attr: {name: nbRollsName, id: nbRollsId}, value: rollData().nbRoll" min="0"  max="20" data-theme="a" />
	
							<label data-bind="attr :{for: rollId}" data-theme="a">Roll :</label>
							<input type="text" data-bind="attr : {name: rollName, id: rollId}, value: rollData().dice" placeholder="Ex : 3D6+12R1B2"   data-theme="a" />
	
							<label data-bind="attr : {for: rollTitleId}" data-theme="a">Titre du roll : </label>
							<input type="text" data-bind="attr {name: rollTitleName, id: rollTitleId}, value: rollData().comment " data-theme="a"  />
							<div data-role="collapsible" data-collapsed="true" data-theme="a" ">
								<h1>results</h1>
								<ul data-role="listview" data-theme="a" id="res1" data-bind="foreach: rollData().results"> 
								  <li data-bind="text: $data"></li>
								</ul>
							</div>
						</fieldset>
					</div>
					<div data-role="collapsible" data-collapsed="true" data-theme="a" data-bind="with: roll5" >
						<h3><span data-bind="text: title"></span></h3>
						<fieldset>
	                        <label data-bind="attr: {for: nbRollsId}" data-theme="a" >Nombre de roll :</label>
							<input type="range" data-bind="attr: {name: nbRollsName, id: nbRollsId}, value: rollData().nbRoll" min="0"  max="20" data-theme="a" />
	
							<label data-bind="attr :{for: rollId}" data-theme="a">Roll :</label>
							<input type="text" data-bind="attr : {name: rollName, id: rollId}, value: rollData().dice" placeholder="Ex : 3D6+12R1B2"   data-theme="a" />
	
							<label data-bind="attr : {for: rollTitleId}" data-theme="a">Titre du roll : </label>
							<input type="text" data-bind="attr {name: rollTitleName, id: rollTitleId}, value: rollData().comment " data-theme="a"  />
							<div data-role="collapsible" data-collapsed="true" data-theme="a" ">
								<h1>results</h1>
								<ul data-role="listview" data-theme="a" id="res1" data-bind="foreach: rollData().results"> 
								  <li data-bind="text: $data"></li>
								</ul>
							</div>
						</fieldset>
					</div>
	
	                
				</div>
				
	            <div data-role="controlgroup">
	            	<a href="#" id="btnRoll" data-theme="a" data-role="button" data-bind="click: rollthedice">Roll the Dice !</a>
					<a href="#resultsPanel" data-theme="a" data-role="button">Open results</a>
				</div>
			</form>
		</div><!-- /content -->
	</div><!--  page home -->
	
</body>
</html>
