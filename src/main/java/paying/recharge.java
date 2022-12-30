package paying;

public class recharge implements Iservice {
	private String name="Recharge";
	
	

	@Override
	public void paying(transaction t) {
		// TODO Auto-generated method stub
		t.transact();
		System.out.println("recharging done ");
	}
 
	@Override
	public String toString() {
		return  name  ;
	}
}
