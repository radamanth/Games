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
        self.rollData = ko.observable(new RequestedRoll('Comment'+self.title, 1, '', []));

    };

    function RollViewModel() {
		
		var self = this;
		self.rolls=  ko.observableArray([]);
		var newIndex = 1 ;
		self.roll1 = ko.observable(new Roll('Roll ' + newIndex, 'roll' + newIndex + 'Title', 'roll' + newIndex + 'Title', 'roll' + newIndex, 'roll' + newIndex, 'nbRoll' + newIndex, 'nbRoll' + newIndex));
		newIndex ++;
		self.roll2 = ko.observable(new Roll('Roll ' + newIndex, 'roll' + newIndex + 'Title', 'roll' + newIndex + 'Title', 'roll' + newIndex, 'roll' + newIndex, 'nbRoll' + newIndex, 'nbRoll' + newIndex));
		newIndex ++;
		self.roll3 = ko.observable(new Roll('Roll ' + newIndex, 'roll' + newIndex + 'Title', 'roll' + newIndex + 'Title', 'roll' + newIndex, 'roll' + newIndex, 'nbRoll' + newIndex, 'nbRoll' + newIndex));
		newIndex ++;
		self.roll4 = ko.observable(new Roll('Roll ' + newIndex, 'roll' + newIndex + 'Title', 'roll' + newIndex + 'Title', 'roll' + newIndex, 'roll' + newIndex, 'nbRoll' + newIndex, 'nbRoll' + newIndex));
		newIndex ++;
		self.roll5 = ko.observable(new Roll('Roll ' + newIndex, 'roll' + newIndex + 'Title', 'roll' + newIndex + 'Title', 'roll' + newIndex, 'roll' + newIndex, 'nbRoll' + newIndex, 'nbRoll' + newIndex));
		self.rollthedice = function() {
			var url = './services/RadaDiceRs/diceSession'
				$.getJSON(url, function(data){
					console.log(data);
				});
		};
//		self.addOneDiceRoll= function() {
//	        var newIndex = self.rolls().length + 1;
//	        var newRoll = new Roll('Roll ' + newIndex, 'roll' + newIndex + 'Title', 'roll' + newIndex + 'Title', 'roll' + newIndex, 'roll' + newIndex, 'nbRoll' + newIndex, 'nbRoll' + newIndex);
//	        self.rolls.push(newRoll);
//	        
//	    }
		
	}
	

    var model = new RollViewModel();
    ko.applyBindings(model);
//    $('#diceSet').trigger('create');



});