package cn.tedu.store.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Goods;
@Transactional
public interface IGoodsService {

	/**
	 * 查询指定分类的商品,并返回集合
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoodsByCategoryId(
			Integer categoryId,Integer offset,
			Integer count);
	
	/**
	 * 获取所有商品总数
	 */
	Integer getAllGoodsCount();
	
	/**
	 * 获取指定分类的记录数
	 * @param categoryId
	 * @return
	 */
	Integer getCount(Integer categoryId);
	
	
	/**
	 * 通过title获取商品
	 * @param title
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoodsByTitle(
			String title,
			Integer offset,
			Integer count);
	/**
	 * 获取title的记录数
	 * @param title
	 * @return
	 */
	Integer getCountByTitle(String title);
	/**
	 * 通过id获取商品信息
	 * @param id
	 * @return
	 */
	Goods getGoodsById(Integer id);
	
	/**
	 * 通过id获得商品所在系列中所有商品的规格信息
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getGoodsSeriesSpecsById(Integer id);

	void addGoods(Goods goods);

	void updateIndexImageUrl(Integer goodsId, String imageUrl);
	
}







