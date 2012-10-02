<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../util/css.jsp" />
<jsp:include page="../../util/js.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Exibir Processo</title>
</head>
<body>
	<s:form cssClass="formee"
			action="listarProcesso"
			method="post"
			theme="simple">
		<fieldset>
			<legend class="grid-12-12">Processo Selecionado</legend>
			<div class="grid-6-12">
				<fieldset>
					<div class="grid-11-12">
						<s:label value="Selecione um Cliente:"
								 for="select_Cliente"/>
						<s:select id="select_Cliente"
								  headerKey="0"
								  headerValue="Selecione"
								  list="clientes"
								  listKey="codigoPessoa"
								  listValue="nomePessoa"
								  disabled="true"
								  value="%{pessoa.cliente.codigoPessoa}"/>
					</div>
					<div class="grid-11-12">
						<s:label value="Selecione um Tipo de Causa:"
								 for="select_TipoCausa"/>
						<s:select id="select_TipoCausa"
								  headerKey="0"
								  headerValue="Selecione"
								  list="tiposCausas"
								  listKey="codigoCausa"
								  listValue="causa"
								  disabled="true"
								  value="%{processo.causa.codigoCausa}"/>
					</div>
					<div class="grid-11-12">
						<s:label value="Selecione um Forum:"
								 for="select_Forum"/>
						<s:select id="select_Forum"
								  headerKey="0"
								  headerValue="Selecione"
								  list="foruns"
								  listKey="codigoPessoa"
								  listValue="nomePessoa"
								  disabled="true"
								  value="%{processo.forum.codigoPessoa}"/>
					</div>
					<div class="grid-11-12">
						<fieldset>
							<legend>Prazos</legend>
							<div class="grid-6-12">
								<s:label value="Data de Abertura:"
										 for="textfield_DataAbertura"/>
								<s:textfield id="textfield_DataAbertura"											 
											 maxlength="10"
											 disabled="true"
											 value="%{processo.dataAbertura}"/>
							</div>
							<div class="grid-6-12">
								<s:label value="Data de Fechamento:"
										 for="textfield_DataFechamento"/>
								<s:textfield id="textfield_DataFechamento"
											 maxlength="10"
											 disabled="true"
											 value="%{processo.dataFechamento}"/>
							</div>
							<div class="grid-6-12">
								<s:label value="Selecione um Tipo de Cobrança:"
								 		 for="select_TipoCobranca"/>
								<s:select id="select_TipoCobranca"
								  		  headerKey="0"
								  		  headerValue="Selecione"
								  		  list="tiposCobrancas"
								  		  listKey="codigoCobranca"
								  		  listValue="periodoCobranca"
								  		  disabled="true"
								  		  value="%{processo.cobranca.codigoCobranca}"/>
							</div>
							<div class="grid-6-12">
								<s:label value="Selecione Dia de Vencimento:"
								 		 for="select_DiaVencimento"/>
								<s:select id="select_DiaVencimento"
								  		  headerKey="0"
								  		  headerValue="Selecione"
								  		  list="dias"
								  		  disabled="true"
								  		  value="%{processo.diaVencimento}"/>
							</div>
						</fieldset>
					</div>
					<div class="grid-11-12">
						<fieldset>
							<legend class="grid-12-12">Resultado da causa</legend>
							<div class="grid-12-12">
								<s:radio id="radio_ResultadoCausa"
										 list="#{'1':'Ganha','0':'Perda'}"
										 disabled="true"
										 value="%{processo.resultadoCausa}"/>
							</div>	
						</fieldset>
					</div>
				</fieldset>
			</div>	
			<div class="grid-6-12">
				<fieldset>	
					<div class="grid-12-12"
						 style="overflow-y: scroll; height: 245px !important">
						<table class="lawyer-table">
							<caption>
								<strong>Advogados Vinculados ao Processo</strong>
							</caption>
							<thead>
								<tr>
									<th align="center" 
										width="50%"
										class="par">
										Nome
									</th>
									<th align="center"
										width="30%"
										class="par">
										Data Inclusão
									</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator id="iterator_AdvogadosVinculados"
											value="advogadosVinculados">
									<tr>
										<td align="left" 
											width="50%"
											class="par">
											<s:property value="advogado.nomePessoa"/>
										</td>
										<td align="left" 
											width="30%"
											class="par">
											<s:property value="dataInicio"/>
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</fieldset>
			</div>
			<div class="grid-6-12">
				<fieldset>
					<div class="grid-11-12">
						<s:label value="Descrição:"
						 		 for="textarea_Descricao"/>
						<s:textarea id="textarea_Descricao"
									disabled="true"
									value="%{processo.processo}"/>
					</div>
				</fieldset>
			</div>
			<div class="grid-12-12">
				<s:label value="Observação:"
				 		 for="textarea_Observacao"/>
				<s:textarea id="textarea_Observacao"
							disabled="true"
							value="%{processo.observacao}"/>
			</div>		
			<div class="grid-12-12">
				<hr></hr>
			</div>
			<div class="grid-12-12" style="text-align: right;">
				<s:submit id="submit_Voltar"
						  value="Voltar"/>
			</div> 			
		</fieldset>
	</s:form>
</body>
</html>