package cn.tedu.store.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.mapper.CartMapper;
@Service
public class CartService implements ICartService{
	
	@Resource
	private CartMapper cartMapper;
	
	/**
	 * 将新加入购物车的商品，添加到数据库中
	 * @param cart 包含新加入商品的购物车
	 */
	public void addCart(Cart cart) {
		//获得数据库中用户对应的购物车
		List<Cart> listCart = 
				cartMapper.getCartByUserid(cart.getUserid());
		
		//循环判断用户的购物车中原先的商品，和新加入的商品是否有一样的
		//		有一样的，更新商品的数量
		for(Cart c : listCart){
			if( c.getGoodsid().equals(cart.getGoodsid()) ){
				Integer quantity = cart.getCount()+c.getCount();
				cart.setCount(quantity);
				cartMapper.update(cart);
				return ;
			}
		}
		
		//添加的商品是新商品，直接保存到数据库中
		cartMapper.insert(cart);
	}
	
	/**
	 * 根据userId，获取商品信息
	 */
	public List<CartVo> getAll(Integer userId){
		return cartMapper.selectAll(userId);
	}
	
	/**
	 * 删除购物车中的商品信息
	 */
	public void deleteByCartId(Integer id) {
		cartMapper.deleteByCartId(id);
		
	}
	
	/**
	 * 批量删除数据
	 * @param ids 其中的id是指cart表中的id
	 */
	public void deleteByBatch(Integer[] ids){
		cartMapper.deleteByBatch(ids);
	}
	
	/**
	 * 通过id修改商品的数量
	 */
	public void updateById(Integer id, Integer count) {
		cartMapper.updateById(id, count);
		
	}
	
	/**
	 * 返回购买商品的集合
	 */
	public List<CartVo> getOrderByUserid(
			Integer userid,Integer[] ids){
		
		//选中的商品的集合
		List<CartVo> newList = new ArrayList<CartVo>();
		
		//返回购物车的所有商品信息
		List<CartVo> list = cartMapper.selectAll(userid);
		
		for(CartVo cartVo:list){
			for(Integer id:ids){
				if(cartVo.getId()==id){
					newList.add(cartVo);
					break;
				}
			}
		}
		return newList;
	}

}






