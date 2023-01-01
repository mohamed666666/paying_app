package paying;

public class serviceFactory implements IserviceFactory  {

	@Override
	public Iservice chooseservice(char selector) {
		
		if (selector=='a') {
			return new recharge();
		}
		if(selector=='b') {
			return new internetpay();
		}
		
		if (selector=='c') {
			return new Landlin();
		}
		if(selector=='d' ) {
			return new Donations();
		}
		return null;
	}
	
	

}
