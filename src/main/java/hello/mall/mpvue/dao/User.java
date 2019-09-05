package hello.mall.mpvue.dao;

public class User {
	private String username;    
	private String password;   
	private String phone;
	private String userid;
	private String address;
	public String getUsername() {        
		return username;    
		}     
	public void setUsername(String username) {
		this.username = username;    
		}     
	public String getPassword() {       
		return password;    
		}     
	public void setPassword(String password) {  
		this.password = password;    
		}   
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    @Override    
    public String toString() {     
    	return "Login{" +               
    "username='" + username + '\'' +             
    ", password='" + password + '\'' +   
     ", phone='" + phone + '\'' +
      ", userid='" + userid + '\'' +
       ", address='" + address + '\'' +
    '}';  
    	}
	
	
}
