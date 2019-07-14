package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.GoodsPicture;

public interface IGoodsPictureService {

	void addGoodsPicture(List<GoodsPicture> picList);

	List<GoodsPicture> getGoodsPictures(Integer goodsId);

}
