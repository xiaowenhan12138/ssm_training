package cn.tedu.store.service;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Admin;

@Transactional
public interface IAdminService {

	boolean checkUsername(String username);

	Admin login(String username, String password);

}
