<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript">
	function time() {
		tmpDate = new Date();
		date = tmpDate.getDate();
		month= tmpDate.getMonth() + 1 ;
		year= tmpDate.getFullYear();
		document.write(year);
		document.write("年");
		document.write(month);
		document.write("月");
		document.write(date);
		document.write("日 ");
		
		myArray=new Array(6);
		myArray[0]="星期日"
		myArray[1]="星期一"
		myArray[2]="星期二"
		myArray[3]="星期三"
		myArray[4]="星期四"
		myArray[5]="星期五"
		myArray[6]="星期六"
		weekday=tmpDate.getDay();
		if (weekday==0 | weekday==6)
		{
		document.write(myArray[weekday])
		}
		else
		{document.write(myArray[weekday])
		};
	}
</script> 
<style type="text/css">
		BODY {
			MARGIN: 0px;
			BACKGROUND-COLOR: #ffffff
		}
		
		BODY {
			FONT-SIZE: 12px;
			COLOR: #000000
		}
		
		TD {
			FONT-SIZE: 12px;
			COLOR: #000000
		}
		
		TH {
			FONT-SIZE: 12px;
			COLOR: #000000
		}
</style>
</head>
	<body>
		<table width="100%" height="70%"  border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="100%" background="${pageContext.request.contextPath}/images/top_100.jpg">
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30" valign="bottom" background="${pageContext.request.contextPath}/images/mis_01.jpg">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="20%" align="left">
								<font color="#000000"> 
										 
								</font>
							</td>
							<td width="65%" align="center">
											<font ></font>佳哥宠物商城系统后台欢迎登陆
							</td>
							<td width="15%">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td>
											用户名：
											<font color="red">${adminuserLogin.username}</font>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</HTML>
