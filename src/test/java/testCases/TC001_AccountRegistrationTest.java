package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_account_registeration() {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegisterationPage regpage=new AccountRegisterationPage(driver);
		
		//regpage.setFirstName("Nandini");
		regpage.setFirstName(randomString().toUpperCase());
		
		//regpage.setLaststName("xyz");
		regpage.setLaststName(randomString().toUpperCase());
		
		//regpage.setEmail("gajjalruchita20@gmail.com");
		regpage.setEmail(randomString()+"@gmail.com");
		
		//regpage.setTelephone("9398288548");
		regpage.setTelephone(randomNumber());
		
		//regpage.setPassword("Nandini@20");
		//regpage.setConnfirmPswd("Nandini@20");
		String pass=randomAlphaNumeric();
		regpage.setPassword(pass);
		regpage.setConnfirmPswd(pass);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confrmmsg=regpage.getConfirmationMsg();
		org.testng.Assert.assertEquals(confrmmsg, "Your Account Has Been Created!");
	}

	//generate romdom string of 5 chars using apache commons dependancy
	public String randomString() {
		String generatedString= RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	//generate romdom number for telephone number using apache commons dependancy
	public String randomNumber() {
		String generatedString= RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	//generate romdom Alphanuumeric values for password using apache commons dependancy
		public String randomAlphaNumeric() {
			String generatedString= RandomStringUtils.randomAlphabetic(3);
			String generatedNumber= RandomStringUtils.randomNumeric(3);
			return (generatedString+"@"+generatedNumber);
		}
}
