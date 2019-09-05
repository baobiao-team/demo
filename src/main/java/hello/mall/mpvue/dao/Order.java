package hello.mall.mpvue.dao;

public class Order {
	private String userId;
	private String orderStatue;
	private String orderId;
	private String proId;
	private String storeId;
	private String proNumOrder;    
	private double proPrice;   
	private String orderDiscount;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getProNumOrder() {
		return proNumOrder;
	}
	public void setProNumOrder(String proNumOrder) {
		this.proNumOrder = proNumOrder;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	public String getOrderDiscount() {
		return orderDiscount;
	}
	public void setOrderDiscount(String orderDiscount) {
		this.orderDiscount = orderDiscount;
	}
	public String getOrderStatue() {
		return orderStatue;
	}
	public void setOrderStatue(String orderStatue) {
		this.orderStatue = orderStatue;
	}
	@Override
	public String toString() {
		return "Order [userId=" + userId + ", orderId=" + orderId + ", proId=" + proId + ", storeId=" + storeId
				+ ", proNumOrder=" + proNumOrder + ", priPrice=" + proPrice + ", orderDiscount=" + orderDiscount
				+ ", orderStatus=" + orderStatue + "]";
	}
}
