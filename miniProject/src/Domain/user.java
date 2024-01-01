package Domain;

import java.sql.Date;

public class user {
	private String userId;
	private String userPassword;
	private String userName;
	private Date userBirth;
	private String userPhone;
	private int userTime;
	private boolean userIsadmin;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}
	
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	public int getUserTime() {
		return userTime;
	}
	public void setUserTime(int userTime) {
		this.userTime = userTime;
	}
	
	public boolean isUserIsadmin() {
		return userIsadmin;
	}
	public void setUserIsadmin(boolean userIsadmin) {
		this.userIsadmin = userIsadmin;
	}
}
