function localizarDespesa(radio){
	var registro = radio.value;
	jQuery.getJSON('localizarDespesa',{'codigoLancamento': registro}, function(json){
		jQuery('#select_TipoDespesa').attr('value', json.jSonTipoDespesa);
		jQuery('#select_TipoDespesa').attr('disabled', true);
		jQuery('#textfield_Valor').attr('value', json.jSonValorDespesa);
		jQuery('#textarea_Observacao').attr('value', json.jSonObservacaoDespesa);
	});
}

function adicionarAdvogado(){
	var registro = jQuery("#select_Advogado").val();
	jQuery.getJSON('adicionarAdvogado', {'advogadoProcesso.advogado.codigoPessoa': registro}, function(json) {
		var advogados = list.advogadosVinculados;
		for(var i in advogados){
			var novaLinha = table.tBodies[0].insertRow(i);
			
			var celula0 = novaLinha.insertCell(0);
			celula0.appendChild(i);
			var celula1 = novaLinha.insertCell(1);
			celula1.appendChild(i);
			var celula2 = novaLinha.insertCell(2);
			celula2.appendChild(i);
		}
	});
	return false;
}