package paying;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		//creating the database of application
		database data=new database();
		
		account acc=new account("145",14520);
		company ets=new etisalat();
		
		data.addCompany(ets);
		data.addAcc(acc, ets);
		
		System.out.println(ets.getCompaccount().getAccbalance());
		
		
		
		
		//the registeration form
		register registeration= new register();

		//creating the login form 
		login loging=login.getinstance();
		
		
		System.out.println("wleocme do you want 1-login 2-register ");
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		
			
			if (a==1) {
				
				//getting the data for login
				Scanner in1 = new Scanner(System.in);
				System.out.println("enter email: ");
				String em=in1.nextLine();
				System.out.println("enter pass: ");
				
				Scanner in2 = new Scanner(System.in);
				String pass=in2.nextLine();
				in1.close();
				in2.close();
				
				loging.loginguser(em, pass, data);
				
			}
			if(a==2) {
				
				// getting the data for register
				Scanner in1 = new Scanner(System.in);
				System.out.println("enter email: ");
				String em=in1.nextLine();
				System.out.println("enter pass: ");
				
				Scanner in2 = new Scanner(System.in);
				String pass=in2.nextLine();
				in1.close();
				in2.close();
				if(registeration.signup(em, pass, data)==1) {
					System.out.println("Successfully registerd you  log in now ");
					loging.loginguser(em, pass, data);
					
					System.out.println("please enter your wallet information :");
					
					Scanner in3 = new Scanner(System.in);
					System.out.println("enter wallet id: ");
					String wid=in3.nextLine();
					System.out.println("Balance : ");
					
					Scanner in4= new Scanner(System.in);
					double balance=in4.nextDouble();
					
					wallet w=new wallet(wid,balance );
					
					data.addwallet(w, loging.getCurrentuser());
					
					data.showuserdataByEmail(em);
					in3.close();
					in4.close();
					
					
				
				}
				else {
					System.out.println("this user actually in use  ");
				}
				
			}
		in.close();
	
		
		

		
		

	}


	
	
	
	
	
}
