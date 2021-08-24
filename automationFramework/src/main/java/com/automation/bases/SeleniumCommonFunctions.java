package com.automation.bases;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author ST57752 Shivangi Tripathi (Quality Analyst)
 *
 */

/*
 * this class is for creating the common methods that will be used in general
 * for performing the Selenium actions in the framework
 */

public class SeleniumCommonFunctions {

	WebDriver driver;
	//SoftAssertions softly = new SoftAssertions();

	public static void click(By element, WebDriver driver) {

		driver.findElement(element).click();
	}

	public static void sendKeys(By element, WebDriver driver, String value) {

		driver.findElement(element).sendKeys(value);
	}

	public static void getText(By element, WebDriver driver) {

		driver.findElement(element).getText();
	}

	public static void getAttribute(By element, WebDriver driver, String title) {

		driver.findElement(element).getAttribute(title);
	}

	public static void selectDropdownByVisibleText(WebDriver driver, By locator, String value) {
		new Select(driver.findElement(locator)).selectByVisibleText(value);

	}

	public static void selectDropdownByIndex(WebDriver driver, By locator, int value) {
		new Select(driver.findElement(locator)).selectByIndex(value);

	}

	public static void selectDropdownByValue(WebDriver driver, By locator, String value) {
		new Select(driver.findElement(locator)).selectByValue(value);
	}

	public static void selectDropdownByFirstSelectedOption(WebDriver driver, By locator) {
		new Select(driver.findElement(locator)).getFirstSelectedOption();
	}

	public static void selectSearchDropdown(WebDriver driver, By locator, String value) {
		driver.findElement(locator).click();
		driver.findElement(locator).sendKeys(value);
		driver.findElement(locator).sendKeys(Keys.TAB);
	} // selecting the searched drop-down which is done by sending the value in the
		// dropdown box

	public void selectIFrameUsingIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);// Handling iFrame by Selecting index
	}

	public void selectIFrameUsingName(WebDriver driver, String name) {
		driver.switchTo().frame(name);// Handling iFrame by using iFrame name
	}

	public void selectIFrameUsingWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);// Handling iFrame by using WebElement
	}

	public static void clickJS(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void scrollPageUsingJS(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void scrollPageUsingActions(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
	public static String delAddFilesTable(WebDriver driver, By element, String ele, String name)
	{
		String str = null;
		
		try {
		WebElement mytable = driver.findElement(element);
		List<WebElement> rows_table = mytable.findElements(By.xpath("//tr"));
		for (int row = 0; row < rows_table.size(); row++) {
			WaitClass.explicitWaitVisible(driver, 5, element);
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.xpath("//td"));
			for (int column = 1; column < Columns_row.size(); column++) {
				String celtext = Columns_row.get(column).getText().trim();
		
				if (celtext.equals(ele)) {
					
					String reportSetName = name;
						PropertiesClass.readAndWriteProperties(reportSetName, celtext);
					
					System.out.println(celtext);
					SeleniumCommonFunctions.click(element, driver); //perform the action
					return str;
				}                           
			}
		}
		return str;
	}
		catch (Exception e)
		{
			System.out.println("element not present");
		}
		return str;
	}
		
	
	public static void getTextForFileNameDisplayed(WebDriver driver, By element)
	{
		try {
			if(driver.findElement(element).isDisplayed()) {
				
				String ele = driver.findElement(element).getText();
				System.out.println(ele);
			}
		}
		catch (Exception e)
		{
			System.out.println("File name not displayed");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
