package cn.tedu.store.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderItemVo implements Serializable{
	
	private static final long serialVersionUID = -8123738344601532830L;
	private Integer orderid;
	private Integer orderitemId;
	private Date tradetime;
	private String image;
	private String title;
	private Double price;
	private Integer count;
	private String spec;
	private Integer paymentStatus;
	private Integer shippingStatus;
	
	//实现日期的格式化
	private String showTime;
	
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	
	
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Integer getShippingStatus() {
		return shippingStatus;
	}
	public void setShippingStatus(Integer shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getOrderitemId() {
		return orderitemId;
	}
	public void setOrderitemId(Integer orderitemId) {
		this.orderitemId = orderitemId;
	}
	public Date getTradetime() {
		return tradetime;
	}
	public void setTradetime(Date tradetime) {
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		showTime = sdf.format(tradetime);
		this.tradetime = tradetime;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + ((orderitemId == null) ? 0 : orderitemId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemVo other = (OrderItemVo) obj;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		if (orderitemId == null) {
			if (other.orderitemId != null)
				return false;
		} else if (!orderitemId.equals(other.orderitemId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderItemVo [orderid=" + orderid + ", orderitemId=" + orderitemId + ", tradetime=" + tradetime
				+ ", image=" + image + ", title=" + title + ", price=" + price + ", count=" + count + ", spec=" + spec
				+ ", paymentStatus=" + paymentStatus + ", shippingStatus=" + shippingStatus + ", showTime=" + showTime
				+ "]";
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	



}
