package lerning.amazon;

import java.util.Properties;
import lerning.amazon.pageobject.*;
import lerning.amazon.tests.Headerpage;
import lerning.amazon.tests.Headerpagetest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

	public WebDriver driver;
	public Headerpage headerpageobject;
	
	public WebDriver initdriver() throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\lerning\\amazon\\globaldata.properties");
		prop.load(fi);
		String browsername = prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	/*	else
		{
			driver = null;
		}*/

	}
	 
	@BeforeMethod(alwaysRun = true)
	public  Headerpage GotoMainPage() throws IOException 
	{	
		driver  = initdriver();		
		//driver.get("https://www.amazon.in/");
		headerpageobject = new Headerpage(driver);
		headerpageobject.gotolink();
		return headerpageobject;
		//System.out.println(driver.getTitle());
	//	Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
		
	}
	public String  getscreenshots(String testcasename,WebDriver driver) throws IOException
	{
		TakesScreenshot ScrShot = (TakesScreenshot)driver; 
		File Scrfile = ScrShot.getScreenshotAs(OutputType.FILE);
		File Destfile = new File(System.getProperty("user.dir")+"/Report/"+testcasename+".png");
		FileUtils.copyFile(Scrfile, Destfile);
		return System.getProperty("user.dir")+"/Report/"+testcasename+".png";
	}
	
	
	@AfterTest(alwaysRun=true)
	public void teardown()
	{
		driver.quit();
	}
	
	
	
}
