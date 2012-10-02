jQuery(document).ready(function(){
	
	jQuery('#textfield_DataAbertura').focus(function(){
		jQuery(this).calendario({
			target:'#textfield_DataAbertura'
		});
	});
	
	jQuery('#textfield_DataFechamento').focus(function(){
		jQuery(this).calendario({
			target:'#textfield_DataFechamento'
		});
	});
	
	jQuery('#textfield_DataInclusao').focus(function(){
		jQuery(this).calendario({
			target:'#textfield_DataInclusao'
		});
	});
	
});
