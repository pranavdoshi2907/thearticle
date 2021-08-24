package com.automation.hooks;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.bases.BaseUtil;

//import com.automation.bases.PropertiesClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
//import io.restassured.response.Response;

public class Hook {

	public static WebDriver driver;

	@Before()
	public void initializeDriver()  {

		String browser = "Chrome"; // browser name that we are giving for the
									// testcase execution

		if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"browserResouces/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();

			options.setHeadless(false);

			options.addArguments("window-size=1440x1024");
			options.addArguments("--ignore-ssl-errors=yes");
			options.addArguments("--ignore-certificate-errors");
			// options.addArguments("--proxy-server='direct://'");
			// options.addArguments("--proxy-bypass-list=*");
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			Reporter.log(browser, true);
			// }

//		 else if (browser.equalsIgnoreCase("Firefox")) {
//			System.setProperty("webdriver.gecko.driver", "browserResouces/geckodriver.exe");
//
//			FirefoxOptions options = new FirefoxOptions();
//			options.setHeadless(true);
//			options.addArguments("window-size=1224x768");
//			driver = new FirefoxDriver(options);
//			driver.manage().deleteAllCookies();

		} else 
		
		{
			System.exit(0);
		}
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@After()
	public void afterScenario() {
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
