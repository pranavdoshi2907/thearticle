package com.automation.hooks;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Demo {
	  WebDriver driver1;
  @Test
  public void f() {
	  Reporter.log("Demo2", true);
  }
  @BeforeClass
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ST57752\\workspace\\automationFramework\\browserResouces\\chromedriver.exe");
	  driver1 = new ChromeDriver ();
	  driver1.get("https://www.google.co.in/");
	  Reporter.log("Demo1", true);
  }

  @AfterClass
  public void afterTest() {
	  Reporter.log("Demo3", true);
  }

}
