package cn.tedu.store.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;
@Service
public class GoodsService implements IGoodsService {

	@Resource
	private GoodsMapper goodsMapper;
	
	public List<Goods> getGoodsByCategoryId(Integer categoryId, Integer offset, Integer count) {
		
		return goodsMapper.getGoodsByCategoryId(categoryId, offset, count);
	}
	/**
	 * 获取指定分类的记录数
	 */
	public Integer getCount(Integer categoryId){
		return goodsMapper.getCount(categoryId);
	}
	public List<Goods> getGoodsByTitle(
			String title,
			Integer offset,
			Integer count){
		return goodsMapper.getGoodsByTitle(title, offset, count);
	}
	/**
	 * 获取记录数
	 */
	public Integer getCountByTitle(String title){
		return goodsMapper.getCountByTitle(title);
	}
	/**
	 * 通过获取商品信息
	 */
	public Goods getGoodsById(Integer id){
		return goodsMapper.getGoodsById(id);
	}
	
	
	public List<Map<String, Object>> getGoodsSeriesSpecsById(Integer id) {
		return goodsMapper.getGoodsSeriesSpecsById(id);
	}
	
	@Override
	public Integer getAllGoodsCount() {
		return goodsMapper.getAllGoodsCount();
	}
	@Override
	public void addGoods(Goods goods) {
		goodsMapper.insert(goods);
	}
	@Override
	public void updateIndexImageUrl(Integer goodsId, String imageUrl) {
		goodsMapper.updateImageUrl(goodsId, imageUrl);
	}
}








