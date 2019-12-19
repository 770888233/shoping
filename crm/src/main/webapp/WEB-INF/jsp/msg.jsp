<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全局页面</title>
</head>
<body>
	${message}
	<br />
	<br />
	<a href="${ pageContext.request.contextPath }/index">首页</a>&nbsp;&nbsp;
	<a href="${ pageContext.request.contextPath }/regist">注册</a>
	&nbsp;&nbsp;
	<a href="${ pageContext.request.contextPath }/login">登录</a>&nbsp;&nbsp;
</body>
</html>