package cn.tedu.store.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExistException;
@Service
public class UserService implements IUserService {
	@Resource
	private UserMapper userMapper;
	
	//从db.properties文件中,获取盐,给salt赋值
	@Value("#{dbConfig.salt}")
	private String salt;
	
	public void register(User user) {
		// TODO Auto-generated method stub
		User user1 = userMapper.getUserByUsername(
				user.getUsername());
			//用户名不存在
			if(user1==null){
				/**
				 * md5加密
				 */
				String pwd = user.getPassword();
				
				//生成md5密码
				String md5 = DigestUtils.md5Hex(pwd+salt);
				user.setPassword(md5);
				userMapper.insert(user);
			}else{
				//用户名存在,抛出异常
				throw new UsernameAlreadyExistException("用户名已经存在,请重新输入!");
			}
	}

	/**
	 * 如果用户名存在,返回true,否则返回false
	 */
	public boolean checkUsernameHasExist(String username) {
		if(userMapper.getUserByUsername(username)==null){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 通过email查询,如果存在,返回true
	 * 否则返回false
	 */
	public boolean checkEmail(String email) {
		
		return userMapper.getCountByEmail(email)>0;
	}

	/**
	 * 通过电话号码查询,如果存在返回true
	 * 否则返回false
	 */
	public boolean checkPhone(String phone) {

		return userMapper.getCountByPhone(phone)>0;
	}

	/**
	 * 
	 */
	public User login(String username, String password) {
		System.out.println("login....");
		User user = userMapper.
				getUserByUsername(username);
		if(user==null){
			throw new UserNotFoundException(""
					+ "用户名不存在!");
		}else{
			//user.getPassword()
			/**
			 * String str = user.getPassword();
			 * str += "dddddd";
			 * String strMd5 = DigestUtils.md5Hex(str)
			 */
			
			//生成md5密码
			String md5 = DigestUtils.md5Hex(password+salt);
			
			if(user.getPassword().equals(md5)){
				return user;
			}else{
				throw new PasswordNotMatchException("密码错误");
			}
		}
		
	}
	/**
	 * 修改密码
	 */
	public void changePassword(Integer id,
			String oldPassword,
			String newPassword){
		User user = userMapper.getUserById(id);
		if(user==null){
			throw new UserNotFoundException("用户不存在");
		}else{
			/**
			 * md5加密oldPassword
			 * 
			 */
			
			//生成md5密码
			String md5 = DigestUtils.md5Hex(oldPassword+salt);
			
			if(user.getPassword().equals(md5)){
				User u = new User();
				u.setId(id);
				/**
				 * md5加密newPassword
				 */
				md5 = DigestUtils.md5Hex(newPassword+salt);
				
				u.setPassword(md5);
				userMapper.update(u);
			}else{
				throw new PasswordNotMatchException("密码不匹配异常");
			}
		}
	}
	/**
	 * 修改个人信息
	 */
	public void updatePerson(Integer id,
			String username,
			Integer gender,
			String phone,
			String email){
		User user = new User();
		User u1 = userMapper.getUserById(id);
		if(u1==null){
			throw new UserNotFoundException("用户不存在");
		}
		
		User u2 = userMapper.getUserByUsername(username);
		if(u2==null){
			user.setUsername(username);
		}else{
			if(u1.getUsername().equals(username)){
				
			}else{
				throw new UsernameAlreadyExistException("用户已存在");
			}
		}
		user.setId(id);
		user.setGender(gender);
		user.setPhone(phone);
		user.setEmail(email);
		userMapper.update(user);
	}

	/**
	 * 通过id查询用户信息
	 */
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(id);
	}

	public void updateImageById(Integer userid, String image) {
		userMapper.updateImageById(userid, image);
		
	}
}







