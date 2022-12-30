package admin;

import Client.User;
import paying.transaction;

public class refundrequest {
	private User user;
	private transaction trans;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public transaction getTrans() {
		return trans;
	}
	public void setTrans(transaction trans) {
		this.trans = trans;
	}
	public refundrequest(User user, transaction trans) {
		
		this.user = user;
		this.trans = trans;
	}
	
	
	
	
}
