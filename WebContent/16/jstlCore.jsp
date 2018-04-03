<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.study.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <!-- jstl var로 시작하는 속성에는 el 표기법을 사용하면 안된다. -->
    <c:set var="msg" value="1000" />
    ${msg } <br>
    <c:set var="msg2" value="${msg + 4 }" />
    ${msg2 } <br>
	
	
	<c:set var="member" value="<%=new Member()%>" />
	<c:set target="${member}" property="mem_name" value="배고파요~~" />
	<c:set target="${member}" property="mem_id" value="gilDong" />
	${member.mem_name} <br>
	${member.mem_phone = "042-719-8850"; "" }
	${member.mem_phone } <br>
	<hr>
	<c:remove var="member"/>
	
	1: ${member.mem_name } <br>
	2: ${member.mem_phone } <br>
	
	<!-- if문 형식 -->
	<c:set var="jumsu" value="89" />
	
	<c:if test="${jumsu > 90 && jumsu <= 100 }">잘했다 이좌식아 <br></c:if>
	<c:if test="${jumsu > 80 and jumsu le 90 }">잘좀하지 이좌식아 <br></c:if>
	<c:if test="${jumsu > 70 and jumsu <= 80}">쯧쯧 이좌식아 <br></c:if>
	<c:if test="${jumsu < 70 }">나가 죽어 이좌식아 <br></c:if>
	
	<hr>
	<!-- swich문 형식 -->
	<c:choose>
		<c:when test="${jumsu > 90 && jumsu <= 100 }">
		잘했다 이좌식아 ${jumsu} <br>
		</c:when>
		
		<c:when test="${jumsu gt 80}">
		쫌 잘했다 이좌식아
		</c:when>
		
		<c:when test="${jumsu > 70 }">
		잘좀하지 이좌식아
		</c:when>
		
		<c:when test="${jumst < 70 }">
		나가 죽어 이좌식아
		</c:when>
		
		<c:otherwise>
			점수가 잘못되었다
		</c:otherwise>
	</c:choose>
	
	<hr>
	<!-- for문 방식 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		${i} 배고파요 ~~~  <br>
	</c:forEach>
	
	<hr>
	
	<c:set var="sum" value="0" />
	<c:set var="sum1" value="0" />
	
	<c:forEach var="i" begin="1" end="100" step="1">
		<c:set var="sum" value="${sum += i } <br>" />
		<c:set var="sum1" value="${sum1 + i }" />
	</c:forEach>
	1부터 100까지의 합은 ${sum }
	<hr>
	1부터 100까지의 합은 ${sum1 }
	<hr>
	
	<%
		List<Member> list = new ArrayList();
			list.add(new Member("hong", "홍길동", "1234", "010-1234-5678", "hong@naver.com", 0));
			list.add(new Member("nolja", "야놀자", "1234", "010-1234-5679", "nolja@naver.com", 0));
			list.add(new Member("sunja", "김순자", "1234", "010-1234-5670", "sunja@naver.com", 0));
		
			request.setAttribute("members", list);
	
	%>
	<ul>
		<c:forEach var="user" items="${members}"  >
			<li>${user.mem_id } = ${user.mem_name } </li>
		</c:forEach>
	</ul>
	
	<hr style="border-color: red; border-bottom-style: solid;">
	
	<ul>
		<c:forEach var="user" items="${members}" varStatus="st"> <!-- 인덱스 1번부터 불러오기 -->
			<c:if test="${st.first }"><hr style="border-color: red; border-bottom-style: solid;"></c:if>
			<li>${st.count}, ${st.index}, ${st.first}, ${st.current.mem_id}, ${user.mem_id} </li>
			<c:if test="${st.last}"><hr style="border-color: green; border-bottom-style: solid;"></c:if>
		</c:forEach>
	</ul>
	
	
	

  </body>
</html>