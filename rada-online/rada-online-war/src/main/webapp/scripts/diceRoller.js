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
        self.rollData = ko.observable(new RequestedRoll('', 0, '', []));

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
        self.getRolls = function() {
            var jsonData = [];
            if (self.roll1().rollData().nbRoll() > 0 ) {
                jsonData.push(ko.toJS(self.roll1().rollData()));
            }
            if (self.roll2().rollData().nbRoll() > 0 ) {
                jsonData.push(ko.toJS(self.roll2().rollData()));
            }
            if (self.roll3().rollData().nbRoll() > 0 ) {
                jsonData.push(ko.toJS(self.roll3().rollData()));
            }
            if (self.roll4().rollData().nbRoll() > 0 ) {
                jsonData.push(ko.toJS(self.roll4().rollData()));
            }
            if (self.roll5().rollData().nbRoll() > 0 ) {
                jsonData.push(ko.toJS(self.roll5().rollData()));
            }
            var data = {"requestedRoll": jsonData};
            return data;
        }
		self.rollthedice = function() {
			var myurl = './services/RadaDiceRs/diceSession'
            console.log('posting dice on ' + myurl);
            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: myurl,
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(self.getRolls()),
                success: function(data, textStatus, jqXHR){
//                    alert('Dice rolled created successfully');
                    var results =  data.requestedRoll;
                    if (!results) {
                        alert("aucun résultats obtenus");
                    } else {
                        if (results.length >= 1) {
                        	var v= results[0];
                        	model.roll1().rollData().comment(v.comment);
                        	model.roll1().rollData().nbRoll(v.nbRoll);
                        	model.roll1().rollData().dice(v.dice);
                        	model.roll1().rollData().results(v.results);
                        }
                           
                        if (results.length >= 2){
                        	var v= results[1];
                        	model.roll2().rollData().comment(v.comment);
                        	model.roll2().rollData().nbRoll(v.nbRoll);
                        	model.roll2().rollData().dice(v.dice);
                        	model.roll2().rollData().results(v.results);
                        }
                        if (results.length >= 3){
                        	var v= results[2];
                        	model.roll3().rollData().comment(v.comment);
                        	model.roll3().rollData().nbRoll(v.nbRoll);
                        	model.roll3().rollData().dice(v.dice);
                        	model.roll3().rollData().results(v.results);
                        }
                        if (results.length >= 4){
                        	var v= results[3];
                        	model.roll4().rollData().comment(v.comment);
                        	model.roll4().rollData().nbRoll(v.nbRoll);
                        	model.roll4().rollData().dice(v.dice);
                        	model.roll4().rollData().results(v.results);
                        }
                        if (results.length >= 5){
                        	var v= results[4];
                        	model.roll5().rollData().comment(v.comment);
                        	model.roll5().rollData().nbRoll(v.nbRoll);
                        	model.roll5().rollData().dice(v.dice);
                        	model.roll5().rollData().results(v.results);
                        }
                    }

                    console.log(ko.toJSON(self.roll1().rollData()));
                    console.log(ko.toJSON(self.roll2().rollData()));
                    console.log(ko.toJSON(self.roll3().rollData()));
                    console.log(ko.toJSON(self.roll4().rollData()));
                    console.log(ko.toJSON(self.roll5().rollData()));
                    


                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('rollthedice ' + textStatus  + ' / ' + errorThrown);
                }
            });


		};

		
	}
	

    var model = new RollViewModel();
    ko.applyBindings(model);

});