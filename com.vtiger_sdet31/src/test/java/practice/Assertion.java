package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
@Test(enabled=false)
	public void assertionBoolean() {
		boolean exp=true;
		boolean act=true;
		Assert.assertEquals(act, exp);			//pass
}
		
		@Test(enabled=false)
		public void assertionString() {
		String exp1= "TestYantra in Bangalore";
		String act1="TestYantra in Mangalore";
		Assert.assertEquals(act1, exp1);	//fail
}
		
		@Test(enabled=false)
		public void softAssert() {
			int x=100;
			int y=200;
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(y, x);		//pass
		}
		
		@Test
		public void softAssert1() {
			int x=100;
			int y=200;
			SoftAssert soft = new SoftAssert();
		soft.assertEquals(y, x);
		System.out.println("X & Y values are different");
	
		
		}
		
		
		
		
		
		

}
