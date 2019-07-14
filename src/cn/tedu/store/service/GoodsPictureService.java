package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.GoodsPicture;
import cn.tedu.store.mapper.GoodsPictureMapper;

@Service
public class GoodsPictureService implements IGoodsPictureService {

	@Resource
	private GoodsPictureMapper picMapper;
	
	@Override
	public void addGoodsPicture(List<GoodsPicture> picList) {
		picMapper.insertGoodsPictures(picList);
	}

	@Override
	public List<GoodsPicture> getGoodsPictures(Integer goodsId) {
		return picMapper.getGoodsPictures(goodsId);
	}

}
