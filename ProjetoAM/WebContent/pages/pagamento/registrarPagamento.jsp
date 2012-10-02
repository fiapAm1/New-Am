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
<title>Registro de Pagamentos</title>
</head>
<body>
	<s:form id="form_RegistrarPagamento" 
		  cssclass="formee"
		  action="registrarPagamento" 
		  method="post" 
		  theme="simple">
		<fieldset>
			<legend>Registro de Pagamento por Processo</legend>
			<div class="grid-8-12">
				<div class="grid-3-12">
					<s:label value="Código do processo:" for="textfield_Codigo" />
				</div>
				<div class="grid-4-12">
					<s:textfield id="textfield_Codigo" name="" />
				</div>
				<div class="grid-3-12">
				<s:submit id="submit_Pesquisar"
						  value="Pesquisar"
						  action=""/>
				</div>
			</div>
			<div class="grid-12-12 lawyer-table">
				<table id="table_Processos">
					<caption>Processos Filtados</caption>
					<thead>
						<tr>
							<th style="width: 1% ;"></th>
							<th style="width: 10%; text-align: left;">Código</th>
							<th style="width: 70% ;">Processo</th>
							<th style="text-align: left;">Data do Processo</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<input type="radio" />
							</td>
							<td>
								<span>1</span>
							</td>
							<td>
								<span>Processo 1</span>
							</td>
							<td>
								<span>11/05/2012</span>
							</td>
						</tr>
						<tr>
							<td>
								<input type="radio" />
							</td>
							<td>
								<span>2</span>
							</td>
							<td>
								<span>Processo 2</span>
							</td>
							<td>
								<span>12/05/2012</span>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="grid-4-12">
				<div class="grid-6-12">
					<label for="input_Vencimento">Vencimento do Pagamento:</label>
				</div>
				<div class="grid-6-12">
					<input id="input_Vencimento" type="text" />
				</div>
				<div class="grid-6-12">
					<label for="input_Vencimento">Valor do Documento:</label>
				</div>
				<div class="grid-6-12">
					<input id="input_Valor" type="text" />
				</div>
			</div>
			<div class="grid-4-12">
				<div class="grid-6-12">
					<label for="input_Taxa">Taxa de Administração:</label>
				</div>
				<div class="grid-6-12">
					<input id="input_Taxa" type="text" />
				</div>
				<div class="grid-6-12">
					<label for="input_Valor">Valor Pago:</label>
				</div>
				<div class="grid-6-12">
					<input id="input_Valor" type="text" />
				</div>
			</div>
			<div class="grid-12-12 lawyer-table">
				<table id="table_Processos">
					<caption>Pagamentos deste processo</caption>
					<thead>
						<tr>
							<th style="width: 1%;"></th>
							<th style="width: 5%;">Código</th>
							<th style="width: 20%;">Vencimento do Pagamento</th>
							<th style="width: 30%;">Valor do Documento</th>
							<th style="width: 30%;">Valor Pago</th>
							<th style="width: 13%;">Taxa de Administração</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<input type="radio" />
							</td>
							<td>
								<span>1</span>
							</td>
							<td>
								<span>11/06/2012</span>
							</td>
							<td>
								<span>R$ 10.000,00</span>
							</td>
							<td>
								<span>R$ 2.500,00</span>
							</td>
							<td>
								<span>6%</span>
							</td>
						</tr>
						<tr>
							<td>
								<input type="radio" />
							</td>
							<td>
								<span>2</span>
							</td>
							<td>
								<span>11/07/2012</span>
							</td>
							<td>
								<span>R$ 11.000,00</span>
							</td>
							<td>
								<span>R$ 1.500,00</span>
							</td>
							<td>
								<span>7%</span>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="grid-12-12">
				<hr></hr>
			</div>
			<div class="grid-12-12" style="text-align: right;">
				<input id="input_Registrar" 
					   type="button" 
					   value="Registrar" 
					   onclick="javascript: void(0);"/>
				<input id="input_Cancelar" 
					   type="button" 
					   value="Cancelar" 
					   onclick="javascript: void(0);"/>
				<input id="input_Voltar" 
					   type="button" 
					   value="Voltar" 
					   onclick="javascript: void(0);"/>
			</div>
		</fieldset>
	</s:form>
</body>
</html>