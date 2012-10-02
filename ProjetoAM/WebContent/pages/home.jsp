<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>HOME - EM CONSTRUÇÃO</title>
</head>
<body>
<s:form method="post">
	<div>
		<s:url var="url_CadastroProcesso" 
			   value="forwardCadastrarProcesso">
			<s:param name="paginaDirecionar">cadastrar</s:param>
		</s:url>
		
		<s:a href="%{url_CadastroProcesso}">
			Cadastrar Processo
		</s:a>
	</div>
	<br></br>
	<div>
		<s:url var="url_ListarProcesso" 
			   value="forwardCadastrarProcesso">
			<s:param name="paginaDirecionar">listar</s:param>
		</s:url>
		
		<s:a href="%{url_ListarProcesso}">
			Listar Processos
		</s:a>
	</div>
	<br></br>
	<div>
		<s:url var="url_RelatorioHonorario" 
			   value="forwardRelatorio">
			<s:param name="paginaDirecionar">emitirHonorario</s:param>
		</s:url>
		
		<s:a href="%{url_RelatorioHonorario}">
			Relatorio Honorario
		</s:a>
	</div>
	<br></br>
	<div>
		<s:url var="url_RelatorioAudiencia" 
			   value="forwardRelatorio">
			<s:param name="paginaDirecionar">emitirAudiencia</s:param>
		</s:url>
		
		<s:a href="%{url_RelatorioAudiencia}">
			Relatorio Audiencia
		</s:a>
	</div>
	<br></br>
	<div>
		<s:url var="url_RegistrarPagamento" 
			   value="forwardRegistrarPagamento">
			<s:param name="paginaDirecionar">registrarPagamento</s:param>
		</s:url>
		
		<s:a href="%{url_RegistrarPagamento}">
			Registrar Pagamento
		</s:a>
	</div>
	<br></br>
	<div>
		<s:url var="url_LancarDespesas" 
			   value="forwardLancarDespesa">
			<s:param name="paginaDirecionar">lancar</s:param>
		</s:url>
		
		<s:a href="%{url_LancarDespesas}">
			Lançar Despesas
		</s:a>
	</div>
</s:form>
</body>
</html>