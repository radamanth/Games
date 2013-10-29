<html>
<head>
<title>RadaDiceProxy</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="../scripts/jquery.mobile-1.3.2.css" />
<script src="../scripts/jquery-2.0.3.js"/>
<script	src="../scripts/jquery.mobile-1.3.2.js"/>
<!-- https://github.com/codepb/jquery-template -->
<script src="../scritps/jquery.loadTemplate-1.2.6.js"/>


<script type="text/html" id="template">
	<div data-role="collapsible" data-collapsed="false" data-theme="a">
		<h3 data-content="title"></h3>
		<fieldset>
			<label data-for="nbRollsName" data-theme="a">Nombre de roll :</label> 
			<input type="range" data-name="nbRollsName" data-id="nbRollsId" value="1" min="1" max="50" data-theme="a" /> 
			<label data-for="rollName" data-theme="a">Roll :</label> 
			<input type="text" data-name="rollName" pattern="<%=com.radamanth.dice.DiceRoller.DICE_PATTERN%>"
				data-id="rollId" value="" placeholder="Ex : 3D6+12R1B2"  class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset" data-theme="a"> 
			<label data-for="rollTitleName" data-theme="a">Titre du roll : </label> 
			<input type="text" data-name="rollTitleName" data-id="rollTitleId" value="" data-theme="a" />
		</fieldset>
	</div>

</script>

<script type="text/javascript">
	$(document).ready(function() {
	
		var Roll = function(title, rollTitleName, rollTitleId, rollName, rollId,nbRollsName, nbRollsId) {
			this.title = title;
			this.rollTitleName = rollTitleName;
			this.rollTitleId = rollTitleId;
			this.rollName = rollName;
			this.rollId = rollId;
			this.nbRollsName = nbRollsName;
			this.nbRollsId=nbRollsId;
			
		};
		var rollsTab = new Array();
	
		var rollDefault = new Roll('Roll 1', 'roll1Title','roll1Title', 'roll1', 'roll1', 'nbRoll1', 'nbRoll1' );
		rollsTab[0] =rollDefault;
		$("#collapseSet").loadTemplate($("#template"),rollDefault);
		
		
		function doAjaxPost(evt) {
			
		}
    })  ;

</script>


</head>

<body>

	<div data-role="page">

		<div data-role="header">
			<h1>RadaDiceProxy</h1>
		</div>
		<!-- /header -->

		<form id="diceRollForm" name="diceRollForm" method="post">
			<div id="collapseSet" data-role="collapsible-set">

				

				

			</div>

			<button type="submit" name="submit" value="submit-value"
				class="ui-btn-hidden" data-theme="a" click="doAjaxPost()" >Roll the Dice !</button>
			<!-- /content -->
		</form>
	</div>
	<!-- /page -->
</body>
</html>
