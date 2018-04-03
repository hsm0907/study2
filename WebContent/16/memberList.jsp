<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>타이틀을 입력하세요!!</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
  </head>  
<body>
<div class="container">
<div class="page-header">
	<h2>회원 목록</h2>
</div>
<div class="row">
	<div class="col-md-4 col-md-offset-8  text-right">
		<a href="memberForm.do" class="btn btn-sm btn-primary">회원등록</a>	
	</div>
</div>

<div class="row">

<table class="table table-striped">
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
	</thead>
	<tbody>
	
		<c:if test="${list.isEmpty()}"> <!-- 비어있는지 확인여부 empty list 와 같 -->
			<tr>
				<td colspan="5">목록이 조회되지 않았습니다.</td>
			</tr>
		</c:if>
		
		<c:forEach var="member" items="${members }" varStatus="st">
			<tr>
				<td>${st.count} ${member.mem_id}</td>
				<td><a href="memberView.do?mem_id=${member.mem_id }">${member.mem_name}</a></td>
				<td>${member.mem_phone}</td>
				<td>${member.mem_email}</td>
				<td>${member.reg_date}</td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>
</div>
</div>
</body>
</html>
