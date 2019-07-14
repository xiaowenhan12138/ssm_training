package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderInfoVo;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.bean.OrderItemVo;
import cn.tedu.store.mapper.OrderMapper;
@Service
public class OrderService implements 
	IOrderService{
	@Resource
	private OrderMapper orderMapper;
	

	/**
	 * 插入订单和订单详情的数据
	 */
	public Order addOrder(Integer userid, Integer addressid, 
			List<CartVo> listCartVo) {
		
		Order order = new Order();
		order.setUserid(userid);
		order.setAddressid(addressid);
		
		//计算订单总价
		double payment = 0.0;
		for(CartVo cartVo:listCartVo){
			payment += cartVo.getPrice() * cartVo.getCount();			
		}
		order.setPayment(payment);
		orderMapper.insetOrder(order);
		
		for(CartVo cartVo:listCartVo){
			OrderItem orderItem = new OrderItem();
			orderItem.setGoodsid(cartVo.getGoodsid());
			orderItem.setUserid(userid);
			orderItem.setImage(cartVo.getImage());
			orderItem.setTitle(cartVo.getTitle());
			orderItem.setCount(cartVo.getCount());
			orderItem.setPrice(cartVo.getPrice());
			orderItem.setSpec(cartVo.getSpec());
			orderItem.setOrderid(order.getId());
			orderMapper.insertOrderItem(orderItem);
		}
		
		return order;
	}


	
	public List<OrderItemVo> getOrderItems(Integer userid) {
		//返回该用户的所有订单信息
		return orderMapper.getOrderItems(userid);
	}


	@Override
	public OrderInfoVo getOrderById(Integer orderid) {
		return orderMapper.getOrderById(orderid);
	}


	@Override
	public List<OrderInfoVo> getAllOrders() {
		return orderMapper.getAllOrders();
	}


	@Override
	public Integer getAllOrdersCount() {
		return orderMapper.getAllOrdersCount();
	}


	@Override
	public List<OrderInfoVo> getOrdersByPage(Integer shippingStatus, Integer start, Integer length) {
		return orderMapper.getOrdersByPage(shippingStatus, start, length);
	}

	/**
	 * 修改付款状态
	 */
	@Override
	public void updatePaymentStatus(Integer orderid, int paymentStatus) {
		orderMapper.updatePaymentStatus(orderid, paymentStatus);
	}



	@Override
	public void updateShippingStatus(Integer orderid, Integer shippingStatus) {
		orderMapper.updateShippingStatus(orderid, shippingStatus);
	}

}




