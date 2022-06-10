package com.vtiger.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImp implements ITestListener{
	ExtentTest test;
	ExtentReports report;
	
	@Override
	public void onTestStart(ITestResult result) {
	// step 3: create a test method during the test execution starts
		test=report.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
	// step 4: log the pass method 
		test.log(Status.PASS, result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
	// step 6: log fail method, take screenshot, attach screen shot to extent report, add exception log
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		String path=null;
		WebDriverUtility wLib = new WebDriverUtility();
		try {
			path=wLib.screenshot(BaseClass.sDriver, result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
	// step 5: log the skip method (test case name and exception logs)
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}
	
	@Override
	public void onStart(ITestContext context) {
		// step 1: Extent report configuration
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./extentReport"+new JavaUtility().getSystemDateAndTime()+".html");
		htmlReporter.config().setReportName("Regression test execution report");
		htmlReporter.config().setDocumentTitle("Com.VTIGER automation execution Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		// step 2: attach the physical report and do the system configuration
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Windows 8");
		report.setSystemInfo("Environment", "Testing");
		report.setSystemInfo("URL", "http://localhost:8888");
		report.setSystemInfo("Reporter name", "Abhishek");
	}
	
	@Override
	public void onFinish(ITestContext context) {
	report.flush();	
	}
	
	

}
