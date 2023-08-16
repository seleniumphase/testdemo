package lerning.amazon.pageobject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class serchboxtoy {
	
	WebDriver driver;
	//public Actions act;
	
	public serchboxtoy(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css = ".a-size-base-plus")
	List<WebElement> Products;	

	
	public WebElement getproductname()
	{
		/* for(WebElement p : Products)
		 {
				act = new Actions(driver);
				act.moveToElement(p).contextClick().sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ENTER)
				.build().perform();	
				
			 
		 }*/
		 WebElement productname = Products.stream().filter(product->product.getText().contains("Toys")).findFirst().orElse(null);
		 return productname;
	}
	


}
