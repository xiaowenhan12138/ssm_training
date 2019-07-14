package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private IGoodsCategoryService goodsCategoryService;
	@Resource
	private IGoodsService goodsService;
	
	@RequestMapping("/showIndex.do")
	public String showIndex(Map<String,Object> map){
		
		//办公电脑 /1F
		//查询编号是161类别下，所有商品类
		/*//161类别的信息如下：
		mysql> select * from t_goods_category where id=161;
		+-----+-----------+-----------------+--------+------------+-----------+---------------------+---------------------+--------------+---------------+
		| id  | parent_id | name            | status | sort_order | is_parent | created_time        | modified_time       | created_user | modified_user |
		+-----+-----------+-----------------+--------+------------+-----------+---------------------+---------------------+--------------+---------------+
		| 161 | 0         | 电脑、办公 | 1      | 3          | 1         | 2017-10-25 15:00:55 | 2017-10-25 15:00:55 | admin        | admin         |
		+-----+-----------+-----------------+--------+------------+-----------+---------------------+---------------------+--------------+---------------+
		
		//list1中存放的是以下类别的前三个
		mysql> select * from t_goods_category where parent_id=161;
		+-----+-----------+---------------+--------+------------+-----------+---------------------+---------------------+--------------+---------------+
		| id  | parent_id | name          | status | sort_order | is_parent | created_time        | modified_time       | created_user | modified_user |
		+-----+-----------+---------------+--------+------------+-----------+---------------------+---------------------+--------------+---------------+
		| 162 | 161       | 电脑整机  | 1      | 1          | 1         | 2017-10-25 15:00:55 | 2017-10-25 15:00:55 | admin        | admin         |
		| 171 | 161       | 电脑配件  | 1      | 2          | 1         | 2017-10-25 15:00:55 | 2017-10-25 15:00:55 | admin        | admin         |
		| 186 | 161       | 外设产品  | 1      | 3          | 1         | 2017-10-25 15:00:55 | 2017-10-25 15:00:55 | admin        | admin         |
		| 202 | 161       | 网络产品  | 1      | 4          | 1         | 2017-10-25 15:00:55 | 2017-10-25 15:00:55 | admin        | admin         |
		| 210 | 161       | 办公设备  | 1      | 5          | 1         | 2017-10-25 15:00:55 | 2017-10-25 15:00:55 | admin        | admin         |
		| 229 | 161       | 文具/耗材 | 1      | 6          | 1         | 2017-10-25 15:00:55 | 2017-10-25 15:00:55 | admin        | admin         |
		| 244 | 161       | 服务产品  | 1      | 7          | 1         | 2017-10-25 15:00:55 | 2017-10-25 15:00:55 | admin        | admin         |
		+-----+-----------+---------------+--------+------------+-----------+---------------------+---------------------+--------------+---------------+
		*/
		List<GoodsCategory> list1=
				goodsCategoryService.
					getGoodsCategoryByParentId(161,0, 3);

		
		//将162、171、186这三个类别 的子类别，保存到list2中
		List<List<GoodsCategory>> list2 = new ArrayList<List<GoodsCategory>>();
		for(GoodsCategory c: list1){
			List<GoodsCategory> goodsCategoryList = 
					goodsCategoryService.getGoodsCategoryByParentId(c.getId(),null,null);
			list2.add( goodsCategoryList );
		}
		
		//查询163类别下所有商品
		List<Goods> listGoods = goodsService.getGoodsByCategoryId(163,0,3);
		
		//把页面需要的数据集合,设置到map对象中
		map.put("list1",list1);
		map.put("list2",list2);
		map.put("listGoods",listGoods);
		
		
		//办公文具/2F
		/*
		List<GoodsCategory> lf2list1=
				goodsCategoryService.
					getGoodsCategoryByParentId(229,0, 3);
		*/
		List<GoodsCategory> lf2list1 = new ArrayList<GoodsCategory>();
		lf2list1.add(goodsCategoryService.getGoodsCategoryById(229));
		lf2list1.add(goodsCategoryService.getGoodsCategoryById(210));
		lf2list1.add(goodsCategoryService.getGoodsCategoryById(202));

		List<List<GoodsCategory>> lf2list2 = new ArrayList<List<GoodsCategory>>();
		for(GoodsCategory c: lf2list1){
			List<GoodsCategory> goodsCategoryList = 
					goodsCategoryService.getGoodsCategoryByParentId(c.getId(),0,13);
			lf2list2.add( goodsCategoryList );
		}
		
		List<Goods> lf2listGoods = goodsService.getGoodsByCategoryId(238,0,3);
		
		map.put("lf2list1", lf2list1);
		map.put("lf2list2", lf2list2);
		map.put("lf2listGoods", lf2listGoods);
		
		return "index";
		
		
	}

}





