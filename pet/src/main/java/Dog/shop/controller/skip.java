package Dog.shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class skip {
	/*//跳转到index页面
		@RequestMapping(value="/index")
		public String index() {
			
			return "index";
		}*/
	//跳转到注册页面
	@RequestMapping(value="/regist")
	public String regist() {
		
		return "regist";
	}
	//已经有账号返回跳转到登录页面
	@RequestMapping(value="/login")
	public String login() {
		
		return "login";
	}
	
	//         关于我们
	@RequestMapping(value="/about")
	public String about() {
		
		return "about";
	}
	
    //发货说明
	@RequestMapping(value="/delivery")
	public String delivery() {
		
		return "delivery";
	}
	//联系我们
	@RequestMapping(value="/contact")
	public String contact() {
		
		return "contact";
	}
	//主页的首页
	@RequestMapping(value="/indexnew")
	public String indexnew() {
		
		return "indexnew";
	}
	
	//
	@RequestMapping(value="/messages")
	public String messages() {
		
		return "messageList";
	}
	//后台的页面
	@RequestMapping(value="/admin")
	public String admin() {
		
		return "admin/index";
	}
		
}
