package Client;

public class User {
       private String uname;
       private String pass;
       private String email;
       private wallet userwallet;
       
       
       
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public wallet getUserwallet() {
		return userwallet;
	}
	public void setUserwallet(wallet userwallet) {
		this.userwallet = userwallet;
	}
	public User(String uname, String pass, String email) {
		
		this.uname = uname;
		this.pass = pass;
		this.email = email;
	}
	public User() {
		
	}

	
       
       
}
