package Logintrial;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class LoginTab {
	
	 WebDriver driver;
	
		public LoginTab(WebDriver driver2) {			
			
			this.driver = driver2;
			PageFactory.initElements(driver, this);
		}
	

	@FindBy(xpath = "//a[@class='_1_3w1N']")
	WebElement Login_button;
	
	@FindBy(xpath = "//*[@class='_3wJI0x']")
	WebElement Signup;
	
	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	WebElement signupcredentials;
	
	@FindBy(xpath = "//a[@class='_14Me7y']")
	WebElement create_account;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement continuebutton;
	
	By mobileno = By.xpath("//input[@class='_2IX_2- VJZDxU']");
	By infomsg = By.cssSelector("._2sKwjB");
	
	@FindBy(css = "._2sKwjB")
	WebElement message;
	
	@FindBy(xpath = "//a[@class='_K2pZ6l _2HKlqd _3NgS1a']")
	WebElement Exsitinguserbutton;
	
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement Profilefirstname;
	
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement Profilelastname;
	
	@FindBy(xpath = "//div[@class='_1XFPmK'])[1]")
	WebElement Profile_Maleradiobutton;	
	
	@FindBy(xpath = "//div[@class='_1XFPmK'])[2]")
	WebElement Profile_Femaleradiobutton;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement Profileemail;
	
	@FindBy(xpath = "//input[@name='mobilenumber']")
	WebElement Profile_mobileno;
	
	@FindBy(xpath = "//button[class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement Requestotpbutton;
	

	Commonstrategy strategy = new Commonstrategy(driver);




	@Test
	public void closeloginalert()
	{
		By alert =By.xpath("//button[@class='_2KpZ6l _2doB4z']");
		
		strategy.Elementappear(alert);
		WebElement Loginalert = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		Loginalert.click();		//Assert.assertEquals(Loginalert.isSelected(), true);
				
	}
	
	@Test
	public void loginbutton()
	{
		Actions login = new Actions(driver);
		login.moveToElement(Login_button);
		Login_button.click();	
					
		//_2sKwjB
	}
	

	@Test
	public void signuppage()
	{
		strategy.Elementappear(mobileno);
		signupcredentials.sendKeys("9726657061");
	}
	
	
	public void create_account() throws InterruptedException {
		
		create_account.click();
		signupcredentials.sendKeys("9726657061");
		continuebutton.click();
		strategy.Elementtobevisible(infomsg);
		System.out.println(message.getText());
		Assert.assertEquals(message.getText(), "You are already registered. Please log in.");
		Exsitinguserbutton.click();
		signupcredentials.sendKeys("9726657061");
		Requestotpbutton.click();

		
		
	}
	
	public void profilereading() {
		
		System.out.println(Profilefirstname.getText());
		System.out.println(Profilelastname.getText());
		System.out.println(Profile_Maleradiobutton.isSelected());
		System.out.println(Profile_Femaleradiobutton.isSelected());
		System.out.println(Profileemail.getText());
		System.out.println(Profile_mobileno.getText());
	}
}