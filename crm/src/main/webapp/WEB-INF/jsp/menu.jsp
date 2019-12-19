<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
			<c:choose>
				<c:when test="${loginUser==null}">
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/login">登录</a>|
					</li>
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/regist">注册</a>|</li>
						<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/messageList?page=1" style="color: red;">留言板</a>
				   |</li>
				</c:when>
				<c:otherwise>
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						${loginUser.username}
					</li>
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/myOrder?page=1" style="color: red;">我的订单</a>
				   |</li>
				   <li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/messageList?page=1" style="color: red;">留言板</a>
				   |</li>
				    <div class="cart">
						<a href="${pageContext.request.contextPath}/myCart">购物车</a>
					</div>
					<li id="headerLogout" class="headerLogout" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/userLogout">退出</a>|</li>
				</c:otherwise>
			</c:choose>
			
			<li><a href="${pageContext.request.contextPath}/admin">后台登录</a></li>
		</ul>
	</div>
	
	<div class="phone">
		<form method="post" action="${pageContext.request.contextPath}/searchProduct" >
                <input id="condition" name="condition" type="text" value="请输入关键词" onfocus="this.value = '';"
                onblur="if (this.value == '') {this.value = '请输入关键词';}">
                <input id="searchSub" type="submit" value="搜">
        </form>
	</div>
</div>
<div class="span24">
	<ul class="mainNav">
		<li><a href="${pageContext.request.contextPath}/index">首页</a> |</li>
		<c:forEach var="c" items="${cList}">
		<li><a href="${pageContext.request.contextPath}/findCategorySecond?cid=${c.cid}&page=1">${c.cname}</a> |</li>
		</c:forEach>
	</ul>
</div>
