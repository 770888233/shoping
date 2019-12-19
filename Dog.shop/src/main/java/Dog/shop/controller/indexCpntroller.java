package Dog.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Dog.shop.ben.Category;
import Dog.shop.ben.Product;
import Dog.shop.service.CategoryService;
import Dog.shop.service.ProductService;
import Utils.PageBean;

@Controller
public class indexCpntroller {

	@Autowired
	private  CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	@RequestMapping(value="/index")
	public String index(Model model,HttpServletRequest request) throws Exception {
			//查询一级分类
			List<Category> cList = categoryService.findCategory();
	    	request.getSession().getServletContext().setAttribute("cList",cList);
	    	
	    	//查询热门商品
		    List<Product> hList= productService.findHotProduct();
			model.addAttribute("hList", hList);
			//查询最热的商品
			List<Product> nList = productService. findNewProduct();
			model.addAttribute("nList", nList);
			//滚动图片
			List<Product> sList;
			if (hList.size()>3) {
			sList = new ArrayList<Product>();
			sList.add(hList.get(0));
			sList.add(hList.get(1));
			sList.add(hList.get(2));
			model.addAttribute("sList", sList);
			}else {
				model.addAttribute("sList", hList);
			}
			return "index";
	}
	//搜索 功能
	@RequestMapping("/searchProduct")
	public String searchProduct(@RequestParam String condition,Model model,HttpServletRequest request) throws Exception {
			//查询一级分类
			List<Category> cList = categoryService.findCategory();
			request.getSession().getServletContext().setAttribute("cList",cList); 
			//查询商品
		    List<Product> hList= productService.findHotProduct();
			model.addAttribute("hList", hList);
			
			//搜索商品
			List<Product> srList = productService.searchProduct(condition);
			model.addAttribute("srList", srList);
			
			//滚动图片专用，最多显示3个商品
			List<Product> sList;
			if(hList.size()>3)
			{
				sList = new ArrayList<Product>();
				sList.add(hList.get(0));
				sList.add(hList.get(1));
				sList.add(hList.get(2));
				model.addAttribute("sList", sList);
			}
			else
			{
				model.addAttribute("sList", hList);
			}
		return "searchProduct";
	}
	
	//根据一级目录查询二级目录
	@RequestMapping(value="/findCategorySecond")
	public String findCategorySecond(HttpServletRequest request ,@RequestParam int cid,Model model,@RequestParam int page) {
		request.getSession().setAttribute("cid", cid);
		PageBean<Product> proPageBean = productService.findProductyBycid(cid,page);
		model.addAttribute("pageBean",proPageBean);
		return "category"; 
	}
//	根据二级目录查询csid来分页查询商品
	@RequestMapping("/findCategorySecond1")
	public String findCategorySecond1(@RequestParam int csid,Model model,@RequestParam int page){
		PageBean<Product> proPageBean = productService.finbProductByCsid(csid,page);
		model.addAttribute("pageBean",proPageBean);
		return "category";
	}
	// 根据id查询
	@RequestMapping("/productFindByPid")
	public String productFindByPid(@RequestParam int pid,Model model){
		Product product = productService.productFindByPid(pid);
		model.addAttribute("product", product);
		return "product";
	}
	@RequestMapping("/bb")
	@ResponseBody
	public List<Category> bb(){
		System.out.println("小程序一级菜单调用");
		return categoryService.list();
	}

	
}
