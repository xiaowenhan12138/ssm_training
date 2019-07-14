<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="top" class="fixed_nav">
    <div id="logo" class="lf">
    	<a href="${pageContext.request.contextPath}/main/showIndex.do">
        	<img class="animated jello" src="${pageContext.request.contextPath}/images/header/logo.png" alt="logo"/>
        </a>
    </div>
    <div id="top_input" class="lf">
    	<form action="${pageContext.request.contextPath}/goods/showGoodsByTitle.do" method="post">
	        <input 
	        id="input" name="title" 
	        type="text" 
	        placeholder="请输入您要搜索的内容" 
	        style="width:360px"
	        value="${title}"/>
	        <a class="rt" onclick="document.forms[0].submit();"> <!-- search1(); -->
	        	<img id="search" src="${pageContext.request.contextPath}/images/header/search.png" alt="搜索"/>
	        </a>
        </form>
    </div>
    <div class="rt">
        <ul class="lf">
        	<li><a href="${pageContext.request.contextPath}/user/showPerson.do">${user.username}</a></li>
            <li><a href="${pageContext.request.contextPath}/web/favorites.jsp" title="我的收藏"><img class="care" src="${pageContext.request.contextPath}/images/header/care.png" alt=""/></a><b>|</b></li>
            <li><a href="${pageContext.request.contextPath}/order/showOrderItem.do" title="我的订单"><img class="order" src="${pageContext.request.contextPath}/images/header/order.png" alt=""/></a><b>|</b></li>
            <li><a href="${pageContext.request.contextPath}/cart/showCart.do" title="我的购物车"><img class="shopcar" src="${pageContext.request.contextPath}/images/header/shop_car.png" alt=""/></a><b>|</b></li>
            <li><a href="${pageContext.request.contextPath}/web/help.jsp">帮助</a><b>|</b></li>
            <c:if test="${user==null}">
            	<li><a href="${pageContext.request.contextPath}/user/showLogin.do">登录</a></li>
        		</c:if>
        		<c:if test="${user!=null}">
            	<li><a href="${pageContext.request.contextPath}/user/logout.do">退出</a></li>
        		</c:if>
        </ul>
    </div>
</header>
<script>
	function search1(){
		location="${pageContext.request.contextPath}/goods/showGoodsByTitle.do?title="+$("#input").val();
	}
</script>
<!--
	//注意开启tomcat配置文件conf/server.xml，对中文路径的支持 
	//第65行
    <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"
			 URIEncoding="UTF-8"/>
	
	//当前项目搜索时，已经改为post方式提交；但在搜索结果中查询第2页时，还是需要上述设置支持。
 -->










