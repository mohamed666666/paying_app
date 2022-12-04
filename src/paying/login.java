package paying;

public class login {
	private User Currentuser;
	public String Uname;
	public String pass;
	
	private login() {
		
	}
	private static  login log =null;
	
	
	public static login getinstance() {
		
		if(log==null) {
			log=new login();
		}
		return log;
	}
	
	
	public void loginguser(String uname,String pass,database data) {
		   User u=data.search(uname);
		   if(u!=null) {
			   if (u.getPass().equals(pass)) {
				   this.Currentuser=u;
				   System.out.println("Successfully logedin");
			   }
			   else {
				   System.out.println(" password incorrect");
			   }
		   }
		   else {
			   System.out.println("this user does not exist please register first");
		   }
		   
	}
	
	public void logout() {
		log=null;
		System.gc();
		
	}
	
	
	

}
