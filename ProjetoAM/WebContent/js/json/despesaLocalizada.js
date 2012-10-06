function localizar(radio){
	var registro = radio.value;
	jQuery.getJSON('localizarDespesa',{'codigoLancamento': registro}, function(json){
		jQuery('#select_TipoDespesa').attr('value', json.jSonTipoDespesa);
		jQuery('#select_TipoDespesa').attr('disabled', true);
		jQuery('#textfield_Valor').attr('value', json.jSonValorDespesa);
		jQuery('#textarea_Observacao').attr('value', json.jSonObservacaoDespesa);
	});

}