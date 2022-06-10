package practice;

import org.testng.annotations.Test;

public class DependsOnMethods {
	@Test()
	public void createAccount() throws Exception {
		System.out.println("login");
		System.out.println("AccountCreated");
		System.out.println("logout");
		throw new Exception();
	}
		
	
		
	@Test(dependsOnMethods="createAccount")
	public void modifyAccount() {
		System.out.println("Logged in");
		System.out.println("Account Modified");
		System.out.println("Logged out");
	}
	
	
	@Test(dependsOnMethods="modifyAccount")
	public void deleteAccount() {
		System.out.println("login");
		System.out.println("Deleted Account");
		System.out.println("");
	}
}
