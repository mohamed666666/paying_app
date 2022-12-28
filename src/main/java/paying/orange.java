package paying;

public class orange extends company{

	public orange(String compid, account compaccount) {
		super(compid, compaccount);
		// TODO Auto-generated constructor stub
	}

	public void payinternet( double mount) {
		// TODO Auto-generated method stub
		double currentbalance=this.getCompaccount().getAccbalance();
		this.getCompaccount().setAccbalance(currentbalance+mount);
		
	}

}

