package Client;

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
	
	
	public int loginguser(String em,String pass,database data) {
		   User u=data.searchForUser(em);
		   if(u!=null) {
			   if (u.getPass().equals(pass)) {
				   this.Currentuser=u;
				   //System.out.println("Successfully logedin");
				   return 0;
			   }
			   else {
				  // System.out.println(" password incorrect");
				   return 1;
			   }
		   }
		   else {   
			  // System.out.println("this user does not exist please register first");
			   return 2;
		   }
		   
	}
	
	public void logout() {
		log=null;
		System.gc();
		
	}


	public User getCurrentuser() {
		return Currentuser;
	}


	


}
