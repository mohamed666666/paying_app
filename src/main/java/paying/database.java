package paying;

import java.util.ArrayList;

public class database {
	
	ArrayList<User> Users = new ArrayList<User>();
	
	ArrayList<wallet> wallets=new ArrayList<wallet>();
	
	ArrayList<company> companys=new ArrayList<company>();
	
	ArrayList<account> accounts=new ArrayList<account>();
	
	ArrayList<transaction> transactions=new ArrayList<transaction>();

	
	public int addUser(User u) {
		
		if (searchForUser(u.getEmail())==null) {
		Users.add(u);
		return 1;
		}
		
		return 0;
	}
	
	
	public User searchForUser(String em) {
		
		for(User u :this.Users) {
			if (u.getEmail().equals(em)) {
				return u;
			}
		}
		return null;
		
	}
	
	
	
	
	public void showuserdataByEmail(String email) {
		for(User u:this.Users) {
			if(u.getEmail().equals(email)) {
				//u.showuserdata();
				//u.getUserwallet().show();
			}
			
		}
		
	}
	
	
	public wallet searchForWallet(String wid) {
		
		for(wallet w :this.wallets) {
			if (w.getId().equals(wid)) {
				return w;
			}
		}
		return null;
	}
	
	
   public int addwallet(wallet w,User u) {
		
		if (searchForWallet(w.getId())==null) {
		wallets.add(w);
		
		u.setUserwallet(w);
		return 1;
		}
		
		return 0;
    	}
   
   
       
   public int addCompany(company c) {
		
		if (searchForComp(c.getCompid())==null) {
		companys.add(c);
		return 1;
		}
		
		return 0;
	}
	
	public company searchForComp(String id) {
		
		for(company c :this.companys) {
			if (c.getCompid().equals(id)) {
				return c;
			}
		}
		return null;
		
	}
	
	
public account searchForAcc(String accid) {
		
		for(account acc :this.accounts) {
			if (acc.getAccid().equals(accid)) {
				return acc;
			}
		}
		return null;
	}
	
	
   public int addAcc( account acc,company C) {
		
		if (searchForAcc(acc.getAccid())==null) {
		accounts.add(acc);
		
		C.setCompaccount(acc);
		return 1;
		}
		
		return 0;
    	}
   
   
   public void addtansaction(transaction t) {
	   
	   transactions.add(t);
   }
	
	
	

}
