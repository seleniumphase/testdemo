package Logintrial;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Loadlink {
	public WebDriver driver;
	
	public Loadlink(WebDriver driver)
	{
		this.driver=driver;
	}
	@Test
	public void getmainlink() {
		
		 driver.get("https://www.flipkart.com/");
		 driver.manage().window().maximize();
		}

}
