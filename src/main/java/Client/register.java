package Client;

public class register {
	
	public int signup(String email,String pass,database d) {
		String s[]=email.split("@");
		
		String uname=s[0];
		User temp =new User(uname,pass,email );
		
		return d.addUser(temp);
		
	}

}
