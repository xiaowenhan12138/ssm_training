package cn.tedu.store.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IGoodsCategoryService;

@Controller("adminGoodsCategoryController")
@RequestMapping("/admin")
public class GoodsCategoryController {

	@Resource
	private IGoodsCategoryService goodsCategoryService;
	
	@RequestMapping("/getCategoryByParentId.do")
	@ResponseBody
	public ResponseResult<List<GoodsCategory>> getCategoryByParentId( Integer parentId ){
		ResponseResult<List<GoodsCategory>> rr;
		List<GoodsCategory> list = goodsCategoryService.getGoodsCategoryByParentId(parentId, null, null);
		
		rr = new ResponseResult<List<GoodsCategory>>();
		rr.setState(1);
		rr.setMessage("获取数据成功");
		rr.setData(list);
		
		return rr;
	}

}





