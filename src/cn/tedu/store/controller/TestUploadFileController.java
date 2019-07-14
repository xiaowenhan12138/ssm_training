package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class TestUploadFileController {
	@RequestMapping("/showUpload.do")
	public String showUplaod(){
		return "upload";
	}
	@RequestMapping("/goUpload.do")
	public String goUpload(MultipartFile file) throws IllegalStateException, IOException{
		//获取上传文件的名字
		String fileName = file.getOriginalFilename();
		System.out.println("FileName:"+fileName);
		
		File f = new File("d:/",fileName);
		//上传文件
		file.transferTo(f);
		
		return "index";
	}

}





