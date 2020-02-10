package academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePageTC extends Base {
	@BeforeTest
	public void before() throws IOException {
		driver = initializeDriver();
		driver.get(pro.getProperty("url"));
	}
	
	@Test()
	public void nevgationToBrowser() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		lp.clickOnNoThanks().click();
		lp.clickOnLogin().click();
		LoginPage log = new LoginPage(driver);
		log.enterUserEmail().sendKeys("aryanraza550@gmail.com");
		log.enterUserPassword().sendKeys("Jakirh641@");
		log.clickOnLoginButton().click();

	}

	@AfterTest
	public void after() {
		driver.close();
		driver = null;
	}
}
