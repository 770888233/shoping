<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<script type="text/javascript">
	function validate() {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if (username == null || username=='') {
			alert("用户名不能为空");
			return false;
		}
		if(password==null|| password ==''){
			alert("密码不能为空");
			return false;
		}
		return true;
	}
</script> 

<script  src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script  src="${pageContext.request.contextPath }/js/js.js"></script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath }/js/cloud.js" type="text/javascript"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台<b class="sysName"></b></span>    
    <ul>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"><b class="sysName"></b></span> 
       
    <div class="loginbox">
    
    <ul>
    <form method="post" action="${pageContext.request.contextPath }/admin/adminUser_login" target="_parent" name='theForm' onsubmit="return validate();">
    <li><input name="username" type="text" class="loginuser" value="用户名" onclick="JavaScript:this.value=''"/></li>
    <li><input name="password" type="password" class="loginpwd" value="" onclick="JavaScript:this.value=''"/></li>
    <li>
    &nbsp;<input type="hidden" name="act" value="signin" />
    &nbsp;<input  type="submit" class="loginbtn" value="登录"   />
    <br>    <label style="padding:10px 0 ">${message}</label></li>    
    </form>
    </ul> 
    </div> 
    </div> 
    <div class="loginbm"> &copy;  </div>
	
    
