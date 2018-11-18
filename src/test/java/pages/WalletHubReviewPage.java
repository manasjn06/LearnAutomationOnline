package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = ".//*[@id='lst-ib']")
	WebElement searchInput;
	@FindBy(xpath = ".//*[@id='tsf']/div[2]/div[3]/center/input[1]")
	WebElement searchButton;
	@FindBy(xpath = ".//*[@id='tsf']/div[2]/div[3]/center/input[2]")
	WebElement IFeelLuckyButton;
	@FindBy(xpath = ".//*[@id='gb_70']")
	WebElement SignIn;
	@FindBy(xpath = ".//*[@id='gbw']/div/div/div[1]/div[1]/a")
	WebElement gmail;
	

	public void enterSearchValue()

	{
		searchInput.sendKeys("Selenium");
	}

	public void clickOnSearchButon()

	{
		searchButton.click();
	}

	public void clickOnIFeelLuckyButton()

	{
		IFeelLuckyButton.click();
	}

	public String getApplicationTitle() {
		return driver.getTitle();

	}

	public void clickOnSignIn() {
		SignIn.click();
	}
	
	public void clickOnGmail()
	{
		gmail.click();
	}

}
