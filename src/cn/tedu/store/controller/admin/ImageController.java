package cn.tedu.store.controller.admin;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.KindEditorResult;

/**
 * 图片上传Controller
 * 
 * @date 2017年9月22日
 */
@Controller
@RequestMapping("/image")
public class ImageController {
 
	/**
	 * 上传图片
	 */
	@RequestMapping("/uploadImg.do")
	public @ResponseBody KindEditorResult uploadImg(
					HttpServletRequest request,
					@RequestParam("imgFile") MultipartFile imgFile) {
		
		KindEditorResult result = new KindEditorResult();
		
		try {
			// 获取绝对路径
			String realpath = request.getServletContext().getRealPath("/upload");

			// 上传文件
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			Random rd = new Random();
			String newFilename = sdf.format(new Date()) + "_" 
									+ rd.nextInt(9000) + "_" 
									+ imgFile.getOriginalFilename();
			imgFile.transferTo(new File(realpath, newFilename));
			
			result.setError(0);
			result.setUrl(request.getServletContext().getContextPath() 
							+ "/upload/" + newFilename);	
		} catch (Exception e) {
			result.setError(1);
			result.setMessage("上传图片出错！");
		}
		
		return result;
	}
}
