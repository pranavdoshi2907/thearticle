package com.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ExpertReviewPage {

	public WebDriver driver;

	public ExpertReviewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static By yesReviewForCEACRExpert = By.xpath("//*[@id='inputNeededYes']");
	public static By endTaskBtn = By.xpath("//button[contains(text(), ' End task')]");
	public static By approveRepliesRecievedBtn = By.xpath("//div[2]/div/div[1]/label");
	public static By expertReviewCompletionSelection = By.xpath("//div[3]/div/label");
			
	
}
