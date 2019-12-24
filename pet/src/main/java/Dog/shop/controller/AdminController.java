package Dog.shop.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import Dog.shop.ben.Adminuser;
import Dog.shop.ben.Category;
import Dog.shop.ben.Categorysecond;
import Dog.shop.ben.Message;
import Dog.shop.ben.Orders;
import Dog.shop.ben.Product;
import Dog.shop.ben.User;
import Dog.shop.service.CategorySecondService;
import Dog.shop.service.CategoryService;
import Dog.shop.service.OrdersService;
import Dog.shop.service.ProductService;
import Dog.shop.service.UserService;
import Dog.shop.service.impl.messageServiceimpl;
import Utils.PageBean;
import Utils.UUIDUtiils;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	public CategorySecondService categorySecondService;
	@Autowired
	public ProductService productService;
	@Autowired
	public OrdersService orderService;
	@Autowired
	public messageServiceimpl messageService;
	//用户管理
	@RequestMapping("/admin/admin_findAll")
	public String admin_findAll(Model model,HttpServletRequest request){
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		List<User> userList = userService.admin_findAll();
		model.addAttribute("userList", userList);
		return "admin/user/list";
	}
	//分类管理  展示
	@RequestMapping("/admin/adminCategory_findAll")
	public String adminCategory_findAll(Model model , HttpServletRequest request) {
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		List<Category> categoryList = categoryService.adminbFindCategory();
		model.addAttribute("categoryList",categoryList);
		return "admin/category/list";
	}
	//分类管理  添加页面
	@RequestMapping("/admin/adminCategory_add")
	public String adminCategory_add(HttpServletRequest request,Model model) {
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		return  "admin/category/add";
	}
	//分类管理  添加
	@RequestMapping("/admin/adminCategory_save")
	public String adminCategory_save(@RequestParam String cname,HttpServletRequest request)
			throws Exception {
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		Category addCategory = new Category();
		addCategory.setCname(cname);
		categoryService.addCategory(addCategory);
		return "redirect:/admin/adminCategory_findAll";
	}
	//分类管理  跳转更新
	@RequestMapping("/admin/adminCategory_edit")
	public String adminCategory_edit(@RequestParam int cid, Model model,HttpServletRequest request){
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		Category existCategory = categoryService.findCategory(cid);
		model.addAttribute("existCategory", existCategory);
		return "admin/category/edit";
	}
	//分类管理  更新逻辑
	@RequestMapping("/admin/adminCategory_update")
	public String adminCategory_update(@RequestParam int cid,@RequestParam String cname,HttpServletRequest request){
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		Category category = new Category();
		category.setCid(cid);
		category.setCname(cname);
		categoryService.adminCategory_update(category);
		return "redirect:/admin/adminCategory_findAll";
	}
	//分类管理  删除
	@RequestMapping("/admin/adminCategory_delete")
	public String adminCategory_delete(@RequestParam int cid,HttpServletRequest request) throws Exception {
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		categorySecondService.adminCategorySecond_deleteByCid(cid);
		categoryService.deleteCategoryByCid(cid);
		return "redirect:/admin/adminCategory_findAll";
	}
	//商品管理
	@RequestMapping("/admin/adminCategorySecond_findAllByPage")
	public String adminCategorySecond_findAllByPage(@RequestParam int page,Model model,HttpServletRequest request) {
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		PageBean<Categorysecond> csPageBean = categorySecondService.adminCategorySecond_findAllByPage(page);
		model.addAttribute("csPageBean", csPageBean);
		return "admin/categorysecond/list";
	}
	//到商品添加页面
	@RequestMapping("/admin/adminCategorySecond_addPage")
	public String adminCategorySecond_addPage(Model model,HttpServletRequest request){
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		List<Category> categoryList = categoryService.adminbFindCategory();
		model.addAttribute("categoryList", categoryList);
		return "admin/categorysecond/add";
	}
	//添加功能
	@RequestMapping("/admin/adminCategorySecond_save")
	public String adminCategorySecond_save(@RequestParam String csname,@RequestParam int cid,HttpServletRequest request) throws Exception{
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		Categorysecond categorysecond = new Categorysecond();
		categorysecond.setCsname(csname);
		categorysecond.setCid(cid);
		categorySecondService.adminCategorySecond_save(categorysecond);
		return "redirect:/admin/adminCategorySecond_findAllByPage?page=1";
	}
	//更新
	@RequestMapping("admin/adminCategorySecond_edit")
	public String adminCategorySecond_edit(@RequestParam int csid,Model model,HttpServletRequest request) throws Exception{
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		Categorysecond findByCsid = categorySecondService.findByCsid(csid);
		model.addAttribute("findByCsid", findByCsid);
		return "admin/categorysecond/edit";
	}
	//删除
	@RequestMapping("admin/adminCategorySecond_update")
	public String adminCategorySecond_update(@RequestParam String csname,@RequestParam int csid,HttpServletRequest request){
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		Categorysecond categorysecond = new Categorysecond();
		categorysecond.setCsname(csname);
		categorysecond.setCsid(csid);
		categorySecondService.adminCategorySecond_update(categorysecond);
		return "redirect:/admin/adminCategorySecond_findAllByPage?page=1";
	}
	//admin的商品管理
	@RequestMapping("/admin/adminProduct_findAllByPage")
	public String adminProduct_findAllByPage(@RequestParam int page, Model model,HttpServletRequest request)
			throws Exception {
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		PageBean<Product> allProPageBean = productService.findAllProduct(page);
		model.addAttribute("allProPageBean", allProPageBean);
		return "admin/product/list";
	}
	//到商品添加
	@RequestMapping("/admin/adminProduct_addPage")
	public String adminProduct_addPage(Model model,HttpServletRequest request) throws Exception {
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		//查询出所有的二级分类
		List<Categorysecond> cslist = categorySecondService.findAll();
		model.addAttribute("cslist", cslist);
		return "admin/product/add";
	}
	//添加功能代码
	@RequestMapping("/admin/adminProduct_save")
	public String adminProduct_save(Product product,HttpServletRequest request,MultipartFile file) throws Exception {
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		product.setPdate(new Date());
//		上传图片
		if (file != null) {
			String path = request.getServletContext().getRealPath(
					"/products");
			String uploadFileName = file.getOriginalFilename();
			String fileName = UUIDUtiils.getUUID()+uploadFileName;
			File diskFile = new File(path + "//" + fileName);
			file.transferTo(diskFile);
			product.setImage("products/" + fileName);
		}
		System.out.println(product.getImage());
		productService.adminProduct_save(product);
		return "redirect:/admin/adminProduct_findAllByPage?page=1";
	}
	//商品修改代码
	@RequestMapping("admin/adminProduct_edit")
	public String adminProduct_edit(@RequestParam int pid,Model model,HttpServletRequest request) throws Exception{
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		Product product = productService.finbProductByPid(pid);
		model.addAttribute("findByPid", product);
		//查询出所有的二级分类
		List<Categorysecond> cslist = categorySecondService.findAll();
		model.addAttribute("cslist", cslist);
		return "admin/product/edit";
	}
	@RequestMapping("/admin/adminProduct_update")
	public String adminProduct_update(Product product,HttpServletRequest request,MultipartFile file) throws Exception {
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		product.setPdate(new Date());
//		上传图片
		if (file != null) {
			String path = request.getServletContext().getRealPath(
					"/products");
			String uploadFileName = file.getOriginalFilename();
			String fileName = UUIDUtiils.getUUID()+uploadFileName;
			File diskFile = new File(path + "//" + fileName);
			file.transferTo(diskFile);
			product.setImage("products/" + fileName);
		}
		productService.adminProduct_update(product);
		return "redirect:/admin/adminProduct_findAllByPage?page=1";
	}
	
	@RequestMapping("admin/adminProduct_deletecs")
	public String adminProduct_deletecs(@RequestParam int pid,HttpServletRequest request) throws Exception{
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		productService.adminProduct_deletecs(pid);
		return "redirect:/admin/adminProduct_findAllByPage?page=1";
	}
	/** 订单管理模块  **/
	
	@RequestMapping("/admin/adminOrder_findAllByPage")
	public String adminOrder_findAllByPage(@RequestParam int page, Model model,HttpServletRequest request)
			throws Exception {
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		
		PageBean<Orders> allProPageBean = orderService.findAllOrderByStateAndPage(page);
		model.addAttribute("pageBean", allProPageBean);
		return "admin/order/list";
	}
	//更新订单状态
	@RequestMapping("/admin/adminOrder_updateState")
	public String adminOrder_updateState(@RequestParam int oid, @RequestParam int status, Model model,HttpServletRequest request)
			throws Exception {
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		
		orderService.updateOrderStatus(oid, status);
		
		return "redirect:/admin/adminOrder_findAllByPage?page=1";
	}
	@RequestMapping("/admin/adminOrder_findByState")
	public String adminOrder_findByState(@RequestParam int page,@RequestParam int state, Model model,HttpServletRequest request)
			throws Exception {
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		
		PageBean<Orders> allProPageBean = orderService.findAllOrderByStateAndPage(state,page);
		model.addAttribute("pageBean", allProPageBean);
		return "admin/order/list";
	}
	//后台留言管理 
	@RequestMapping("/admin/adminMessage_findAllByPage")
	public String adminMessage_findAllByPage(@RequestParam int page, Model model,HttpServletRequest request)
			throws Exception {
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		
		PageBean<Message> pageBean = messageService.findAllMessageByPage(page);
		model.addAttribute("pageBean", pageBean);
		
		return "admin/message/list";
	}
	
	@RequestMapping("/admin/adminMessage_delete")
	public String adminOrder_updateState(@RequestParam int messageid, Model model,HttpServletRequest request){
		Adminuser adminuserLogin = (Adminuser) request.getSession().getAttribute("adminuserLogin");
		if(adminuserLogin==null){
			request.getSession().setAttribute("message","对不起您还没有登录");
			return "admin/index";
		}
		messageService.deleteMessage(messageid);
		return "redirect:/admin/adminMessage_findAllByPage?page=1";
	}
	
	
}
