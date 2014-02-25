$(document).ready(function() {
	var myurl = './services/Cryptotron/cryptotron';
	
	// {"src":"example","res":"example","key":[1,11,42],"mode":"CRYPT","percentage":100}
	function CrytotronViewModelData(p_src, p_key_tab, p_result,
			p_percent, p_mode) {
		var self = this;
		self.src = ko.observable(p_src);
		self.key = ko.observable(p_key_tab);
		self.res = ko.observable(p_result);
		self.mode = ko.observable(p_mode);
		self.percentage = ko.observable(p_percent);
	}
	
	function CrytotronViewModel(p_src, p_key_tab, p_result, p_percent,
			p_mode) {
		var self = this;
		self.data = ko.observable(new CrytotronViewModelData(p_src,
				p_key_tab, p_result, p_percent, p_mode));
	
		self.cypher = function() {
			self.data().mode('CRYPT');
			self.doit();
	
		};
	
		self.decypher = function() {
			self.data().mode('DECRYPT');
			self.doit();
		};
		
		self.doit = function() {
			$.mobile.loading('show');
			var jsonDataCypher  = ko.toJS(self.data());
			var k = jsonDataCypher .key;
			var karray = k.split('/');
			jsonDataCypher.key = karray;
	
			$.ajax({
				type : 'POST',
				url : myurl,
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				data : JSON.stringify(jsonDataCypher),
				success : function(data, textStatus, jqXHR) {
					var skey = [];
					if (Array.isArray(data.key)) {
			            skey = data.key.join('/');
			        } 
					 
					self.data().res(data.res);
					
	
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$.mobile.loading('hide');
					alert(self.data().mode() + ' ' + textStatus + ' / ' + errorThrown);
				}
			});
			$.mobile.loading('hide');
		};
	}
	;
	
	var model = new CrytotronViewModel('', '', '', 0, 'CRYPT');
	ko.applyBindings(model);
});