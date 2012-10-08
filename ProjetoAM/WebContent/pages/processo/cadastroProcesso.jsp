<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Cadastro de Processos</title>
</head>
<body>
	<s:form id="form_CadastrarProcesso"
			cssClass="formee"
			action="cadastrarProcesso"
			method="post"
			theme="simple">
		<jsp:include page="../../util/includes/menu.jsp" />
		<fieldset>
			<legend class="grid-12-12">Cadastro de Processos</legend>
			<div class="grid-6-12">
				<fieldset>
					<div class="grid-11-12">
						<s:label value="Cliente:"
								 for="select_Cliente"/>
						<s:select id="select_Cliente"
								  headerKey="0"
								  headerValue="Selecione"
								  list="clientes"
								  listKey="codigoPessoa"
								  listValue="nomePessoa"
								  name="processo.cliente.codigoPessoa"/>
					</div>
					<div class="grid-11-12">
						<s:label value="Tipo de Causa:"
								 for="select_TipoCausa"/>
						<s:select id="select_TipoCausa"
								  headerKey="0"
								  headerValue="Selecione"
								  list="tiposCausas"
								  listKey="codigoCausa"
								  listValue="causa"
								  name="processo.causa.codigoCausa"/>
					</div>
					<div class="grid-11-12">
						<s:label value="Forum:"
								 for="select_Forum"/>
						<s:select id="select_Forum"
								  headerKey="0"
								  headerValue="Selecione"
								  list="foruns"
								  listKey="codigoPessoa"
								  listValue="nomePessoa"
								  name="processo.forum.codigoPessoa"/>
					</div>
					<div class="grid-11-12">
						<fieldset>
							<legend>Prazos</legend>
							<div class="grid-6-12">
								<s:label value="Data de Abertura:"
										 for="textfield_DataAbertura"/>
								<s:textfield id="textfield_DataAbertura"											 
											 maxlength="10"
											 name="processo.dataAberturaStr"/>
							</div>
							<div class="grid-6-12">
								<s:label value="Data de Fechamento:"
										 for="textfield_DataFechamento"/>
								<s:textfield id="textfield_DataFechamento"
											 maxlength="10"
											 name="processo.dataFechamentoStr"/>
							</div>
							<div class="grid-6-12">
								<s:label value="Tipo de Cobrança:"
								 		 for="select_TipoCobranca"/>
								<s:select id="select_TipoCobranca"
								  		  headerKey="0"
								  		  headerValue="Selecione"
								  		  list="tiposCobrancas"
								  		  listKey="codigoCobranca"
								  		  listValue="periodoCobranca"
								  		  name="processo.cobranca.codigoCobranca"
								  		  required="true"/>
							</div>
							<div class="grid-6-12">
								<s:label value="Dia de Vencimento:"
								 		 for="select_DiaVencimento"/>
								<s:select id="select_DiaVencimento"
								  		  headerKey="0"
								  		  headerValue="Selecione"
								  		  list="dias"
								  		  name="processo.diaVencimento"
								  		  required="true"/>
							</div>
						</fieldset>
					</div>
					<div class="grid-11-12">
						<fieldset>
							<legend class="grid-12-12">Resultado da causa</legend>
							<div class="grid-12-12">
								<s:radio id="radio_ResultadoCausa"
										 name="processo.resultadoCausa"
										 list="#{'2':'Ganha','1':'Perda'}"/>
							</div>	
						</fieldset>
					</div>
				</fieldset>
			</div>	
			<div class="grid-6-12">
				<fieldset>
					<div class="grid-11-12">
						<s:label value="Selecione um Advogado:"
						 		 for="select_Advogado"/>
						<s:select id="select_Advogado"
						  		  headerKey="0"
						  		  headerValue="Selecione"
						  		  list="advogados"
								  listKey="codigoPessoa"
								  listValue="nomePessoa"
								  name="advogadoProcesso.advogado.codigoPessoa"/>
					</div>
					<div class="grid-5-12 clear">
						<s:label value="Data de Inclusão:"
								 for="textfield_DataInclusao"/>
						<s:textfield id="textfield_DataInclusao"
									 maxlength="10"/>
					</div>
					<div class="grid-6-12"
						 style="top: 4% !important">
						<input id="button_Adicionar"
							   class="formee-button"
							   onclick="javascript: adicionarAdvogado();"
							   value="Vincular Advogado"
							   align="left"
							   type="button"/>
					</div>	
					<div class="grid-12-12"
						 style="overflow-y: scroll; height: 245px !important">
						<table id="table_AdvogadosVinculados"
							   class="lawyer-table">
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
									<th align="center" 
										width="20%"
										class="impar">
										Remover
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
										<td align="center" 
											width="20%"
											class="impar">
											<s:hidden id="hidden_Remover"
		 		   									  name="codigoPessoa"
		           									  value="%{advogado.codigoPessoa}"/>
		           							<img src="../css/img/formee/form-ic-error.png" 
									 				 alt="Remover Advogado" 
									 				 title="Remover Advogado"
									 				 style="cursor: pointer"
									 				 onclick="javascript: removerAdvogado(document.getElementById('hidden_Remover').getAttribute('value'))"/>
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
									name="processo.processo"/>
					</div>
				</fieldset>
			</div>
			<div class="grid-12-12">
				<s:label value="Observação:"
				 		 for="textarea_Observacao"/>
				<s:textarea id="textarea_Observacao"
							name="processo.observacao"/>
			</div>		
			<div class="grid-12-12">
				<hr></hr>
			</div>
			<div class="grid-12-12" style="text-align: right;">
				<s:submit id="submit_Confirmar"
						  value="Confirmar"/>
				<s:submit id="submit_Voltar"
						  action="forwardHome"
						  value="Voltar"/>
			</div> 			
		</fieldset>
	</s:form>
</body>
</html>