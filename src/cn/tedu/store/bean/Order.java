package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable{
	
	private static final long serialVersionUID = 6664374961044644142L;
	private Integer id;
	private Integer userid;
	private int addressid;
	private double payment;
	private int paymentStatus;
	private int shippingStatus;
	private Date tradetime;
	private Date receiptime;
	private Date delivertime;
	private Date handovertime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userid=" + userid + ", addressid=" + addressid + ", payment=" + payment
				+ ", paymentStatus=" + paymentStatus + ", shippingStatus=" + shippingStatus + ", tradetime=" + tradetime
				+ ", receiptime=" + receiptime + ", delivertime=" + delivertime + ", handovertime=" + handovertime
				+ "]";
	}
	
	
	
	

}
