package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

public interface CartMapper {
	/**
	 * 添加数据
	 * @param cart
	 */
	void insert(Cart cart);
	/**
	 * 查询指定用户的购物车,并返回集合
	 * @param userid
	 * @return
	 */
	List<Cart> getCartByUserid(Integer userid);
	/**
	 * 根据商品id和用户id修改数量count
	 * @param cart
	 */
	void update(Cart cart);
	/**
	 * 通过userid查询当前用户的购物车的商品信息
	 * @param userid
	 * @return
	 */
	List<CartVo> selectAll(Integer userid);
	/**
	 * 删除t_cart表中的商品记录
	 * @param id
	 */
	void deleteByCartId(Integer id);
	
	/**
	 * 批量删除数据
	 * @param ids
	 */
	void deleteByBatch(Integer[] ids);
	/**
	 * 通过id修改商品的数量
	 * @param id
	 * @param count
	 */
	void updateById(@Param("id") Integer id,
			 @Param("count") Integer count);
}










