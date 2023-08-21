package Logintrial;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
@Test
public void setup() {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	 driver.get("https://www.flipkart.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	LoginTab login = new LoginTab(driver);
	login.closeloginalert();

}

@Test
public void LoginTestpage() {


	/*logintab.loginbutton();
	logintab.signuppage();
	logintab.create_account();
	logintab.profilereading();*/
	
}

@Test
public void serchproducts() {
	
	SearchProduct serchpro = new SearchProduct(driver);
	serchpro.searchproduct();
}

}
