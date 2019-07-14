package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
@Service
public class AddressService implements IAddressService{
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;
	public void addAddress(Address address) {
		//1.setDistrict
		String pCode = address.getRecvProvince();
		String cCode = address.getRecvCity();
		String aCode = address.getRecvArea();
		String pName = dictMapper.getProvinceByCode(pCode);
		String cName = dictMapper.getCityByCode(cCode);
		String aName = dictMapper.getAreaByCode(aCode);
		address.setRecvDistrict(pName+cName+aName);
		//2.setIsDefault
		List<Address> listA = addressMapper.getAddressByUid(address.getUid());
		int n = listA.size() > 0 ? 0:1;
		address.setIsDefault(n);
		//3.insert();
		addressMapper.insert(address);
		
	}

	/**
	 * 通过uid查询该用户的收件地址,并返回集合
	 */
	public List<Address> getAllAddessByUid(Integer uid) {
		
		return addressMapper.getAddressByUid(uid);
	}

	public void setDefault(Integer uid, Integer id) {
		Integer n1 = addressMapper.setCancel(uid);
		if(n1==0)
			throw new RuntimeException("修改失败");
		Integer n2 = addressMapper.setDefault(id);
		if(n2==0)
			throw new RuntimeException("修改失败");
	}
	/**
	 * 通过id查询Address信息,并返回该Address信息
	 */
	public Address getAddressById(Integer id){
		return addressMapper.getAddressById(id);
	}
	/**
	 * 修改收件人地址
	 */
	public void updateAddress(Address address){
		String pName = dictMapper.getProvinceByCode(
				address.getRecvProvince());
		String cName = dictMapper.getCityByCode(
				address.getRecvCity());
		String aName = dictMapper.getAreaByCode(
				address.getRecvArea());
		
		address.setRecvDistrict(pName+cName+aName);
		addressMapper.update(address);
	}
	/**
	 * 删除指定id的address记录
	 */
	public void deleteAddress(Integer uid,
			Integer id){
		Address address = 
				addressMapper.getAddressById(id);
		Integer i = addressMapper.delete(id);
		if(i==1){
			if(address.getIsDefault()==1){
				List<Address> list = 
						addressMapper.getAddressByUid(uid);
				if(list.size()>0){
					Address addr = list.get(0);
					addressMapper.setDefault(
							addr.getId());
				}else{
					
				}
			}else{
				
			}
		}
	}
}












