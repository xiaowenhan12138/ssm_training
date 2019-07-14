package cn.tedu.store.service;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.User;
@Transactional
public interface IUserService {
	/**
	 * 用户注册
	 * @param user
	 */
	void register(User user);
	
	
	/**
	 * 验证用户名是否存在
	 * @param username
	 * @return
	 */
	boolean checkUsernameHasExist(String username);

	/**
	 * 验证邮箱
	 * @param email
	 * @return
	 */
	boolean checkEmail(String email);
	
	/**
	 * 验证电话号码
	 * @param phone
	 * @return
	 */
	boolean checkPhone(String phone);
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username,String password);
	/**
	 * 修改密码
	 * @param id 
	 * @param oldPassword
	 * @param newPassword
	 */
	void changePassword(Integer id,
			String oldPassword,
			String newPassword);
	/**
	 * 修改用户基本信息
	 * @param id
	 * @param username
	 * @param gender
	 * @param phone
	 * @param email
	 */
	void updatePerson(Integer id,
			String username,
			Integer gender,
			String phone,
			String email);
	
	/**
	 * 通过id查询用户信息
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);
	/**
	 * 修改userID的image值
	 * @param userid
	 * @param image
	 */
	void updateImageById(Integer userid,
							String image);
}













