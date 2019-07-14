package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
@Transactional
public interface IDictService {
	List<Province> getProvinces();
	List<City> getCities(String provinceCode);
	List<Area> getAreas(String cityCode);

}







