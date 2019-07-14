package cn.tedu.store.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.bean.GoodsPicture;
import cn.tedu.store.bean.ProductCount;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsPictureService;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	IGoodsService goodsService;
	
	@Resource
	IGoodsCategoryService goodsCategoryService;

	@Resource
	IGoodsPictureService goodsPictureService;
	
	@RequestMapping("/showGoods.do")
	public String showGoods(
			Integer categoryId,Integer page,
			Map<String,Object> map){
		
		if(page==null){
			page = 1;
		}
		
		//通过page计算偏移量
		int offset = (page-1)*ProductCount.COUNT;
		List<Goods> listGoods = goodsService.
				getGoodsByCategoryId(
				categoryId, offset, ProductCount.COUNT);
		
		Integer count = goodsService.getCount(categoryId);
		
		Integer pageSize = 
				count%ProductCount.COUNT==0?
						count/ProductCount.COUNT:
						count/ProductCount.COUNT+1;
		
		//查询categoryId对应的类别名
		GoodsCategory goodsCategory = goodsCategoryService.getGoodsCategoryById(categoryId);
		String categoryName = goodsCategory.getName();
		
		//设置页面的记录数
		map.put("currentPage",page);
		map.put("count",count);
		map.put("listGoods",listGoods);
		map.put("pageSize",pageSize);
		map.put("categoryId",categoryId);
		map.put("categoryName", categoryName);
		return "search";
	}

	@RequestMapping("/showGoodsByTitle.do")
	public String showGoodsByTitle(
			String title,
			Integer page,
			Map<String,Object> map){
		if(page==null){
			page = 1;
		}
		
		Integer offset = (page-1)*ProductCount.COUNT;
		List<Goods> listGoods=
				goodsService.getGoodsByTitle(
				title, offset, ProductCount.COUNT);
		Integer count = goodsService.getCountByTitle(title);
		Integer pageSize = 
				count%ProductCount.COUNT==0?
						count/ProductCount.COUNT:
						count/ProductCount.COUNT+1;
		map.put("listGoods",listGoods);
		map.put("title",title);
		map.put("pageSize",pageSize);
		map.put("count",count);
		map.put("currentPage",page);
		
		return "search";
	}
	
	@RequestMapping("/showGoodsInfo.do")
	public String showGoodsInfo(Integer id,
			Integer categoryId,
			Map<String,Object> map){
		
		//获得商品信息
		Goods goods = goodsService.getGoodsById(id);
		System.out.println(goods);
		
		//获得商品左侧商品介绍图片
		List<GoodsPicture> listPic = goodsPictureService.getGoodsPictures(id);
		//System.out.println(listPic);
		
		//获得推荐商品
		List<Goods> listGoods=
				goodsService.getGoodsByCategoryId(categoryId, 0, 4);
		
		//通过id获得商品所在系列中 所有商品的规格信息
		List<Map<String, Object>> listGoodsSeriesSpecs= 
				goodsService.getGoodsSeriesSpecsById(id);
		//System.out.println(listGoodsSeriesInfo);
		
		map.put("categoryId", categoryId);
		map.put("goods",goods);
		map.put("listGoods", listGoods);
		map.put("listSeries", listGoodsSeriesSpecs);
		map.put("listPic", listPic);
		return "product_details";
	}
	
}










