package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.TestBase;

public class extentReportListener extends TestBase implements ITestListener {
	ExtentTest test;
	ExtentReports extent = getReport();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();// thread safe when you run test parallel

	@Override
	public void onTestStart(ITestResult result) {
		// ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);// It will create unique id for each test and assign to Extent test object
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test passed");
		String filepath = null;
		try {
			filepath = takeScreenShots(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// ITestListener.super.onTestFailure(result);
		extentTest.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String filepath = null;
		try {
			filepath = takeScreenShots(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		//ITestListener.super.onTestFailedWithTimeout(result);
//	}

	@Override
	public void onStart(ITestContext context) {
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// ITestListener.super.onFinish(context);
		extent.flush();
	}

}
