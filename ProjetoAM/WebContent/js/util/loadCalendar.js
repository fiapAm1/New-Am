jQuery(document).ready(function(){
	jQuery(function(){
		jQuery("#textfield_DataAbertura").datepicker({dateFormat : "dd/mm/yy",
			dayNamesMin : ['Do','Se','Te','Qa','Qi','Se','Sa'],
			monthNames: ["Janeiro","Fevereiro","Março","Abril",
			             "Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"]});
		jQuery("#textfield_DataFechamento").datepicker({dateFormat : "dd/mm/yy",
			dayNamesMin : ['Do','Se','Te','Qa','Qi','Se','Sa'],
			monthNames: ["Janeiro","Fevereiro","Março","Abril",
			             "Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"]});
		jQuery("#textfield_DataInclusao").datepicker({dateFormat : "dd/mm/yy",
			dayNamesMin : ['Do','Se','Te','Qa','Qi','Se','Sa'],
			monthNames: ["Janeiro","Fevereiro","Março","Abril",
			             "Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"]});
	});
});
