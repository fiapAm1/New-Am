var desativar;

jQuery(document).ready(function(){ 
	ativarMensagem();
});

function ativarMensagem(){
	var resultado = jQuery("#hidden_Resultado");
	if(resultado.val() != null && resultado.val() != ""){
		if(resultado.val() == "sucesso"){
			jQuery("#div_Mensagem").removeClass(jQuery("#div_Mensagem").attr("class"));
			jQuery("#div_Mensagem").addClass("formee-msg-success");
			jQuery("#div_Mensagem").show("slow");
		} else if (resultado.val() == "erro") {
			jQuery("#div_Mensagem").removeClass(jQuery("#div_Mensagem").attr("class"));
			jQuery("#div_Mensagem").addClass("formee-msg-error");
			jQuery("#div_Mensagem").show("slow");
		} else if (resultado.val() == "info"){
			jQuery("#div_Mensagem").removeClass(jQuery("#div_Mensagem").attr("class"));
			jQuery("#div_Mensagem").addClass("formee-msg-info");
			jQuery("#div_Mensagem").show("slow");
		}
		desativar = setTimeout('visibilidadeMensagem()', 10000);
	}
}

function visibilidadeMensagem(){
	if(jQuery("#div_Mensagem").is(":visible")){
		jQuery("#div_Mensagem").hide("slow");
	}
}

function atribuirMensagemDinamica(mensagem, resultado){
	jQuery("#hidden_Resultado").val(resultado);
	jQuery("#strong_Mensagem").html(mensagem);
}
