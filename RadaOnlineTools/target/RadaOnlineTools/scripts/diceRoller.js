$(document).ready(function () {
	var dicetpl = $.templates('#diceTpl');
	
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
	rollsTab[0] = rollDefault;
	
	
	
	var defDice = dicetpl.render(rollDefault);
	$('#diceSet').append(defDice);
	$( "#diceSet" ).trigger( "create" );
	
	$('#btnRoll').bind("click submit", rollTheDice);
	$('#adddices').bind("click", addDice);
	
	function rollTheDice(evt) {
		evt.preventDefault();
	};
	
	function addDice(evt) {
		var newIndex = rollsTab.length  + 1 ;
		var newRoll = new Roll('Roll '+newIndex, 'roll'+newIndex+'Title','roll'+newIndex+'Title', 'roll'+newIndex, 'roll'+newIndex, 'nbRoll'+newIndex, 'nbRoll'+newIndex );
		rollsTab[newIndex-1] = newRoll;
		var html = dicetpl.render(newRoll);
		$( "#diceSet" ).append(html);
		$( "#diceSet" ).trigger( "create" );
		evt.preventDefault();
	}
	
});