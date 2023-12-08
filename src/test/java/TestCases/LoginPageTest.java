package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage lp;
	
	 
	
	

	
	public LoginPageTest()
	{
		super();
	}
	
	

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
	
//	@Test(priority=2)
//	public void loginTest() throws InterruptedException
//	{
//		 lp=new LoginPage();
//		homePage=lp.login(prop.getProperty("username"), prop.getProperty("password"));
//
//		
//	}
	

	@Test(dataProvider="ExcelData")
	public void loginTest(String userame, String password) throws InterruptedException
	{
		lp=new LoginPage();
	
		lp.login(userame, password);
		
		
	

	}}
	
	
	
	
	
	

	


