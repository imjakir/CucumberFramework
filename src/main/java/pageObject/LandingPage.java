package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Login']")
	WebElement login;

	@FindBy(xpath = "//button[text()='NO THANKS']")
	WebElement popupMsg;

	@FindBy(xpath = "//h2[text()='Featured Courses']")
	WebElement title;

	public WebElement clickOnNoThanks() {
		return popupMsg;

	}

	public WebElement clickOnLogin() {
		return login;

	}

	public WebElement getTitle() {
		return title;

	}
}
