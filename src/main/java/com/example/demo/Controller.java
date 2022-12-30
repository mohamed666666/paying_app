package com.example.demo;




import java.util.ArrayList;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Response;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Client.database;
import Client.login;
import Client.register;
import Client.wallet;
import companies.account;
import companies.company;
import companies.etisalat;
import companies.orange;
import companies.vodafone;
import companies.we;
import paying.Iservice;
import paying.serviceFactory;
import paying.transaction;


@RestController
public class Controller {
	
	private database data = new database();
	private register registeration = new register();

	// creating the login form
	private login loging = login.getinstance();
	
	company ets;
	company voda ;
	company orange;
	company we;
	serviceFactory servicefact = new serviceFactory();
	Iservice service=null;
	
	
	
	Controller() {
		 account etsacc = new account("011ac", 14520);
		 ets = new etisalat("011", etsacc);

		data.addCompany(ets);
		data.addAcc(etsacc, ets);

		account vodacc = new account("010ac", 1424);
		voda = new vodafone("010", vodacc);

		data.addCompany(voda);
		data.addAcc(vodacc, voda);

		account orangeacc = new account("012ac", 123457);
		orange = new orange("012", orangeacc);
		
		data.addCompany(orange);
		data.addAcc(orangeacc, orange);

		account weacc = new account("015ac", 5895);
	    we = new we("015", weacc);

		data.addCompany(we);
		data.addAcc(weacc, we);
	}
	
	
	
	
	
	
	@GetMapping("hi") 
	public String hellow() {
		
		return "hi from server"; 
	}
	
	
	
	
	
	
	@PostMapping("/Register")
    public Response Register(@RequestBody ObjectNode objectNode) {
		String em = objectNode.get("email").asText();
		String pass = objectNode.get("pass").asText();
        int res = registeration.signup(em, pass, data);
        Response response = new Response();
        if (res != 1) {
            response.setStatus(false);
            response.setMessage("User Already Exists");
            return response;
        }

        response.setStatus(true);
        response.setMessage("Person created successfully");
        return response;
    }
	
	
	
	@PostMapping("/Login")
	public Response Login(@RequestBody ObjectNode objectNode ) {
		String em = objectNode.get("email").asText();
		String pass = objectNode.get("pass").asText();
		Response response = new Response();
		int res = loging.loginguser(em, pass, data);
		if (res == 2) {
            response.setStatus(false);
            response.setMessage("this user does not exist please register first");
            return response;
        }
		if(res==0) {
		response.setStatus(true);
        response.setMessage("Person logging in  successfully");
        return response;
		}
		
		response.setStatus(false);
        response.setMessage("incorrect password");
        return response;
	}
	
	
	
	@PostMapping("/addw")
	public wallet addwallet(@RequestBody wallet w) {
		data.addwallet(w, loging.getCurrentuser());
		return loging.getCurrentuser().getUserwallet();
		
	}
	
	
	
	@GetMapping("/services") 
	public String Services() {
		
		return "a. Mobile recharge services.\n"
				+"i. Vodafone\n" + "ii.Etisalat\n" + "iii. Orange\n"
		+ "b. Internet Payment services.\n"+
		"i. Vodafone\n" + "ii.Etisalat\n" + "iii. Orange\n"
				+ "c. Landline services\n"+
				"i. Monthly\n" + "ii.3Months\n" ; 
	}
	
	@PostMapping("/service/{s}/company/{c}") 
	public Response ServiceCompany(@PathVariable("s")char s,@PathVariable("c")String c,@RequestBody ObjectNode objectNode) {
		 service = servicefact.chooseservice(s);
		 Response response = new Response();
		 double fee = objectNode.get("fee").asDouble();
		 
		 if (service!=null) {
			 
			 if (c.equals("i")) {
				 paying(fee,service, voda, loging, data);
        	 
				 response.setStatus(true);
				 response.setMessage("You have payed to Vodafone");
				 return response;
         }
        
         
         if (c.equals("ii")) {
        	 paying(fee,service, ets, loging, data);
        	 
        	 response.setStatus(true);
        	 response.setMessage("You have payed to Etisalat");
        	 return response;
         }
         
         else if (c.equals("iii")) {
        	 paying(fee,service, orange, loging, data);
        	 
        	 response.setStatus(true);
        	 response.setMessage("You have payed to orange");
        	 return response;
         }
         else {
        	 response.setStatus(false);
        	 response.setMessage("this company not in the system ");
         }
         
		 }
		 else {
			 response.setStatus(false);
        	 response.setMessage("this Service not in the system ");
		 }
		 
		return response;
		
	}
	
	
	 @GetMapping("/service/{c}")
	 public Response service(@PathVariable("c")char c){
		 Response response = new Response();
		 service = servicefact.chooseservice(c);
		 
	        if (service == null) {
	            response.setStatus(false);
	            response.setMessage("Service Not Found");
	            return response;
	        }
	        
	        
	        response.setStatus(true);
	        response.setMessage("Service is exist U can use it bro !");
	        

	        return response;
	 }
	 
	 
	 @GetMapping("transactions")
	 public ArrayList<transaction> showTrans(){
		 
		 return data.getTransactions();
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	 public static void paying(double fee,Iservice service, company c, login l, database data) {
			transaction t;
			t = new transaction(c, l.getCurrentuser(), fee);
			service.paying(t);

			data.addtansaction(t);

		}
	 
	 
	
	
	
	
	

}
