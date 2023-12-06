package Utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter {
	public void onTestSuccess(ITestResult tr) {
		System.out.println("Test Passed");
	}
	public void onTestFailure(ITestResult tr) {
		System.out.println("Test Failed");
	}
	 public void onStart(ITestContext testContext) {
		 System.out.println("Test Started");
	 }
	 public void onTestSkipped(ITestResult tr) {
		 System.out.println("Test skipped");
	 }
	 

}
