package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;
	String path = System.getProperty("user.dir");
	public Properties pro;

	public WebDriver initializeDriver() throws IOException {
		pro = new Properties();
		FileInputStream fis = new FileInputStream(
				path + File.separator + "src\\main\\java\\resources\\data.properties");
		pro.load(fis);
		String browserName = pro.getProperty("browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public void getScreenshots(String result) throws IOException {
		// String path = System.getProperty("user.dir"); //
		// E:/automationIrctc/E2EProject /screenshots/methodName.png \\

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(path + File.separator + "screenshots" + File.separator + result + ".png"));

		/*
		 * EventFiringWebDriver rv = new EventFiringWebDriver(driver); File src
		 * =rv.getScreenshotAs(OutputType.FILE); File dest = new
		 * File("E://Screenshots//"+result+"screenshot.png"); FileUtils.copyFile(src,
		 * dest);
		 */
	}
}
