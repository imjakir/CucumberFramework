package academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;

public class ValidateTitleTC extends Base {
	@BeforeTest
	public void before() throws IOException {
		driver = initializeDriver();
		driver.get(pro.getProperty("url"));
	}
	@Test
	public void verifyTitle() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		lp.getTitle().getText();
		assertEquals(lp.getTitle().getText(), "FEATURED1 COURSES");
	}
	@AfterTest
	public void after() {
		driver.close();
		driver = null;
	}
}
