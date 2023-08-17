package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class SearchProduct {
	 WebDriver driver;	

		
		@FindBy(xpath = "//input[@class='_3704LK']")
		WebElement Searchbox;
		
		@FindBy(xpath = "//button[@class='L0Z3Pu']")
		WebElement clickonsearchicon;
		
		public SearchProduct(WebDriver driver2) {
			
			this.driver = driver2;
			PageFactory.initElements(driver2,this);
		}

		
		public void searchproduct()
		{
			Searchbox.sendKeys("t shirts");
			clickonsearchicon.click();
			
		}

}
