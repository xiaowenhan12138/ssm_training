package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderInfoVo implements Serializable{
	
	private static final long serialVersionUID = -6841226565810902021L;

	private Integer orderid;
	private double payment;
	private int paymentStatus;
	private int shippingStatus;
	private Date tradetime;
	private Date receiptime;
	private Date delivertime;
	private Date handovertime;

	//收货人信息
	private String recvName;
	private String recvZip;
	private String recvPhone;
	private String recvTel;
	private String recvDistrict;
	private String recvAddr;
	
	private List<OrderItemVo> listItems;
	
	
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	
	public int getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public int getShippingStatus() {
		return shippingStatus;
	}
	public void setShippingStatus(int shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	public Date getTradetime() {
		return tradetime;
	}
	public void setTradetime(Date tradetime) {
		this.tradetime = tradetime;
	}
	public Date getReceiptime() {
		return receiptime;
	}
	public void setReceiptime(Date receiptime) {
		this.receiptime = receiptime;
	}
	public Date getDelivertime() {
		return delivertime;
	}
	public void setDelivertime(Date delivertime) {
		this.delivertime = delivertime;
	}
	public Date getHandovertime() {
		return handovertime;
	}
	public void setHandovertime(Date handovertime) {
		this.handovertime = handovertime;
	}
	public List<OrderItemVo> getListItems() {
		return listItems;
	}
	public void setListItems(List<OrderItemVo> listItems) {
		this.listItems = listItems;
	}
	
	public String getRecvName() {
		return recvName;
	}
	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}
	public String getRecvZip() {
		return recvZip;
	}
	public void setRecvZip(String recvZip) {
		this.recvZip = recvZip;
	}
	public String getRecvPhone() {
		return recvPhone;
	}
	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}
	public String getRecvTel() {
		return recvTel;
	}
	public void setRecvTel(String recvTel) {
		this.recvTel = recvTel;
	}
	public String getRecvDistrict() {
		return recvDistrict;
	}
	public void setRecvDistrict(String recvDistrict) {
		this.recvDistrict = recvDistrict;
	}
	public String getRecvAddr() {
		return recvAddr;
	}
	public void setRecvAddr(String recvAddr) {
		this.recvAddr = recvAddr;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
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
		OrderInfoVo other = (OrderInfoVo) obj;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderInfoVo [orderid=" + orderid + ", payment=" + payment + ", paymentStatus=" + paymentStatus
				+ ", shippingStatus=" + shippingStatus + ", tradetime=" + tradetime + ", receiptime=" + receiptime
				+ ", delivertime=" + delivertime + ", handovertime=" + handovertime + ", recvName=" + recvName
				+ ", recvZip=" + recvZip + ", recvPhone=" + recvPhone + ", recvTel=" + recvTel + ", recvDistrict="
				+ recvDistrict + ", recvAddr=" + recvAddr + ", listItems=" + listItems + "]";
	}
	
	
	
	
	
}
