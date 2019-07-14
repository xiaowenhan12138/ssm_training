package cn.tedu.store.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IAddressService;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController{
	@Resource
	private IAddressService addressService;
	/**
	 * 显示addressAdmin页面
	 * @return
	 */
	@RequestMapping("/showAddress.do")
	public String  showAddress(HttpSession session,
			Map<String,List<Address>> map){
		List<Address> list = 
				addressService.getAllAddessByUid(
				this.getUid(session));
		map.put("listAddress", list);
		
		return "addressAdmin";
	}
	
	@RequestMapping("/add.do")
	public String add(HttpSession session,
			@RequestParam("receiverName") 
				String recvName,
			@RequestParam("receiverState")
				String recvProvince,
			@RequestParam("receiverCity")
				String recvCity,
			@RequestParam("receiverDistrict")
				String recvArea,
			@RequestParam("receiverAddress")
				String recvAddr,
			@RequestParam("receiverMobile")
				String recvPhone,
			@RequestParam("receiverPhone")
				String recvTel,
			@RequestParam("receiverZip")
				String recvZip,
			@RequestParam("addressName")
				String recvTag){
		Address address = new Address();
		address.setUid(this.getUid(session));
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddr(recvAddr);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.addAddress(address);
		
		return "redirect:../address/showAddress.do";
		
	}
	@RequestMapping("/setDefault.do")
	public String setDefault(Integer id,HttpSession session){
		addressService.setDefault(this.getUid(session), id);
		return "redirect:../address/showAddress.do";
	}
	@RequestMapping("/getAddress.do")
	@ResponseBody
	public ResponseResult<Address> getAddress(Integer id){
		Address address = addressService.getAddressById(id);
		ResponseResult<Address> rr ;
		rr = new ResponseResult<Address>(1,"获取数据成功");
		rr.setData(address);
		return rr;
	}
	@RequestMapping("/updateAddress.do")
	public String updateAddress(
			Integer id,
		@RequestParam("receiverName") 
			String recvName,
		@RequestParam("receiverState")
			String recvProvince,
		@RequestParam("receiverCity")
			String recvCity,
		@RequestParam("receiverDistrict")
			String recvArea,
		@RequestParam("receiverAddress")
			String recvAddr,
		@RequestParam("receiverMobile")
			String recvPhone,
		@RequestParam("receiverPhone")
			String recvTel,
		@RequestParam("receiverZip")
			String recvZip,
		@RequestParam("addressName")
			String recvTag){
	Address address = new Address();
	address.setId(id);
	address.setRecvName(recvName);
	address.setRecvProvince(recvProvince);
	address.setRecvCity(recvCity);
	address.setRecvArea(recvArea);
	address.setRecvAddr(recvAddr);
	address.setRecvPhone(recvPhone);
	address.setRecvTel(recvTel);
	address.setRecvZip(recvZip);
	address.setRecvTag(recvTag);
		
	addressService.updateAddress(address);
	
	return "redirect:../address/showAddress.do";
	}
	
	@RequestMapping("/deleteAddress.do")
	public String deleteAddress(Integer id,
			HttpSession session){
		Integer uid = this.getUid(session);
		addressService.deleteAddress(uid, id);
	return "redirect:../address/showAddress.do";
	}
	
}













