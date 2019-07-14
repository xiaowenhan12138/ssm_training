package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.GoodsCategory;

public interface GoodsCategoryMapper {

	/**
	 * 通过parentId查询子分类
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<GoodsCategory> 
	getGoodsCategoryByParentId(
		@Param("parentId") Integer parentId,
		@Param("offset") Integer offset,
		@Param("count") Integer count);

	/**
	 * 通过id查询某个分类
	 * @param id
	 * @return
	 */
	GoodsCategory getGoodsCategoryById(
					@Param("id")Integer id);
}








