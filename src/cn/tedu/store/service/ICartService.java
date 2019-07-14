package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
@Transactional
public interface ICartService {
	/**
	 * 添加cart信息到数据库
	 * @param cart
	 */
	void addCart(Cart cart);
	
	/**
	 * 查询指定用户的商品信息
	 * @param id
	 * @return
	 */
	List<CartVo> getAll(Integer id);
	/**
	 * 删除t_cart(购物车)中的商品信息
	 * @param id
	 */
	void deleteByCartId(Integer id);
	
	/**
	 * 批量删除商品数据
	 * @param ids
	 */
	void deleteByBatch(Integer [] ids);
	
	/**
	 * 通过id修改商品的数量
	 * @param id
	 * @param count
	 */
	void updateById(Integer id,Integer count);
	/**
	 * 返回确认购买的商品的集合
	 * @param userid
	 * @param id
	 * @return
	 */
	List<CartVo> getOrderByUserid(
			Integer userid,Integer[] id);
	
}



