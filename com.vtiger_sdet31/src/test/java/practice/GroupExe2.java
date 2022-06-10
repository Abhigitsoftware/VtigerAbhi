package practice;

import org.testng.annotations.Test;

public class GroupExe2 {
	@Test(groups="usability")
	public void performancetesting() {
		System.out.println("usability testing is done");
	}
	
	@Test(groups={"smoketesting","regression"})
	public void usabilitytesting() {
		System.out.println("smoketesting & regressiontesting is done");
	}
	
	@Test(groups={"usability","regression","smoketesting"})
	public void globalizationtesting() {
		System.out.println("usability, regression & smoketesting is done");
	}
}
