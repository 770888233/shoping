<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function showDetail(oid){
				var but = document.getElementById("but"+oid);
				var div1 = document.getElementById("div"+oid);
				if(but.value == "订单详情"){
					// 1.创建异步对象
					var xhr = createXmlHttp();
					// 2.设置监听
					xhr.onreadystatechange = function(){
						if(xhr.readyState == 4){
							if(xhr.status == 200){
								
								div1.innerHTML = xhr.responseText;
							}
						}
					}
					// 3.打开连接
					xhr.open("GET","${pageContext.request.contextPath}/adminOrder_findOrderItem?oid="+oid+"&time="+new Date().getTime(),true);
					// 4.发送
					xhr.send(null);
					but.value = "关闭";
				}else{
					div1.innerHTML = "";
					but.value="订单详情";
				}
				
			}
			function createXmlHttp(){
				   var xmlHttp;
				   try{ // Firefox, Opera 8.0+, Safari
				        xmlHttp=new XMLHttpRequest();
				    }
				    catch (e){
					   try{// Internet Explorer
					         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
					      }
					    catch (e){
					      try{
					         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
					      }
					      catch (e){}
					      }
				    }

					return xmlHttp;
				 }
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/order/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单列表</strong>
						</TD>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="5%">
										序号
									</td>
									<td align="center" width="5%">
										订单编号
									</td>
									<td align="center" width="8%">
										订单金额
									</td>
									<td align="center" width="8%">
										收货人
									</td>
									<td align="center" width="18%">
										收货地址
									</td>
									<td align="center" width="10%">
										订单状态
									</td>
									<td align="center" width="50%">
										订单详情
									</td>
								</tr>
									<c:forEach items="${pageBean.list}" var="o" varStatus="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												${status.count}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												${o.oid}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												${o.money}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="8%">
												${o.accepter}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												${o.receiveinfo}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<c:if test="${o.state==0}">
													未付款
												</c:if>
												<c:if test="${o.state==1}">
													已付款，<a href="${ pageContext.request.contextPath }/admin/adminOrder_updateState?oid=${o.oid}&status=2"><font color="blue">发货</font></a>
												</c:if>
												<c:if test="${o.state==2}">
													等待确认收货
												</c:if>
												<c:if test="${o.state==3}">
													订单完成
												</c:if>
											
											</td>
											<td align="center" style="HEIGHT: 22px">
												<div id="div${o.oid}">
													<table width="100%">
														<c:forEach items="${o.oiList}" var="orderItem">
														<tr>
															<td><img width="40" height="45" src="${ pageContext.request.contextPath }/${orderItem.product.image}"></td>
															<td>商品名称：${orderItem.product.pname}</td>
															<td>商品数量：${orderItem.count}</td>
															<td>商品总价：${orderItem.subtotal}</td>
														</tr>
														</c:forEach>
													</table>
												</div>
											</td>
							
										</tr>
									</c:forEach>	
							</table>
						</td>
					</tr>
					<tr align="center">
						<td colspan="7">
							第${pageBean.page}/${pageBean.totlePage}页 
							<c:if test="${pageBean.page != 1}">
								<a href="${ pageContext.request.contextPath }/admin/adminOrder_findAllByPage?page=1">首页</a>|
								<a href="${ pageContext.request.contextPath }/admin/adminOrder_findAllByPage?page=${pageBean.page-1}">上一页</a>|
							</c:if>
							<c:if test="${pageBean.page != pageBean.totlePage}">
								<a href="${ pageContext.request.contextPath }/admin/adminOrder_findAllByPage?page=${pageBean.page+1}">下一页</a>|
								<a href="${ pageContext.request.contextPath }/admin/adminOrder_findAllByPage?page=${pageBean.totlePage}">尾页</a>|
							</c:if>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

