jQuery(document).ready(function(){
	jQuery(function(){
		
		jQuery.datepicker.formatDate('dd/MM/yyyy', 
		{dayNamesShort: jQuery.datepicker.regional['pt_BR'].dayNamesShort, 
		dayNames: jQuery.datepicker.regional['pt_BR'].dayNames, 
		monthNamesShort: jQuery.datepicker.regional['pt_BR'].monthNamesShort, 
		monthNAmes: jQuery.datepicker.regional['pt_BR'].monthNames});
		
		jQuery("#textfield_DataAbertura").datepicker();
		jQuery("#textfield_DataFechamento").datepicker();
		jQuery("#textfield_DataInclusao").datepicker();
	});
});
