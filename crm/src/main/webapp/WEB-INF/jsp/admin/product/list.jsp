<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/admin/adminProduct_addPage";
			}
			function edit(pid) {
				window.location.href = "${pageContext.request.contextPath}/admin/adminProduct_edit?pid="+pid;
			}
			function deletecs(pid) {
				window.location.href = "${pageContext.request.contextPath}/admin/adminProduct_deletecs?pid="+pid;
			}
		</script>
</HEAD>
<body>
	<br>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center"
		bgColor="#f5fafe" border="0">
		<TBODY>
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
				</TD>
			</tr>
			<tr>
				<td align="right">
					<button type="button" onclick="addProduct()">添加</button>
				</td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe">
					<table cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

							<td align="center" width="18%">序号</td>
							<td align="center" width="17%">商品图片</td>
							<td align="center" width="17%">商品名称</td>
							<td align="center" width="17%">商品价格</td>
							<td align="center" width="17%">是否热门</td>
							<td width="7%" align="center">编辑</td>
							<td width="7%" align="center">删除</td>
						</tr>
						<c:forEach items="${allProPageBean.list }" var="p"
							varStatus="status">
							<tr onmouseover="this.style.backgroundColor = 'white'"
								onmouseout="this.style.backgroundColor = '#F5FAFE';">
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="18%">${status.count }</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%"><img width="40" height="45"
									src="${ pageContext.request.contextPath }/${p.image}"></td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">${p.pname }</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">${p.shopPrice}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%"><c:choose>
										<c:when test="${p.isHot==1 }">
														是
										</c:when>
										<c:otherwise>
														否
										</c:otherwise>
									</c:choose></td>
								<td align="center">
									<button type="button" onclick="edit(${p.pid})">编辑</button>
								</td>
								<td align="center">
									<button type="button" onclick="deletecs(${p.pid})">删除</button>
								</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
			<tr align="center">
				<td colspan="7">第 ${allProPageBean.page}/${allProPageBean.totlePage }页 
					<c:if test="${allProPageBean.page != 1 }">
						<a
							href="${pageContext.request.contextPath }/admin/adminProduct_findAllByPage?page=1">首页</a>|
			     	<a
							href="${pageContext.request.contextPath }/admin/adminProduct_findAllByPage?page=${allProPageBean.page-1}">上一页</a>
					</c:if> 
					<c:forEach begin="1" end="${allProPageBean.totlePage }" var="i">
						<c:choose>
							<c:when test=" ${allProPageBean.page!=i}">
								<a
									href="${ pageContext.request.contextPath }/admin/adminProduct_findAllByPage?page=${i}">${i}</a>
							</c:when>
							<c:otherwise>
								<span class="currentPage">${i}</span>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${allProPageBean.page!= allProPageBean.totlePage }">
						<a
							href="${pageContext.request.contextPath }/admin/adminProduct_findAllByPage?page=${allProPageBean.page+1}">下一页</a> |
							<a
							href="${pageContext.request.contextPath }/admin/adminProduct_findAllByPage?page=${allProPageBean.totlePage }">尾页</a>
					</c:if>
				</td>
			</tr>
		</TBODY>
	</table>
</body>
</HTML>

