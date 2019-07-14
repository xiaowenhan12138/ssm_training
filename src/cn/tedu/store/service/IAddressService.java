package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Address;
@Transactional
public interface IAddressService {
	/**
	 * 添加address
	 * @param address
	 */
	void addAddress(Address address);
	/**
	 * 通过uid查询该用户的收件地址
	 * @param uid
	 * @return
	 */
	List<Address> getAllAddessByUid(Integer uid);
	/**
	 * 设置is_default
	 * @param uid
	 * @param id
	 */
	void setDefault(Integer uid,Integer id);
	
	/**
	 * 通过id查询Address信息,并返回
	 * @param id
	 * @return
	 */
	Address getAddressById(Integer id);
	/**
	 * 修改Address
	 * @param address
	 */
	void updateAddress(Address address);
	
	/**
	 * 删除address记录
	 * @param uid
	 * @param id
	 */
	void deleteAddress(Integer uid,Integer id);
}










