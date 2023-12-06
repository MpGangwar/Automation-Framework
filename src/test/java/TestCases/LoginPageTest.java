package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage lp;
	HomePage homePage;
	 
	
	

	
	public LoginPageTest()
	{
		super();
	}
	
	
//	@BeforeMethod
//	public void setUp() throws InterruptedException
//	{
//		
//		initialization();
//		 lp=new LoginPage();
//	}
	
	@Test(priority=1)
	public void loginPageTitileTest() throws InterruptedException
	{
		
		 lp=new LoginPage();
		String title=lp.validateLoginPageTitle();
		Assert.assertEquals(title.trim(), "OrangeHRM");
		test.info(" login page title is display");
		log.info("login page title is display");
		
	}
	
	@Test( enabled = true)
	public  void logoImageTest() throws InterruptedException
	{
		 lp=new LoginPage();
		boolean flag = lp.validateCRMlogo();
		Assert.assertTrue(flag);
		test.info("Logo of the application is display ");;
		log.info("Logo of the application is display ");
	}
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException
	{
		 lp=new LoginPage();
		homePage=lp.login(prop.getProperty("username"), prop.getProperty("password"));
//		test.info("Clicked on Login button");
//		log.info("Clicked on Login button");
		
	}
	
	
	
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}
//	
	

}
