package companies;

import Client.database;

public class CompanyFactory implements IcompanyFactory {

	@Override
	public company chooseCompany(String theOrder ,database data ) {
		 
		if (theOrder.equals("i")) {
			return data.searchForComp("010");
		}
		if (theOrder.equals("ii")) {
			return data.searchForComp("011");
		}
		if (theOrder.equals("iii")) {
			return data.searchForComp("012");
		}
		if (theOrder.equals("iiii")) {
			return data.searchForComp("015");
		}
		return null;
	}

}
