<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../util/css.jsp" />
<jsp:include page="../../util/js.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
</head>
<body>
	<fieldset class="fieldMenu">
		<div class="divMenu">
			<ul class="sf-menu">
				<li>
					<s:url var="url_Home" 
				   		   value="forwardHome">
						<s:param name="paginaDirecionar">home</s:param>
					</s:url>
			
					<s:a href="%{url_Home}">
						HOME
					</s:a>				
				</li>
				<li class="current">
					<s:a>Processos</s:a>
					<ul>
						<li>
							<s:url var="url_CadastroProcesso" 
				   				   value="forwardCadastrarProcesso">
								<s:param name="paginaDirecionar">cadastrar</s:param>
							</s:url>
			
							<s:a href="%{url_CadastroProcesso}">
								Cadastrar Processo
							</s:a>
						</li>
						<li>
							<s:url var="url_ListarProcesso" 
				   				   value="forwardListarProcesso">
								<s:param name="paginaDirecionar">listar</s:param>
							</s:url>
			
							<s:a href="%{url_ListarProcesso}">
								Listar Processos
							</s:a>
						</li>
					</ul>
				</li>
				<li class="current">
					<s:a>Relatórios</s:a>
					<ul>
						<li>
							<s:url var="url_RelatorioHonorario" 
								   value="forwardRelatorio">
								<s:param name="paginaDirecionar">emitirHonorario</s:param>
							</s:url>
							
							<s:a href="%{url_RelatorioHonorario}">
								Honorário
							</s:a>
						</li>
						<li>
							<s:url var="url_RelatorioAudiencia" 
								   value="forwardRelatorio">
								<s:param name="paginaDirecionar">emitirAudiencia</s:param>
							</s:url>
							
							<s:a href="%{url_RelatorioAudiencia}">
								Audiência
							</s:a>
						</li>
					</ul>
				</li>
				<li class="current">
					<s:a>Negócios</s:a>
					<ul>
						<li>
							<s:url var="url_RegistrarPagamento" 
								   value="forwardRegistrarPagamento">
								<s:param name="paginaDirecionar">registrarPagamento</s:param>
							</s:url>
							
							<s:a href="%{url_RegistrarPagamento}">
								Registrar Pagamento por Processo
							</s:a>
						</li>
						<li>
							<s:url var="url_LancarDespesas" 
								   value="forwardLancarDespesa">
								<s:param name="paginaDirecionar">lancar</s:param>
							</s:url>
							
							<s:a href="%{url_LancarDespesas}">
								Lançar Despesas por Processo
							</s:a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</fieldset>
	<div id="div_Mensagem"
		 class="formee-msg-info"
		 style="display: none">
		 <strong id="strong_Mensagem">
		 	<s:property value="mensagem"/>
		 </strong>
		 <s:hidden id="hidden_Resultado"
		 		   name="resultado"
		           value="%{resultado}"/>
	</div>
</body>
</html>