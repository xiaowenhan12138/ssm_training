package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

public interface UserMapper {
	/**
	 * 添加用户信息
	 */
	void  insert(User user);
	/**
	 * 通过用户名查询用户信息
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
	
	/**
	 * 根据email查询,如果存在,返回非0 
	 * 否则返回 0 
	 * @param email
	 * @return
	 */
	Integer getCountByEmail(String email);
	
	/**
	 * 根据phone查询,如果存在,返回非0 
	 * 否则返回 0 
	 * @param phone
	 * @return
	 */
	Integer getCountByPhone(String phone);
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	void update(User user);
	/**
	 * 根据id查询用户信息,并返回
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);
	/**
	 * 修改userid的image
	 * @param userid
	 * @param image
	 */
	void updateImageById(
			@Param("userid") Integer userid,
			@Param("image") String image);
}









