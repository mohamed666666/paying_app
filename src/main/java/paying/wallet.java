package paying;

public class wallet {
	private String id;
	double balance;
	
	
	public wallet(String id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void editBalance(double newbalance) {
		this.setBalance(newbalance);
	}
	/*
	public void show() {
		System.out.println("wallet id :"+this.id);
	}*/
}
