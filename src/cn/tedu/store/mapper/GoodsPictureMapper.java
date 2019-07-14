package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.GoodsPicture;

public interface GoodsPictureMapper {

	void insertGoodsPictures(List<GoodsPicture> picList);

	List<GoodsPicture> getGoodsPictures(Integer goodsId);

}
