package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	//contructor invoked from basepageclass
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	
	//locators
	@FindBy(xpath="//a[@title='My Account']") 
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']") 
	WebElement lnkRegister;
	
	//action methods
	
	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	
	
	
	
}
