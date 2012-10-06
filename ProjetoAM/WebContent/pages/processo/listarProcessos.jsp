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
<title>Listar Processos</title>
</head>
<body>
	<s:form id="form_ListarProcessos"
			cssClass="formee"
			action="listarProcesso"
			method="post"
			theme="simple">
		<fieldset>
			<legend>Pesquisa de Processo</legend>
			<div class="grid-12-12">
				<fieldset>
					<div class="grid-4-12">
						<s:label value="N�mero do processo:" for="textfield_num_processo"/>
						<s:textfield id="textfield_num_processo" name="processo.numeroProcesso"/>
					</div>
				</fieldset>
				<fieldset>	
					<div class="grid-4-12">
						<s:label value="Selecione um Tipo de Causa:"
								 for="select_TipoCausa"/>
						<s:select id="select_TipoCausa"
								  headerKey="0"
								  headerValue="Selecione"
								  list="tiposCausas"
								  listKey="codigoCausa"
								  listValue="causa"
								  name="processo.causa.codigoCausa"/>
					</div>
					<div class="grid-4-12">
						<s:label value="Cliente:"
						 		 for="textfield_cliente"/>
						 <s:textfield id="textfield_cliente"											 
									 name="advogadoProcesso.advogado.nomePessoa"/>
					</div>
				</fieldset>
			</div>
			<div class="grid-12-12" style="text-align: right;">
				<s:submit id="submit_Pesquisar"
						  value="Pesquisar"
						  action="listarProcesso"/>
			</div>
			<div class="grid-12-12">
				<hr />
			</div>		
			<div class="grid-12-12">
				<table id="table_Processos" 
					   class="lawyer-table"
					   style="margin-left: 10px !important;">
					<caption><strong>Processos Filtrados</strong></caption>
					<thead>				
						<tr>
							<th width="10%" class="par"><strong>Processo</strong></th>
							<th width="15%" class="par"><strong>Cliente</strong></th>
							<th width="10%" class="par"><strong>Tipo de Causa</strong></th>
							<th width="10%" class="par"><strong>Abertura</strong></th>
							<th width="10%" class="par"><strong>Fechamento</strong></th>
							<th width="5%" class="par"><strong>Resultado</strong></th>
							<th width="1%" class="impar"></th>
							<th width="1%" class="impar"></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator id="iterator_Processos"
									value="processos">
							<tr>
								<td class="par"><s:property value="processo" /></td>
								<td class="par"><s:property value="cliente.nomePessoa"/></td>
								<td class="par"><s:property value="causa.causa"/></td>
								<td class="par"><s:property value="dataAbertura"/></td>
								<td class="par"><s:property value="dataFechamento"/></td>
								<td class="par"><s:property value="resultado"/></td>
								<td align="center" 
									class="impar">
									<s:url id="url_ExibirProcesso"
										   action="exibirProcesso">
										<s:param name="processo.numeroProcesso" 
												 value="numeroProcesso"/>
									</s:url>
									<s:a href="%{url_ExibirProcesso}">
										<img src="../img/form-ic-info.png" 
							 				 alt="Exibir este processo" 
							 				 title="Exibir este processo"/>
									</s:a>
								</td>
								<td align="center" 
									class="impar">
									<s:url id="url_AtualizarProcesso"
										   action="forwardCadastrarProcesso">
										<s:param name="processo.numeroProcesso" 
												 value="numeroProcesso"/>
										<s:param name="paginaDirecionar">alterar</s:param>
									</s:url>
									<s:a href="%{url_AtualizarProcesso}">
										<img src="../img/form-ic-success.png" 
							 				 alt="Atualizar este processo" 
							 				 title="Atualizar este processo"/>
									</s:a>
								</td>
							</tr>
						</s:iterator>
					</tbody>	
				</table>
			</div>	
		</fieldset>		
	</s:form>
</body>
</html>