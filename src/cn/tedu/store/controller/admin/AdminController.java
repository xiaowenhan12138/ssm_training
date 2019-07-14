package cn.tedu.store.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Admin;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IAdminService;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Resource
	private IAdminService adminService;
	
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "admin/login";
	}
	
	/**
	 * 管理员登陆时，验证用户名是否正确
	 * @param username
	 * @return
	 */
	@RequestMapping("/validateUsername.do")
	@ResponseBody
	public ResponseResult<Void> validateUsername(String username) {
		ResponseResult<Void> rr;
		//如果返回true,表示用户名存在,
		//如果返回false,表示用户名不存在
		if(adminService.checkUsername(username)){
			rr = new ResponseResult<Void>(1,"用户名正确");
		}else{
			rr = new ResponseResult<Void>(0,"用户名错误");
		}
		return rr;
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username, String password, HttpSession session) {
		
		ResponseResult<Void> rr;
		try{
			Admin admin = adminService.login(username, password);
			session.setAttribute("admin", admin);
			rr = new ResponseResult<Void>(1,"登录成功");
		}catch(UserNotFoundException e){
			rr = new ResponseResult<Void>(0,e.getMessage());
		}catch(PasswordNotMatchException e){
			rr = new ResponseResult<Void>(-1,e.getMessage());
		}
		return rr;
	}
	
	@RequestMapping("/showIndex.do")
	public String showIndex() {
		return "admin/index";
	}
	
}







