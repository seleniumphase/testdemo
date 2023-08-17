package lerning.amazon.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lerning.amazon.BaseTest;
import lerning.amazon.pageobject.*;

public class Toypage extends BaseTest{
	
	//WebDriver driver;

	@Test	
	public  void  Toyproduct()
	{		
		serchboxtoy toy = new serchboxtoy(driver);
		System.out.println("Changes done");		
	}

}
