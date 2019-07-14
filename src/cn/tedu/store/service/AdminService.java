package cn.tedu.store.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Admin;
import cn.tedu.store.mapper.AdminMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;

@Service
public class AdminService implements IAdminService {

	@Resource
	private AdminMapper adminMapper;
	
	//从db.properties文件中,获取盐,给salt赋值
	@Value("#{dbConfig.salt}")
	private String salt;
	
	/**
	 * 如果用户名存在,返回true,否则返回false
	 */
	public boolean checkUsername(String username) {
		if(adminMapper.getAdminByUsername(username)==null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public Admin login(String username, String password) {
		Admin admin = adminMapper.getAdminByUsername(username);
		if(admin==null){
			throw new UserNotFoundException("用户名不存在!");
		}else{
			//生成md5密码
			String md5 = DigestUtils.md5Hex(password+salt);
			
			if(admin.getPassword().equals(md5)){
				return admin;
			}else{
				throw new PasswordNotMatchException("密码错误");
			}
		}
	}

	

}
