package com.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ThematicLeadPage {
	
	public WebDriver driver;

	public ThematicLeadPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static By addFileIcon = By.xpath("//button[contains(text(), 'Add file(s) below')]");
	public static By selectDocumentType = By.xpath("//select[@title='Select Document Type']");
	public static By saveFilesInWorkflow = By.xpath("//button[contains(text(), 'Save file(s) in workflow')]");
	public static By selectConvention = By.xpath("//tr[7]/td/div/ng-select/div/div/div/input");
	public static By selectConventionValue = By.xpath("//span[contains(text(),'C182')][@class='ng-option-label']");
	public static By selectLanguageOfDocument = By.xpath("//select[@title='Select Language of document']");
	public static By thematicLeadSignOffIcon = By.xpath("//button[contains(text(), 'Thematic Lead sign-off')]");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
