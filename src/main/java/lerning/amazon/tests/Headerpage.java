package lerning.amazon.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lerning.amazon.pageobject.serchboxtoy;


public class Headerpage  extends Abstractmethods{
	
	
	WebDriver driver;
	
	public Headerpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id='nav-cart']")
	WebElement GotoCart;

	@FindBy(css="a[id='nav-orders'] span[class='nav-line-1']")
	WebElement Returns;
	
	@FindBy(css="#nav-link-accountList-nav-line-1")
	WebElement AccountName;
	
	@FindBy(css=".nav-icon.nav-arrow")
	WebElement LanguageSelectionArrow;
	
	@FindBy(css="#nav-global-location-popover-link")
	WebElement Userlocation;
	
	@FindBy(css="#nav-logo-sprites")
	WebElement Amazonlink;
	
	@FindBy(xpath= "//input[@id='twotabsearchtextbox']" )
	WebElement Searchbox;
	
	@FindBy(xpath = "//*[@id='add-to-cart-button']")
	WebElement AddtoCartButton;
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement Searchicon;
	
	@FindBy(css="#nav-logo-sprites")
	WebElement Amazonlogoicon;
	
	@FindBy(xpath="(//span[contains(@dir,'ltr')][normalize-space()='English'])[1]")
	WebElement SelectLanguage;
	
	public void searchproduct(String Productname)
	{
		Searchbox.sendKeys(Productname);
			
	}
	public void gotolink()
	{
		driver.get("https://www.amazon.in/");
	}
	
	public serchboxtoy hitonserchicon()
	{
		Searchicon.click();
		serchboxtoy toy = new serchboxtoy(driver);	
		return toy;

		
	}
	
	public void ClickonAddtoCartButton()
	{
		//waitforElementToclickable(AddtoCartButton);
		AddtoCartButton.click();
		
	}
	public void Goto_cart()
	{
		waitforElementToclickable(GotoCart);
		GotoCart.click();
		
	}
	public void ClickAmazonlogo()
	{
		Amazonlogoicon.click();
	}
	
	public Boolean LanguageSelection()
	{
		LanguageSelectionArrow.click();
		Boolean result = SelectLanguage.isSelected();
		return result;
	}
}
