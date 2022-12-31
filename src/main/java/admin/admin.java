package admin;

import java.util.ArrayList;

import Client.database;
import paying.transaction;

public class admin  implements Observer {
	
	ArrayList<refundrequest> reqs=new ArrayList<refundrequest>();

	@Override
	public void update(refundrequest r) {
		reqs.add(r);
		
	}
	
	public ArrayList<refundrequest> GetReqs(){
		return this.reqs;
	}
	
	
	public double returnMonyBack(String ReqId,database data) {
		for(refundrequest rr:this.reqs) {
			if(rr.getReqId().equals(ReqId)) {
				rr.getTrans().Refund();
				transaction newtrans=new transaction(rr.getTrans().getComp(),rr.getTrans().getUser(),rr.getTrans().getFee());
				data.addtansaction(newtrans);
				return rr.getTrans().getFee();
			}
		}
		return 0;
		
	}
	
	

}
