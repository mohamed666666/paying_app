package paying;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		register registeration= new register();
		
		database data=new database();
		login loging=login.getinstance();
		
		
		System.out.println("wleocme do you want 1-login 2-register ");
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		
			
			if (a==1) {
				Scanner in1 = new Scanner(System.in);
				System.out.println("enter email: ");
				String em=in1.nextLine();
				System.out.println("enter pass: ");
				
				Scanner in2 = new Scanner(System.in);
				String pass=in2.nextLine();
				
				
				loging.loginguser(em, pass, data);
				
			}
			if(a==2) {
				Scanner in1 = new Scanner(System.in);
				System.out.println("enter email: ");
				String em=in1.nextLine();
				System.out.println("enter pass: ");
				
				Scanner in2 = new Scanner(System.in);
				String pass=in2.nextLine();
				
				if(registeration.signup(em, pass, data)==1) {
					System.out.println("Successfully registerd you can log in now ");
				}
				else {
					System.out.println("this user actually in use  ");
				}
				
			}
		
		data.showdata();
		
		
		
		
		
		

	}


	
	
	
	
	
}
