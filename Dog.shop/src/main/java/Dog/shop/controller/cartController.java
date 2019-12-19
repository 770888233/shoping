package Dog.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Dog.shop.ben.Cart;
import Dog.shop.ben.CartItem;
import Dog.shop.ben.Product;
import Dog.shop.ben.User;
import Dog.shop.service.CartService;
import Dog.shop.service.ProductService;

@Controller
public class cartController {
	
	@Autowired
	private ProductService  productService;
	//添加到购物车
	@RequestMapping("/addCart")
	public String addCart(HttpServletRequest request,@RequestParam int pid,@RequestParam int count ,Model model) {
		Product product = productService.productFindByPid(pid);
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		if(loginUser==null){
			model.addAttribute("message", "对不起您还没有登录");
			return "msg";
		}
//		存进一个购物项
		CartItem cartitem = new CartItem();
		cartitem.setCount(count);
		cartitem.setProduct(product);
		cartitem.setSubtotle(count*product.getShopPrice());
//		存进购物车
		Cart cart = getCart(request);
		cart.addCart(cartitem);
		return "cart";
	}
//	查看我的购物车
	@RequestMapping("/myCart")
	public String myCart(HttpServletRequest request,Model model){
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		if (loginUser == null) {
			model.addAttribute("message","您还没有登录！");
			return "msg";
		}
		return "cart";
	}	
//	清空购物车
	@RequestMapping("/clearCart")
	public String clearCart(HttpServletRequest request){
		Cart cart=getCart(request);
		cart.clearCart();
		return "redirect:myCart";
	}
//	删除某个购物项
	@RequestMapping("/delProFromCart")
	public String delProFromCart(@RequestParam int pid,HttpServletRequest request){
		Cart cart=getCart(request);
		cart.delProFromCart(pid);
		return "redirect:myCart";
	}
	
	
	public Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		return cart;
	}
}
