<%@page import="com.study.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	mem_id = <%=request.getParameter("mem_id") %> <br>
	el mem_id = ${param.mem_id} <br>

	${1000 + "4"} <br>
	${20 / 4} <br>
	${20 % 3 } <br>
	${20 mod 3 } <br>
	
	${4 > 3} <br>
	
	${4 > 3 and 1 eq 1 } <br>
	
	${empty abc} <br>
	${empty param.mem_id} <br>
	
	${ 4 > 5 ? '4가크네요' : '4가 작네요' } <br>
	
	<%
		Member member = new Member("hong","길동아빠","1234","010-1234-5678","hong@naver.com",1004); 
		Member member2 = new Member("nolja","놀자","1234","010-1234-5678","nolja@naver.com",0); 
		
		request.setAttribute("member", member); // 키 / 값
		session.setAttribute("member", member2); 
		
		
		// requst 저장영역과 session 저장영역이 다르기때문에 각기 불러와야함
	%>
	${member.mem_id } = ${member.mem_id } <br>
	${requstScope.member_mem_id } = ${requstScope.member_mem_id } <br> 
	${sessionScope.member_id } = ${sessionScope.member_id } <br> 
	
	${member.mem_name }의 마일리지는 ${member.mem_mileage } 입니다. <br>
	${member.mem_name += "의 마일리지는 " += member.mem_mileage += " 입니다." } <br>
	
	${arr = [1,2,3,4,5]; ""} <br>
	${arr[2]} = ${arr[2] } <br>
	<hr>
	${var1 = 1004; var2 = 100; ""} <br>
	값은 = ${var1 + var2} <br>
	<%=member.getMem_name() %> <br>
	<%=member2.getMem_name() %> <br>
	<hr>
	${arr1 = ["길동아빠", "소향엄마", "놀자"]; ''} <br> <!-- 리스트형식 -->
	${arr2 = {"name" : "홍길동", "age" : 20}; ''} <br> <!-- 맵형식 -->
	
	\${arr1[2]} = ${arr1[2]} <br>
	\${arr2['name'] } = ${arr2.name} <br>
	
  </body>
</html>