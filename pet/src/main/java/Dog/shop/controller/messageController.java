package Dog.shop.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Dog.shop.ben.Message;
import Dog.shop.ben.User;
import Dog.shop.service.MessageService;
import Utils.PageBean;

@Controller
public class messageController {
	@Autowired
	private MessageService messageService;
	@RequestMapping("/saveMessage")
	public String saveMessage(@RequestParam String messageinfo, Model model,HttpServletRequest request) {
		Message Message = new Message();
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		if(loginUser==null){
			model.addAttribute("message", "对不起您还没有登录");
			return "msg";
		}
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Message.setMessage(messageinfo);
		Message.setUid(loginUser.getUid());
		Message.setMessagedate(sdf.format(new Date()));
		messageService.insertMessage(Message);
		request.getSession().setAttribute("Message", Message);
		return "redirect:/messageList?page=1";
	}
	// 显示留言板全部留言
	@RequestMapping("/messageList")
	public String messageList(HttpServletRequest request,Model model, @RequestParam int page) {
		PageBean<Message> pageBean =messageService.findAllMessageByPage(page);
		model.addAttribute("pageBean", pageBean);
		return "messageList";
	}
	//小程序
	@RequestMapping("/cc")
	@ResponseBody
	public List<Message> cc(){
		System.out.println("查询论坛");
		return messageService.list();
	}
	
	

}
