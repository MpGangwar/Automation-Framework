package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.TestBase;
import Utilities.TestUtil;

public class HomePage extends TestBase{
	TestUtil ts= new TestUtil();
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement dashboard;
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement adminLink;
	
	@FindBy(xpath="//span[text()='PIM']")
	WebElement PIMLink;
	
	@FindBy(xpath="//span[text()='Leave']")
	WebElement leaveLink;
	
	@FindBy(xpath="//p[text()='Time at Work']")
	WebElement timeAtWorkGrid;
	
	@FindBy(xpath="//p[text()='My Actions']")
	WebElement MyActionsGrid;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return dashboard.getText();
	}
	

	public AdminPage clickOnAdminLink()
	{
		ts.clickmethod(adminLink, 30);
		//adminLink.click();
		return new AdminPage();
	}

	public PIMPage clickOnPIMLink()
	{
		ts.clickmethod(PIMLink, 30);
		//PIMLink.click();
		return new PIMPage();
	}
	public LeavePage clickOnleaveLink() throws InterruptedException
	{
		ts.clickmethod(leaveLink, 30);
		//leaveLink.click();
		return new LeavePage(); 
	}
	
	public void VerifyTimeAtWorkGrid()
	{
		boolean isTextDisplayed = timeAtWorkGrid.isDisplayed();
		Assert.assertTrue(isTextDisplayed);
		System.out.println("Time at work grid is display");
		
	}
	
	public void verifyMyActionsGrid()
	{
		boolean isTextDisplayed1=MyActionsGrid.isDisplayed();
		Assert.assertTrue(isTextDisplayed1);
		System.out.println("My Actions grid is display");
		
	}
}
