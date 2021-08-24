package com.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TechnicalDepPage {

	public WebDriver driver;

	public TechnicalDepPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static By endTaskBtnTextXpath = By.xpath("//button[contains(text(), 'End Task')]");
	public static By endTaskBtn = By.xpath("//div[2]/span/div[1]/div/table/tbody/tr/td[7]/p/button");
	public static By techInputCompletionSelection = By.xpath("//label[contains(text(), 'Inputs are completed and incorporated in some/all DLCs by the assigned technical department person')]");
	public static By proceedBtn = By.xpath("//button[contains(text(), 'Proceed')]");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
