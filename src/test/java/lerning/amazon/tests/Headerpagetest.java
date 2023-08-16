package lerning.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;
import lerning.amazon.BaseTest;
//mport lerning.amazon.pageobject.Headerpage;
import lerning.amazon.pageobject.serchboxtoy;

public class Headerpagetest extends BaseTest{
	

	String ExpectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	Actions act;
	
	@Test(priority=1)
	public void SearchProdToy() throws InterruptedException 
	{		
		headerpageobject.searchproduct("Toys");
		serchboxtoy toy= headerpageobject.hitonserchicon();	
		//toy.getproductname();
		WebElement Prodname = toy.getproductname();
		//String Actualproductname = Prodname.getText();
		//System.out.println(Actualproductname);
		act = new Actions(driver);
		act.moveToElement(Prodname).contextClick().sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ENTER)
		.build().perform();		
		String ParentWindow =  driver.getWindowHandle();
		//System.out.println("PW: "+ParentWindow);
		Set<String> ChildWindow= driver.getWindowHandles();
		//System.out.println("CW: "+ChildWindow);
		Iterator<String> CW = ChildWindow.iterator();
		//System.out.println("CW1: "+CW);
		
		while(CW.hasNext())
		{
			String ChildWin = CW.next();
			// System.out.println("CW1: "+ChildWin);
		 if(!ParentWindow.equals(ChildWin))
		 {
		
			 System.out.println("inside if" +ChildWin);
		
			 Thread.sleep(3000);
			 driver.switchTo().window(ChildWin);
			 System.out.println(driver.getTitle());
		 }
			 
		}
		
		Thread.sleep(1000);
		driver.getCurrentUrl();
		//System.out.println(driver.getTitle());
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,100)");
		
	//	headerpageobject.ClickonAddtoCartButton();
		//headerpageobject.Goto_cart();		

		
	}
	
	@Test(priority=3)
	public void ClickonAmazonlogo()
	{
		headerpageobject.ClickAmazonlogo();
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	
	@Test(priority=4)
	public void UserLocationClick() {
		headerpageobject.Userlocation.click();
		act.sendKeys(Keys.ESCAPE);	

	}
	
	@Test(priority=2)	
	public void LunguageSelection_HeaderPage()
	{
		Boolean res = headerpageobject.LanguageSelection();
		//Assert.assertEquals(false,res);
		System.out.println(res);
	
	}
	
	

}
