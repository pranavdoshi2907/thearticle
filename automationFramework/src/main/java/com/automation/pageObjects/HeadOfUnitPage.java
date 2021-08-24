package com.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author ST57752 Shivangi Tripathi (Quality Analyst)
 *
 */

public class HeadOfUnitPage {

	public WebDriver driver;

	public HeadOfUnitPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static By fillReportSetName = By.xpath("//*[@id=\'hdr_report_set_name_Sort\']/input");
	public static By reportSetname = By.xpath("//*[@id='hdr_report_set_name']");
	public static By nextBtn = By.xpath("//li[@class='pagination-next']");
	public static By reportSetbtnLink = By.xpath("//button[@class='btn-link']");
	public static By legalSpecialistIcon = By.xpath("//a[contains(text(), 'Legal specialist assignment')]");
	public static By assignThematicLeadAndLegalSpecialistOption = By.xpath("//*[@id='yes_legal']");
	public static By assignLegalSpecialistCheckBox = By.xpath("//*[contains(text(), 'Assign Legal Specialist')]/span");
	public static By selectLegalSpecialistDropDown = By.xpath("//*[@id='ddlLegalSpecialist']/div/div/div[2]/input");
	public static By legalSpecialistUsername = By.xpath("//span[contains(text(), 'ILO_SHAREPOINT_TEST5')]");
	public static By assignThematicLeadCheckBox = By.xpath("//*[contains(text(), 'Assign Thematic Lead')]/span");
	public static By selectThematicLeadDropDown = By.xpath("//*[@id='ddlThematicLead']/div/div/div[2]/input");
	public static By thematicLeadUserName = By.xpath("//span[contains(text(), 'Joshi, Trupti')]");
	public static By saveBtn = By.xpath("//button[contains(text(), 'Save')]");
	public static By closeReportSet = By.xpath("//button[contains(text(), 'Close report set')]");
	public static By reportValidationIcon = By.xpath("//a[contains(text(), 'Report validation')]");
	public static By observationCheckboxFirstRow = By.xpath("//table[1]/tbody/tr[2]/td/div/div[1]/label/span[@class='checkedMarkCHKBox']  ");
	public static By initialHoUSignOffIcon = By.xpath("//button[contains(text(), 'Initial HoU sign-off')]");
	public static By selectDecisionForCreateDLC = By.xpath("//select[@title='Select Decision']");
	public static By HoUSignOffAfterExpertReviews = By.xpath("//button[@title='HoU sign-off after expert reviews']");
	
	
	
	
	
	
	
	
	
	
	
	
	

}