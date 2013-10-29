$(document).ready(function () {

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
	
	
	var tpl = $.templates('#diceTpl');
	var htmlOutput = tpl.render(rollDefault);
	
	$('#diceSet').append(htmlOutput);
	$( "#diceSet" ).trigger( "create" );
	
	$('#btnRoll').click(function(evt) {
		evt.preventDefault();
	});
	$('#adddices').click(function(evt) {
		evt.preventDefault();
	});
	
});