package admin;

import java.util.ArrayList;

import Client.User;
import paying.transaction;

public class refundrequest implements Subject {
	
	private ArrayList<Observer >observers=new ArrayList<Observer>();
	private String userid;
	private transaction trans;
	private String ReqId;
	
	
	
	public String getUserId() {
		return userid;
	}
	
	public transaction getTrans() {
		return trans;
	}
	public void setTrans(transaction trans) {
		this.trans = trans;
	}
	public refundrequest(String userid, transaction trans) {
		
		this.userid = userid;
		this.trans = trans;
		this.ReqId=userid+trans.getTransId();
	}
	public String getReqId() {
		return ReqId;
	}

	public void setReqId(String reqId) {
		ReqId = reqId;
	}

	@Override
	public void Subscrib(Observer O) {
		
		observers.add(O);
	}
	@Override
	public void UnSubscrib(Observer O) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void NotifyAll() {
		for(Observer O:this.observers) {
			O.update(this);
		}
		
	}
	
	
	
	
	
}
