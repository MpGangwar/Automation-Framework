package TestCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Base.TestBase;
import Pages.AdminPage;
import Pages.HomePage;
import Pages.LeavePage;
import Pages.LoginPage;
import Pages.PIMPage;

public class HomePageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	AdminPage ap;
	PIMPage pp;
	LeavePage leavep;
	
	public HomePageTest()
	{
		super();
	}

//	@BeforeMethod
//	public void setup() throws InterruptedException 
//	{
//		initialization();
//		lp=new LoginPage();
//		ap=new AdminPage();
//		pp=new	PIMPage();
//		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
//	}
	
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException
	{
		lp=new LoginPage();
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		hp=new HomePage();
		String homePageTitle = hp.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Dashboard","HomePage text is not matched");
		test.info("Home page title got successfully");
		
		log.info("Home Page Title is display");
	}
	
	@Test(priority=2)
	public void VerifyTimeAtWorkGridTest() throws InterruptedException
	{
		lp=new LoginPage();
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		hp=new HomePage();
		hp.VerifyTimeAtWorkGrid();
		test.info("TimeAtWorkGrid is display successfully");
		log.info("TimeAtWorkGrid is display");
	}
	
	@Test(priority=3)
	public void verifyMyActionsGrid() throws InterruptedException
	{
		lp=new LoginPage();
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		hp=new HomePage();
		hp.verifyMyActionsGrid();
		test.info("MyActions is display successfully");
		log.info("MyActions Grid is display");
	}
	
	@Test(priority=4)
	public void verifyAdminLinkTest() throws InterruptedException
	{
		lp=new LoginPage();
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		hp=new HomePage();
		ap=hp.clickOnAdminLink();
		test.info("Admin Link is display successfully");
		log.info("Admin Link is display");
	}
	
	@Test(priority=5)
	public void verifyPIMLinkTest() throws InterruptedException
	{
		lp=new LoginPage();
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		hp=new HomePage();
		pp=hp.clickOnPIMLink();
		test.info("PIM Link is display successfully");
		log.info("PIM Link is display");
	}
	
	@Test(priority=6)
	public void verifyleaveLink() throws InterruptedException
	{
		lp=new LoginPage();
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		hp=new HomePage();
		leavep=hp.clickOnleaveLink();
		test.info("Leave Link is display successfully");
		log.info("Leave Link is display");
	}

	
	
	
//	@AfterMethod
//	public void testDown()
//	{
//		driver.quit();
//	}
}
