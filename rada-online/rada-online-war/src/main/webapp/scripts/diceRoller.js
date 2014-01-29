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

    function VerifyMail(pmailContent, pmailKey, presult, presultMessage) {
    	var self = this;
    	self.mailContent= ko.observable(pmailContent);
    	self.key = ko.observable(pmailKey);
    	self.result = ko.observable(presult);
    	self.resultMessage = ko.observable(presultMessage);
    };

	function Roll(title, rollTitleName, rollTitleId, rollName, rollId, nbRollsName, nbRollsId) {
		var self = this;
		self.rollPattern = '/^[1-9]{1}[0-9]*[dD]{1}[1-9]{1}[0-9]*([\\+-]{1}[1-9]{1}[0-9]*)?([rR]{1}[1-9]{1}[0-9]*)?([bB]{1}[1-9]{1}[0-9]*)?/g';
        self.title = title;
        self.rollTitleName = rollTitleName;
        self.rollTitleId = rollTitleId;
        self.rollName = rollName;
        self.rollId = rollId;
        self.nbRollsName = nbRollsName;
        self.nbRollsId = nbRollsId;
        self.rollData = ko.observable(new RequestedRoll('', 0, '', []));
        self.needToShow = function() {
        	return (self.rollData().nbRoll > 0);
        }

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
		self.author = '';
		self.dest1 = '';
		self.dest2 = '';
		self.dest3 = '';
		self.dest4 = '';
		self.dest5 = '';
		self.verifyMail= ko.observable(new VerifyMail('', '', true, ''));
		self.checkMailContent= function() {
            $('#checkMailPopup').popup('close');
            $.mobile.loading( 'show');
			var jsonDataMail = ko.toJS(self.verifyMail());
            var myurl = './services/MailVerifyerRs/mailVerify'

//			alert("Checking mail : " + ko.toJSON(jsonDataMail));
            jsonDataMail = ko.toJSON(jsonDataMail);
            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: myurl,
                dataType: "json",
                contentType: "application/json",
                data: jsonDataMail,
                success: function(data, textStatus, jqXHR){
                    self.verifyMail = ko.observable(new VerifyMail(data.mailContent, data.key, data.result, data.resultMessage));
                    alert(data.resultMessage);


                },
                error: function(jqXHR, textStatus, errorThrown){
                    $.mobile.loading( 'hide');
                    alert('verifyMail ' + textStatus  + ' / ' + errorThrown);
                }
            });
            $.mobile.loading( 'hide');
		};
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
            var data = {"author" : self.author, "dest1" : self.dest1, "dest2" : self.dest2, "dest3" : self.dest3, "dest4" : self.dest4, "dest5" : self.dest5, "requestedRoll": jsonData};
            return data;
        }
		self.rollthedice = function() {
			var myurl = './services/RadaDiceRs/diceSession'
            console.log('posting dice on ' + myurl);
			$('#diceRollForm').validate();
			
			 
            $.mobile.loading( 'show');
            $.cookie("roll-data", JSON.stringify(self.getRolls()));
            
            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: myurl,
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(self.getRolls()),
                success: function(data, textStatus, jqXHR){
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

                    
                    
                    
                    $('#resultsPanel').panel('open');
                    
                    $.mobile.loading( 'hide');
                    


                },
                error: function(jqXHR, textStatus, errorThrown){
                    $.mobile.loading( 'hide');
                    alert('rollthedice ' + textStatus  + ' / ' + errorThrown);
                }
            });


		};

		
	}
	

    var model = new RollViewModel();
   
    ko.applyBindings(model);
    
    if ($.cookie("roll-data") ) {
    	var cData = JSON.parse($.cookie("roll-data"));
    	var rolls = cData.requestedRoll;
    	if (rolls) {
	    	if (rolls.length >= 1) {
	        	var v= rolls[0];
	        	model.roll1().rollData().comment(v.comment);
	        	model.roll1().rollData().nbRoll(v.nbRoll);
	        	model.roll1().rollData().dice(v.dice);
	        	
	        }
	           
	        if (rolls.length >= 2){
	        	var v= rolls[1];
	        	model.roll2().rollData().comment(v.comment);
	        	model.roll2().rollData().nbRoll(v.nbRoll);
	        	model.roll2().rollData().dice(v.dice);
	
	        }
	        if (rolls.length >= 3){
	        	var v= rolls[2];
	        	model.roll3().rollData().comment(v.comment);
	        	model.roll3().rollData().nbRoll(v.nbRoll);
	        	model.roll3().rollData().dice(v.dice);
	
	        }
	        if (rolls.length >= 4){
	        	var v= rolls[3];
	        	model.roll4().rollData().comment(v.comment);
	        	model.roll4().rollData().nbRoll(v.nbRoll);
	        	model.roll4().rollData().dice(v.dice);
	
	        }
	        if (rolls.length >= 5){
	        	var v= rolls[4];
	        	model.roll5().rollData().comment(v.comment);
	        	model.roll5().rollData().nbRoll(v.nbRoll);
	        	model.roll5().rollData().dice(v.dice);
	
	        }
    	}
    	
        model.author = $.cookie("roll-data").author;
        model.dest1 = $.cookie("roll-data").dest1;
        model.dest2 = $.cookie("roll-data").dest2;
        model.dest3 = $.cookie("roll-data").dest3;
        model.dest4  = $.cookie("roll-data").dest4;
        model.dest5 = $.cookie("roll-data").dest5;
        
    } 
    
    
    
    $('#diceRollForm').validate();
    $( "#mailPanel" ).panel( "open" );
    
});
