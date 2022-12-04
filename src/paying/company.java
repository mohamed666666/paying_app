package paying;

public abstract  class  company {

	private String compid;
	private account compaccount;
	
	public company() {}
	
	
	public company(String compid, account compaccount) {
		
		this.compid = compid;
		this.compaccount = compaccount;
	}
	
	
	
	
	public String getCompid() {
		return compid;
	}
	public void setCompid(String compid) {
		this.compid = compid;
	}
	public account getCompaccount() {
		return compaccount;
	}
	public void setCompaccount(account compaccount) {
		this.compaccount = compaccount;
	}
	
}
