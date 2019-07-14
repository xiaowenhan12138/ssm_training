package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderInfoVo;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.bean.OrderItemVo;

public interface OrderMapper {
	/**
	 * 在订单表中插入数据
	 * @param order
	 */
	void insetOrder(Order order);
	
	/**
	 * 在订单详情表中插入数据
	 * @param orderItem
	 */
	void insertOrderItem(OrderItem orderItem);
	
	/**
	 * 查询该用户的所有订单
	 * @param userid
	 * @return
	 */
	List<OrderItemVo> getOrderItems(Integer userid);
	
	/**
	 * 查询某个订单的详情
	 * @param orderid
	 * @return
	 */
	OrderInfoVo getOrderById(Integer orderid);

	/**
	 * 获得所有订单信息
	 * @return
	 */
	List<OrderInfoVo> getAllOrders();

	Integer getAllOrdersCount();

	List<OrderInfoVo> getOrdersByPage(
			@Param("shippingStatus")Integer shippingStatus, 
			@Param("start")Integer start, 
			@Param("length")Integer length);

	/**
	 * 修改付款状态
	 * @param orderid
	 * @param paymentStatus
	 */
	void updatePaymentStatus(
			@Param("orderid")Integer orderid, 
			@Param("paymentStatus")int paymentStatus);

	/**
	 * 修改订单的发货状态
	 * @param orderid
	 * @param shippingStatus
	 */
	void updateShippingStatus(
			@Param("orderid")Integer orderid, 
			@Param("shippingStatus")Integer shippingStatus);
}






