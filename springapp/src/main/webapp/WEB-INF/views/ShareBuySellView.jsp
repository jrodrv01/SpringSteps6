<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="SpringApp" /></title>
</head>
<body>
	<h1>
		<fmt:message key="Welcome to Share Fees Changer" />
	</h1>
	<p>
		<fmt:message key="Remember, good customers deserve good fees" />
		<c:out value="${model.now}" />
	</p>
	<h3>Fees applies on Client's Investment Account</h3>
	<c:forEach items="${model.feeArray}" var="bfee">
		<c:out value="${bfee.description}" />
		<c:out value="${bfee.fee}" />
		<c:out value="${bfee.idAccount}" />
		<br>
	</c:forEach>
	<br>
	<a href="<c:url value="changefee.htm"/>">Decrease Fees</a>
	<br>
</body>
</html>