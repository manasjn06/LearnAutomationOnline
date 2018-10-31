package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPageWithReport {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setUp() {
		report = new ExtentReports(".\\Reports\\LoginWithReport.html",true);
		logger = report.startTest("Verify Login into gmail test ");
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running.");
	}

	@Test
	public void testHomePage() throws InterruptedException

	{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		logger.log(LogStatus.INFO, "Get the application title name");
		String sTitle = home.getApplicationTitle();
		Assert.assertTrue(sTitle.contains("Google"));
		logger.log(LogStatus.PASS, "Title verified.");
		home.clickOnSignIn();
		logger.log(LogStatus.INFO, "Click on SignIn button");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		logger.log(LogStatus.INFO, "Verify Login application");
		home.clickOnGmail();
		logger.log(LogStatus.INFO, "Click on gmail icon");
		login.verifyComposeButton();
		logger.log(LogStatus.PASS, "Logged in verified");

	}

	@AfterMethod
	public void tearDown() {
		BrowserFactory.closeBrowser();
		report.endTest(logger);
		report.flush();
	}

}
