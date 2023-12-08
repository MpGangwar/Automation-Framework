package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilities.ReadXLSData;
import Utilities.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends ReadXLSData {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	public static Logger log;
	public static ExtentReports extent;
	public static ExtentTest test;

	
	
	
	@BeforeMethod
	public void setup(Method method)
	{
		test = extent.createTest(method.getName());
		TestBase.initialization(method);
		
	}
	
	
	@AfterMethod
	public void getTestResult(ITestResult result) {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "FAILED", ExtentColor.RED));
	            test.log(Status.FAIL, "Reson for Fail: "+result.getThrowable());
	            TakesScreenshot takeScreenshot=(TakesScreenshot )driver;
	    		String base64Code=takeScreenshot.getScreenshotAs(OutputType.BASE64);
	            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build());
	            
	        } else if (result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "PASSED", ExtentColor.GREEN));
	            
	        } else if (result.getStatus() == ITestResult.SKIP) {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "SKIPPED", ExtentColor.YELLOW));

	        }
	        
	        
	        
		driver.quit();
		}
	
	
	public TestBase()
	{
		try {
			
		
		 prop =new Properties();
		
		FileInputStream fis= new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\AutomationFramework\\src\\main\\java\\Config\\config.properties");
		prop.load(fis);
	}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initialization(Method method)
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if (browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventlistener=new WebEventListener();
		e_driver.register(eventlistener);
		driver=e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	log=LogManager.getLogger("Class "+method.getDeclaringClass().toString()+" Method "+method.getName());
	}
		
		
	
		
		@BeforeTest
		public void beforeTest()
		{
			 extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/Spark.html");
			extent.attachReporter(spark);
//			test.addScreenCaptureFromBase64String(base64Code);
		}
		
		@AfterTest
		public void afterTest()
		{
			
			extent.flush();
		}

		
		
}
