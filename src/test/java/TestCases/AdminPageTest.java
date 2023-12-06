package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.TestBase;
import Pages.AdminPage;
import Pages.LoginPage;
import Utilities.TestUtil;

public class AdminPageTest extends TestBase {
	AdminPage ap;
	LoginPage lp;
	String sheetName = "sheet1";
	TestUtil tu;

	public AdminPageTest() {
		super();
	}

//	@DataProvider
//	public Object[][] getCRMTestData() throws EncryptedDocumentException, IOException
//	{
//		tu=new TestUtil();
//		Object data[][]=TestUtil.getTestData(sheetName);
//		return data;
//	}

	@Test
	public void userManangementButtonTest() throws InterruptedException {
		lp = new LoginPage();
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		ap = new AdminPage();
		ap.clickOnAdminButton();
		test.log(Status.INFO, "Clicked on Admin button on Home page ");
		log.info("Clicked on Admin button on Home page");
		Thread.sleep(3000);
		
		ap.clickOnUserManangementButton();
		test.log(Status.INFO, "Clicked on User Manangement Button ");
		log.info("Clicked on User Manangement Button");
		
		ap.clickOnusersButton();
		test.log(Status.INFO, "Clicked on user button under User Manangement");
		log.info("Clicked on user button under User Manangement");
		String empName = ap.getEmployeName();
		System.out.println("--------------------Employee Name is: " + empName + "---------------------");
		
		ap.clickOnaddButton();
		test.log(Status.INFO, "Clicked on Add button ");
		log.info("Clicked on Add button");
		
		ap.clickOnUserRoleDropDown();
		test.log(Status.INFO, "Clicked on User Role DropDown button ");
		log.info("Clicked on User Role DropDown button");
		
		ap.selectAdminRole();
		test.log(Status.INFO, "Admin Role is selected ");
		log.info("Admin Role is selected");
		
		ap.typeEmployeeName(empName);
		test.log(Status.INFO, "Employee name is entered ");
		log.info("Employee name is entered ");
		
		ap.selectEmployeeName();
		test.log(Status.INFO, "Employee name is is selected");
		log.info("Employee name is is selected");
		
		ap.clickOnStatusDropDown();
		test.log(Status.INFO, "Clicked on status DropDown button ");
		log.info("Clicked on status DropDown button");
		
		ap.selectStatusEnabled();
		test.log(Status.INFO, "Enable status is selected");
		log.info("Enable status is selected");
		
		ap.typeuserName("amit kumar");
		test.log(Status.INFO, "user name is entered ");
		log.info("user name is entered ");
		
		ap.typePassword();
		test.log(Status.INFO, "Password is enetered");
		log.info("Password is enetered ");
		
		ap.typeConfirmPassword();
		test.log(Status.INFO, "Confirm Password is enetered ");
		log.info("Confirm Password is enetered ");
		
		ap.clickOnSaveButton();
		test.log(Status.INFO, "Clicked on save button ");
		log.info("Clicked on save button ");

		log.info("form is submitted successfully");

	}

}
