package hello.mall.mpvue.controller;

public class Goods {
	
	private String proId; //商品ID
	
	private String proName; //商品名称
	
	private String proPrice; //商品价格
	
	private String proAddress;//商品产地
	
	private String proType;
	
	private String proNum;
	
	private String proDisc;
	
	private String proImg;

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProPrice() {
		return proPrice;
	}

	public void setProPrice(String proPrice) {
		this.proPrice = proPrice;
	}

	public String getProAddress() {
		return proAddress;
	}

	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public String getProNum() {
		return proNum;
	}

	public void setProNum(String proNum) {
		this.proNum = proNum;
	}

	public String getProDisc() {
		return proDisc;
	}

	public void setProDisc(String proDisc) {
		this.proDisc = proDisc;
	}

	public String getProImg() {
		return proImg;
	}

	public void setProImg(String proImg) {
		this.proImg = proImg;
	}

	@Override
	public String toString() {
		return "{proId=" + proId + ", proName=" + proName + ", proPrice=" + proPrice + ", proAddress="
				+ proAddress + ", proType=" + proType + ", proNum=" + proNum + ", proDisc=" + proDisc + ", proImg="
				+ proImg + "}";
	}
	
}
