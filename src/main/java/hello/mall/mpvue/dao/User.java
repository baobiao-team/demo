package hello.mall.mpvue.dao;

public class User {
	private String userName;    
	private String password;   
	private String userTel;
	private String userId;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	private String userAddress;
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", userTel=" + userTel + ", userId=" + userId
				+ ", userAddress=" + userAddress + "]";
	}
	
	
	
}
