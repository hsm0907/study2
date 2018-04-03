<%@page import="com.study.member.vo.Member"%>
<%@page import="com.study.util.FileUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
   	<c:set var="msg" value="Hello 오늘은 금요일 ~~"></c:set>
   	
   	
   	${fn:length(msg)} <br>
   	${fn:toUpperCase(msg) } <br>
   	${fn:contains(msg,"금요일") } <br>
   	${fn:replace(msg, "hoho","굿굿") } <br>
   	
   	<c:forEach items="${fn:split(msg, ' ') }" varStatus="st">
   	
   	${st.count }, ${st.current} <br>
   	
   	</c:forEach>
   	
   	<c:set var="member" value='<%=new Member("hong", "길동", "1234", "010-1234-5678", "hong@naver.com", 0) %>'></c:set>
   	
   	id = ${member.mem_id } <br>
   	id = ${member.getMem_id() }
   	
   	${member.setMem_id("Nolja") } <br>
   	id = ${member.mem_id } <br>
   	
   	${FileUtil.fancySize(15245558) } <br>
   	
   	${greaterThen = (a,b) -> a > b ? true : false; '' } 
   	
   	${greaterThen(3,2) } <br>
   	
   	${factorial = (n) -> n == 1 ? 1 : n * factorial(n-1); '' } <br> <!-- 5 * 4 * 3 * 2 * 1 이런식으로 자기 호출해서 사용 --> 
   	
   	${factorial(5) } <br>
   	
   	 ${fancy = (size)-> size < 1024 ? size += "bytes" : 
   	 	( size < 10485760 ? size / 1024.0 += "Kb" : size / 10485760.0 += "Mb" ); ''}
   	
   	<hr>
   	${fancy(1234567231) } <br>
   	
   	<!-- 문제 : 람다식을 한번 만드시오 -->
   	
   	<%-- <c:set var="dan" value="7" />
   	<ul>
   		<c:forEach begin="1" end="9" var="i">
   			<li>${gugu = (n) -> (dan * i) ; ''}
   			${dan += "x" += i += " = " += gugu(dan) }</li>
   		</c:forEach>
   	</ul> --%>
   	
   	<c:set var="dan" value="7" />
   			${gugu=(a,b) -> a += ' * ' += b += ' = ' += a*b ; '' }
   	<ul>
   		<c:forEach begin="1" end="9" var="i">
   			<li>${gugu(dan,i) }</li> 
   		</c:forEach>
   	</ul>
   		
  </body>
</html>