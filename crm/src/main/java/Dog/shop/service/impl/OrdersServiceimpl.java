package Dog.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dog.shop.ben.Orderitem;
import Dog.shop.ben.Orders;
import Dog.shop.ben.OrdersExample;
import Dog.shop.mapper.OrderitemMapper;
import Dog.shop.mapper.OrdersMapper;
import Dog.shop.service.OrdersService;
import Utils.PageBean;
@Service
public class OrdersServiceimpl implements OrdersService {
	
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private OrderitemMapper orderitemMapper;
	
	@Override
	public void toOrder(Orders orders) {
		// TODO Auto-generated method stub
		ordersMapper.insert(orders);
		
	}

	@Override
	public void toOrderItem(Orderitem orderitem) {
		// TODO Auto-generated method stub
		orderitemMapper.insert(orderitem);
		
	}
	@Override
	public Orders findOrderByOid(int oid) {
		return ordersMapper.selectByPrimaryKey(oid);
		
	}

	@Override
	public PageBean<Orders> findOrderByUidAndPage(int page, Integer uid){
		PageBean<Orders> pageBean = new PageBean<>();
//		设置这是第几页
		pageBean.setPage(page);
//		设置10个
		int limitPage =4;
		pageBean.setLimitPage(limitPage);
//		设置一共多少页
		int totlePage = 0;
//		查询一共有多少页
		totlePage = ordersMapper.countOrdersByUid(uid);
		if(Math.ceil(totlePage % limitPage)==0){
			totlePage=totlePage / limitPage;
		}else{
			totlePage=totlePage / limitPage+1;
		}
		pageBean.setTotlePage(totlePage);
		int beginPage= (page-1)*limitPage;
//		商品集合
		List<Orders> list = ordersMapper.findOrderByUidAndPage(uid,beginPage,limitPage);
		pageBean.setList(list);
		return pageBean;
	}

	//提交订单
	@Override
	public void payOrder(Orders orders){
		Orders payOrder = ordersMapper.selectByPrimaryKey(orders.getOid());
		if(orders.getReceiveinfo()!=null && orders.getPhonum()!=null){
			System.out.println("id得值"+ordersMapper.selectByPrimaryKey(orders.getOid()));
			payOrder.setReceiveinfo(orders.getReceiveinfo());
			payOrder.setPhonum(orders.getPhonum());
			payOrder.setAccepter(orders.getAccepter());
			payOrder.setState(1);
			
		}
		ordersMapper.updateByPrimaryKeySelective(payOrder);
	}

	@Override
	public PageBean<Orders> findAllOrderByStateAndPage(int page){
		PageBean<Orders> pageBean = new PageBean<>();
//		设置这是第几页
		pageBean.setPage(page);
//		设置10个
		int limitPage = 4;
		pageBean.setLimitPage(limitPage);
//		设置一共多少页
		int totlePage = 0;
//		查询一共有多少页
		totlePage = ordersMapper.countAllOrders();
		if(Math.ceil(totlePage % limitPage)==0){
			totlePage=totlePage / limitPage;
		}else{
			totlePage=totlePage / limitPage+1;
		}
		pageBean.setTotlePage(totlePage);
		int beginPage= (page-1)*limitPage;
		//商品集合
		List<Orders> list = ordersMapper.findAllOrderByPage(beginPage,limitPage);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void updateOrderStatus(int oid, int status) {
		Orders payOrder = ordersMapper.selectByPrimaryKey(oid);
		payOrder.setState(status); 
		ordersMapper.updateByPrimaryKeySelective(payOrder);
	}

	@Override
	public PageBean<Orders> findAllOrderByStateAndPage(int state,int page){
		PageBean<Orders> pageBean = new PageBean<>();
//		设置这是第几页
		pageBean.setPage(page);
//		设置10个
		int limitPage =4;
		pageBean.setLimitPage(limitPage);
//		设置一共多少页
		int totlePage = 0;
//		查询一共有多少页
		totlePage = ordersMapper.countOrdersByState(state);
		
		if(Math.ceil(totlePage % limitPage)==0){
			totlePage=totlePage / limitPage;
		}else{
			totlePage=totlePage / limitPage+1;
		}
		pageBean.setTotlePage(totlePage);
		int beginPage= (page-1)*limitPage;
		//商品集合
		List<Orders> list = ordersMapper.findAllOrderByStateAndPage(state, beginPage, limitPage) ;
		pageBean.setList(list);
		return pageBean;
	}

	

	

}
