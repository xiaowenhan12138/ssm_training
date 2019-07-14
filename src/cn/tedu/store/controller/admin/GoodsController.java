package cn.tedu.store.controller.admin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsPicture;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.common.Const;
import cn.tedu.store.service.IGoodsPictureService;
import cn.tedu.store.service.IGoodsService;

@Controller("adminGoodsController")
@RequestMapping("/admin")
public class GoodsController {

	@Resource
	private IGoodsService goodsService;

	@Resource
	private IGoodsPictureService picService;
	
	@RequestMapping("/toAddGoods.do")
	public String toAddGoods() {
		return "admin/product-add";
	}

	@RequestMapping("/addGoods.do")
	@ResponseBody
	public ResponseResult<Void> addGoods(Goods goods, HttpServletRequest request) {

		ResponseResult<Void> rr = new ResponseResult<Void>();
		
		//保存商品信息到数据库中
		goodsService.addGoods(goods);
		//System.out.println(goods);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
		String uploadRealPath = request.getServletContext().getRealPath("upload");        
		int turn = 0;
        List<GoodsPicture> picList = new ArrayList<GoodsPicture>();
		
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver =
					new CommonsMultipartResolver(
							request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile multiFile = multiRequest.getFile(
										iter.next().toString());
				//获得原始文件名
				String OriFilename = multiFile.getOriginalFilename(); 
				if (OriFilename.equals("")) {
					continue;
				} else if (multiFile != null) {
					String type = OriFilename.substring( 
										OriFilename.lastIndexOf(".") + 1, OriFilename.length());
					String newFilename = sdf.format(new Date()) + "_" + turn;
					
					if (type.equals("jpg")) {
						newFilename += ".jpg";
			        } else if (type.equals("png")) {
			        	newFilename += ".png";
			        } else if (type.equals("jpeg")) {
			        	newFilename += ".jpeg";
			        } else {
			            continue;
			        }
					
					//File.separator;
					String goodsDirRealPath = uploadRealPath + File.separator + goods.getId();
					File dir = new File(goodsDirRealPath);
					if(!dir.exists()) {
						dir.mkdirs();
					}
					
					String picRealPath = goodsDirRealPath + File.separator + newFilename;
					
					// 上传
					try {
						multiFile.transferTo(new File(picRealPath));
					} catch (IllegalStateException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					GoodsPicture pic = new GoodsPicture();
					pic.setGoodsId(goods.getId());
					
					String url = "/upload/" + goods.getId() + File.separator + newFilename;
					pic.setUrl(url);
					pic.setTurn(turn);
					turn++;
					
					pic.setFilename(OriFilename);
					picList.add(pic);
				}

			}

		}

		//将商品相关的图片信息，保存到库表中t_goods_pictures
		picService.addGoodsPicture(picList);

		//更新t_goods表中image属性，作为索引图
		goodsService.updateIndexImageUrl(goods.getId(), picList.get(0).getUrl());
		
		rr.setState(Const.SUCCESS);
		rr.setMessage("上传成功");
		return rr;
	}

	@RequestMapping("/showGoods.do")
	public String showGoods() {
		return "admin/product-list";
	}

	@RequestMapping("/getAllGoods.do")
	@ResponseBody
	public Map getAllGoods(Integer draw, Integer start, Integer length) {

		Integer recordsTotal = goodsService.getAllGoodsCount();

		List<Goods> list = goodsService.getGoodsByTitle("", start, length);
		System.out.println(list);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("draw", draw);
		map.put("data", list);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered", recordsTotal);
		return map;
	}
}
