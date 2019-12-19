package Dog.shop.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Dog.shop.ben.Adminuser;
import Dog.shop.ben.User;

import Dog.shop.service.UserService;
import exception.zdyException;

@Controller
public class Userlogin {
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/")
	public String index() {
		
		
		return "login";
	}
	
	
	//判断验证码，密码，账号是否正确
	@RequestMapping("/list")
	public String userLogin(HttpServletRequest request , User user,Model model,@RequestParam String checkImg)throws Exception {
		String sessionCode = (String) request.getSession().getAttribute("checkcode");
		if (!sessionCode.equalsIgnoreCase(checkImg)) {;
		    System.out.println("验证码输入错误");
			request.getSession().setAttribute("message", "验证码输入错误请重新");
			 return "login";
		}		
		User loginUser = userservice.loginFindByUnameAndPwd(user.getUsername(),
				user.getPassword());
		if (loginUser == null) {
		
			System.out.println("密码输入错误请重新登陆");
			 request.getSession().setAttribute("message", "密码输入错误请重新登陆");
			 return "login";
		}
		request.getSession().setAttribute("loginUser", loginUser);
		System.out.println(user.getUsername()+user.getPassword());
		System.out.println(loginUser);
		request.getSession().removeAttribute("message");
		return "indexnew";
	}
	//判断账号是否可以登录
	@RequestMapping("/loginFindByid")
	public void loginFindByid(HttpServletRequest request,
			HttpServletResponse response, @RequestParam String username) {
		response.setContentType("text/html;charset=UTF-8");
		try {
			User user = userservice.loginFindByid(username);
			if (user!=null) {
				response.getWriter().write("可以登录");
			}else{
				response.getWriter().write("不可以登录");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//判断账号是否可以注册
	@RequestMapping("/registFindByid")
	public void registFindByid(HttpServletResponse ponse,@RequestParam String username) {
		ponse.setContentType("text/html;charset=UTF-8");
		try {
			User user = userservice.loginFindByid(username);
			
			if(user!=null) {
				ponse.getWriter().write("已经被注册");
			}else {
				ponse.getWriter().write("可以注册");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//注册  注册只需要判断用户名是否数据库存在 和验证码的正确性 
	//其他数据可以保持不唯一账号已经判断过只需要判断验证码并存入数据库
	@RequestMapping("/userRegist")
	public String userRegist(Model model, HttpServletRequest request,
			@Validated User user, BindingResult bindingResult,
			@RequestParam String checkImg) throws Exception {
		if (bindingResult.hasErrors()) {
			List<ObjectError> errors =bindingResult.getAllErrors();
			List<String> list = new ArrayList<>();
			for (ObjectError objectError : errors) {
				String str = new String(objectError.getDefaultMessage()
						.getBytes("ISO-8859-1"), "gbk");
				list.add(str);
			}
			model.addAttribute("errors", list);
			return "regist";
		}
		// 查看验证码
		String sessionCode = (String) request.getSession().getAttribute(
				"checkcode");

		if (!sessionCode.equalsIgnoreCase(checkImg)) {
			model.addAttribute("message", "验证码错误请重新注册");
		/*	throw new zdyException("验证码错误请重新注册");*/
			return "regist";
		}
		// 开始写入数据库
		userservice.saveUser(user);
		//model.addAttribute("message", "注册成功请去邮箱激活");
		model.addAttribute("message", "注册成功请登录");
		return "login";
	}
		
	//判断邮箱是否注册
	@RequestMapping("/activeUser")
	public String activeUser(@RequestParam String code,Model model) throws zdyException,Exception  {
		/*
		 * 根据传递激活码进行用户查询. 如果用户不为空: 修改用户状态 改为1 如果用户为空: 激活码被篡改了.
		 */
			User activeUser = userservice.findByCode(code);
			if(activeUser==null){
//				model.addAttribute("message", "激活码被篡改了,请重新注册");
				throw new zdyException("激活码被篡改了,请重新注册");
			}
			activeUser.setState(1);
			activeUser.setCode(null);
			userservice.activeUser(activeUser);
			model.addAttribute("message", "激活码成功");
			return "msg";
	}
	//退出
	@RequestMapping(value="/userLogout")
	public String userLogout(HttpServletRequest request,HttpServletResponse response,Model model) {
		request.getSession().removeAttribute("loginUser");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setHeader("refresh", "5;url=/");
		model.addAttribute("message", "退出成功，系统将在5秒之后跳转到首页......");
		return "msg";
	}
	
	//后台登录
	@RequestMapping("/admin/adminUser_login")
	public String adminUser_login(HttpServletRequest request,Model model,@RequestParam String username,@RequestParam String password) {
		Adminuser adminuserLogin  = userservice.adminUser_login(username,password);
		if (adminuserLogin==null) {
			model.addAttribute("message", "改用户未被授予管理员身份！");
			return "admin/index";
		}
		request.getSession().setAttribute("adminuserLogin", adminuserLogin);
		return "admin/home";
	}
	//微信小程序端
	@RequestMapping("/aa")
	@ResponseBody
    public  boolean login (String username, String password){
    System.out.println ( "微信小程序调用接口！！！用户名:" + username + "密码:" + password );
    boolean login = userservice.login ( username, password );
    if (login) {
        return true;
    }
    return false;
}

	
}
