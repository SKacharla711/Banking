package com.w2a.listeners;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.w2a.base.Base;
import com.w2a.utilities.ExtentManager;

public class CustomListeners extends Base implements ITestListener, ISuiteListener {

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Test Suite " + result.getName() + " ending ***"));
		ExtentManager.startTest(result.getMethod().getMethodName().toUpperCase());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentManager.getTest().log(Status.PASS, result.getName().toUpperCase()+" PASS");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentManager.getTest().log(Status.FAIL, result.getName().toUpperCase()+" Test Failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentManager.getTest().log(Status.SKIP, result.getName().toUpperCase()+" Test Skipped");
	}

	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentManager.endTest();
		ExtentManager.getInstance().flush();

	}

}
