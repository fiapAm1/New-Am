<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lan�amento de Despesas</title>
</head>
<body>
	<s:form id="form_LancarDepesas" cssClass="formee" action="cadastrarDespesa" method="post" theme="simple">
		<jsp:include page="../../util/includes/menu.jsp" />
		<div class="content">
			<h2>Lan�ar Despesas</h2>
			<div class="grid-6-12">
				<s:label value="C�digo do processo:" for="textfield_Codigo" />
				<s:textfield cssClass="formee-medium" id="textfield_Codigo" name="numeroProcesso" />
				<s:submit cssClass="formee-button left" id="submit_Pesquisar" value="Pesquisar" action="pesquisarProcessoDespesas"/>
			</div>
			<s:if test="%{!processos.isEmpty()}">
				<div class="grid-12-12">
					<table id="table_Audiencias" class="lawyer-table" style="margin-bottom: 5% !important">
						<h3>Processo</h3>
						<thead>
							<tr>
								<th width="10%" class="par">N�mero do Processo</th>
								<th width="50%" class="par">Descri��o do Processo</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator id="iterator_Processo" value="processos">
								<tr>
									<td class="par">
										<s:property value="numeroProcesso"/>
									</td>
									<td class="par">
										<s:property value="processo"/>
									</td>
								</tr>			
							</s:iterator>
						</tbody>
					</table>
					<table id="table_Audiencias" class="lawyer-table">
						<h3>Despesas Filtradas</h3>
						<thead>
							<tr>
								<th width="1%" />
								<th width="15%" class="par">Tipo da Despesa</th>
								<th width="10%" class="par">Valor(R$)</th>
								<th width="10%" class="par" >Data de Lan�amento</th>
								<th width="50%" class="par">Observa��o</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator id="iterator_Despesas" value="despesas">
								<tr>
									<td>
										<input id="radio_Registro" type="radio" name="codigoLancamento" value="${codigoLancamento}"
											   onclick="javascript: localizarDespesa(this);"/>
									</td>
									<td class="par">
										<s:property value="tipoDespesa.despesa"/>
									</td>
									<td class="par">
										<s:property value="valorDespesa"/>
									</td>
									<td class="par">
										<s:date name="dataDespesa" format="dd/MM/yyyy"/>
									</td>
									<td class="par">
										<s:property value="observacao"/>
									</td>
								</tr>			
							</s:iterator>
						</tbody>
					</table>
					<div class="grid-4-12">
						<s:label value="Tipo de Despesa:" for="select_TipoDespesa"/>
						<s:select id="select_TipoDespesa"
								  headerKey="0"
								  headerValue="Selecione"
								  list="tiposDespesas"
								  listKey="codigoDespesa"
								  listValue="despesa"
								  name="despesa.tipoDespesa.codigoDespesa"/>
						
					</div>
					<div class="grid-4-12">
						<s:label value="Valor da Despesa:" for="textfield_Valor" />
						<s:textfield id="textfield_Valor" name="despesa.valorDespesa" />
					</div>
					<div class="grid-12-12">
						<s:label value="Observa��o:" for="textarea_Observacao"/>
						<s:textarea id="textarea_Observacao" name="despesa.observacao" cols="10" rows="25"/>
					</div>
					<div class="grid-12-12" style="text-align: right;">
						<s:submit id="submit_Incluir" action="cadastrarDespesa" value="Incluir"/>
						<s:submit id="submit_Alterar" action="alterarDespesa" value="Alterar"/>
						<s:submit id="submit_Excluir" action="excluirDespesa" value="Excluir"/>
					</div>
				</div>
			</s:if>	
		</div>
	</s:form>
</body>
</html>