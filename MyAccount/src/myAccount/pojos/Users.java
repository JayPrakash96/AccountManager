package myAccount.pojos;

public class Users {
	private int Userid;
	private String Username;
	private String Password;
	private String Name;
	private String Address;
	private String Mobile;
	private String Email;
	public Users(int userid, String username, String password, String name, String address, String mobile,
			String email) {
		super();
		Userid = userid;
		Username = username;
		Password = password;
		Name = name;
		Address = address;
		Mobile = mobile;
		Email = email;
	}
	public Users(String username, String password, String name, String address, String mobile, String email) {
		super();
		Username = username;
		Password = password;
		Name = name;
		Address = address;
		Mobile = mobile;
		Email = email;
	}
	public Users() {
		super();
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "Users [Userid=" + Userid + ", Username=" + Username + ", Password=" + Password + ", Name=" + Name
				+ ", Address=" + Address + ", Mobile=" + Mobile + ", Email=" + Email + "]";
	}
	
}	