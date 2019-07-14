package cn.tedu.store.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.ICartService;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
	@Resource
	private ICartService cartService;
	/**
	 * 显示cart.jsp页面
	 * @return
	 */
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,
			Map<String,Object> map){
		List<CartVo> list = cartService.getAll(
				this.getUid(session));
		map.put("listCartVo",list);
		return "cart";
	}
	
	/**
	 * 将商品添加到购物车
	 * @param goodsid 商品id
	 * @param session 会话
	 * @param count 购买商品的数量
	 * @return
	 */
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(
			Integer goodsid,HttpSession session,
			int count){
		
		System.out.println("添加到购物车的商品goodsid："+goodsid);
		Cart cart =  new Cart();
		cart.setGoodsid(goodsid);
		cart.setUserid(this.getUid(session));
		cart.setCount(count);
		
		cartService.addCart(cart);
		ResponseResult<Void> rr = 
				new ResponseResult<Void>(1,"添加成功");
		
		return rr;
	}
	@RequestMapping("/deleteById.do")
	public String deleteById(Integer id){
		
		cartService.deleteByCartId(id);
		
		return "redirect:../cart/showCart.do";
	}
	@RequestMapping("/deleteByBatch.do")
	public String deleteByBatch(Integer[] ids){
		
		cartService.deleteByBatch(ids);
		return "redirect:../cart/showCart.do";
	}
	
	@RequestMapping("/updateCountById.do")
	@ResponseBody
	public ResponseResult<Void> updateCountById(
			Integer id,Integer count){
		ResponseResult<Void> rr =
				new ResponseResult<Void>(1,"修改成功");
		cartService.updateById(id, count);
		
		return rr;
	}
}







