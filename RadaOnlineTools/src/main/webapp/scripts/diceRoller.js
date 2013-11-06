$(document).ready(function () {
	var dicetpl = $.templates('#diceTpl');

     var RequestedRoll = function(p_comment, p_nbRoll, p_dice, p_results) {
         this.nbRoll =  p_nbRoll;
         this.dice= p_dice;
         this.comment = p_comment ;
         // devrait être une Array
         if (Array.isArray(p_results)) {
             this.results = p_results;
         } else
            this.results = [];



     };



	var Roll = function(title, rollTitleName, rollTitleId, rollName, rollId,nbRollsName, nbRollsId) {
		this.title = title;
		this.rollTitleName = rollTitleName;
		this.rollTitleId = rollTitleId;
		this.rollName = rollName;
		this.rollId = rollId;
		this.nbRollsName = nbRollsName;
		this.nbRollsId=nbRollsId;
		this.nbRoll =  1;
        this.dice= '';
        this.comment = '' ;
        this.results = [];
		
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
        rollsTab.forEach(function(entry) {
           console.log(entry.nbRoll);
           console.log(entry.dice);
           console.log(entry.comment);
        });

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