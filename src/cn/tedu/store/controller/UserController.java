package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.common.Const;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExistException;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource
	private IUserService userService;
	/**
	 * 上传图片
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/uploadImage.do")
	@ResponseBody
	public ResponseResult<Void> uploadImage(
			MultipartFile file,
			HttpSession session) throws IllegalStateException, IOException{
		System.out.println("uploadImage");
		ResponseResult<Void> rr = 
				new ResponseResult<Void>(1,"上传成功");
		
		//获取服务器的真实路径
		String contextPath = session.getServletContext()
							.getRealPath("/upload");
		String path = contextPath+"/"+file.getOriginalFilename();
		System.out.println(path);
		
		//上传 文件到指定的路径
		file.transferTo(new File(path));
		
		//修改数据
		userService.updateImageById(
			this.getUid(session), "/upload/"+file.getOriginalFilename());
		
		return rr;
	}
	
	/**
	 * 显示注册画面
	 * @return
	 */
	@RequestMapping("/showRegister.do")
	public String showRegister(){
		return "register";
	}
	
	/**
	 * 显示登录画面
	 * @return
	 */
	@RequestMapping("/showLogin.do")
	public String showLogin(){
		return "login";
	}
	/**
	 * 显示修改密码页面
	 * @return
	 */
	@RequestMapping("/showPassword.do")
	public String showPassword(){
		return "password";
	}
	/**
	 * 显示个人信息的页面
	 * @return
	 */
	@RequestMapping("/showPerson.do")
	public String showPerson(){
		return "person";
	}

	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username){
		ResponseResult<Void> rr;
		//如果返回true,表示用户名存在,
		//如果返回false,表示用户名不存在
		if(userService.checkUsernameHasExist(username)){
			rr = new ResponseResult<Void>(0,"用户名已经存在");
		}else{
			rr = new ResponseResult<Void>(1,"用户名可以使用");
		}
		return rr;
	}
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){
		ResponseResult<Void> rr;
		//如果返回true,表示用户名存在,
		//如果返回false,表示用户名不存在
		if(userService.checkEmail(email)){
			rr = new ResponseResult<Void>(0,"邮箱已经存在");
		}else{
			rr = new ResponseResult<Void>(1,"邮箱可以使用");
		}
		return rr;
	}
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){
		ResponseResult<Void> rr;
		//如果返回true,表示用户名存在,
		//如果返回false,表示用户名不存在
		if(userService.checkPhone(phone)){
			rr = new ResponseResult<Void>(0,"电话号码已经存在");
		}else{
			rr = new ResponseResult<Void>(1,"电话号码可以使用");
		}
		return rr;
	}
	
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(
		@RequestParam("uname") String username,
		@RequestParam("upwd") String password,
		String email,String phone){
		
		ResponseResult<Void> rr;
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		//set方法给User对象赋值
		try{
			userService.register(user);
			rr = new ResponseResult<Void>(1,"注册成功");
		}catch(UsernameAlreadyExistException e){
			rr = new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(
			String username,String password,HttpSession session){
		ResponseResult<Void> rr;
		try{
			User user = userService.login(username, password);
			session.setAttribute("user",user);
			rr = new ResponseResult<Void>(1,"登录成功");
		}catch(UserNotFoundException e){
			rr = new ResponseResult<Void>(0,e.getMessage());
		}catch(PasswordNotMatchException e){
			rr = new ResponseResult<Void>(-1,e.getMessage());
		}
		return rr;
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:../main/showIndex.do";
	}
	
	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> updatePassword(
			HttpSession session,
			String oldPassword,
			String  newPassword){
		ResponseResult<Void> rr;
		
		try{
			Integer id = this.getUid(session);
			userService.changePassword(id, oldPassword, newPassword);
			rr = new ResponseResult<Void>(1,"修改成功");
		}catch(RuntimeException e){
			rr = new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
		
	}
	@RequestMapping("/updatePerson.do")
	@ResponseBody
	public ResponseResult<Void> updatePerson(
			HttpSession session,String username,
			Integer gender,String phone,
			String email){
		
		System.out.println(username+gender+phone+email);
		
		ResponseResult<Void> rr;
		try{
			Integer id = this.getUid(session);
			userService.updatePerson(id, username, gender, phone, email);
			//把修改后的对象重新设置为session的属性
			session.setAttribute("user", 
					userService.getUserById(id));
			
			rr = new ResponseResult<Void>(1,"成功");
			
		}catch(RuntimeException e){
			rr = new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}

	
	@RequestMapping("checkLoginUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkLoginUsername(String username){
		ResponseResult<Void> rr;
		//如果返回true,表示用户名存在,
		//如果返回false,表示用户名不存在
		if(userService.checkUsernameHasExist(username)){
			rr = new ResponseResult<Void>(Const.SUCCESS,"用户名存在");
		}else{
			rr = new ResponseResult<Void>(Const.FAILED,"用户名不存在");
		}
		return rr;
	} 
}
















