package com.automation.bases;

/**
 * @author ST57752 Shivangi Tripathi (Quality Analyst)
 *
 */

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitClass {

	WebDriver driver;

	public static void explicitWaitVisible(WebDriver driver, int time, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void explicitWaitInVisible(WebDriver driver, int time, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static void explicitWaitClickable1(WebDriver driver, int time, By locator) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void explicitWaitClickable2(WebDriver driver2, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver2, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void explicitWaitVisibility(WebDriver driver, By Ele, String duration) {
		// String duration;
		WebDriverWait wait = (new WebDriverWait(driver, Integer.parseInt(duration) * 1000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Ele));
	}

	public static void explicitWaitUntil(WebDriver driver, By Ele, String duration) {
		WebDriverWait wait = (new WebDriverWait(driver, Integer.parseInt(duration) * 1000));
		wait.until(ExpectedConditions.elementToBeClickable(Ele));
	}
	
	public static void explicitWaitUntil1(WebDriver driver, By Ele, int duration) {
		WebDriverWait wait = (new WebDriverWait(driver, duration));
		wait.until(ExpectedConditions.elementToBeClickable(Ele));
	}

	public static void waitUntilElementIsLocated (WebDriver driver, By Ele, int time) {
		
		// get the "Ele" element
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Ele));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
