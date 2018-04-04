<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h2>게시판 등록</h2>
</div>

<form action="boardInsert.do" method="post">
<div class="row">

<table class="table">
	<tbody>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="bo_title" value="" >
			</td>
		</tr>	
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" name="bo_writer" value="" >
			</td>
		</tr>			
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="bo_passwd" value="" >
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="bo_email" value="" >
			</td>
		</tr>	
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="10" cols="60" name="bo_content"></textarea>
			</td>
		</tr>
	</tbody>
</table>
</div>

<div class="row">
	<div class="col-md-6 col-xs-4">
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














