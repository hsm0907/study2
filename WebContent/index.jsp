<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStreamReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>/ index.jsp </title>
</head>
<body>
<table>
	<colgroup>
		<col width="20%;" />
		<col  />
	</colgroup>
	<tr>
		<td colspan="2">
		  <!-- 메뉴영역 START    -->  	
		  <jsp:include page="/include/top.jsp" flush="false" />
		  <!-- 메뉴영역 END -->
		</td>
	</tr>
	<tr>
		<td>
			<!-- 좌측메뉴 START  -->
			<jsp:include page="/include/left.jsp" flush="false" />
			<!-- 좌측메뉴 END  -->
		</td>
		<td>
			<!-- 본문 START  -->		
			A-Ra 사이트입니다.	
			<!-- 본문 END  -->
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<!-- 푸터 START  -->		
			<jsp:include page="/include/footer.jsp" flush="false" />	
			<!-- 푸터 END  -->
		</td>
	</tr>	

</table>




</body>
</html>

