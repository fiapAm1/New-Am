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
	<s:form cssClass="formee" action="listarProcesso" method="post" theme="simple">
		<jsp:include page="../../util/includes/menu.jsp" />
		<div class="content">
			<h2>Processo Selecionado</h2>
			<div class="box box-processo">
				<h3>Informações básicas</h3>
				<div class="grid-6-12">
					<s:label value="Nome do processo:" for="textarea_Descricao"/>
					<s:textfield id="textarea_Descricao" disabled="true" value="%{processo.processo}"/>
				</div>
				<div class="grid-6-12">	
					<s:label value="Selecione um Cliente:" for="select_Cliente"/>
					<s:select id="select_Cliente"
							  headerKey="0"
							  headerValue="Selecione"
							  list="clientes"
							  listKey="codigoPessoa"
							  listValue="nomePessoa"
							  disabled="true"
							  value="%{processo.cliente.codigoPessoa}"/>
				</div>
				<div class="grid-6-12 clear">
					<s:label value="Selecione um Tipo de Causa:" for="select_TipoCausa"/>
					<s:select id="select_TipoCausa"
							  headerKey="0"
							  headerValue="Selecione"
							  list="tiposCausas"
							  listKey="codigoCausa"
							  listValue="causa"
							  disabled="true"
							  value="%{processo.causa.codigoCausa}"/>
				</div>
				<div class="grid-6-12">
					<s:label value="Selecione um Forum:" for="select_Forum"/>
					<s:select id="select_Forum"
							  headerKey="0"
							  headerValue="Selecione"
							  list="foruns"
							  listKey="codigoPessoa"
							  listValue="nomePessoa"
							  disabled="true"
							  value="%{processo.forum.codigoPessoa}"/>
				</div>
				<div class="box box-prazo">
					<div class="grid-12-12">
						<h3>Prazos</h3>
						<div class="grid-6-12">
							<s:label value="Data de Abertura:" for="textfield_DataAbertura"/>
							<s:textfield id="textfield_DataAbertura" maxlength="10" disabled="true" value="%{processo.dataAberturaStr}"/>
						</div>
						<div class="grid-6-12">
							<s:label value="Data de Fechamento:" for="textfield_DataFechamento"/>
							<s:textfield id="textfield_DataFechamento" maxlength="10" disabled="true" value="%{processo.dataFechamentoStr}"/>
						</div>
						<div class="grid-6-12">
							<s:label value="Selecione um Tipo de Cobrança:" for="select_TipoCobranca"/>
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
							<s:label value="Selecione Dia de Vencimento:" for="select_DiaVencimento"/>
							<s:select id="select_DiaVencimento"
							  		  headerKey="0"
							  		  headerValue="Selecione"
							  		  list="dias"
							  		  disabled="true"
							  		  value="%{processo.diaVencimento}"/>
						</div>
					</div>
				</div>	
				<div class="box box-causa">
					<div class="grid-12-12">
						<h3>Resultado da causa</h3>
						<div class="grid-12-12">
							<s:radio id="radio_ResultadoCausa" list="#{'2':'Ganha','1':'Perdida'}" value="%{processo.resultado}" disabled="true"/>
						</div>	
					</div>
				</div>
				<div class="grid-12-12">
					<s:label value="Observação:" for="textarea_Observacao"/>
					<s:textarea id="textarea_Observacao" disabled="true" value="%{processo.observacao}"/>
				</div>
				
			</div>
			<div class="box box-advogado">
				<div class="grid-12-12">
					<table class="lawyer-table">
						<h3>Advogados Vinculados ao Processo</h3>
						<thead>
							<tr>
								<th align="center" width="50%" class="par"> Nome</th>
								<th align="center" width="30%" class="par"> Data Inclusão</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator id="iterator_AdvogadosVinculados" value="advogadosVinculados">
								<tr>
									<td align="left" width="50%" class="par">
										<s:property value="advogado.nomePessoa"/>
									</td>
									<td align="left" width="30%" class="par">
										<s:property value="dataInicioStr"/>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		</div>	
	</s:form>
</body>
</html>
