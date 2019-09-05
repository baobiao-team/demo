package hello.mall.mpvue.dao;

public class Order {
	private String userId;      
	private String orderId;
	private String proId;
	private String storeId;
	private String proNumOrder;    
	private double priPrice;   
	private String orderDiscount;
	private String orderStatus;
	
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
	public double getPriPrice() {
		return priPrice;
	}
	public void setPriPrice(double priPrice) {
		this.priPrice = priPrice;
	}
	public String getOrderDiscount() {
		return orderDiscount;
	}
	public void setOrderDiscount(String orderDiscount) {
		this.orderDiscount = orderDiscount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [userId=" + userId + ", orderId=" + orderId + ", proId=" + proId + ", storeId=" + storeId
				+ ", proNumOrder=" + proNumOrder + ", priPrice=" + priPrice + ", orderDiscount=" + orderDiscount
				+ ", orderStatus=" + orderStatus + "]";
	}
}
