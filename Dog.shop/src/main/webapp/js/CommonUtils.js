function initLogin(username) 
{
	if (null == username || "" == username)
	{
		$("#noLogin").css("display","block");
		$("#logined").css("display","none");
	}
	else
	{
		$("#noLogin").css("display","none");
		$("#logined").css("display","block");
	}
}
