package com.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LegalSpecialistPage {

	public WebDriver driver;

	public LegalSpecialistPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static By commentYesCheckBoxForC138 = By.xpath("//table[1]/tbody/tr[2]/td/div/div/div[1]/div/div[1]/label");
	public static By repliesReceivedBar = By.xpath("//label[contains(text(), 'Replies received to the issues raised in a direct request')]");
	public static By commentYesCheckBoxForC182 = By.xpath("//table[2]/tbody/tr[2]/td/div/div/div[1]/div/div[1]/label");
	public static By createDLCBtn = By.xpath("//button[@title = 'Create DLC']");
	public static By DLCTypeReply = By.xpath("//div[2]/div[1]/div[2]/div/div[3]/label");
	public static By DLCTypeDirectRequest = By.xpath("//div[2]/div[1]/div[2]/div/div[2]/label");
	public static By DLCTypeObservation = By.xpath("//div[2]/div[1]/div[2]/div/div[1]/label");
	public static By selectConvention = By.xpath("//div[2]/div[2]/div[2]/ng-select/div/div/div[2]/input");
	public static By selectConventionC138 = By.xpath("//div/div/div/span[contains(text(), 'C138')]");
	public static By selectConventionC182 = By.xpath("//div/div/div/span[contains(text(), 'C182')]");
	public static By createDLCOnCreateNewDLCPopUp = By.xpath("//div[3]/button[contains(text(),'Create DLC')]");
	public static By caseSensitiveApprovalOfCoB = By.xpath("//*[@id = 'Yes']");
	public static By readyForThematicLeadSignOffIcon = By.xpath("//button[contains(text(), 'Ready for Thematic Lead sign-off')]");
	public static By tableTBody = By.xpath("//tbody");
	public static By deleteIconOnAddFilesBelow = By.xpath("//tr/td[9]/p/button/i");
	public static By technicalDepartmentInputsTab = By.xpath("//a[contains(text(), 'Technical department inputs')]");
	public static By inputNeededYes = By.xpath("//*[@id=\"inputNeededYes\"]");
	public static By selectTechDepPersonDropDown = By.xpath("//div[2]/input");
	public static By techDepAssignedUsername = By.xpath("//span[contains(text(), 'ILO_SHAREPOINT_TEST6')]");
	public static By assignBtn = By.xpath("//button[contains(text(), 'Assign')]");
	public static By draftDLCTab = By.xpath("//a[contains(text(), 'Draft DLC')]");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
