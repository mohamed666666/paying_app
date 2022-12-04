package paying;

import java.util.ArrayList;

public class database {
	
	ArrayList<User> Users = new ArrayList<User>();
	
	ArrayList<wallet> wallets=new ArrayList<wallet>();
	
	
	public int addUser(User u) {
		
		if (search(u.getUname())==null) {
		Users.add(u);
		return 1;
		}
		
		return 0;
	}
	
	
	public User search(String Uname) {
		
		for(User u :this.Users) {
			if (u.getUname().equals(Uname)) {
				return u;
			}
		}
		return null;
		
	}
	
	public void showdata() {
		for(User u:this.Users) {
			u.showuserdata();
		}
		
	}
	

}
