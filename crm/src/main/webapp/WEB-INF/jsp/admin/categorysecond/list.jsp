<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
		function addCategorySecond(){
			window.location.href = "${pageContext.request.contextPath}/admin/adminCategorySecond_addPage";
		}
		function edit(csid) {
			window.location.href = "${pageContext.request.contextPath}/admin/adminCategorySecond_edit?csid="+csid;
		}
		function deletecs(csid) {
			window.location.href ="${pageContext.request.contextPath}/admin/adminCategorySecond_delete?csid="+csid;
		}
		</script>
</head>
<body>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<tr>
			<td align="center" bgColor="#afd1f3"><strong>二级分类 列表</strong></td>
		</tr>
		<tr>
			<td align="right">
				<button type="button" onclick="addCategorySecond()">添加</button>
			</td>
		</tr>
		<tr>
			<td align="center" bgColor="#f5fafe">
				<table cellspacing="0" cellpadding="0" rules="all" border="1"
					style="WIDTH: 100%;">
					<tr
						style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
						<td align="center" width="18%">序号</td>

						<td align="center" width="17%">二级分类名称</td>
						<td width="7%" align="center">编辑</td>
						<td width="7%" align="center">删除</td>
					</tr>
					<c:forEach items="${csPageBean.list}" var="cs" varStatus="status">
						<tr onmouseover="this.style.backgroundColor = 'white'"
							onmouseout="this.style.backgroundColor = '#F5FAFE';">
							<td align="center">${status.count}</td>
							<td align="center">${cs.csname}</td>
							<td align="center">
								<button type="button" onclick="edit(${cs.csid})">编辑</button>
							</td>
							<td align="center">
								<button type="button" onclick="deletecs(${cs.csid})">删除</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	<%-- 	<tr align="center">
			<td colspan="4">第 ${csPageBean.page }/${csPageBean.totlePage}页 <c:if
					test="${csPageBean.page!= 1}">
					<a
						href="${pageContext.request.contextPath }/admin/adminCategorySecond_findAllByPage?page=1">首页</a>|
			     	<a
						href="${pageContext.request.contextPath }/admin/adminCategorySecond_findAllByPage?page=${csPageBean.page-1}">上一页</a>
				</c:if>
				 <c:forEach begin="1" end="${csPageBean.totlePage}" var="i">
					<c:choose>
						<c:when test="${csPageBean.page!=i}">
							<a
								href="${ pageContext.request.contextPath }/admin/adminCategorySecond_findAllByPage?page=${i}">${i}</a>
						</c:when>
						<c:otherwise>
							<span class="currentPage">${i}</span>
						</c:otherwise>
					</c:choose>
				</c:forEach> 
				<c:if test="${csPageBean.page!=csPageBean.totlePage}">
					<a
						href="${pageContext.request.contextPath }/admin/adminCategorySecond_findAllByPage?page=${csPageBean.page+1}">下一页</a> |
							<a
						href="${pageContext.request.contextPath }/admin/adminCategorySecond_findAllByPage?page=${csPageBean.totlePage}">尾页</a>
				</c:if>
			</td>
		</tr> --%>
	</table>
</body>
</HTML>

