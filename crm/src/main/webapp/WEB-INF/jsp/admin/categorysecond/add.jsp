<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</HEAD>
	
	<body>
			<form action="${pageContext.request.contextPath}/admin/adminCategorySecond_save" method="post" >
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添加二级分类</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe">
						二级分类名称：
					</td>
					<td bgColor="#ffffff" >
						<input type="text" name="csname" value="" />
					</td>
					<td width="18%" align="center" bgColor="#f5fafe">
						所属的一级分类：
					</td>
					<td bgColor="#ffffff" >
						<select name="cid">
							<c:forEach var="c" items="${categoryList}">
								<option value="${c.cid }">${c.cname}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td align="center" colSpan="4"> 
						<input type="submit" value="确定"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="reset">重置</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<!--history.go(-1)返回上一个页面  -->
						<input type="button" onclick="history.go(-1)" value="返回"/>
					</td>
				</tr>
			</table>
			</form>
	</body>
</HTML>