var a$ = jQuery.noConflict();

a$(document).ready(function(){
	a$(function(){
		a$("#textfield_DataAbertura").datepicker({dateFormat : "dd/mm/yy",
			dayNamesMin : ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],
			monthNames: ["Janeiro","Fevereiro","Março","Abril",
			             "Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"]});
		a$("#textfield_DataFechamento").datepicker({dateFormat : "dd/mm/yy",
			dayNamesMin : ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],
			monthNames: ["Janeiro","Fevereiro","Março","Abril",
			             "Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"]});
		a$("#textfield_DataInclusao").datepicker({dateFormat : "dd/mm/yy",
			dayNamesMin : ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],
			monthNames: ["Janeiro","Fevereiro","Março","Abril",
			             "Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"]});
	});
});
