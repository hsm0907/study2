<%@page import="com.study.member.vo.Member"%>
<%@page import="com.study.member.service.MemberServiceImpl"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="oracle.jdbc.driver.OracleDriver"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<fmt:setLocale value="en"/>
<fmt:setBundle basename=""/>
<fmt:bundle basename="resource.message">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><fmt:message key="MEMBER.TITLE" /></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
  </head>  
<body>
<div class="container">
<div class="page-header">
	<h2><fmt:message key="MEMBER.TITLE" /></h2>
</div>
<div class="row">
<%
 String mem_id = request.getParameter("mem_id");
 MemberServiceImpl  memberService = new MemberServiceImpl();
 Member member = memberService.getMember(mem_id);
 request.setAttribute("member", member);
%>
<table class="table">
	<tbody>
		<c:if test="${member != null }">
			<tr>
			<th><fmt:message key="MEMBER.ID" /></th>
			<fmt:message key="MEMBER.MESSAGE" var="msg">
				<fmt:param value="${member.mem_name }" />
				<fmt:param value="${member.mem_mileage }" />
			</fmt:message>
			<td title="${msg}">${member.mem_id}</td>
		</tr>		
		<tr>
			<th><fmt:message key="MEMBER.NAME" /></th>
			<td>${member.mem_name }</td>
		</tr>
		<tr>
			<th><fmt:message key="MEMBER.PHONE" /></th>
			<td>${member.mem_phone }</td>
		</tr>
		<tr>
			<th><fmt:message key="MEMBER.EMAIL" /></th>
			<td>${member.mem_email }</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>${member.reg_date }</td>
		</tr>
		</c:if>
		
		<c:if test="${member == null }">
			<tr>
			<td><fmt:message key="MEMBER.NOTFOUND" /></td>
		</tr>
		</c:if>

	</tbody>
</table>
</div>

<div class="row">
	<div class="col-md-6">
		<a href="memberList.jsp" class="btn btn-sm btn-warning"><fmt:message key="MEMBER.LIST" /></a>
	</div>
	<div class="col-md-6 text-right">
		<a href="memberEdit.jsp?mem_id=<%=mem_id%>" class="btn btn-sm btn-primary">수정</a>	
	</div>
</div>
</div>
</body>
</fmt:bundle>
</html>

