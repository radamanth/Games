$(document).ready(function () {

	function RequestedRoll (p_comment, p_nbRoll, p_dice, p_results) {
		var self = this;
        self.nbRoll = ko.observable(p_nbRoll);
        self.dice = ko.observable(p_dice);
        self.comment = ko.observable(p_comment);
        // devrait être une Array
        if (Array.isArray(p_results)) {
            self.results = ko.observable(p_results);
        } else
            self.results = ko.observable([]);
    };
    
	function Roll(title, rollTitleName, rollTitleId, rollName, rollId, nbRollsName, nbRollsId) {
		var self = this;
        self.title = title;
        self.rollTitleName = rollTitleName;
        self.rollTitleId = rollTitleId;
        self.rollName = rollName;
        self.rollId = rollId;
        self.nbRollsName = nbRollsName;
        self.nbRollsId = nbRollsId;
        self.rollData = ko.observable([new RequestedRoll('Comment'+self.title, 4, '1D20+13', [])]);

    };

    function RollViewModel() {
		
		var self = this;
		self.rolls=  ko.observableArray([]);
		self.addOneDiceRoll= function() {
	        var newIndex = self.rolls().length + 1;
	        var newRoll = new Roll('Roll ' + newIndex, 'roll' + newIndex + 'Title', 'roll' + newIndex + 'Title', 'roll' + newIndex, 'roll' + newIndex, 'nbRoll' + newIndex, 'nbRoll' + newIndex);
	        self.rolls.push(newRoll);
	        $('div[data-role="page"]').trigger('refresh');
	    }
		
	}
	
      function rollTheDice(evt) {

        evt.preventDefault();
    };

    

//    function addDice(evt) {
//        addOneDiceRoll();
//        evt.preventDefault();
//    }

    
    $('#btnRoll').bind("click submit", rollTheDice);
    

    var model = new RollViewModel();
    model.addOneDiceRoll();
    ko.applyBindings(model);

    $('div[data-role="page"]').trigger('refresh');


});