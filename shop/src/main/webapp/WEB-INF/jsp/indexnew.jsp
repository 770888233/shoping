<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
String path=request.getContextPath(); 
String basePath=request.getScheme()
    + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>佳哥宠物商城 </title>
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
            function DropDown(el) {
                this.dd = el;
                this.initEvents();
            }
            DropDown.prototype = {
                initEvents: function() {
                    var obj = this;

                    obj.dd.on('click',
                    function(event) {
                        $(this).toggleClass('active');
                        event.stopPropagation();
                    });
                }
            }

            $(function() {

				initLogin("${username}");
				
                var dd = new DropDown($('#dd'));

                $(document).click(function() {
                    // all dropdowns
                    $('.wrapper-dropdown-2').removeClass('active');
                });

            });
        </script>
    </head>
    
    <body>
    <input type="hidden" id="menuColor" value="index"/>
        <div class="wrap">
            <div class="header">

				<jsp:include page="topCommon.jsp"></jsp:include>
				
                <div class="header_slide">
                    <div class="header_bottom_left">
					<!-- 左上角，商品一级分类 -->
					<div class="categories">
					    <ul>
					        <h3>分类 </h3> 
					        <c:forEach var="c" items="${cList}">
							<li><a href="${pageContext.request.contextPath}/findCategorySecond?cid=${c.cid}&page=1">${c.cname}</a></li>
							</c:forEach> 
					    </ul>
					</div>

                    </div>
                    <div class="header_bottom_right">
                        <div class="slider">
                            <div id="slider">
                                <div id="mover">
                                <c:choose>
                                    <c:when test="${empty sList}">
                                      <div id="slide-1" class="slide">
                                        <div class="slider-img">
                                                <img src="images/cs10004.jpg" alt="learn more" />
                                        </div>
                                        <div class="slider-text">
                                            <h1>
                                                GEI NOW!
                                                <br>
                                                <span>
                                                    大量可爱宠物
                                                </span>
                                            </h1>
                                            <h2>
                                                降价 20%
                                            </h2>
                                            <div class="features_list">
                                                <h4>
                                                    欢迎访问本宠物商城
                                                </h4>
                                            </div>
                                            <a href="${pageContext.request.contextPath}/index" target="_blank" class="button">
                                                详情
                                            </a>
                                        </div>
                                        <div class="clear">
                                        </div>
                                    </div>
                                                    </c:when>
                                                    <c:otherwise> 
                                                        <c:forEach items="${sList}" var="p">
                                                        <div id="slide-1" class="slide">
					                                        <div class="slider-img">
					                                                <img src="${pageContext.request.contextPath}/${p.image}" alt="learn more" />
					                                        </div>
					                                        <div class="slider-text">
					                                            <h1>
					                                                Hot!
					                                                <br>
					                                                <span>
					                                                    ${p.pname }
					                                                </span>
					                                            </h1>
					                                            <h2>
					                                               ￥ ${p.marketPrice}
					                                            </h2>
					                                            <div class="features_list">
					                                                <h4>
					                                                    ${p.pdesc }
					                                                </h4>
					                                            </div>
					                                            <a href="${pageContext.request.contextPath}/productFindByPid?pid=${p.pid}"
					                                                                    target="_blank" class="button">
					                                                详情
					                                            </a>
					                                        </div>
					                                        <div class="clear">
					                                        </div>
					                                    </div>
                                                        </c:forEach>
                                                    </c:otherwise>
                                                </c:choose>
                                </div>
                            </div>
                            <div class="clear">
                            </div>
                        </div>
                    </div>
                    <div class="clear">
                    </div>
                </div>
            </div>
            <div class="main">
                <div class="content">
                    <div class="content_top">
                        <div class="heading">
                            <h3>
                               热门宠物
                            </h3>
                        </div>
                        <div class="see">
                            <p>
                                 
                            </p>
                        </div>
                        <div class="clear">
                        </div>
                    </div>
                    
<div class="bookShow">
                                            <ul>
                                                <c:choose>
                                                    <c:when test="${empty hList}">
                                                        <label>
                                              更多精美物品欢迎进入主页面查看
                                                        </label>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:forEach items="${hList}" var="p">
                                                            <li>
                                                                <a href="${pageContext.request.contextPath}/productFindByPid?pid=${p.pid}"
                                                                target="_blank">
                                                                    <img src='${pageContext.request.contextPath}/${p.image}' />
                                                                </a>
                                                                <p class="name">
                                                              
                                                                    <a href="${pageContext.request.contextPath}/productFindByPid?pid=${p.pid}"
                                                                    target="_blank" title="${p.pname}">
                                                                        ${p.pname}
                                                                    </a>
                                                                </p>
                                                                
                                                                <p class="price">
                                                                    <span class="rob">
                                                                        <span>
                                                                            &yen;
                                                                        </span>
                                                                        <span>
                                                                            ${p.marketPrice}
                                                                        </span>
                                                                    </span>
                                                                    <span class="price_r">
                                                                        <span>
                                                                            &yen;
                                                                        </span>
                                                                        <span>
                                                                            ${p.shopPrice}
                                                                        </span>
                                                                    </span>
                                                                </p>
                                                            </li>
                                                        </c:forEach>
                                                    </c:otherwise>
                                                </c:choose>
                                             </ul>
                                        </div>
                    
                    
                    
                    
                    <div class="content_bottom">
                        <div class="heading">
                            <h3>
                                最新宠物
                            </h3>
                        </div>
                        <div class="see">
                            <p>
                                
                            </p>
                        </div>
                        <div class="clear">
                        </div>
                    </div>
                    
<div class="bookShow">
                                            <ul>
                                                <c:choose>
                                                    <c:when test="${empty nList}">
                                                        <label>
                                                             更多精美物品欢迎进入主页面查
                                                        </label>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:forEach items="${nList}" var="p">
                                                            <li>
                                                                <a href="${pageContext.request.contextPath}/productFindByPid?pid=${p.pid}"
                                                                target="_blank">
                                                                    <img src='${pageContext.request.contextPath}/${p.image}' />
                                                                </a>
                                                                <p class="name">
                                                                    <a href="${pageContext.request.contextPath}/productFindByPid?pid=${p.pid}"
                                                                    target="_blank" title="${p.pname}">
                                                                        ${p.pname}
                                                                    </a>
                                                                </p>
                                                                
                                                                <p class="price">
                                                                    <span class="rob">
                                                                        <span>
                                                                            &yen;
                                                                        </span>
                                                                        <span>
                                                                            ${p.marketPrice}
                                                                        </span>
                                                                    </span>
                                                                    <span class="price_r">
                                                                        <span>
                                                                            &yen;
                                                                        </span>
                                                                        <span>
                                                                            ${p.shopPrice}
                                                                        </span>
                                                                    </span>
                                                                </p>
                                                            </li>
                                                        </c:forEach>
                                                    </c:otherwise>
                                                </c:choose>
                                             </ul>
                                        </div>                    
                    
                    
                </div>
            </div>
        </div>
     </div>
		<jsp:include page="bottomCommon.jsp"></jsp:include>
	</body>
</html>