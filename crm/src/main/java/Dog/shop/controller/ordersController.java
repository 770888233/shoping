package Dog.shop.controller;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Select;
import org.ietf.jgss.Oid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import Dog.shop.ben.Cart;
import Dog.shop.ben.CartItem;
import Dog.shop.ben.Orderitem;
import Dog.shop.ben.Orders;
import Dog.shop.ben.User;
import Dog.shop.service.OrdersService;
import Utils.PageBean;

@Controller
public class ordersController {
	@Autowired
	private OrdersService ordersService;
	@RequestMapping("/toOrder")
	public String myOrder(HttpServletRequest request,Model model) {
		Orders orders = new Orders();
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		if(loginUser==null){
			model.addAttribute("message", "对不起您还没有登录");
			return "msg";
		}
//		0表示没有付款、1表示已付款即将发货 2表示确认收货 3表示交易成功
		orders.setState(0);
		orders.setOrderTime(new Date());
		orders.setUid(loginUser.getUid());
		orders.setMoney(cart.getTotale());
		ordersService.toOrder(orders);
		
		Map<Integer, CartItem> cartItems = cart.getCartItem();
		for (Entry<Integer, CartItem> entry : cartItems.entrySet()) {
			CartItem cartItem = entry.getValue();
			Orderitem orderitem = new Orderitem();
			orderitem.setProduct(cartItem.getProduct());
			orderitem.setCount(cartItem.getCount());
			orderitem.setPid(cartItem.getProduct().getPid());
			orderitem.setSubtotal(cartItem.getSubtotle());
			orderitem.setOid(orders.getOid());
			orders.getOiList().add(orderitem);
			ordersService.toOrderItem(orderitem);
		}
		cart.clearCart();
		request.getSession().setAttribute("orders", orders);
		return "order";
	}
	// 查询我的订单
	@RequestMapping(value="/myOrder")
	public String myOrder(@RequestParam int page, Model model,HttpServletRequest request){
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		PageBean<Orders> pageBean = ordersService.findOrderByUidAndPage(page,loginUser.getUid());
		model.addAttribute("pageBean", pageBean);
		return "orderList";
	}
  //payOrderAganin
	@RequestMapping("/payOrderAganin")
	public String payOrderAganin(@RequestParam int oid,HttpServletRequest request){
		Orders noPayOrder = ordersService.findOrderByOid(oid);
		request.getSession().setAttribute("orders", noPayOrder);
		return "order";
	}
	// 为订单付款
	@RequestMapping("/payOrder")
	public String payOrder(Orders orders,@RequestParam String receiveInfo,@RequestParam String phoNum,@RequestParam String accepter){
		orders.setReceiveinfo(receiveInfo);
		orders.setPhonum(phoNum);
		orders.setAccepter(accepter);
		ordersService.payOrder(orders);
		return "redirect:myOrder?page=1";
	}
	// 确认收货
			@RequestMapping("/updateState")
			public String updateState(@RequestParam int oid ) throws Exception {
				ordersService.updateOrderStatus(oid, 3);
				return "redirect:myOrder?page=1";
			}

	
}
