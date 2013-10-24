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
</head>

<body>

	<div data-role="page">

		<div data-role="header">
			<h1>RadaDiceProxy</h1>
		</div>
		<!-- /header -->

		<form action="/spring/DiceRoller/rollTheDice" method="post">
			<div data-role="collapsible-set">

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

				<div data-role="collapsible" data-collapsed="true" data-theme="a">
					<h3>Roll 2</h3>
					<fieldset>
						<label for="nbRoll-2" data-theme="a">Nombre de roll :</label> <input
							type="range" name="nbRoll-2" id="nbRoll-2" value="1" min="1"
							max="50" data-theme="a" /> <label for="roll-2" data-theme="a">Roll
							:</label> <input type="number" name="roll-2"
							pattern="<%=com.radamanth.dice.DiceRoller.DICE_PATTERN%>"
							id="roll-2" value="" placeholder="Dice Value"
							class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset"
							data-theme="a"> <label for="comment-2" data-theme="a">Commentaire
							:</label> <input type="text" name="comment-2" id="comment-2" value=""
							data-theme="a" />
					</fieldset>
				</div>

				<div data-role="collapsible" data-collapsed="true" data-theme="a">
					<h3>Roll 3</h3>
					<fieldset>
						<label for="nbRoll-3" data-theme="a">Nombre de roll :</label> <input
							type="range" name="nbRoll-3" id="nbRoll-3" value="1" min="1"
							max="50" data-theme="a" /> <label for="roll-3" data-theme="a">Roll
							:</label> <input type="number" name="roll-3"
							pattern="<%=com.radamanth.dice.DiceRoller.DICE_PATTERN%>"
							id="roll-3" value="" placeholder="Dice Value"
							class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset"
							data-theme="a"> <label for="comment-3" data-theme="a">Commentaire
							:</label> <input type="text" name="comment-3" id="comment-3" value=""
							data-theme="a" />
					</fieldset>
				</div>

				<div data-role="collapsible" data-collapsed="true" data-theme="a">
					<h3>Roll 4</h3>
					<fieldset>
						<label for="nbRoll-4" data-theme="a">Nombre de roll :</label> <input
							type="range" name="nbRoll-4" id="nbRoll-4" value="1" min="1"
							max="50" data-theme="a" /> <label for="roll-4" data-theme="a">Roll
							:</label> <input type="number" name="roll-4"
							pattern="<%=com.radamanth.dice.DiceRoller.DICE_PATTERN%>"
							id="roll-4" value="" placeholder="Dice Value"
							class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset"
							data-theme="a"> <label for="comment-4" data-theme="a">Commentaire
							:</label> <input type="text" name="comment-4" id="comment-4" value=""
							data-theme="a" />
					</fieldset>
				</div>

				<div data-role="collapsible" data-collapsed="true" data-theme="a">
					<h3>Roll 5</h3>
					<fieldset>
						<label for="nbRoll-5" data-theme="a">Nombre de roll :</label> <input
							type="range" name="nbRoll-5" id="nbRoll-5" value="1" min="1"
							max="50" data-theme="a" /> <label for="roll-5" data-theme="a">Roll
							:</label> <input type="number" name="roll-5"
							pattern="<%=com.radamanth.dice.DiceRoller.DICE_PATTERN%>"
							id="roll-5" value="" placeholder="Dice Value"
							class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset"
							data-theme="a"> <label for="comment-5" data-theme="a">Commentaire
							:</label> <input type="text" name="comment-5" id="comment-5" value=""
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
