package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='user_email']")
	WebElement userEmail;
	@FindBy(xpath = "//input[@id='user_password']")
	WebElement userPassword;
	@FindBy(xpath = "//input[@value='Log In']")
	WebElement loginButton;
	
	public WebElement enterUserEmail() {
		return userEmail;
		
	}
	public WebElement enterUserPassword() {
		return userPassword;
		
	}
	public WebElement clickOnLoginButton() {
		return loginButton;
		
	}
}
