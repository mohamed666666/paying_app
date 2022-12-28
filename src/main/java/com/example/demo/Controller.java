package com.example.demo;




import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Response;
import com.fasterxml.jackson.databind.node.ObjectNode;

import paying.account;
import paying.company;
import paying.database;
import paying.etisalat;
import paying.login;
import paying.orange;
import paying.register;
import paying.vodafone;
import paying.wallet;
import paying.we;


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
		
		return "a. Mobile recharge services.\n" + "b. Internet Payment services.\n" + "c. Landline services\n"; 
	}
	
	
	
	
	
	
	
	
	

}
