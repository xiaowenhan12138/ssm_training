package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IDictService;

@Controller
@RequestMapping("/dict")
public class DictController {
	@Resource
	private IDictService dictService;

	@RequestMapping("/showProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> showProvince() {
		ResponseResult<List<Province>> rr;
		List<Province> listp = dictService.getProvinces();
		rr = new ResponseResult<List<Province>>();
		rr.setState(1);
		rr.setMessage("获取数据成功");
		rr.setData(listp);
		return rr;
	}

	@RequestMapping("/showCity.do")
	@ResponseBody
	public ResponseResult<List<City>> showCity(String provinceCode) {
		ResponseResult<List<City>> rr;
		List<City> listC = dictService.getCities(provinceCode);
		rr = new ResponseResult<List<City>>();
		rr.setState(1);
		rr.setMessage("获取数据成功");
		rr.setData(listC);
		return rr;
	}

	@RequestMapping("/showArea.do")
	@ResponseBody
	public ResponseResult<List<Area>> showArea(String cityCode) {
		ResponseResult<List<Area>> rr;
		List<Area> listA = dictService.getAreas(cityCode);

		rr = new ResponseResult<List<Area>>();
		rr.setData(listA);
		rr.setState(1);
		rr.setMessage("获取数据成功");
		return rr;
	}

}
