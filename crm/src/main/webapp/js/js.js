function form_submit(){
	document.getElementById("login").submit();
}
function form_regist(){
	window.location = "regist.jsp";
}
function form_reset(){
	document.getElementById("login").reset();
}
function reloadcode(){
    var verify=document.getElementById('safecode');
    verify.setAttribute('src','code.jsp?'+Math.random());
}
