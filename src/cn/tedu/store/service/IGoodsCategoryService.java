package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.GoodsCategory;
@Transactional
public interface IGoodsCategoryService {
	/**
	 * 查询商品分类
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<GoodsCategory> 
	getGoodsCategoryByParentId(Integer parentId,
			Integer offset,Integer count);

	
	/**
	 * 查询某个商品类名
	 * @param id
	 * @return
	 */
	GoodsCategory getGoodsCategoryById(Integer id);
}





