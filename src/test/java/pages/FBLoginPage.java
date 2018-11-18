package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = ".//*[@id='identifierId']")
	WebElement username;
	@FindBy(xpath = ".//*[@id='identifierNext']/content/span")
	WebElement nextbutton;
	@FindBy(xpath = ".//*[@id='password']/div[1]/div/div[1]/input")
	WebElement password;
	@FindBy(xpath = ".//*[@id='passwordNext']/content/span")
	WebElement passNextButton;
	@FindBy(xpath = ".//*[@id=':44']/div/div")
	WebElement composeButton;

	public void loginApplication(String user, String pass) throws InterruptedException {
		username.sendKeys(user);
		nextbutton.click();
		Thread.sleep(2000);
		password.sendKeys(pass);
		passNextButton.click();
	}

	public void verifyComposeButton() {
		composeButton.isDisplayed();
	}

}
