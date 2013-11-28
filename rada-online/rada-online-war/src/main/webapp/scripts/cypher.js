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
			$.mobile.loading('show');
	
			var jsonDataCypher  = ko.toJS(self.data());
//			new CrytotronViewModelData(self.data().src, self
//					.data().key, self.data().result,
//					self.data().percentage);
	
			var k = jsonDataCypher .key;
			var karray = k.split('/');
			jsonDataCypher.key = karray;
			
	
			$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : myurl,
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(jsonDataCypher),
				success : function(data, textStatus, jqXHR) {
					self = ko.observable(new CrytotronViewModel(
							data.src, data.key, data.result,
							data.percent, 'CRYPT'));
	
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$.mobile.loading('hide');
					alert('crypt ' + textStatus + ' / ' + errorThrown);
				}
			});
			$.mobile.loading('hide');
	
		};
	
		self.decypher = function() {
			self.data().mode('DECRYPT');
			alert("decypher");
		};
	}
	;
	
	var model = new CrytotronViewModel('', '', '', 100, 'CRYPT');
	ko.applyBindings(model);
});