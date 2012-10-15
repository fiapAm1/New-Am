jQuery(document).ready(function(){
	
	jQuery("#textfield_num_processo").change(function(){
		if(this.value != null && this.value != ""){
			jQuery("#select_TipoCausa").val(0);
			jQuery("#select_TipoCausa").attr("disabled", true);
			jQuery("#textfield_cliente").val(null);
			jQuery("#textfield_cliente").attr("disabled", true);
		} else {
			jQuery("#select_TipoCausa").attr("disabled", false);
			jQuery("#textfield_cliente").attr("disabled", false);
		}
	});

	jQuery("#textfield_cliente").change(function(){
		if(this.value != null && this.value != ""){
			jQuery("#textfield_num_processo").val(null);
			jQuery("#textfield_num_processo").attr("disabled", true);
		} else {
			if(jQuery("#select_TipoCausa").val() != null && jQuery("#select_TipoCausa").val() == 0){
				jQuery("#textfield_num_processo").attr("disabled", false);
			}
		}
	});

	jQuery("#select_TipoCausa").change(function(){
		if(this.value != null && this.value != 0){
			jQuery("#textfield_num_processo").val(null);
			jQuery("#textfield_num_processo").attr("disabled", true);
		} else {
			if(jQuery("#textfield_cliente").val() == null || jQuery("#textfield_cliente").val() == ""){
				jQuery("#textfield_num_processo").attr("disabled", false);
			}
		}
	});
	
});