package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsPicture;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.mapper.GoodsPictureMapper;

public class TestGoods {
	
	@Test
	public void testExchangeData(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext(
						"spring-dao.xml",
						"spring-service.xml");
		
		GoodsMapper gm = ac.getBean("goodsMapper",GoodsMapper.class);
		GoodsPictureMapper gpm = ac.getBean(GoodsPictureMapper.class);
		
		
		List<Goods> list = gm.getGoodsByTitle("",0, 1000);
		System.out.println(list);
		System.out.println(list.size());
		
		List<GoodsPicture> picList = new ArrayList<GoodsPicture>();
		for(Goods g : list) {
			GoodsPicture pic = new GoodsPicture();
			
			pic.setGoodsId(g.getId());
			
			///images/portal/00GuangBo1040A5GBR0731/collect.png
			pic.setUrl(g.getImage());
			pic.setTurn(0);
			pic.setFilename("collect.png");
			picList.add(pic);
			
			String url = g.getImage();
			url = url.substring(0, url.lastIndexOf("/")) + "/";
			//1_big.png
			for (int i = 1; i <= 5; i++) {
				String newUrl = url + i + "_big.png";
				GoodsPicture p = new GoodsPicture();
				
				p.setGoodsId(g.getId());
				p.setUrl(newUrl);
				p.setTurn(i);
				p.setFilename(i+ "_big.png");
				picList.add(p);
			}
		}
		
//		for( GoodsPicture p : picList ) {
//			System.out.println(p);
//		}
		
		gpm.insertGoodsPictures(picList);
	}

}






