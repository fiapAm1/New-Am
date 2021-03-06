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
<title>Emiss�o de Relat�rio de Audi�ncias</title>
</head>
<body>
	<s:form id="form_EmitirRelatorio" action="emitirAudiencia"	method="post" cssClass="formee"	theme="simple">
		
		<jsp:include page="../../util/includes/menu.jsp" />	
		<div class="content">
			
			<h2>Pesquisar Audi�ncias por Processo</h2>
			<div class="grid-6-12">
				<s:label value="C�digo do Processo" for="textfield_Codigo" />
				<s:textfield cssClass="formee-medium" id="textfield_Codigo" name="codigoProcesso" />
				<s:submit id="submit_Pesquisar" cssClass="formee-button left" value="Pesquisar" action="pesquisarAudiencia"/>
			</div>
			<s:if test="%{!audiencias.isEmpty()}">
				<div class="grid-12-12">
					<table id="table_Audiencias"
						   class="lawyer-table">
						<h3>Audi�ncias Filtradas</h3>
						<thead>
							<tr>
								<th width="15%" class="par">Advogado</th>
								<th width="15%" class="par">Forum</th>
								<th width="10%" class="par" >Data da Audi�ncia</th>
								<th width="30%" class="par">Logradouro</th>
								<th width="10%" class="par">N�mero</th>
								<th width="10%" class="par">Sala</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator id="iterator_Audiencias"
										value="audiencias">
								<tr>
									<td class="par"><s:property value="nomeAdvogado"/></td>
									<td class="par"><s:property value="forum"/></td>
									<td class="par"><s:date name="dataAudiencia" format="dd/MM/yyyy"/></td>
									<td class="par"><s:property value="logradouro"/></td>
									<td class="par"><s:property value="numeroEndereco"/></td>
									<td class="par"><s:property value="sala"/></td>
								</tr>			
							</s:iterator>
						</tbody>
					</table>
				</div>
			</s:if>
		</div>
	</s:form>
</body>
</html>