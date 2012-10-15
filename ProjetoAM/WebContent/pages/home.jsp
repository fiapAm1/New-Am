<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjc" uri="/struts-jquery-chart-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<sj:head/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>HOME - ADVOCACIA</title>
</head>
<body>
	<s:form id="form_Home" method="get" action="carregarHome" theme="simple" >
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
					<a class="score-causas-item causa-tributaria" href="#" title="Tributária">
						<span class="score-number">319</span>
						<span class="score-label">Tributária</span>
					</a>
					<a class="score-causas-item causa-trabalhista" href="#" title="Trabalhista">
						<span class="score-number">435</span>
						<span class="score-label">Trabalhista</span>
					</a>
					<a class="score-causas-item causa-comercial" href="#" title="Comercial">
						<span class="score-number">218</span>
						<span class="score-label">Comercial</span>
					</a>
				</div>
			</div>
		</div>
    </s:form>
</body>
</html>