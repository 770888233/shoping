<%@ page language="java" pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path;  
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>关于我们</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="${pageContext.request.contextPath}/css/style2.css" rel="stylesheet" type="text/css" media="all"/>
        <link href="${pageContext.request.contextPath}/css/slider2.css" rel="stylesheet" type="text/css" media="all"/>
        <link href="${pageContext.request.contextPath}/css/productShow.css" rel="stylesheet" type="text/css" media="all"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js">
        </script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/move-top.js">
        </script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/easing.js">
        </script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/startstop-slider.js">
        </script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/CommonUtils.js">
        </script>
   <script type="text/javascript">
		$(document).ready(function() 
		{			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
			initLogin("${username}");
		});
	</script>

</head>
<body>
 <input type="hidden" id="menuColor" value="about"/>
  <div class="wrap">

	<jsp:include page="topCommon.jsp"></jsp:include>

 <div class="main">
    <div class="content">
    	<div class="section group">
				<div class="col_1_of_3 span_1_of_3">
					<h3>全球贸易合作伙伴</h3>
					<img src="images/logo.png" alt="">
					<p>买全球</p>
					<p>卖往全世界</p>
				</div>
				<div class="col_1_of_3 span_1_of_3">
					<h3>关于我们</h3>
				 <div class="history-desc">
					<div class="year"><p>2018 -</p></div>
					<p class="history">公司成立</p>
				 <div class="clear"></div>
				</div>
				 <div class="history-desc">
					<div class="year"><p>2018 -</p></div>
					<p class="history">开始营业</p>
				 <div class="clear"></div>
				</div>
				 <div class="history-desc">
					<div class="year"><p>2018 -</p></div>
					<p class="history">开始营业</p>
				 <div class="clear"></div>
				</div>
			</div>
				<div class="col_1_of_3 span_1_of_3">
					<h3>机遇</h3>
					<p>加入我们吧！</p>
				    <div class="list">
					     <ul>
					     	<li><a href="mailto:help@qq.com">点击加入</a></li>
					     	<li><a href="mailto:help@qq.com">点击加入</a></li>
					     	<li><a href="mailto:help@qq.com">点击加入</a></li> 
					     </ul>
					 </div>
					 <p>给你一片广阔的天空</p>
				</div>
			</div>	
			</div>		
    </div>
 </div>
</div>
 <jsp:include page="bottomCommon.jsp"></jsp:include>
</body>
</html>

