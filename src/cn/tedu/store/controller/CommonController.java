package cn.tedu.store.controller;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.common.Const;

@Controller
@RequestMapping("/common")
public class CommonController {

	@RequestMapping("/getConsts.do")
	@ResponseBody
	public ResponseResult getConsts() {
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("PAGE_SIZE", Const.PAGE_SIZE);
//		map.put("SUCCESS", Const.SUCCESS);
//		map.put("paymentStatusArray", Const.paymentStatusArray);
//		map.put("shippingStatusArray", Const.shippingStatusArray);
		
		//利用反射直接取出Const类中系统定义的常量
		try {
			Field[] fields = Const.class.getDeclaredFields();
			for( Field f : fields ) {
				map.put(f.getName(), f.get(null));
			}
		} catch (Exception e) {
		}
		
		ResponseResult rr = new ResponseResult(1, "ok", map);
		return rr;
	}
}
