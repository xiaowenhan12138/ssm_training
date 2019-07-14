<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="cn">
    <meta charset="UTF-8">
    <title>学子商城首页</title>
    <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/slide.css" rel="stylesheet"/>
    </head>
<body>
<!-- 页面顶部-->
	<jsp:include page="header.jsp"></jsp:include>
<!-- nav主导航-->
	<jsp:include page="nav.jsp"></jsp:include>

<!-- banner部分-->
<div class="ck-slide">
    <ul class="ck-slide-wrapper">
        <li>
            <a href="${pageContext.request.contextPath}/goods/showGoodsInfo.do?id=33&categoryId=163"><img src="${pageContext.request.contextPath}/images/itemCat/itemCat_banner1.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="${pageContext.request.contextPath}/goods/showGoodsInfo.do?id=58&categoryId=238"><img src="${pageContext.request.contextPath}/images/itemCat/itemCat_banner2.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="${pageContext.request.contextPath}/goods/showGoodsInfo.do?id=21&categoryId=163"><img src="${pageContext.request.contextPath}/images/itemCat/itemCat_banner3.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="${pageContext.request.contextPath}/goods/showGoodsInfo.do?id=59&categoryId=238"><img src="${pageContext.request.contextPath}/images/itemCat/itemCat_banner4.png" alt=""></a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/goods/showGoodsInfo.do?id=33&categoryId=163"><img src="${pageContext.request.contextPath}/images/itemCat/itemCat_banner1.png" alt=""></a>
        </li>
    </ul>
    <a href="javascript:;" class="ctrl-slide ck-prev">上一张</a> <a href="javascript:;" class="ctrl-slide ck-next">下一张</a>
    <div class="ck-slidebox">
        <div class="slideWrap">
            <ul class="dot-wrap">
                <li class="current"><em>1</em></li>
                <li><em>2</em></li>
                <li><em>3</em></li>
                <li><em>4</em></li>
                <li><em>5</em></li>
            </ul>
        </div>
    </div>
</div>

<!--/*楼梯1f*/-->
<a name="computer"><h2 id="computer" class="stair"><span><img src="${pageContext.request.contextPath}/images/itemCat/computer_icon.png" alt=".stair"/></span>办公电脑 /1F</h2></a>
<div class="lf1">
    <div class="lf1_top">
        <!-- 上面部分左侧区域-->
        <div class="left lf" onclick="itemInfo(10,163);">
            <div class="left_pro lf">
                <p class="top_ys1">灵越 燃7000系列</p>

                <p class="top_ys2">
                    酷睿双核i5处理器|256GB SSD| 8GB内存
                    </br>
                    英特尔HD显卡620含共享显卡内存
                </p>

                <p class="top_ys3">￥4999.00</p>

                <p class="top_ys4 color_2">
                <a href="#">
                	查看详情
                </a></p>
            </div>
            <span><img src="${pageContext.request.contextPath}/images/itemCat/study_computer_img1.png" alt=""/></span>
        </div>
        <!-- 上面部分右侧区域-->
        <div class="right lf"  onclick="itemInfo(14,163);">
            <div class="right_pro lf">
                <p class="top_ys1">颜值 框不住</p>

                <p class="top_ys2">
                    酷睿双核i5处理器|256GB SSD| 8GB内存
                    </br>
                    英特尔HD显卡620含共享显卡内存
                </p>

                <p class="top_ys3">￥6888.00</p>

                <p class="top_ys4 color_2">
                	<a href="#">查看详情</a>
                </p>
            </div>
            <span><img src="${pageContext.request.contextPath}/images/itemCat/study_computer_img2.png" alt=""/></span>
        </div>
    </div>
    <div class="lf1_bottom">
        <div class="item_cat lf">
            <div class="cat_header color_2">
                <span>
                    <img src="${pageContext.request.contextPath}/images/itemCat/computer_icon1.png" alt=""/>
                    电脑,办公/1F
                </span>
            </div>
            <div class="item_cat_all">
            	<c:forEach items="${list1}" var="gc" varStatus="sindex">
	                <p>${gc.name}</p>
	                <ul>
		                <c:forEach items="${list2[sindex.index]}" var="goodsCategory">
		                    <li>
		                    	<a href="${pageContext.request.contextPath}/goods/showGoods.do?categoryId=${goodsCategory.id}">
		                    		${goodsCategory.name}
		                    	</a>
		                    </li>
		                </c:forEach>
		                
	                </ul>
                
                </c:forEach>
            </div>
        </div>
        <c:forEach items="${listGoods}" var="goods">
	        <div class="item_msg lf" onclick='itemInfo(${goods.id},${goods.categoryId})'>
	            <img 
	            height="140px"
	            width="200px"
	            src="${pageContext.request.contextPath}${goods.image}" alt="${goods.title}"/>
	
	            <p class="bottom_ys2">${goods.title}</p>
	
	            <p class="bottom_ys3">￥${goods.price}</p>
	
	            <p class="bottom_ys4 color_2">
	            <a href="#">
	            	查看详情
	            </a></p>
	        </div>
        </c:forEach>
        
    </div>
</div>


<!--楼梯2f-->
<a name="stationery"><h2 id="stationery" class="stair"><span><img src="${pageContext.request.contextPath}/images/itemCat/stationery_icon.png" alt=".stair"/></span>办公文具 /2F</h2></a>

<div class="lf1">
    <div class="lf1_top">
        <!-- 上面部分左侧区域-->
        <div class="left lf">
            <div class="left_ys1 lf">
            	<img src="${pageContext.request.contextPath}/images/portal/002calculator1548A/collect.png" alt=""/>
            </div>
            <div class="left_pro lf" onclick="itemInfo(6,241);">
                <p class="top_ys1">得力办公计算器</p>

                <p class="top_ys2">
                    得力（deli）1548A商务办公桌面计算器 太阳能双电源
                </p>

                <p class="top_ys3 price_ys3">仅售 ￥58.00</p>

                <p class="top_ys4 color_1"><a href="#">查看详情</a></p>
            </div>
        </div>
        <!-- 上面部分右侧区域-->
        <div class="right lf">
            <div class="left_ys2 lf">
            	<img src="${pageContext.request.contextPath}/images/portal/04_SUNWOODC452312/collect.png" alt=""/>
            </div>
            <div class="right_ys rt" onclick="itemInfo(8,236);">
                <p class="top_ys1">网格拉链袋</p>
                <p class="top_ys2">
                    三木(SUNWOOD) C4523 网格拉链袋/文件袋
                </p>
                <p class="top_ys3 price_ys3">仅售 ￥28.00</p>

                <p class="top_ys4 color_1"><a href="#">查看详情</a></p>
            </div>
        </div>
    </div>
    <div class="lf1_bottom">
        <div class="item_cat lf">
            <div class="cat_header color_1">
                <span>
                    <img src="${pageContext.request.contextPath}/images/itemCat/stationery_icon1.png" alt=""/>
                    办公文具/2F
                </span>
            </div>
            <div class="item_cat_all item_color">
                <c:forEach items="${lf2list1}" var="gc" varStatus="sindex">
	                <p>${gc.name}</p>
	                <ul>
		                <c:forEach items="${lf2list2[sindex.index]}" var="goodsCategory">
		                    <li>
		                    	<a href="${pageContext.request.contextPath}/goods/showGoods.do?categoryId=${goodsCategory.id}">
		                    		${goodsCategory.name}
		                    	</a>
		                    </li>
		                </c:forEach>
		                
	                </ul>
                
                </c:forEach>
            </div>
        </div>
        <c:forEach items="${lf2listGoods}" var="goods">
	        <div class="item_msg lf" onclick='itemInfo(${goods.id},${goods.categoryId})'>
	            <img 
	            height="140px"
	            width="200px"
	            src="${pageContext.request.contextPath}${goods.image}" alt="${goods.title}"/>
	
	            <p class="bottom_ys2">${goods.title}</p>
	
	            <p class="bottom_ys3">￥${goods.price}</p>
	
	            <p class="bottom_ys4 color_2">
	            <a href="#">
	            	查看详情
	            </a></p>
	        </div>
        </c:forEach>
        

    </div>
</div>
<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
             <p class="footer1"><img src="${pageContext.request.contextPath}/images/footer/logo.png" alt="" class=" footLogo"/></p>
             <p class="footer2"><img src="${pageContext.request.contextPath}/images/footer/footerFont.png" alt=""/></p>
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="${pageContext.request.contextPath}/images/footer/wechat.png" alt=""/>
                    <img src="${pageContext.request.contextPath}/images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="${pageContext.request.contextPath}/images/footer/ios.png" class="lf">
            <img src="${pageContext.request.contextPath}/images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="${pageContext.request.contextPath}/images/footer/erweima.png">
        </div>
		<!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/slide.js"></script>
<script>
//查看详情
function itemInfo(id,categoryId){
	
	location="${pageContext.request.contextPath}/goods/showGoodsInfo.do?id="+id+"&categoryId="+categoryId;
}

    $('.ck-slide').ckSlide({
        autoPlay: true,//默认为不自动播放，需要时请以此设置
        dir: 'x',//默认效果淡隐淡出，x为水平移动，y 为垂直滚动
        interval:3000//默认间隔2000毫秒
    });
</script>
<script>
    $("#iii").click(function(){
        location.href="product_details.html";
    })
</script>
</body>
</html>