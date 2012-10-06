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
<title>Emiss�o de Relat�rio de Honor�rios</title>
</head>
<body>
	<s:form id="form_EmitirRelatorio" action="emitirHonorario" method="post" cssClass="formee" theme="simple">
		<fieldset>
			<legend>Pesquisar Honor�rios por Processo</legend>
			<div class="grid-4-12">
				<div class="grid-5-12">
					<s:label value="C�digo do Processo" for="textfield_Codigo" />
				</div>
				<div class="grid-7-12">
					<s:textfield id="textfield_Codigo" name="codigoProcesso" />
				</div>
			</div>
			<div class="grid-4-12">
				<div class="grid-5-12">
					<s:label value="Selecione uma Tarefa:" for="select_Tarefa"/>
				</div>
				<div class="grid-7-12">
					<s:select id="select_Tarefa"
							  headerKey="0"
							  headerValue="Selecione"
							  list="tarefas"
							  listKey="codigo"
							  listValue="tarefa"
							  name="codigoTarefa"/>
				</div>
			</div>
			<div class="grid-4-12" style="text-align: left;">
				<s:submit id="submit_Pesquisar" value="Pesquisar" action="pesquisarHonorario"/>
			</div>
			<div class="grid-12-12">
				<table id="table_Processos" class="lawyer-table">
					<caption>Honor�rios Filtrados</caption>
					<thead>
						<tr>
							<th width="40%" class="par">Advogado</th>
							<th width="40%" class="par" >Data do Honor�rio</th>
							<th width="20%" class="par">Valor Tarefa</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator id="iterator_Honorarios" value="honorarios">
							<tr>
								<td class="par"><s:property value="nomeAdvogado"/></td>
								<td class="par"><s:date name="dataHonorario" format="dd/MM/yyyy"/></td>
								<td class="par"><s:property value="valorTarefa"/></td>
							</tr>			
						</s:iterator>
					</tbody>
				</table>
			</div>
			<div class="grid-9-12" style="text-align: right;">
				<s:label value="Total gasto:" for="label_somaHonorario"/>
			</div>
			<div class="grid-3-12" >
				<s:label id="label_somaHonorario" name="somaHonorario" />
			</div>
			<div class="grid-12-12">
				<hr></hr>
			</div>
			<div class="grid-12-12" style="text-align: right;">
				<s:submit id="submit_Emitir" action="emitir" value="Emitir Relat�rio"/>
				<s:submit id="submit_Voltar" action="home" value="Voltar"/>
			</div>
		</fieldset>
	</s:form>
</body>
</html>