package paying;

public class recharge implements Iservice {

	@Override
	public void paying(transaction t) {
		// TODO Auto-generated method stub
		t.transact();
		System.out.println("recharging done ");
	}
 
}
