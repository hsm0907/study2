<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    
    <title>타이틀을 입력하세요!!</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  </head>
  <body>
	<a href="<%=request.getContextPath()%>/15/memberList.jsp">회원목록</a> <br>
	<a href="${pageContext.request.contextPath}/15/memberList.jsp">회원목록</a> <br>
	<a href='<c:url value="/15/memberList.jsp" />' >회원목록</a> <br>
	
	<img alt="" src="/image/tomato.jpg" width="200px">
	
	<a href="/study/common/download.do?=id=234&path=board" class="btn btn-sm- btn-primary">
	<span class="glyphicon glyphicon-floppy-disk"> Down </span>
	</a>
	
	<c:url var="downUrl" value="/common/download.do">
		<c:param name="id" value="234" />
		<c:param name="path" value="board" />
	</c:url>
	
	<a href="${downUrl }" class="btn btn-sm- btn-primary">
		<span class="glyphicon glyphicon-floppy-disk"> Down </span>
	</a>
	
  </body>
</html>