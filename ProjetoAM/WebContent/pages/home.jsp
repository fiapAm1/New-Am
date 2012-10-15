<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjc" uri="/struts-jquery-chart-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script>
	jQuery.noConflict();
	jQuery(document).ready(function(){
		jQuery.getJSON('carregarHome', function(json) {
			jQuery("#span_CausaTributaria").html(json.contagemProcessoGanho);
			jQuery("#span_CausaTrabalhista").html(json.contagemTrabalhista);
			jQuery("#span_CausaComercial").html(json.contagemComercial);	 
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>HOME - ADVOCACIA AZEVEDO</title>
</head>
<body>
	<s:form id="form_Home" method="post" action="carregarHome" theme="simple">
		<jsp:include page="../util/includes/menu.jsp" flush="true"/>
		<div class="content">
			<div class="dashboard-section dashboard-section-processos">
				<h3>Andamento de processos</h3>
			    <sjc:chart
			        id="chartPie"
			        cssStyle="width: 100%; min-height: 400px;"
			        pie="true"
			        pieLabel="true"
			        legendShow="false"
			    >
			        <sjc:chartData
			                id="processos_andamento"
			                label="Processos em andamento"
			                data="10"
			                color="#1EB1DE"
			        />
			        <sjc:chartData
			                id="processos_ganho"
			                label="Processos ganhos"
			                color="#64C601"
			                data="3"
			        />
			        <sjc:chartData
			                id="processos_perdido"
			                label="Processos perdidos"
			                data="17"
			                color="#F7352D"
			        />
			    </sjc:chart>
			</div>
			<div class="dashboard-section dashboard-section-causa">
				<h3>Resumo de causas</h3>
				<div class="score-causas">
					<a class="score-causas-item causa-tributaria" href="listarProcesso?codigoCausa=1" title="Tributária">
						<span id="span_CausaTributaria" class="score-number"><s:property value="contagemTributaria"/></span>
						<span class="score-label">Tributária</span>
					</a>
					<a class="score-causas-item causa-trabalhista" href="listarProcesso?codigoCausa=2" title="Trabalhista">
						<span id="span_CausaTrabalhista" class="score-number"><s:property value="contagemTrabalhista"/></span>
						<span class="score-label">Trabalhista</span>
					</a>
					<a class="score-causas-item causa-comercial" href="listarProcesso?codigoCausa=3" title="Comercial">
						<span id="span_CausaComercial" class="score-number"><s:property value="contagemComercial"/></span>
						<span class="score-label">Comercial</span>
					</a>
				</div>
			</div>
		</div>
    </s:form>
</body>
</html>