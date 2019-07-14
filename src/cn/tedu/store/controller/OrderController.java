package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderInfoVo;
import cn.tedu.store.bean.OrderItemVo;
import cn.tedu.store.common.Const;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IOrderService;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{
	
	@Resource
	private ICartService cartService;
	@Resource
	private IAddressService addressService;
	@Resource
	private IOrderService orderService;
	
	// 源页面地址：http://127.0.0.1:8080/tedustore/cart/showCart.do
	// 购物车页面，点击 去结算 按钮
	/**
	 * 下单结账，显示订单确认页面
	 * @param session
	 * @param ids 购物车中选中的商品
	 * @param map 用于向页面传递的集合 
	 * @return "orderConfirm"，打开确认订单信息 页面，用于确认地址和已选购商品情况
	 */
	@RequestMapping("/showOrderConfirm.do")
	public String showOrderConfirm(
				HttpSession session,
				Integer[] ids,
				Map<String,Object> map){
		System.out.println("order/showOrderConfirm.do = showOrderConfirm >> orderConfirm.jsp");
		
		//获取商品信息的集合
		List<CartVo> listCartVo = 
				cartService.getOrderByUserid(
				this.getUid(session), ids);
		
		//获取地址信息的集合
		List<Address> listAddress =
				addressService.getAllAddessByUid(
						this.getUid(session));
		
		session.setAttribute("listCartVo",listCartVo);
		
		map.put("listCartVo",listCartVo);
		map.put("listAddress",listAddress);
		
		return "orderConfirm";
	}
	
	
	// 源页面地址：http://127.0.0.1:8080/tedustore/order/showOrderConfirm.do?ids=68,69
	// 在确认订单信息页面中，点击了“确认并付款”按钮
	/**
	 * @param session
	 * @param addressid 用户在页面中选择的收货地址
	 * @return "payment" 进入了 支付订单 页面（等待选择银行确认支付）
	 */
	@RequestMapping("/showPayment.do")
	public String showPayment(HttpSession session, Integer addressid){
		
		System.out.println("/order/showPayment.do = showPayment >> payment.jsp");
		
		Integer userid = this.getUid(session);
		List<CartVo> listCartVo=
				(List<CartVo>)session.getAttribute("listCartVo");
		
		Order order = orderService.addOrder(userid, addressid, listCartVo);
		session.setAttribute("order", order);
		
		//清空购物车中已经下完订单的商品
		List<Integer> listIds = new ArrayList<Integer>();
		for(CartVo vo : listCartVo ) {
			listIds.add( vo.getId() );
		}
		Integer[] ids = {};
		ids = listIds.toArray(ids);
		cartService.deleteByBatch(ids);
		
		return "payment";
	}
	
	
	// 源页面地址：http://127.0.0.1:8080/tedustore/order/showPayment.do
	// 在支付订单页面中，并选择了银行后，点击了 确认支付 按钮
	/**
	 * 
	 * @param session
	 * @return "pay_success" 支付成功页面
	 */
	@RequestMapping("/pay.do")
	public String pay(HttpSession session, Map<String, Object> map){
		
		System.out.println("/order/pay.do = pay >> pay_success.jsp");

		Order order = (Order)session.getAttribute("order");
		//修改订单付款状态为：付款成功
		orderService.updatePaymentStatus(order.getId(), Const.STATUS_PAYMENT_COMPLETED);
		map.put("orderid", order.getId());
		map.put("payment", order.getPayment());
		
		//从session中移除order
		session.removeAttribute("order");
		
		return "pay_success";
	}
	

	@RequestMapping("/showOrderItem.do")
	public String showOrderItem(
			HttpSession session,
			Map<String,List<OrderItemVo>> map){
		
		System.out.println("/order/showOrderItem.do = showOrderItem >> orders.jsp");
		
		List<OrderItemVo> listItems = 
				orderService.getOrderItems(
				this.getUid(session));
		map.put("listItems",listItems);
		
		return "orders";
	}
	
	
	@RequestMapping("/showOrderInfo.do")
	public String showOrderInfo(Integer orderid, Map<String, Object> map) {
		//System.out.println("查询订单详情：#" + orderid);
		OrderInfoVo orderInfoVo = orderService.getOrderById(orderid);
		map.put("orderInfo", orderInfoVo);
		
		String orderStatus = Const.getPaymentStatusName(orderInfoVo.getPaymentStatus())
				+ " "+ Const.getShippingStatusName(orderInfoVo.getShippingStatus());
		map.put("orderStatus", orderStatus);
		
		return "orderInfo";
	}
	
	@RequestMapping("/confirmReceived.do")
	public String confirmReceived(Integer orderid) {
		orderService.updateShippingStatus(orderid, Const.STATUS_ORDER_DELIVERED);
		return "redirect:showOrderInfo.do?orderid=" + orderid;
	}
	
	@RequestMapping("/cancelOrder.do")
	public String cancelOrder(Integer orderid) {
		orderService.updateShippingStatus(orderid, Const.STATUS_ORDER_CANCELED);
		return "redirect:showOrderItem.do";
	}
	
}

