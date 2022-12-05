package paying;

public class serviceFactory implements IserviceFactory  {

	@Override
	public Iservice chooseservice(char selector) {
		
		if (selector=='a') {
			return new internetpay();
		}
		if(selector=='b') {
			return new recharge();
		}
		
		return null;
	}
	
	

}
