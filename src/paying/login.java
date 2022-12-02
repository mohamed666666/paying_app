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
	
	
	

}
