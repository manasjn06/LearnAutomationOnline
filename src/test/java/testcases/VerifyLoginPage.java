package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}

	@Test
	public void testHomePage() throws InterruptedException

	{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String sTitle = home.getApplicationTitle();
		Assert.assertTrue(sTitle.contains("Google"));
		home.clickOnSignIn();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.loginApplication("seleniummanas1","manas1234");
		home.clickOnGmail();
		login.verifyComposeButton();
	
	}

	@AfterMethod
	public void tearDown() {
		BrowserFactory.closeBrowser();
	}

}
