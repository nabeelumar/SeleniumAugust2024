package andoorathodi.SeleniumTestNGJuly2024;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("TEST NAMED "+result.getName()+" HAS STARTED");
 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	 
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		 
	}

}
