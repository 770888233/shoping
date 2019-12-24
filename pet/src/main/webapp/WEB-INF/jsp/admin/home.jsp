<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
		body
		{
			SCROLLBAR-ARROW-COLOR: #ffffff;  SCROLLBAR-BASE-COLOR: #dee3f7;
		}
    </style>
  </head>
  
<frameset rows="103,*,43" frameborder=1 border="1" framespacing="1">
  <frame src="${pageContext.request.contextPath}/jsp/top.jsp" name="topFrame" scrolling="NO" noresize>
	  <frameset cols="159,*">
			<frame src="${pageContext.request.contextPath}/jsp/left.jsp" name="leftFrame" noresize scrolling="YES">
			<frame src="${pageContext.request.contextPath}/jsp/right.jsp" name="mainFrame">
	  </frameset>
</frameset>
</html>
