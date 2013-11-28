$(document).ready(function () {

	
	function CrytotronViewModel (p_src, p_key_tab, p_result) {
		var self = this;
        self.src = ko.observable(p_src);
        self.key= ko.observable(p_key_tab);
        self.result = ko.observable(p_result);
        self.cypher = function() {
        	alert("cypher");
        };
        self.decypher = function() {
        	alert("decypher");
        };
    };
    
	

    var model = new CrytotronViewModel();
    ko.applyBindings(model);
    
    
});