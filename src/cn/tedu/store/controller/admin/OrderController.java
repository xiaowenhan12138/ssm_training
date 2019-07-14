package cn.tedu.store.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.OrderInfoVo;
import cn.tedu.store.common.Const;
import cn.tedu.store.service.IOrderService;

@Controller("adminOrderController")
@RequestMapping("/admin")
public class OrderController{
	
	@Resource
	private IOrderService orderService;
	
	@RequestMapping("/showOrders.do")
	public String showOrders(Integer shippingStatus) {
		if(shippingStatus==null) {
			return "admin/order-list";
		}
		
		switch (shippingStatus) {
		case Const.STATUS_AWAITING_ORDER:
			return "admin/order-list-awaiting";
		case Const.STATUS_ORDER_IN_PROCESSING:
			return "admin/order-list-processing";
		case Const.STATUS_ORDER_DISPATCHED:
			return "admin/order-list-dispatched";
		case Const.STATUS_ORDER_DELIVERED:
			return "admin/order-list-delivered";
		default:
			return "admin/order-list";
		}
	}
	
	@RequestMapping("/getAllOrders.do")
	@ResponseBody
	public Map getAllOrders(
			Integer shippingStatus, Integer draw, Integer start, Integer length){
		
		Integer recordsTotal = orderService.getAllOrdersCount();
		
		//List<OrderInfoVo> orderList = orderService.getAllOrders();
		List<OrderInfoVo> orderList = 
						orderService.getOrdersByPage(shippingStatus, start, length);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("draw", draw);
		map.put("data", orderList);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered", recordsTotal);
		return map;
	}
	
	@RequestMapping("/showOrderInfo.do")
	public String showOrderInfo(Integer orderid, Map<String, Object> map) {
		//System.out.println("查询订单详情：#" + orderid);
		OrderInfoVo orderInfoVo = orderService.getOrderById(orderid);
		map.put("orderInfo", orderInfoVo);
		return "admin/order-detail";
	}

	@RequestMapping("/printOrder.do")
	public String printOrder(Integer orderid, Map<String, Object> map) {
		OrderInfoVo orderInfoVo = orderService.getOrderById(orderid);
		map.put("orderInfo", orderInfoVo);
		
		String orderStatus = Const.getPaymentStatusName(orderInfoVo.getPaymentStatus())
							+ " "+ Const.getShippingStatusName(orderInfoVo.getShippingStatus());
		map.put("orderStatus", orderStatus);
		
		return "admin/order-print";
	}
	
	@RequestMapping("/showOrderProcess.do")
	public String showOrderProcess(Integer orderid, Map<String, Object> map) {
		OrderInfoVo orderInfoVo = orderService.getOrderById(orderid);
		map.put("orderInfo", orderInfoVo);
		return "admin/order-process";
	}
	
	@RequestMapping("/updateShippingStatus.do")
	public String updateShippingStatus(Integer orderid, Integer shippingStatus) {
		orderService.updateShippingStatus(orderid, shippingStatus);
		return "redirect:showOrderProcess.do?orderid=" + orderid;
	}
}

