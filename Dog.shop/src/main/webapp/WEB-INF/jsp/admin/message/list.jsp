<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
</head>
<body>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<tr>
			<td align="center" bgColor="#afd1f3"><strong>留言列表</strong></td>
		</tr>
		 
		<tr>
			<td align="center" bgColor="#f5fafe">
				<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 11pt; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="10%">序号</td>
								<td align="center" width="15%">用户昵称</td>
								<td align="center" width="45%">留言</td>
								<td align="center" width="15%">留言日期</td>
								<td align="center" width="15%">删除</td>
							</tr> 
						<c:forEach items="${pageBean.list}" var="message"> 
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										 >${message.messageid}</td>

									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										 >${message.user.username}
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" ><strong><font color="red">${message.message}
										</font>
									</strong></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" >${message.messagedate}</td>
									 <td align="center" style="HEIGHT: 22px"  >
										 <a href="${ pageContext.request.contextPath }/admin/adminMessage_delete?messageid=${message.messageid}">
											 <img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
										 </a>
									</td>
								</tr>
						 </c:forEach>
				</table>
			</td>
		</tr>
		<tr align="center">
			<td >第 ${pageBean.page }/${pageBean.totlePage}页 <c:if test="${pageBean.page!= 1}">
					<a
						href="${pageContext.request.contextPath }/admin/adminMessage_findAllByPage?page=1">首页</a>|
			     	<a
						href="${pageContext.request.contextPath }/admin/adminMessage_findAllByPage?page=${pageBean.page-1}">上一页</a>
				</c:if>
				 <c:forEach begin="1" end="${pageBean.totlePage}" var="i">
					<c:choose>
						<c:when test="${pageBean.page!=i}">
							<a href="${ pageContext.request.contextPath }/admin/adminMessage_findAllByPage?page=${i}">${i}</a>
						</c:when>
						<c:otherwise>
							<span class="currentPage">${i}</span>
						</c:otherwise>
					</c:choose>
				</c:forEach> 
				<c:if test="${pageBean.page!=pageBean.totlePage}">
					<a
						href="${pageContext.request.contextPath }/admin/adminMessage_findAllByPage?page=${pageBean.page+1}">下一页</a> |
							<a
						href="${pageContext.request.contextPath }/admin/adminMessage_findAllByPage?page=${pageBean.totlePage}">尾页</a>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</HTML>

