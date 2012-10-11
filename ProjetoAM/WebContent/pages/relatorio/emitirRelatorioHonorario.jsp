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
<title>Emissão de Relatório de Honorários</title>
</head>
<body>
	<s:form id="form_EmitirRelatorio" action="emitirHonorario" method="post" cssClass="formee" theme="simple">
		<jsp:include page="../../util/includes/menu.jsp" />
		<div class="content">
			<h2>Pesquisar Honorários por Processo</h2>
			<div class="grid-6-12">
				<s:label value="Código do Processo" for="textfield_Codigo" />
				<s:textfield id="textfield_Codigo" name="codigoProcesso" />
			</div>
			<div class="grid-6-12">
				<s:label value="Selecione uma Tarefa:" for="select_Tarefa"/>
				<s:select id="select_Tarefa"
							cssClass="formee-medium"
						  headerKey="0"
						  headerValue="Selecione"
						  list="tarefas"
						  listKey="codigo"
						  listValue="tarefa"
						  name="codigoTarefa"/>
				<s:submit cssClass="formee-button left" id="submit_Pesquisar" value="Pesquisar" action="pesquisarHonorario"/>
			</div>
			<s:if test="%{!honorarios.isEmpty()}">
				<div class="grid-12-12">
					<table id="table_Processos" class="lawyer-table">
						<caption>Honorários Filtrados</caption>
						<thead>
							<tr>
								<th width="40%" class="par">Advogado</th>
								<th width="40%" class="par" >Data do Honorário</th>
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
			</s:if>
		</div>
	</s:form>
</body>
</html>