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
		self.mailOnly = ko.observable(false);
		self.rolls=  ko.observableArray([]);
		self.initRolls = function(){
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
        }   ;
        self.initRolls();
		self.author = '';
        self.subject= '';
		self.dest1 = '';
		self.dest2 = '';
		self.dest3 = '';
		self.dest4 = '';
		self.dest5 = '';
        self.resetResults = function () {

                model.roll1().rollData().results([]);
                model.roll2().rollData().results([]);
                model.roll3().rollData().results([]);
                model.roll4().rollData().results([]);
                model.roll5().rollData().results([]);

        }
		self.verifyMail= ko.observable(new VerifyMail('', '', true, ''));
		self.showWaiting = function(p_selector, p_message) {
			$.mobile.loading( 'show', {text : p_message, textVisible: true, theme: 'b'});
			$(p_selector).addClass('ui-disabled');
		};
		self.hideWaiting = function(p_selector) {
			$.mobile.loading( 'hide');
            $(p_selector).removeClass('ui-disabled');
		};
		self.checkMailContent= function() {
            $('#checkMailPopup').popup('close');
            self.showWaiting('#dice','Verifying suspicious mail ... ');
            
			var jsonDataMail = ko.toJS(self.verifyMail());
            var myurl = './services/MailVerifyerRs/mailVerify'

//			alert("Checking mail : " + ko.toJSON(jsonDataMail));
            jsonDataMail = ko.toJSON(jsonDataMail);
            $.ajax({
                type: 'POST',
                url: myurl,
                dataType: "json",
                contentType: "application/json; charset=UTF-8",
                data: jsonDataMail,
                success: function(data, textStatus, jqXHR){
                    self.verifyMail = ko.observable(new VerifyMail(data.mailContent, data.key, data.result, data.resultMessage));
                    alert(data.resultMessage);


                },
                error: function(jqXHR, textStatus, errorThrown){
                	self.hideWaiting('#dice');
                    alert('verifyMail ' + textStatus  + ' / ' + errorThrown);
                }
            });
            self.hideWaiting('#dice');
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
            var data = { "mailOnly" : self.mailOnly(), "author" : self.author, "dest1" : self.dest1, "dest2" : self.dest2, "dest3" : self.dest3, "dest4" : self.dest4, "dest5" : self.dest5, "requestedRoll": jsonData};
            return data;
        }
		self.rollthedice = function() {
			var myurl = './services/RadaDiceRs/diceSession'
            console.log('posting dice on ' + myurl);
			$('#diceRollForm').validate();
			
			 
			self.showWaiting('#dice', 'launching dice ! Alea jacta est ... ');
			
            $.cookie("roll-data", JSON.stringify(self.getRolls()));
            
            $.ajax({
                type: 'POST',
                url: myurl,
                dataType: "json",
                contentType: "application/json; charset=UTF-8",
                data: JSON.stringify(self.getRolls()),
                success: function(data, textStatus, jqXHR){
                    var results =  data.requestedRoll;
                    if (!results) {
                        alert("aucun résultats obtenus");
                    } else if (data.mailOnly) {
                    	alert("Pas de résultats affichés, eventuels mails envoyés!")
                    	
                    } else {

                        model.resetResults();


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
                        $('#resultsPanel').panel('open');
                    }

                    
                    
                    
                    
                    
                    self.hideWaiting('#dice');
                    


                },
                error: function(jqXHR, textStatus, errorThrown){
                	self.hideWaiting('#dice');
                    alert('rollthedice ' + textStatus  + ' / ' + errorThrown);
                }
            });


		};

		
	}
	

    var model = new RollViewModel();
  
    
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
    	
        model.author = cData.author;
        model.dest1 = cData.dest1;
        model.dest2 = cData.dest2;
        model.dest3 = cData.dest3;
        model.dest4  = cData.dest4;
        model.dest5 = cData.dest5;
        
    } 
    
    
    ko.applyBindings(model);
    
    
    
    $('#diceRollForm').validate();
    $( "#mailPanel" ).panel( "open" );
    
});
