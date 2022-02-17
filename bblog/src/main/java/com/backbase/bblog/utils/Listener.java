package com.backbase.bblog.utils;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener, IInvokedMethodListener{

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		String txtMsg = "About to begin executing "+returnMethodName(method.getTestMethod());
		Reporter.log(txtMsg, true);
		
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		String txtMsg = "Completed executing " + returnMethodName(method.getTestMethod());	
		Reporter.log(txtMsg, true);
	}

	private String returnMethodName(ITestNGMethod testMethod) {
		// TODO Auto-generated method stub
		return testMethod.getRealClass().getSimpleName() + "." + testMethod.getMethodName();
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		printTestResults(result);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		printTestResults(result);
		
	}

	private void printTestResults(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("TestName="+result.getTestName(),true);
		Reporter.log("Test Method resides in" + result.getTestClass().getName(),true);
		if(result.getParameters().length!=0) {
			String params = null;
			for(Object parameter:result.getParameters()) {
				params += parameter.toString() + ",";	
			}
		Reporter.log("Test Method had the following parameters:"+params, true);			
		}	
		String status = null;
		switch(result.getStatus()) {
		case ITestResult.SUCCESS:
				status = "Pass";
				break;
		case ITestResult.FAILURE:
			status = "Failed";
			break;
		case ITestResult.SKIP:
			status = "Skipped";
			break;			
		}
		Reporter.log("Test Status:" +status, true);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		printTestResults(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("About to begin executing test"+context.getName(), true);
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("Completed executing test"+context.getName(), true);
		
	}

}
