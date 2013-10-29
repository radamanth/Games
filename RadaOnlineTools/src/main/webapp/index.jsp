<html>
<head>
<title>RadaDiceProxy</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="../scripts/jquery.mobile-1.3.2.css" />
<script src="../scripts/jquery-2.0.3.js"></script>
<script
	src="../scripts/jquery.mobile-1.3.2.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
    })  ;


	
	
</script>

<script id="tdeTmpl" type="text/x-jquery-tmpl">
        
        <div class="dcell">
            <label>${runner_id}</label><br />
            <label>${first_name}</label><br />
            <label>${last_name}</label><br />
            <label>${gender}</label><br />
            <label>${finish_time}</label><br />

        </div>

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

				<div data-role="collapsible" data-collapsed="false" data-theme="a">
					<h3>Roll 1</h3>
					<fieldset>
						<label for="nbRoll-1" data-theme="a">Nombre de roll :</label> <input
							type="range" name="nbRoll-1" id="nbRoll-1" value="1" min="1"
							max="50" data-theme="a" /> <label for="roll-1" data-theme="a">Roll
							:</label> <input type="number" name="roll-1"
							pattern="<%=com.radamanth.dice.DiceRoller.DICE_PATTERN%>"
							id="roll-1" value="" placeholder="Dice Value"
							class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset"
							data-theme="a"> <label for="comment-1" data-theme="a">Commentaire
							:</label> <input type="text" name="comment-1" id="comment-1" value=""
							data-theme="a" />
					</fieldset>
				</div>

				

			</div>

			<button type="submit" name="submit" value="submit-value"
				class="ui-btn-hidden" data-theme="a" click="doAjaxPost()" >Roll the Dice !</button>
			<!-- /content -->
		</form>
	</div>
	<!-- /page -->
</body>
</html>
