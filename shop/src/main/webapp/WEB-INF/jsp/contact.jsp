<%@ page language="java" pageEncoding="UTF-8" %>
<% String path=request.getContextPath(); String basePath=request.getScheme()
+ "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>
        联系我们
    </title>
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

                    $(function() 
                    {
						
                        var dd = new DropDown($('#dd'));

                        $(document).click(function() {
                            // all dropdowns
                            $('.wrapper-dropdown-2').removeClass('active');
                        });

                    });
   </script>
    
</head>
<body>
 <input type="hidden" id="menuColor" value="contact"/>
    <div class="wrap">
        <div class="header">
            
        <jsp:include page="topCommon.jsp"></jsp:include>
            
        </div>
        <div class="main">
            <div class="content">
                <div class="section group">
                    <div class="col span_2_of_3">
                        <div class="contact-form">
                            <h2>
                                联系我们
                            </h2>
                            <form method="post" action="#">
                                <div>
                                    <span>
                                        <label>
                                            姓名
                                        </label>
                                    </span>
                                    <span>
                                        <input name="userName" type="text" class="textbox" value="Mr.Lee">
                                    </span>
                                </div>
                                <div>
                                    <span>
                                        <label>
                                            邮箱
                                        </label>
                                    </span>
                                    <span>
                                        <input name="userEmail" type="text" class="textbox" value="service@qq.com">
                                    </span>
                                </div>
                                <div>
                                    <span>
                                        <label>
                                            单位名称
                                        </label>
                                    </span>
                                    <span>
                                        <input name="userPhone" type="text" class="textbox" value="Company">
                                    </span>
                                </div>
                                <div>
                                    <span>
                                        <label>
                                            类型
                                        </label>
                                    </span>
                                    <span>
                                        <textarea name="userMsg">
                                        </textarea>
                                    </span>
                                </div>
                                <div>
                                    <span>
                                        
                                    </span>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col span_1_of_3">
                        <div class="contact_info">
                            <h3>
                                如何找到我们
                            </h3>
                            <div class="map">
                                <iframe width="100%" height="175" frameborder="0" scrolling="no" marginheight="0"
                                marginwidth="0" src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed">
                                </iframe>
                                <br>
                                <small>
                                    <a href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265"
                                    style="color:#666;text-align:left;font-size:12px">
                                        View Larger Map
                                    </a>
                                </small>
                            </div>
                        </div>
                        <div class="company_address">
                            <h3>
                                公司信息 :
                            </h3>
                            <p>
                               中国,
                            </p>
                            <p>
                                安阳,
                            </p>
                            <p>
                               安阳师范学院
                            </p>
                            <p>
                                电话:151 3722 6422
                            </p>
                            <p>
                                传真: (010) 000 00 00 0
                            </p>
                            <p>
                                Email:
                                <span>
                                    800@qq.com
                                </span>
                            </p>
                            <p>
                                友情链接:
                                <span>
                                    Facebook
                                </span>
                                ,
                                <span>
                                    Twitter
                                </span>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="bottomCommon.jsp"></jsp:include>
</body>

</html>