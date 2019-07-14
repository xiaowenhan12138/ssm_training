package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
	/**
	 * 通过分类的id获取商品
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoodsByCategoryId(
			@Param("categoryId") Integer categoryId,
			@Param("offset") Integer offset,
			@Param("count") Integer count);

	/**
	 * 获取该分类的所有记录的个数
	 * @param categoryId
	 * @return
	 */
	Integer getCount(Integer categoryId);
	/**
	 * 通过title查询商品
	 * @param title  
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoodsByTitle(
			@Param("title") String title,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
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
	 * 根据商品的id，获得商品所在系列中所有商品的规格信息：商品goodsId，商品系列规格名itemType
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getGoodsSeriesSpecsById(Integer id);

	/**
	 * 获取所有商品的总数
	 */
	Integer getAllGoodsCount();

	void insert(Goods goods);

	void updateImageUrl(
			@Param("goodsId") Integer goodsId, 
			@Param("imageUrl") String imageUrl);
}






