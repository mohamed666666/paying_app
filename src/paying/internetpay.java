package paying;

public class internetpay  implements Iservice{

	@Override
	public void paying(transaction t) {
		// TODO Auto-generated method stub
		t.transact();
		System.out.println("internet payment done ");
		
	}

}
