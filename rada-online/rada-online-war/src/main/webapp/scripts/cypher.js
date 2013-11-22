$(document).ready(function () {

	
	function CrytotronViewModel (p_src, p_key_tab, p_result) {
		var self = this;
        self.src = ko.observable(p_src);
        self.dice = ko.observable(p_dice);
        self.comment = ko.observable(p_comment);
        // devrait être une Array
        if (Array.isArray(p_results)) {
            self.results = ko.observable(p_results);
        } else
            self.results = ko.observable([]);
    };
	

    var model = new CrytotronViewModel();
    ko.applyBindings(model);
    
    
});