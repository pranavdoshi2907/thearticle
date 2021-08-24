package com.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ChiefOfBranchPage {

	public WebDriver driver;

	public ChiefOfBranchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static By chiefOfBranchSignOffIcon = By.xpath("//button[contains(text(), 'CoB sign-off')]");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
