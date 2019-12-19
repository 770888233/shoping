<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
					<tr>
						<td  align="center"  bgColor="#afd1f3">
							<strong>用户列 表</strong>
						</td>
					</tr>
					<tr>
						<td align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="0" rules="all" border="1" style="WIDTH: 100%;">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
									<td align="center" width="7%">
										用户名
									</td>
									<td align="center" width="7%">
										密码
									</td>
									<td width="7%" align="center">
										email
									</td>
									<td width="7%" align="center">
										phone
									</td>
									<td width="7%" align="center">
										收货地址
									</td>
									<td width="7%" align="center">
										激活状态
									</td>
								</tr>
								<c:forEach items="${userList}" var="u">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td align="center">
												${u.username}
											</td>
											<td align="center">
												${u.password}
											</td>
											<td align="center">
												${u.email}
											</td>
											<td align="center">
												${u.phone}
											</td>
											<td align="center">
												${u.addr}
											</td>
											<td align="center">
												${u.state}
											</td>
										</tr>
									</c:forEach>	
							</table>
						</td>
					</tr>
			</table>
	</body>
</HTML>

