package cn.tedu.store.mapper;

import cn.tedu.store.bean.Admin;

public interface AdminMapper {

	/**
	 * 通过用户名查询Admin信息
	 * @param username
	 * @return
	 */
	Admin getAdminByUsername(String username);

}
