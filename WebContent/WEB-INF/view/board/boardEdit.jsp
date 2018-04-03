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
	<h2>게시판 정보 수정</h2>
</div>

<form action="boardUpdate.do" method="post">
<div class="row">


<table class="table">
	<tbody>
	
		<c:if test="${!empty board}">
			<tr>
			<th>게시글번호</th>
			<td>
				${board.bo_no }
				<input type="hidden" name="bo_no" value="${board.bo_no}" >
			</td>
		</tr>		
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="bo_title" value="${board.bo_title}" >
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="bo_passwd" value="${board.bo_passwd}" >
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<input type="text" name="bo_content" value="${board.bo_content}" >
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" name="bo_writer" value="${board.bo_writer}" >
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="bo_email" value="${board.bo_email }">
			</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>
				${board.bo_reg_date }
			</td>
		</tr>
		
		</c:if>
		
		<c:if test="${empty board }">
			<tr>
			<td>해당 회원이 존재하지 않습니다.</td>
		</tr>
		</c:if>
		
	</tbody>
</table>
</div>

<div class="row">
	<div class="col-md-6 col-xs-3">
		<a href="boardList.do" class="btn btn-sm btn-warning">목록으로</a>
	</div>
	<div class="col-md-6 text-right">
		<button type="submit" class="btn btn-sm btn-primary">저장</button>
	</div>
</div>
</form>
</div>
</body>
</html>














