<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Registro de Pagamentos</title>
</head>
<body>
	<s:form id="form_RegistrarPagamento" cssClass="formee" action="realizarPagamento" method="post" theme="simple">
		<jsp:include page="../../util/includes/menu.jsp" />
		<div class="content">
			<h2>Registro de Pagamento por Processo</h2>
			<div class="grid-6-12">
				<s:label value="Número do processo:" for="textfield_Codigo" />
				<s:textfield cssClass="formee-medium" id="textfield_Codigo" name="titulo.processo.numeroProcesso" />
				<s:submit cssClass="formee-button left" id="submit_Pesquisar" value="Pesquisar" action="pesquisarTitulosProcesso"/>
			</div>
			<s:if test="%{!processos.isEmpty()}">
				<div class="grid-12-12">
					<table id="table_Processos" class="lawyer-table">
						<h3>Processo Filtrado</h3>
						<thead>
							<tr>
								<th width="15%" class="par">Número do Processo</th>
								<th width="25%" class="par">Processo</th>
								<th width="15%" class="par">Tipo de Cobrança</th>
								<th width="15%" class="par">Tax. Júros Atraso</th>
								<th width="15%" class="par">Dia de Vencimento</th>
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
									<td class="par">
										<s:property value="cobranca.periodoCobranca"/>
									</td>
									<td class="par">
										<s:property value="cobranca.taxaJuros"/>
									</td>
									<td class="par">
										<s:property value="diaVencimento"/>
									</td>
								</tr>			
							</s:iterator>
						</tbody>
					</table>
				</div>
				<div class="grid-12-12">
					<table id="table_Tituloss" class="lawyer-table">
						<h3>Títulos a Pagar do Processo</h3>
						<thead>
							<tr>
								<th width="15%" class="par">Número do Título</th>
								<th width="15%" class="par">Número da Agência</th>
								<th width="15%" class="par">Data do Documento</th>
								<th width="15%" class="par">Data do Vencimento</th>
								<th width="15%" class="par">Valor do Documento(R$)</th>
								<th width="2%"></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator id="iterator_Titulos" value="titulos">
								<tr>
									<td class="par">
										<s:property value="numeroTitulo"/>
									</td>
									<td class="par">
										<s:property value="agenciaCedente"/> 
									</td>
									<td class="par">
										<s:date name="dataDocumento" format="dd/MM/yyyy"/>
									</td>
									<td class="par">
										<s:date name="dataVencimento" format="dd/MM/yyyy"/>
									</td>
									<td class="par">
										<s:property value="valorDocumento"/>
									</td>
									<td>
										<s:url var="url_PagarTitulo" value="realizarPagamento">
											<s:param name="titulo.numeroTitulo" value="numeroTitulo"/>
										</s:url>
			
										<s:a href="%{url_PagarTitulo}">
											<img src="../css/img/formee/form-ic-success.png" alt="Efeturar Pagamento do Título" title="Efeturar Pagamento do Título"/>
										</s:a>
									 </td>
								</tr>			
							</s:iterator>
						</tbody>
					</table>
				</div>
				<div class="grid-12-12">
					<table id="table_TitulosPagos" class="lawyer-table">
						<h3>Títulos Pagos do Processo</h3>
						<thead>
							<tr>
								<th width="15%" class="par">Número Título</th>
								<th width="15%" class="par">Data Pagamento</th>
								<th width="15%;" class="par">Valor Pago</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator id="iterator_Titulos" value="titulosPagos">
								<tr>
									<td class="par">
										<s:property value="titulo.numeroTitulo"/>
									</td>
									<td class="par">
										<s:date name="dataPagamento" format="dd/MM/yyyy"/>
									</td>
									<td class="par">
										<s:property value="valorPago"/>
									</td>
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