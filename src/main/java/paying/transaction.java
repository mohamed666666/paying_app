package paying;

import java.util.Random;

import Client.User;
import companies.company;




public class transaction {
	private company comp;
	private User user;
	private double fee;
	private String transId;
	
	
	public transaction(company comp, User user, double fee) {
		
		this.comp = comp;
		this.user = user;
		this.fee = fee;
		Random random = new Random();
		
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = (int)fee;
		this.transId =random.ints(leftLimit, rightLimit + 1)
			      .limit(targetStringLength)
			      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			      .toString();
	}
	public company getComp() {
		return comp;
	}
	public void setComp(company comp) {
		this.comp = comp;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getTransId() {
		return transId;
	}
	
	
	
	public void transact() {
		
		double current_user_balance=user.getUserwallet().getBalance();
		user.getUserwallet().editBalance( current_user_balance- this.fee);
		comp.getCompaccount().add(this.fee);
		
	}
	
	public void Refund() {
		double current_user_balance=user.getUserwallet().getBalance();
		user.getUserwallet().editBalance( current_user_balance+this.fee);
		comp.getCompaccount().add(-this.fee);
		
	}
	
	
	
	
	
	

}
