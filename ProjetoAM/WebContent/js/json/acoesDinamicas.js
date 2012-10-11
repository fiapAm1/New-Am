function construirTabelaAdvogadoProcesso(list){
	var tabela = "";
	for(var i in list){
		tabela += "<tr>" +
						"<td align=\"left\"	width=\"50%\" class=\"par\">" +
							list[i].advogado.nomePessoa +
						"</td>" +
						"<td align=\"left\"	width=\"30%\" class=\"par\">" +
							list[i].dataInicioStr +
						"</td>" +
						"<td align=\"left\"	width=\"20%\" class=\"impar\">" +
							"<input type=\"hidden\" id=\"hidden_Remover\" name=\"codigoPessoa\" value=\""+list[i].advogado.codigoPessoa+"\"/>"+
							"<img src=\"../css/img/formee/form-ic-error.png\" "+ 
					 			 "alt=\"Remover Advogado\""+ 
					 			 "title=\"Remover Advogado\"" +
					 			 "style=\"cursor: pointer\"" +
					 			 "onclick=\"javascript: removerAdvogado(this)\"/>"+
						"</td>" +
					"</tr>";
	} 
	return tabela;
}

function adicionarAdvogado(){
	var registro = jQuery("#select_Advogado").val();
	var data = jQuery("#textfield_DataInclusao").val();
	jQuery.getJSON('adicionarAdvogado', {'advogadoProcesso.advogado.codigoPessoa': registro, 
		'advogadoProcesso.dataInicioStr': data}, function(json) {
		var list = json.advogadosVinculados;
		var table = jQuery("#table_AdvogadosVinculados > tbody:first");
		table.html("");
		table.append(construirTabelaAdvogadoProcesso(list));
		jQuery("#select_Advogado").val(0);
		jQuery("#textfield_DataInclusao").val("");
		atribuirMensagemDinamica(json.jSonMensagem, json.jSonResultado);
		ativarMensagem();
	});
}

function removerAdvogado(img){
	var tr = img.parentNode;
	var array = tr.childNodes;
	for(var i in array){
		var auxHidden = array[i]; 
		if(auxHidden.nodeName == "INPUT"){
			var hidden = auxHidden;
			break;
		}
	}
	jQuery.getJSON('removerAdvogado', {'advogadoProcesso.advogado.codigoPessoa': hidden.value}, function(json) {
		var list = json.advogadosVinculados;
		var table = jQuery("#table_AdvogadosVinculados > tbody:first");
		table.html("");
		table.append(construirTabelaAdvogadoProcesso(list));
		atribuirMensagemDinamica(json.jSonMensagem, json.jSonResultado);
		ativarMensagem();
	});
}

function localizarDespesa(radio){
	var registro = radio.value;
	jQuery.getJSON('localizarDespesa',{'codigoLancamento': registro}, function(json){
		jQuery('#select_TipoDespesa').attr('value', json.jSonTipoDespesa);
		jQuery('#select_TipoDespesa').attr('disabled', true);
		jQuery('#textfield_Valor').attr('value', json.jSonValorDespesa);
		jQuery('#textarea_Observacao').attr('value', json.jSonObservacaoDespesa);
	});
}