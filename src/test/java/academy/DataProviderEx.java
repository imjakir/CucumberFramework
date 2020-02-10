package academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class DataProviderEx extends Base {
	@BeforeTest
	public void before() throws IOException {
		driver = initializeDriver();
		
	}
	@Test(dataProvider = "getData")
	public void nevgationToBrowser(String userName, String userPassword) {
		driver.get(pro.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.clickOnLogin().click();
		LoginPage log = new LoginPage(driver);
		log.enterUserEmail().sendKeys(userName);
		log.enterUserPassword().sendKeys(userPassword);
		log.clickOnLoginButton().click();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "aryanraza550@gmail.com";
		data[0][1] = "Jakirh641@";

		data[1][0] = "aryanraza5500@gmail.com";
		data[1][1] = "Jakirh641@1";
		return data;
	}
	@AfterTest
	public void after() {
		driver.close();
		driver = null;
	}
}
