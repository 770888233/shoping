// 创建Ajax对象
function Ajax() {
	var Ajax = false;
	if(window.XMLHttpRequest) {
		Ajax = new XMLHttpRequest();
	} else {
		Ajax = new window.ActiveXObject('Mircorsoft.XMLHTTP')
	}
	return Ajax;
}