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
<title>发货</title>
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
		$("#posts").accordion({ 
			header: "div.tab", 
			alwaysOpen: false,
			autoheight: false
		});
		
	});
	
			function DropDown(el) {
				this.dd = el;
				this.initEvents();
			}
			DropDown.prototype = {
				initEvents : function() {
					var obj = this;

					obj.dd.on('click', function(event){
						$(this).toggleClass('active');
						event.stopPropagation();
					});	
				}
			}

			$(function() {

				var dd = new DropDown( $('#dd') );

				$(document).click(function() {
					// all dropdowns
					$('.wrapper-dropdown-2').removeClass('active');
				});

			});

	
</script>
</head>
<body>
 <input type="hidden" id="menuColor" value="delivery"/>
  <div class="wrap">
	<div class="header">

<jsp:include page="topCommon.jsp"></jsp:include>
</div>

 <div class="main">
    <div class="content">
    	<div class="section group">
				<div class="grid_1_of_3 images_1_of_3">
					  <img src="images/delivery-img1.jpg" alt="" />
					  <h3>发货流程 </h3>
					  <p>我们发货</p>
				</div>
				<div class="grid_1_of_3 images_1_of_3">
					  <img src="images/delivery-img2.jpg" alt="" />
					  <h3>送货上门 </h3>
					  <p>我们送货上门</p>
				</div>
				<div class="grid_1_of_3 images_1_of_3">
					  <img src="images/delivery-img3.jpg" alt="" />
					  <h3>保证质量</h3>
					  <p>我们保证质量</p>
				</div>
			</div>	
		<div class="faqs">
    	  <h2>一站式购买宠物</h2>	          	
            <div id="posts">
			    <div class="tab bar">
                    <h4 class="post-title">1.送货上门</h4>
                </div>
			    <div class="panel margin-lr-7">
            		<p>足不出户，轻松选择喜爱的宠物</p>
			    </div>		   
                <div class="tab bar">
                     <h4 class="post-title"> 2.提供服务</h4>
                </div>
				<div class="panel margin-lr-7">
	        		 <p>保证安全</p>
                </div>
                <div class="tab bar">
                     <h4 class="post-title"> 3.保证质量</h4>
                </div>
				<div class="panel margin-lr-7">
	        		 <p></p>
                </div>
		       </div>
		      </div>	
         </div> 
         </div> 
    </div>
 </div>
<jsp:include page="bottomCommon.jsp"></jsp:include>
</body>
</html>

