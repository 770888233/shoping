package Dog.shop.service;

import Dog.shop.ben.Orderitem;
import Dog.shop.ben.Orders;
import Utils.PageBean;

public interface OrdersService {

	void toOrder(Orders orders);

	void toOrderItem(Orderitem orderitem);

	PageBean<Orders> findOrderByUidAndPage(int page, Integer uid);

	void payOrder(Orders orders);

	Orders findOrderByOid(int oid);

	PageBean<Orders> findAllOrderByStateAndPage(int page);

	void updateOrderStatus(int oid, int status);

	PageBean<Orders> findAllOrderByStateAndPage(int state, int page);



}
