package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class MyListeners implements ITestListener {
	
	public static ExtentReports test = Extent_report_manager.get_extent_report();
	
	public static ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = test.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.info("Success");
		extentTest.pass(result.getMethod().getMethodName()+" test Case Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.info("Failed");
		extentTest.pass(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		test.flush();
	}


	public static ExtentTest getExtentTest() {
		return extentTest;
	}
}