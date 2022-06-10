package com.vtiger.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This class contains Implementation for ITestListeners interface
 * of TestNG
 * @author Abhishek
 *
 */
public class ListenerImplementationClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------> Start");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------>Script Execution Success");
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------>Script Execution Failed");
		System.out.println(result.getThrowable());
		
		try {
			String path = new WebDriverUtility().screenshot(BaseClass.sDriver, methodName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------>Script Execution Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Execution Started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution Finished");
	}

}
