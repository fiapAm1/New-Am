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
<title>Lançamento de Despesas</title>
</head>
<body>
	<s:form id="form_LancarDepesas"
			cssClass="formee" 
			action="cadastrarDespesa" 
			method="post" 
			theme="simple">
		<fieldset>
			<legend>Lançar Despesas</legend>
			<div class="grid-8-12">
				<div class="grid-3-12">
					<s:label value="Código do processo:" for="textfield_Codigo" />
				</div>
				<div class="grid-4-12">
					<s:textfield id="textfield_Codigo" name="numeroProcesso" />
				</div>
				<div class="grid-3-12">
				<s:submit id="submit_Pesquisar"
						  value="Pesquisar"
						  action="pesquisarProcessoDespesas"/>
				</div>
			</div>
			<div class="grid-12-12">
				<table id="table_Audiencias"
					   class="lawyer-table"
					   style="margin-bottom: 5% !important">
					<caption>Processo</caption>
					<thead>
						<tr>
							<th width="10%" class="par">Número do Processo</th>
							<th width="50%" class="par">Descrição do Processo</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator id="iterator_Processo"
									value="processos">
							<tr>
								<td class="par"><s:property value="numeroProcesso"/></td>
								<td class="par"><s:property value="processo"/></td>
							</tr>			
						</s:iterator>
					</tbody>
				</table>
				<table id="table_Audiencias"
					   class="lawyer-table">
					<caption>Despesas Filtradas</caption>
					<thead>
						<tr>
							<th width="1%" ></th>
							<th width="15%" class="par">Tipo da Despesa</th>
							<th width="10%" class="par">Valor(R$)</th>
							<th width="10%" class="par" >Data de Lançamento</th>
							<th width="50%" class="par">Observação</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator id="iterator_Despesas"
									value="despesas">
							<tr>
								<td>
									<input id="radio_Registro"
										   type="radio" 
										   name="codigoLancamento" 
										   value="${codigoLancamento}"
										   onclick="javascript: localizar();"/>
								</td>
								<td class="par"><s:property value="tipoDespesa.despesa"/></td>
								<td class="par"><s:property value="valorDespesa"/></td>
								<td class="par"><s:date name="dataDespesa" format="dd/MM/yyyy"/></td>
								<td class="par"><label title="<s:property value="observacao"/>"/></td>
							</tr>			
						</s:iterator>
					</tbody>
				</table>
				<div class="grid-8-12">
					<div class="grid-2-12">
						<s:label value="Tipo de Despesa:"
								 for="select_TipoDespesa"/>
					</div>
					<div class="grid-4-12">
						<s:select id="select_TipoDespesa"
								  headerKey="0"
								  headerValue="Selecione"
								  list="tiposDespesas"
								  listKey="codigoDespesa"
								  listValue="despesa"
								  name="despesa.tipoDespesa.codigoDespesa"
								  required="true"/>
						
					</div>
					<div class="grid-3-12">
						<s:label value="Valor da Despesa:" for="textfield_Valor" />
					</div>
					<div class="grid-3-12">
						<s:textfield id="textfield_Valor" name="despesa.valorDespesa" />
					</div>
				</div>
				<div class="grid-8-12">
					<s:label value="Observação:"
					 		 for="textarea_Observacao"/>
					<s:textarea id="textarea_Observacao"
								name="despesa.observacao"
								cols="10"
								rows="25"/>
				</div>
			</div>
			<div class="grid-12-12">
				<hr></hr>
			</div>
			<div class="grid-12-12" style="text-align: right;">
				<s:submit id="submit_Incluir"
						  action="cadastrarDespesa"
						  value="Incluir"/>
				<s:submit id="submit_Alterar"
						  action="alterarDespesa"
						  value="Alterar"/>
				<s:submit id="submit_Excluir"
						  action="excluirDespesa"
						  value="Excluir"/>
				<s:submit id="submit_Voltar"
						  action="home"
						  value="Voltar"/>
			</div>
		</fieldset>
	</s:form>
</body>
</html>