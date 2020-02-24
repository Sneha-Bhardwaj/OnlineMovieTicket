package com.cg.onlinemovieticket.ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.cg.onlinemovieticket.model.User;
import com.cg.onlinemovieticket.service.LoginServiceImplementation;

public class MainClass {
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader buff=new BufferedReader(isr);

	LoginServiceImplementation ser;
	public static void main(String[] args) {
		MainClass mObject=new MainClass();
		  mObject.isr=new InputStreamReader(System.in);
			mObject.buff=new BufferedReader(mObject.isr);
		
		mObject.ser=new LoginServiceImplementation();
		
		mObject.selectOption();

	}
	public void selectOption() {
		
		System.out.println("\n 1.Login \n 2. Registration \n");
		
		try {
			int choice;
			choice=Integer.parseInt(buff.readLine());
		
		if(choice==1) {
			loginSelection();
			
		}
		if(choice==2) {
			userReg();
		}
	
		} catch (NumberFormatException | IOException e){
	
		e.printStackTrace();
	}
	}
	private void userReg() {
		try {
		System.out.println("Enter user id:");
		Integer uid=Integer.parseInt(buff.readLine());
		System.out.println("Enter User Name:");
		String name=buff.readLine();
		System.out.println("Enter password:");
		String pass = buff.readLine();
			if(ser.isValidation(uid, name, pass)) {
				if(ser.userRegistration(new User(uid,name,pass))) {
				System.out.println("Registration sucess...");
				selectOption();
			}
				}
			else {
				System.out.println("Registration failed...");
				selectOption();	
				
		} }catch (IOException e) {
	
			e.printStackTrace();
		}
		
	}
		
	
	
	private void loginSelection() {
		
		System.out.println("\n 1.Login As admin \n 2. Login As user \n");
		int choice;
		try {
			choice=Integer.parseInt(buff.readLine());
			if(choice==1) {
				System.out.println("Enter Admin id:");
				String uid=buff.readLine();
				System.out.println("Enter password:");
				String pass=buff.readLine();
				boolean f=ser.loginAsAdmin(uid, pass);
				if(f) {
					System.out.println("Ädmin login Success......");
					return;
				}
				else {
					System.out.println("Invalid user id & password");
					selectOption();
		} 
		 }
			if(choice==2) {
				System.out.println("Enter user id:");
				Integer uid=Integer.parseInt(buff.readLine());
				System.out.println("Enter password:");
				String pass=buff.readLine();
				boolean f=ser.loginAsUser(uid, pass);
				if(f) {
					System.out.println("User login Success......");
					return;
				}
				else {
					System.out.println("Invalid user id & password");
					selectOption();
				}
			}
			 }catch (NumberFormatException  |IOException e) {
			    e.printStackTrace();
		}
		
			
		
	}

}
