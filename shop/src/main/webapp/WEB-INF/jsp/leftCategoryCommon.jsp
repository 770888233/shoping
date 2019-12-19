<%@ page language="java" pageEncoding="UTF-8" %>
<% 
String path=request.getContextPath(); 
String basePath=request.getScheme()
    + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<div class="categories">
    <ul>
        <h3>
            分类
        </h3>
        
        <c:forEach var="c" items="${cList}">
		<li><a href="${pageContext.request.contextPath}/findCategorySecond?cid=${c.cid}&page=1">${c.cname}</a></li>
		</c:forEach>
         
    </ul>
</div>