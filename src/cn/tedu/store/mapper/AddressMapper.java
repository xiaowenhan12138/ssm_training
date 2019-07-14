package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {

	/**
	 * 添加address
	 * @param address
	 */
	void insert(Address address);
	/**
	 * 通过uid查询收获地址
	 * @param uid
	 * @return
	 */
	List<Address> getAddressByUid(Integer uid);
	/**
	 * 修改uid的所有的收件地址的is_default的值为0
	 * @param uid
	 */
	Integer setCancel(Integer uid);
	/**
	 * 修改is_default值为1
	 * @param id
	 */
	Integer setDefault(Integer id);
	/**
	 * 通过Id查询Address信息
	 * @param id
	 * @return
	 */
	Address getAddressById(Integer id);
	/**
	 * 修改address
	 * @param address
	 */
	void update(Address address);
	
	/**
	 * 根据id删除一个地址信息
	 * @param id
	 * @return
	 */
	Integer delete(Integer id);
}








