package paying;

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
		this.transId = comp.getCompid() + user.getEmail();
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
	
	
	
	
	
	
	

}
