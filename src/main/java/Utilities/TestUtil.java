package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class TestUtil extends TestBase {
	
	
	
	
    
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainPanel");
	}
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\dell\\eclipse-workspace\\AutomationFramework\\src\\main\\java\\testData\\orangeHRM.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException{
		FileInputStream file=null;
		try {
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i + 1).getCell(k).toString();
			}}
		
		
		return null;
		
		
	}

	public static String takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		return currentDir ; 
		

		
	}

	


	public WebElement waitForVisibilityOfElement(WebElement element,long waitTimeSecond)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(waitTimeSecond));
		WebElement elements = wait.until(ExpectedConditions.visibilityOf(element));
		return elements;
	}	
	
		
		
		public WebElement waitForElementToBeClickable(WebElement elementName,long waitTimeSecond)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(waitTimeSecond));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementName));
			return element;
		}

		// For Click Action
		
		public void clickmethod(WebElement element,long waitTimeInSecond)
		{
			WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(waitTimeInSecond));
			WebElement elements= null;
			elements=wait.until(ExpectedConditions.elementToBeClickable(element));
			elements.click();
			test.info("Clicked on element");
			log.info("Clicked on element");
			
			
		}
		
		// For sendKeys Action
		
		public void sendkeysMethod(WebElement element, String text)
		{
			waitForElementToBeClickable(element,20);
			element.click();
			element.clear();
			element.sendKeys(text);
			test.info("Data entered in to text field");
			log.info("Data entered in to text field");
			
		}
		
		// For Drop Down Action
		
		public void dropDownMethod(WebElement element , String text)
		{
			try {
				Select s=new Select(element);
				s.selectByVisibleText(text);
				log.info("text"+text+"is selected from dropDown"+ element);
				
			}
			catch(Exception c)
			{
				log.error("text" +element+ "is not present or text "+ text+ " is not selected");
			}
		}
		
		//  For Alert Action
		
		public void acceptAlert(WebDriver alert)
		{
			driver.switchTo().alert().accept();
			test.info("CLicked on Alert's OK button");
			log.info("CLicked on Alert's OK button");
		}

		// FOr MouseHover action
		
		public void mouseHoverMethod(WebElement element)
		{
			Actions a=new Actions(driver);
			a.moveToElement(element).click().perform();
			test.info("Mouse Hover to the Element");
			log.info("Mouse Hover to the Element");
			
			
					
		}

}
