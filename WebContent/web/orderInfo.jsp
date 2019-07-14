<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>学子商城-订单详情页</title>
    <link rel="stylesheet" href="../css/header.css"/>
    <link rel="stylesheet" href="../css/footer.css"/>
    <link rel="stylesheet" href="../css/order.css"/>
    <link rel="stylesheet" href="../css/orders.css"/>
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<!-- nav主导航-->
<jsp:include page="nav.jsp"></jsp:include>


<!--详细信息-->
<div id="container">
        <!-- 导航 -->
        <div class="container_nav">
            首页&gt;订单管理&gt;订单<span>${orderInfo.orderid}</span>
        </div>
        <div class="orderInfo_icon">
            <p>订单<span class="order-num">${orderInfo.orderid}</span>&nbsp;&nbsp;&nbsp;
            当前状态：<span class="state">${orderStatus}</span></p>
        </div>
        <!-- 订单状态流程图-->
        <div id="orderStatusChart">
              <dl>
                  <dt><img src="../images/orderinfo/orderinfo_img1_2.png" alt=""/></dt>
                  <dd>
                      <p>提交订单</p>
                      <span><fmt:formatDate value="${orderInfo.tradetime}" pattern="yyyy.MM.dd HH:mm:ss"/></span>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6_2.png" alt=""/></dt>
              </dl>

              <dl>
              	<c:if test="${orderInfo.receiptime!=null}">
                  <dt><img src="../images/orderinfo/orderinfo_img2_1.png" alt=""/></dt>
                  <dd>
                      <p>付款成功</p>
                      <span><fmt:formatDate value="${orderInfo.receiptime}" pattern="yyyy.MM.dd HH:mm:ss"/></span>
                  </dd>
                </c:if>
                <c:if test="${orderInfo.receiptime==null}">
                  <dt><img src="../images/orderinfo/orderinfo_img2.png" alt=""/></dt>
                  <dd>
                      <p>待付款</p>
                  </dd>
                </c:if>
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6.png" alt=""/></dt>
              </dl>

              <dl>

	              <c:if test="${orderInfo.delivertime!=null}">
	                  <dt><img src="../images/orderinfo/orderinfo_img3_1.png" alt=""/></dt>
	                  <dd>
	                      <p>已发货</p>
	                      <span><fmt:formatDate value="${orderInfo.delivertime}" pattern="yyyy.MM.dd HH:mm:ss"/></span>
	                  </dd>
	              </c:if>
	 	          <c:if test="${orderInfo.delivertime==null}">
	                  <dt><img src="../images/orderinfo/orderinfo_img3.png" alt=""/></dt>
	                  <dd>
	                      <p>待配送</p>
	                  </dd>
	              </c:if>
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6.png" alt=""/></dt>
              </dl>

              <dl>
	              <c:if test="${orderInfo.handovertime!=null}">
	                  <dt><img src="../images/orderinfo/orderinfo_img4_1.png" alt=""/></dt>
	                  <dd >
	                      <p>已确认收货</p>
	                      <span><fmt:formatDate value="${orderInfo.handovertime}" pattern="yyyy.MM.dd HH:mm:ss"/></span>
	                  </dd>
                  </c:if>
				  <c:if test="${orderInfo.handovertime==null}">
	                  <dt><img src="../images/orderinfo/orderinfo_img4.png" alt=""/></dt>
	                  <dd >
	                      <p>待收货</p>
	                  </dd>
                  </c:if>
                  
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6.png" alt=""/></dt>
              </dl>

            <dl>
                  <dt><img src="../images/orderinfo/orderinfo_img5.png" alt=""/></dt>
                  <dd >
                      <p>待评价</p>
                      <span style="display: none">2016.01.01 13:00</span>
                  </dd>
              </dl>

        </div>
        <div class="clear">

        <!-- 详细信息-->
            <h1>详细信息</h1>
            收货人：<span class="consignee">${orderInfo.recvName}</span>&nbsp;&nbsp;&nbsp;&nbsp;邮编：<span class="postcode">${orderInfo.recvZip}</span>&nbsp;&nbsp;&nbsp;&nbsp;联系电话：<span class="tel">${orderInfo.recvPhone} ${orderInfo.recvTel}</span>
            <br/>
            <p>收货地址：<span>${orderInfo.recvDistrict}${orderInfo.recvAddr}</span></p>
        </div>

		<c:if test="${orderInfo.delivertime!=null}">
        <!-- 物流信息-->
        <div style="width: 1000px; margin:0px auto" class="logistics">
            <h1>物流信息</h1>
            <p>发货时间：<span><fmt:formatDate value="${orderInfo.delivertime}" pattern="yyyy.MM.dd HH:mm:ss"/></span></p>
            <p>物流公司：<span class="express">顺丰快递</span><a href="#">顺丰官网</a></p>
            <p>快递单号：<span>512883827907</span></p>
            <div><span>物流信息：</span>
                <div>
                    <p>2018.11.11 12:11 您的快递在【北京马驹桥镇分拣中心】分拣完毕</p>
                    <p>2018.11.11 12:11 您的快递在【北京马驹桥镇分拣中心】准备装车</p>
                    <p>2018.11.11 12:11 您的快递到达【北京昌平分拣中心】</p>
                    <p>2018.11.11 12:11 您的快递到达【北京昌平沙河分拣中心】</p>
                </div>
            </div>
        </div>
        </c:if>

        <!-- 商品信息-->
        <div style="width: 1000px; margin:0px auto">
            <h1 class="commodity">商品信息</h1>
           <!-- 商品信息标题-->
            <table id="order_list_title"  cellpadding="0" cellspacing="0" >
                <tr>
                    <th width="345">商品</th>
                    <th width="82">单价（元）</th>
                    <th width="50">数量</th>
                    <th width="82">售后</th>
                    <th width="100">实付款（元）</th>
                    <th width="30"></th>
                    <th width="152">操作</th>
                </tr>
            </table>
            <c:set var="oid" value="0" />
            <c:set var="oid2" value="0" />
            <!-- 订单列表项 -->
            <c:forEach items="${orderInfo.listItems}" var="orderItem">
	              <div id="orderItem_detail">
	                  <ul>
	                      <li class="product">
	                          <b><a href="#">
	                          <img src="..${orderItem.image }" width="84px" height="84px" /></a></b>
	                          <b class="product_name lf" >
	                              <a href="">${orderItem.title }</a>
	                              <br/>
	                          </b>
	                          <b class="product_color ">
	                              规格：${orderItem.spec}
	                          </b>
	                      </li>
	                      <li class="unit_price">
	                          专属价
	                          <br/>
	                          ￥${orderItem.price }
	                      </li>
	                      <li class="count">
	                          ${orderItem.count }件
	                      </li>
	                      <li class="sale_support">
	                          退款/退货
	                          <br/>
	                          我要维权
	                      </li>
	                      <li class=" payments_received">
	                          ￥${orderItem.count*orderItem.price }
	                      </li>
	                      <c:if test="${oid2!=orderItem.orderid}">
	                      	  <c:set var="oid2" value="${orderItem.orderid}" />
		                      <li class="trading_status">
		                          
		                      </li>
		                      <li class="operate">
		                          
		                          <c:if test="${orderItem.shippingStatus==0 || orderItem.shippingStatus==1}">
		                          	<a href="cancelOrder.do?orderid=${orderItem.orderid}">取消订单</a>
		                          </c:if>
		                          <c:if test="${orderItem.shippingStatus==2}">
		                          	<a href="confirmReceived.do?orderid=${orderItem.orderid}">确认收货</a>
		                          </c:if>
		                          <c:if test="${orderItem.shippingStatus==3}">
		                          	<a href="#">评价</a>
		                          </c:if>
		                          
	                      	  </li>
	                      </c:if>
	                  </ul>
	              </div>

				</c:forEach>
        </div>

    </div>
<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
             <p class="footer1"><img src="../images/footer/logo.png" alt="" class=" footLogo"/></p>
             <p class="footer2"><img src="../images/footer/footerFont.png" alt=""/></p>
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
                    <img src="../images/footer/wechat.png" alt=""/>
                    <img src="../images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="../images/footer/ios.png" class="lf">
            <img src="../images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../images/footer/erweima.png">
        </div>
		<!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx
        </div>
    </div>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
    //搜索下拉
    $('.seek').focus(function(){

        if($(this).hasClass('clickhover')){

            $(this).removeClass('clickhover');
            $(this).find('.seek_content').hide();
            $(this).find('img').attr('src','../images/header/header_normal.png');

        }else{
            $(this).addClass('clickhover');
            $(this).find('.seek_content').show();
            $(this).find('img').attr('src','../images/header/header_true.png');
        }
    })
    $('.seek_content>div').click(function(){
        $('.seek').removeClass('clickhover');
        var text=$(this).html();
        $('.seek span').html(text);
        $(this).parent().hide();
        $('.seek').find('img').attr('src','../images/header/header_normal.png');
        $('.seek').blur();

    })

    $('.seek').blur(function(){

        $('.seek').removeClass('clickhover');
        $('.seek_content').hide();

        $('.seek').find('img').attr('src','../images/header/header_normal.png');
        console.log(1);
    })
    //头部hover
    $(".care").hover(function(){
        $(this).attr('src',"../images/header/care1.png");
    },function(){
        $(this).attr('src',"../images/header/care.png");
    });
    $(".order").hover(function(){
        $(this).attr('src',"../images/header/order1.png");
    },function(){
        $(this).attr('src',"../images/header/order.png");
    });
    $(".shopcar").hover(function(){
        $(this).attr('src',"../images/header/shop_car1.png");
    },function(){
        $(this).attr('src',"../images/header/shop_car.png");
    });
</script>
</html>