package paying;

public class we extends company implements internetpayment{

	
	public we() {}
	
	public we(String compid, account compaccount) {
		super(compid, compaccount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void payinternet(double mount) {
		// TODO Auto-generated method stub
		double currentbalance=this.getCompaccount().getAccbalance();
		this.getCompaccount().setAccbalance(currentbalance+mount);
		
		
	}

}
