<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../util/css.jsp" />
<jsp:include page="../../util/js.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Alterar Processos</title>
</head>
<body>
	<s:form cssClass="formee"
			action="alterarProcesso"
			method="post"
			theme="simple">
		<fieldset>
			<legend class="grid-12-12">Alterar Processo</legend>
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
								  name="processo.cliente.codigoPessoa"
								  disabled="true"
								  value="%{processo.cliente.codigoPessoa}"/>
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
								  name="processo.causa.codigoCausa"
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
								  name="processo.forum.codigoPessoa"
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
											 name="processo.dataAbertura"
											 disabled="true"
											 value="%{processo.dataAbertura}"/>
							</div>
							<div class="grid-6-12">
								<s:label value="Data de Fechamento:"
										 for="textfield_DataFechamento"/>
								<s:textfield id="textfield_DataFechamento"
											 maxlength="10"
											 name="processo.dataFechamento"
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
								  		  name="processo.cobranca.codigoCobranca"
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
								  		  name="processo.diaVencimento"
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
										 name="processo.resultadoCausa"
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
									 maxlength="10"
									 name="advogadoProcesso.dataInicio"/>
					</div>
					<div class="grid-6-12"
						 style="top: 4% !important">
						<s:submit id="submit_Adicionar"
								  action="adicionarAdvogado"
								  value="Adicionar advogado ao processo"
								  align="left"/>
					</div>	
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
											<s:url id="url_RemoverAdvogado"
												   action="removerAdvogado">
												<s:param name="advogadoProcesso.advogado.codigoPessoa" 
														 value="advogado.codigoPessoa"/>
											</s:url>
											<s:a href="%{url_RemoverAdvogado}">
												<img src="../img/form-ic-error.png" 
									 				 alt="Remover Advogado" 
									 				 title="Remover Advogado"/>
											</s:a>
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
									name="processo.processo"
									value="%{processo.processo}"/>
					</div>
				</fieldset>
			</div>
			<div class="grid-12-12">
				<s:label value="Observação:"
				 		 for="textarea_Observacao"/>
				<s:textarea id="textarea_Observacao"
							name="processo.observacao"
							value="%{processo.observacao}"/>
			</div>		
			<div class="grid-12-12">
				<hr></hr>
			</div>
			<div class="grid-12-12" style="text-align: right;">
				<s:submit id="submit_Confirmar"
						  value="Confirmar"/>
				<s:submit id="submit_Voltar"
						  action="listarProcesso"
						  value="Voltar"/>
			</div> 			
		</fieldset>
	</s:form>
</body>
</html>