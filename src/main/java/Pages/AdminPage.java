package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utilities.TestUtil;

public class AdminPage extends TestBase{
	TestUtil ts=new TestUtil();
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Admin']")
	WebElement adminButton;
	
	@FindBy(xpath="//span[text()='User Management ']")
	WebElement userManangementButton;
	
	@FindBy(xpath="(//div[contains(@class,\"oxd-table-body\")]/div[contains(@class,\"oxd-table-card\")])[1]//div[contains(@class,\"oxd-table-cell\")][4]")
	WebElement getEmployeeName;
	
	@FindBy(xpath="//a[@class='oxd-topbar-body-nav-tab-link' and text()='Users']")
	WebElement usersButton;
	
	@FindBy(xpath="//button[@type='button' and @class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
	WebElement addButton;
	
	@FindBy(xpath="//div[contains(@class,'oxd-input-group__label-wrapper')]//label[text()='User Role']/../following-sibling::div/descendant::div[@class='oxd-select-text--after']")
	WebElement userRole;
	
	@FindBy(xpath="//div[@role=\"listbox\"]//descendant::div//following-sibling::div//child::span[text()='Admin'] ")
	WebElement roleAdmin;
	
	@FindBy(xpath="//input[@placeholder=\"Type for hints...\"]")
	WebElement employeeName;
	
	@FindBy(xpath="//div[@role=\"option\"]/span")
	WebElement selectEmployee;
	
	@FindBy(xpath="//div[contains(@class,'oxd-input-group__label-wrapper')]//label[text()='Status']/../following-sibling::div//descendant::div[@class='oxd-select-text-input']")
	WebElement selectStatus;
	
	@FindBy(xpath="//span[text()='Enabled']")
	WebElement statusEnabled;
	
	@FindBy(xpath="//label[text()='Username']//parent::div//following-sibling::div//descendant::input[@class=\"oxd-input oxd-input--active\"]")
	WebElement userName;
	
	@FindBy(xpath="//label[text()='Password']//parent::div//following-sibling::div//descendant::input")
	WebElement password;
	
	@FindBy(xpath="//label[text()='Confirm Password']//parent::div//following-sibling::div//descendant::input")
	WebElement confirmPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;
	
	
	public AdminPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAdminButton()
	{
		ts.clickmethod(adminButton, 30);
		//adminButton.click();
	}
	
	public void clickOnUserManangementButton()
	{
		ts.clickmethod(userManangementButton, 30);
		//userManangementButton.click();
	}
	public String getEmployeName()
	{
		String employeeName1 = getEmployeeName.getText();
		return employeeName1;
	}
	
	public void clickOnusersButton()
	{
		ts.clickmethod(usersButton, 30);
		//usersButton.click();
	}
	
	
	public void clickOnaddButton()
	{
		ts.clickmethod(addButton, 30);
		//addButton.click();
	}
	public void clickOnUserRoleDropDown()
	{
		ts.clickmethod(userRole, 30);
		//userRole.click();
	}
	public void selectAdminRole()
	{
		ts.clickmethod(roleAdmin, 30);
		//roleAdmin.click();
	}
	public void typeEmployeeName(String employeeName1)
	{
		ts.sendkeysMethod(employeeName, employeeName1);
		//employeeName.sendKeys(employeeName1);
	}
	public void selectEmployeeName()
	{
		ts.clickmethod(selectEmployee, 30);
		//selectEmployee.click();
	}
	
	public void clickOnStatusDropDown()
	{
		ts.clickmethod(selectStatus, 30);
		//selectStatus.click();
	}
	public void selectStatusEnabled()
	{
		ts.clickmethod(statusEnabled, 30);
		//statusEnabled.click();
		System.out.println("this is status Enable method");
	}
	public void typeuserName(String Name) throws InterruptedException
	{
//		System.out.println("this is username method");
//		Thread.sleep(5000);
		userName.clear();
		Thread.sleep(5000);
		userName.sendKeys(Name);
	}

	public void typePassword()
	{
		ts.sendkeysMethod(password,"Admin123456" );
		//password.sendKeys("Admin123456");
	}
	public void typeConfirmPassword()
	{
		ts.sendkeysMethod(confirmPassword,"Admin123456" );
		//confirmPassword.sendKeys("Admin123456");
	}
	public void clickOnSaveButton()
	{
		ts.clickmethod(saveButton, 30);
		//saveButton.click();
	}
	
}
