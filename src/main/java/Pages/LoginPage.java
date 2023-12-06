package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utilities.TestUtil;

public class LoginPage extends TestBase{

	TestUtil ts= new TestUtil();
	
	@FindBy(xpath="//input[@name=\'username\']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[text()=' Login ']")
	WebElement login;
	
	@FindBy(xpath="//img[@alt='company-branding']")
	WebElement logo;
	
	public LoginPage() 
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() 
	{
		
		return driver.getTitle();
	}
	
	public boolean validateCRMlogo() throws InterruptedException 
	{
		ts.waitForVisibilityOfElement(login, 30);
		return logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException
	{
		


ts.waitForVisibilityOfElement(login, 30);
		username.sendKeys(un);
		password.sendKeys(pwd);
		ts.clickmethod(login, 30);
		
		return new HomePage();
	}
	
}
