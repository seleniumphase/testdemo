package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class demo {
	
	 public WebDriver driver;
@Test(priority = 1)
public void setup() {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://www.flipkart.com/");
	 driver.manage().window().maximize();
	 
	 

	
}


public void closetab()
{
	 demo1 d = new demo1(driver);
	 d.closeloginalert();
}

public void product() {
	
	 SearchProduct searchpro = new SearchProduct(driver);
	 searchpro.searchproduct();
}

}
