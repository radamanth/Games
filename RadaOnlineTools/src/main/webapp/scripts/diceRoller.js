$(document).ready(function () {
	
     var RequestedRoll = function(p_comment, p_nbRoll, p_dice, p_results) {
         this.nbRoll =  ko.observable(p_nbRoll);
         this.dice= ko.observable(p_dice);
         this.comment = ko.observable(p_comment) ;
         // devrait être une Array
         if (Array.isArray(p_results)) {
             this.results = ko.observable(p_results);
         } else
            this.results = ko.observable([]);
     };



	var Roll = function(title, rollTitleName, rollTitleId, rollName, rollId,nbRollsName, nbRollsId) {
		this.title = title;
		this.rollTitleName = rollTitleName;
		this.rollTitleId = rollTitleId;
		this.rollName = rollName;
		this.rollId = rollId;
		this.nbRollsName = nbRollsName;
		this.nbRollsId=nbRollsId;
		this.data= ko.observable(new RequestedRoll('', 4, '', []));
		
	};
	var rollDefault = new Roll('Roll 1', 'roll1Title','roll1Title', 'roll1', 'roll1', 'nbRoll1', 'nbRoll1' );
	var rollDefault2 = new Roll('Roll 2', 'roll2Title','roll2Title', 'roll2', 'roll2', 'nbRoll2', 'nbRoll2' );
	
	
	var rollsTab = new Array();
	rollsTab[0] = rollDefault;
	rollsTab[1] = rollDefault2;
	
	
	
	ko.applyBindings({rolls: rollsTab});
	
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
		ko.applyBindings({rolls: rollsTab});
		$( "#diceSet" ).trigger( "create" );
		evt.preventDefault();
	}
	
});