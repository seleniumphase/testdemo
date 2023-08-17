package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class demo1 {
	
	WebDriver driver;
	

	
	public demo1(WebDriver driver2) {
		
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}
	public void print() {
	System.out.println("2nd Test");
	}
	
	public void Elementappear(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	@FindBy(xpath ="//button[@class='_2KpZ6l _2doB4z']")
	WebElement closebutton;
	public void closeloginalert()
	{
		//By alert =By.xpath("//button[@class='_2KpZ6l _2doB4z']");
		
		//Elementappear(alert);
		
		//WebElement Loginalert = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		closebutton.click();		//Assert.assertEquals(Loginalert.isSelected(), true);
				
	}

}
