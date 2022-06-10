package practice;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericutility.BaseClass;

@Listeners(com.vtiger.genericutility.ListenerImp.class)
public class ReportTest extends BaseClass {
	@Test
	public void createOrg() {
		System.out.println("passed");
	}
	
	@Test
	public void createContact() {
		System.out.println("fail");
		Assert.fail();
	}
	
	@Test
	public void createproduct() throws Exception{
	System.out.println("skipped");
	throw new SkipException("skipped");
	}

}
