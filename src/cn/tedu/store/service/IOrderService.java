package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderInfoVo;
import cn.tedu.store.bean.OrderItemVo;
@Transactional
public interface IOrderService {

	
	/**
	 * 完成订单和订单详情的插入
	 * @param userid
	 * @param addressid
	 * @param listCartVo
	 */
	Order addOrder(
			Integer userid, 
			Integer addressid, 
			List<CartVo> listCartVo);
		
	

	/**
	 * 查询该用户的所有订单信息
	 * @param userid
	 * @return
	 */
	List<OrderItemVo> getOrderItems(Integer userid);


	/**
	 * 根据订单id，查询出该订单的详情（订单信息，收货信息，条目信息）
	 * @param orderid
	 * @return
	 */
	OrderInfoVo getOrderById(Integer orderid);


	List<OrderInfoVo> getAllOrders();


	Integer getAllOrdersCount();


	List<OrderInfoVo> getOrdersByPage(Integer shippingStatus, Integer start, Integer length);


	/**
	 * 修改付款状态
	 * @param id
	 * @param paymentStatus
	 */
	void updatePaymentStatus(Integer id, int paymentStatus);



	void updateShippingStatus(Integer orderid, Integer shippingStatus);

	
}







