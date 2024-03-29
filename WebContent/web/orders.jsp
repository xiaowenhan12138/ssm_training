<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.tedu.store.common.Const" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<!-- nav主导航-->
<jsp:include page="nav.jsp"></jsp:include>

<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>订单管理</a></li>
    </ul>
</div>
    <!--我的订单内容区域 #container-->
    <div id="container" class="clearfix">
	    <!-- 左边栏-->
	    <jsp:include page="left.jsp"></jsp:include>
       
         <!-- 右边栏-->
        <div class="rightsidebar_box rt">
            <!-- 商品信息标题-->
            <table id="order_list_title"  cellpadding="0" cellspacing="0" >
                <tr>
                    <th width="345">商品</th>
                    <th width="82">单价（元）</th>
                    <th width="50">数量</th>
                    <th width="82">售后</th>
                    <th width="100">实付款（元）</th>
                    <th width="90">交易状态</th>
                    <th width="92">操作</th>
                </tr>
            </table>
            <c:set var="oid" value="0" />
            <c:set var="oid2" value="0" />
            <!-- 订单列表项 -->
            <c:forEach items="${listItems}" var="orderItem">
            	<c:if test="${oid!=orderItem.orderid}">
            		<c:set var="oid" value="${orderItem.orderid}" />
		            <div id="orderItem">
		              <p class="orderItem_title">
		                 <span id="order_id">
		                     &nbsp;&nbsp;订单编号:<a href="#">${orderItem.orderid }</a>
		                 </span>
		                  &nbsp;&nbsp;成交时间：${orderItem.showTime}&nbsp;&nbsp;
		                 <span>
		                     <a href="#" class="servie">
		                        联系客服<img src="../images/myOrder/kefuf.gif"/>
		                      </a>
		                 </span>
		              </p>
		            </div>
	            </c:if>
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
		                          <a href="showOrderInfo.do?orderid=${orderItem.orderid }">订单详情</a>
		                          <br/>

		                          <c:choose>
		                              <c:when test="${orderItem.shippingStatus==0}">
		                                  待处理
		                              </c:when>
		                              <c:when test="${orderItem.shippingStatus==1}">
		                                  处理中
		                              </c:when>
		                              <c:when test="${orderItem.shippingStatus==2}">
		                                  <img src="../images/myOrder/car.png" alt=""/>已发货
				                          <br/>
				                          <a class="view_logistics" href="showOrderInfo.do?orderid=${orderItem.orderid }">查看物流</a>
		                              </c:when>
		                              <c:when test="${orderItem.shippingStatus==3}">
		                                  已交付
		                              </c:when>
		                              <c:when test="${orderItem.shippingStatus==4}">
		                                  已退回
		                              </c:when>
		                              <c:when test="${orderItem.shippingStatus==5}">
		                                  已取消
		                              </c:when>
		                          </c:choose>
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
<!--分页器-->
            <div class="tcdPageCode"></div>

        </div>
    </div>

        <!--<iframe src="order_status.html" width="1000" height=500""></iframe>-->
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
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
</html>