package Dog.shop.mapper;

import Dog.shop.ben.Orders;
import Dog.shop.ben.OrdersExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OrdersMapper {
    int countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
//	查询一共有多少页
	int countOrdersByUid(Integer uid);
//  全部订单数
	int countAllOrders();

	List<Orders> findAllOrderByPage(int beginPage, int limitPage);
//	商品集合
	List<Orders> findOrderByUidAndPage(Integer uid, int beginPage, int limitPage);

	int countOrdersByState(int state);

	List<Orders> findAllOrderByStateAndPage(int state, int beginPage, int limitPage);
}