package com.backbase.bblog.utils;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter{
	
	public void onTestFailure(ITestResult result) {
		String rs = getMethodContext(result);
		System.err.println(rs+"|FAILED");				
	}
	
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String rs = getMethodContext(result);
		System.out.println(rs + "|SKIPPED");
		Reporter.log(rs + " |SKIPPED");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String rs = getMethodContext(result);
		System.out.println(rs + "|PASSED");
		Reporter.log(rs + " |PASSED");
	}

	private String getMethodContext(ITestResult result) {
		String testClass = result.getTestClass().getName();
		String name = result.getName();
		String rs = testClass + "|" + name;
		return rs;
	}

}
