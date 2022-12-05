package paying;

public class vodafone extends company {

	public vodafone(String compid, account compaccount) {
		super(compid, compaccount);
		// TODO Auto-generated constructor stub
	}
	public vodafone() {
		
		
	}
	
	public void payinternet(double mount) {
		// TODO Auto-generated method stub
		double currentbalance=this.getCompaccount().getAccbalance();
		this.getCompaccount().setAccbalance(currentbalance+mount);
		
	}

}
