<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Summary Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Summaries
</h1>

<c:url var="addAction" value="/summary/add" ></c:url>

<form:form action="${addAction}" commandName="summary">
<table>
	<c:if test="${!empty summary.summary}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="summary">
				<spring:message text="Summary"/>
			</form:label>
		</td>
		<td>
			<form:input path="summary" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="originalText">
				<spring:message text="Search Text"/>
			</form:label>
		</td>
		<td>
			<form:input path="originalText" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="userIdentity">
				<spring:message text="User Identity"/>
			</form:label>
		</td>
		<td>
			<form:input path="userIdentity" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty summary.summary}">
				<input type="submit"
					value="<spring:message text="Edit Summary"/>" />
			</c:if>
			<c:if test="${empty summary.summary}">
				<input type="submit"
					value="<spring:message text="Add Summary"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Summaries List</h3>
<c:if test="${!empty listSummaries}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Summary </th>
		<th width="120">Search Text</th>
		<th width="120">User Identity</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listPersons}" var="person">
		<tr>
			<td>${summary.id}</td>
			<td>${summary.summary}</td>
			<td>${summary.originalText}</td>
			<td>${summary.userIdentity}</td>
			<td><a href="<c:url value='/edit/${summary.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${summary.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
