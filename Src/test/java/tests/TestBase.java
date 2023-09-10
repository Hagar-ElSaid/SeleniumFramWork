package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import helper.Helper;

public class TestBase {
	public static  WebDriver driver;
   
	@SuppressWarnings("deprecation")

	@BeforeSuite
	@Parameters({"browser"})
	public void startdriver ( @Optional("chrome") String browserName) {


		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com");

	}
	
	//Take screenshot when test case fail 
	@AfterMethod

	public void ScreenshotOnFail (ITestResult result) throws IOException {

		if ( result.getStatus() == ITestResult.FAILURE) {

			System.out.println("Failed");
			System.out.println("Taking Schreenshot....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
	
	@AfterSuite
	public void stopdriver () {
		driver.quit();

	}
}
