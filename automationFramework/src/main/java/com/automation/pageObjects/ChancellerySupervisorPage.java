package com.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactory;

import com.automation.bases.BaseUtil;
import com.automation.bases.WaitClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * @author ST57752 Shivangi Tripathi (Quality Analyst)
 *
 */
public class ChancellerySupervisorPage {

	public WebDriver driver;

	public ChancellerySupervisorPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static By ISO_HeadQuarters_Login_Path = By.xpath("//*[@id=\"bySelection\"]/div[2]/div/span");
	public static By ISO_HeadQuarters_Username = By.xpath("//*[@id='userNameInput']");
	public static By ISO_HeadQuarters_Password = By.xpath("//*[@id='passwordInput']");
	public static By Create_New_Report_Set_Icon = By.xpath("//button[contains(text(),'new report set')]");
	public static By Article_Type_DropDown = By.xpath("//*[@title='Select Article type']");
	public static By DropDown_Arrow = By.xpath("//*[@class='ng-arrow']");
	public static By Article_22 = By.xpath("//*[contains(text(),'Article 22 or 35')]");
	public static By Select_Country_DropDown = By.xpath("//*[@id='selectCountry']");
	public static By Country_Afghanistan = By.xpath("//span[contains(text(),'Afghanistan')]");
	public static By Subject = By.xpath("//*[@id='subject']");
	public static By Subject_Value = By
			.xpath("//*[contains(text(),'Elimination of child labour and protection of children and young persons')]");
	public static By Convention_DropDown_Value_1 = By.xpath("//*[@id='conventions']");
	public static By Convention_C138 = By.xpath("//*[contains(text(),'C138')]");
	public static By Convention_C182 = By.xpath("//*[contains(text(),'C182')]");
	public static By Select_Year = By.xpath("//*[@id='selectYear']");
	public static By Year_2020 = By.xpath("//*[contains(text(),'2020')]");
	public static By Save_Btn = By.xpath("//*[contains(text(),' Save report set')]");
	public static By Yes_Icon = By.xpath("//*[contains(text(),'Yes')]");
	public static By Submit_Btn = By.id("submitButton");
	public static By Report_Set_Name = By.xpath("//span[@id='reportSetName']");
	public static By selectChancelleryMemberDropdown = By.xpath("//input[@role='combobox']");
	public static By chancelleryMemberName1 = By.xpath("//span[contains(text(),' ILO_SHAREPOINT_TEST3')]");
	public static By chancelleryMemberName2 = By.xpath("//span[contains(text(),'Shinde, Yogesh')]");
	public static By chancelleryMemberName3 = By.xpath("//span[contains(text(),' Agrawal, Sujay')]");
	public static By yesBtnForC138 = By.xpath("//input[@id='cc10']/following-sibling::label");
	public static By yesBtnForC182 = By.xpath("//input[@id='cc11']/following-sibling::label");
	public static By noBtnForC138 = By.xpath("//input[@id='cc20']");
	public static By noBtnForC182 = By.xpath("//input[@id='cc21']");
	public static By saveBtnForC138 = By.xpath("//div[4]/div/button[1][contains(text(), 'Save')]");
	public static By deleteReportSetCheckbox = By.xpath("//div[@title='AFG_A22_CL_2020']/div/i[2]");
	public static By deleteReportSet = By.xpath("//span[contains(text(),'Delete')]");
	public static By deleteReportSetIcon = By.xpath("//span[contains(text(),'Delete')][@class='od-Button-label']");
	public static By reportSetName = By.xpath("//div[2]/div[1]/span/span[2]/span/a[contains(text(), 'AFG_A22_CL_2020')]");
	public static By reportSetNameById = By.xpath("//span[@id='reportSetName']");
	public static By reportedDateForC138 = By.xpath("//table[1]/tbody/tr[3]/td/div/div/p/span/input[@title = 'Reported date']");
	public static By reportedDateForC182 = By.xpath("//table[2]/tbody/tr[3]/td/div/div/p/span/input[@title = 'Reported date']");
	public static By cancelBtn = By.xpath("//button[contains(text(), 'Cancel')]");

	/* locators for Add Files Report Registration Page */
	public static By addFilesReportRegistrationIcon = By.xpath("//button[contains(text(), ' Add file(s) below ')]");
	public static By saveFileInWorkflow = By.xpath("//div[1]/div[3]/div/button[1]");
	public static By uploadFile = By.xpath("//input[@id='uploadFile']");
	public static By selectAnnexType = By.xpath("//tr[3]/td/div/ng-select/div/div/div[2]/input");
	public static By selectConvention = By.xpath("//tr[8]/td/div/ng-select/div/div/div[2]/input");
	public static By selectAnnexTypeValue = By.xpath("//span[contains(text(), 'Acknowledgement to Govt.')]");
	public static By selectConventionValue = By.xpath("//span[contains(text(),'C138')][@class='ng-option-label']");
	public static By selectLanguage = By.xpath("//select[@name='ddlLanguage']");
	public static By selectTranslationLanguage = By.xpath("//select[@id='ddlTranslationLanguage0']");
	public static By notifyHoUAboutNewReportsOrAnnexesUploads = By
			.xpath("//button[contains(text(), 'Notify HoU about new reports or annexes uploads')]");
	//public static By notifyHOUMessage = By.xpath("//label[contains(text(), 'Notified by: ILO_SHAREPOINT_TEST1')]");
	public static By notifyHOUMessage = By.xpath("//div/div/div/label");
	public static By closeReportSet = By.xpath("//button[contains(text(), 'Close report set')]");
	
	/* locators for report translation task*/
	public static By reportTranslationIcon = By.xpath("//a[contains(text(),' Report translation')]");
	public static By uploadBtn = By.xpath("//button[contains(text(), 'Upload')]");
	//public static By uploadFileIcon = By.xpath("//input[@id='uploadFile']");
	public static By addFileBtn = By.xpath("//button[contains(text(), 'Add file')]");
	public static By okBtn = By.xpath("//button[contains(text(), 'OK')]");
	public static By sendDocsForTranslationBar = By.xpath(" //button[contains(text(), 'Send above selected docs for translation')]");
	public static By checkBoxForFileTranslation = By.xpath("//*[@id=\"hdrTranslation_required\"]/label/span");
	public static By reportTranslationMsge = By.xpath("//div[2]/div[1]/div/div/div[2]/ul/li[@class = 'ng-star-inserted']");
	public static By yesBtnUsingButtonTagName = By.xpath("//button[contains(text(),'Yes')]");
	public static By yesBtnForApproval = By.xpath("//button[@title='Yes']");

	public WebElement getLogin() {
		return driver.findElement(ISO_HeadQuarters_Login_Path);
	}

	public WebElement getReportSetName() {
		return driver.findElement(Report_Set_Name);
	}

	public WebElement getUsername() {
		return driver.findElement(ISO_HeadQuarters_Username);
	}

	public WebElement getPassword() {
		return driver.findElement(ISO_HeadQuarters_Password);
	}

	public WebElement getCreateNewReportIcon() {
		return driver.findElement(Create_New_Report_Set_Icon);
	}

	public WebElement getArticle_Type_DropDown() {
		return driver.findElement(Article_Type_DropDown);
	}

	public WebElement getArticle_22() {
		return driver.findElement(Article_22);
	}

	public WebElement getSelect_Country_DropDown() {
		return driver.findElement(Select_Country_DropDown);
	}

	public WebElement getCountry_Afghanistan() {
		return driver.findElement(Country_Afghanistan);
	}

	public WebElement getSubject() {
		return driver.findElement(Subject);
	}

	public WebElement getSubject_Value() {
		return driver.findElement(Subject_Value);
	}

	public WebElement getConvention_DropDown_Value_1() {
		return driver.findElement(Convention_DropDown_Value_1);
	}

	public WebElement getConvention_C138() {
		return driver.findElement(Convention_C138);
	}

	public WebElement getConvention_C182() {
		return driver.findElement(Convention_C182);
	}

	public WebElement getSelect_Year() {
		return driver.findElement(Select_Year);
	}

	public WebElement getYear_2020() {
		return driver.findElement(Year_2020);
	}

	public WebElement getSave_Btn() {
		return driver.findElement(Save_Btn);
	}

	public WebElement getYes_Icon() {
		return driver.findElement(Yes_Icon);
	}

	public WebElement getSubmit_Btn() {
		return driver.findElement(Submit_Btn);
	}

}
