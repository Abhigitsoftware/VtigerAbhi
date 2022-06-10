package practice;

import org.testng.annotations.Test;

public class GroupExe1 {
	@Test(groups="regression")
	public void functional() {
		System.out.println("smoke & regressiontesting is done");
	}
	
	@Test(groups="usability")
	public void endtoend() {
		System.out.println("usabilitytesting is done");
	}
	
	@Test(groups={"usability","smoketesting"})
	public void integration() {
		System.out.println("usability, smoketesting is done");
	}

}
