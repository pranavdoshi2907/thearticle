package com.automation.stepDefinitions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

import com.automation.bases.PropertiesClass;
import com.automation.bases.SeleniumCommonFunctions;
import com.automation.hooks.Hook;
import com.automation.pageObjects.ChancellerySupervisorPage;
import com.automation.pageObjects.ChiefOfBranchPage;
import com.automation.pageObjects.ExpertReviewPage;
import com.automation.pageObjects.HeadOfUnitPage;
import com.automation.pageObjects.LegalSpecialistPage;
import com.automation.pageObjects.TechnicalDepPage;
import com.automation.pageObjects.ThematicLeadPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.automation.bases.*;

/**
 * @author ST57752 Shivangi Tripathi (Quality Analyst)
 *
 */
public class StepDefinitions {

	
	static ExtentTest test;
	static ExtentReports report; // extent report tasks
	
	WebDriver driver;
	SoftAssertions softly = new SoftAssertions();
	// SoftAssert softly = new SoftAssert();

	public StepDefinitions() {
		this.driver = Hook.getDriver();
	}

	public void launchBrowser() { // launching the Chrome browser through this method
		System.setProperty("webdriver.chrome.driver", "browserResouces/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.setHeadless(false);

		options.addArguments("window-size=1440x1024");
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("--ignore-certificate-errors");

		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		Reporter.log("Chrome", true);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void extentReport() {
		
		report = new ExtentReports(System.getProperty("user.dir")+"/targetOutput/ExtentReportResults.html");
		test = report.startTest("ExtentResult");
		System.setProperty("webdriver.chrome.driver", "browserResouces/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.setHeadless(false);

		options.addArguments("window-size=1440x1024");
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("--ignore-certificate-errors");

		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		Reporter.log("Chrome", true);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		report.endTest(test);
		report.flush();
		
		// code for generating the extent report
}

	@Given("^user switched to \"([^\"]*)\" view$")
	public void user_switched_to_view(String role_type) throws Throwable {

		extentReport();
		//launchBrowser();
		Thread.sleep(2000);

		switch (role_type) {

		case "Chancellery Supervisor":
			driver.get(PropertiesClass.loadPropertiesFile("url", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.ISO_HeadQuarters_Login_Path, driver);
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Username, driver,
					PropertiesClass.loadPropertiesFile("chancellerySupervisorUsername", "URL_path"));
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Password, driver,
					PropertiesClass.loadPropertiesFile("password", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Submit_Btn, driver);
			break;

		case "Chancellery Member":
			driver.get(PropertiesClass.loadPropertiesFile("url", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.ISO_HeadQuarters_Login_Path, driver);
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Username, driver,
					PropertiesClass.loadPropertiesFile("chancelleryMemberUsername", "URL_path"));
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Password, driver,
					PropertiesClass.loadPropertiesFile("password", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Submit_Btn, driver);
			break;

		case "Head of Unit":
			driver.get(PropertiesClass.loadPropertiesFile("url", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.ISO_HeadQuarters_Login_Path, driver);
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Username, driver,
					PropertiesClass.loadPropertiesFile("headOfUnitUsername", "URL_path"));
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Password, driver,
					PropertiesClass.loadPropertiesFile("headOfUnitPassword", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Submit_Btn, driver);
			// driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			break;

		case "Article 23 Supervisor":
			driver.get(PropertiesClass.loadPropertiesFile("url", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.ISO_HeadQuarters_Login_Path, driver);
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Username, driver,
					PropertiesClass.loadPropertiesFile("article23SupervisorUsername", "URL_path"));
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Password, driver,
					PropertiesClass.loadPropertiesFile("password", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Submit_Btn, driver);
			break;

		case "Thematic Lead":
			driver.get(PropertiesClass.loadPropertiesFile("url", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.ISO_HeadQuarters_Login_Path, driver);
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Username, driver,
					PropertiesClass.loadPropertiesFile("thematicLeadUsername", "URL_path"));
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Password, driver,
					PropertiesClass.loadPropertiesFile("thematicLeadPassword", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Submit_Btn, driver);
			break;

		case "Legal Specialist":
			driver.get(PropertiesClass.loadPropertiesFile("url", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.ISO_HeadQuarters_Login_Path, driver);
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Username, driver,
					PropertiesClass.loadPropertiesFile("legalSpecialistUsername", "URL_path"));
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Password, driver,
					PropertiesClass.loadPropertiesFile("password", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Submit_Btn, driver);
			break;
			
		case "Technical Department User":
			driver.get(PropertiesClass.loadPropertiesFile("url", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.ISO_HeadQuarters_Login_Path, driver);
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Username, driver,
					PropertiesClass.loadPropertiesFile("technicalDepartmentUsername", "URL_path"));
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Password, driver,
					PropertiesClass.loadPropertiesFile("password", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Submit_Btn, driver);
			break;
			
		case "Chief of Branch":
			driver.get(PropertiesClass.loadPropertiesFile("url", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.ISO_HeadQuarters_Login_Path, driver);
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Username, driver,
					PropertiesClass.loadPropertiesFile("chiefOfBranchUsername", "URL_path"));
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Password, driver,
					PropertiesClass.loadPropertiesFile("password", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Submit_Btn, driver);
			break;
			
		case "Expert Review 1":
			driver.get(PropertiesClass.loadPropertiesFile("url", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.ISO_HeadQuarters_Login_Path, driver);
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Username, driver,
					PropertiesClass.loadPropertiesFile("expertReviewUsername9", "URL_path"));
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Password, driver,
					PropertiesClass.loadPropertiesFile("password", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Submit_Btn, driver);
			break;
			
		case "Expert Review 2":
			driver.get(PropertiesClass.loadPropertiesFile("url", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.ISO_HeadQuarters_Login_Path, driver);
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Username, driver,
					PropertiesClass.loadPropertiesFile("expertReviewUsernameC", "URL_path"));
			SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Password, driver,
					PropertiesClass.loadPropertiesFile("password", "URL_path"));
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Submit_Btn, driver);
			break;
			
		default:
			break;
		}
	}

	@When("^user clicks on \"([^\"]*)\" icon$")
	public void user_clicks_on_icon(String action) throws Throwable {
		// launchBrowser();
		Thread.sleep(2000);
		// action = null;

		switch (action) {

		case "Add new report set":
			WaitClass.waitUntilElementIsLocated(driver, ChancellerySupervisorPage.Create_New_Report_Set_Icon, 900);
			// SeleniumCommonFunctions.click(LoginPage.Create_New_Report_Set_Icon, driver);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.Create_New_Report_Set_Icon);
			break;

		case "yes":
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.Yes_Icon);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.Yes_Icon);
			break;

		case "Save Report Set":
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.Save_Btn);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.Save_Btn);
			break;

		case "yes button for C138":
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ChancellerySupervisorPage.yesBtnForC138);
			Thread.sleep(1000);
			// WaitClass.explicitWaitClickable1(driver, 30, LoginPage.yesBtnForC138);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.yesBtnForC138, driver);
//			SeleniumCommonFunctions.click(LoginPage.reportedDate, driver);
//			WebElement element = driver.findElement(LoginPage.reportedDate);
//			element.sendKeys(DateTime.currentDate(driver, "dd MMMM yy"));
			// DateTime.currentDate(driver, "dd MMMM yy");
			break;

		case "yes button for C182":
			Thread.sleep(2000);
			if (driver.findElement(ChancellerySupervisorPage.yesBtnForC182).isEnabled()) {
				SeleniumCommonFunctions.scrollPageUsingJS(driver, ChancellerySupervisorPage.yesBtnForC182);
				Thread.sleep(1000);
				// WaitClass.explicitWaitClickable1(driver, 30,
				// ChancellerySupervisorPage.yesBtnForC182);
				SeleniumCommonFunctions.click(ChancellerySupervisorPage.yesBtnForC182, driver);
				Thread.sleep(1000);
			}
			break;

		case "no button for C138":
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.noBtnForC138);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.noBtnForC138);
			break;

		case "chancelleryMemberName1":
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.chancelleryMemberName1);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.chancelleryMemberName1);
			break;

		case "saveBtnForC138":
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ChancellerySupervisorPage.saveBtnForC138);
			// WaitClass.explicitWaitClickable1(driver, 30, LoginPage.saveBtnForC138);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.saveBtnForC138, driver);
			Thread.sleep(2000);
			break;

		case "Add file(s) below-Report Registration":
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ChancellerySupervisorPage.addFilesReportRegistrationIcon);
			Thread.sleep(1000);
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.addFilesReportRegistrationIcon);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.addFilesReportRegistrationIcon, driver);
			break;

		case "Save file(s) in workflow":
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.saveFileInWorkflow);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.saveFileInWorkflow, driver);
			Thread.sleep(2000);
			break;

		case "notifyHoUAboutNewReportsOrAnnexesUploads":

			WaitClass.waitUntilElementIsLocated(driver,
					ChancellerySupervisorPage.notifyHoUAboutNewReportsOrAnnexesUploads, 50);
			if (driver.findElement(ChancellerySupervisorPage.notifyHoUAboutNewReportsOrAnnexesUploads).isDisplayed()) {
				Thread.sleep(2000);
				SeleniumCommonFunctions.scrollPageUsingJS(driver,
						ChancellerySupervisorPage.notifyHoUAboutNewReportsOrAnnexesUploads);
				WaitClass.explicitWaitClickable1(driver, 30,
						ChancellerySupervisorPage.notifyHoUAboutNewReportsOrAnnexesUploads);
				SeleniumCommonFunctions.clickJS(driver,
						ChancellerySupervisorPage.notifyHoUAboutNewReportsOrAnnexesUploads);
				Thread.sleep(2000);
			}
			break;

		case "createReportSetBtnLink":
			WaitClass.explicitWaitClickable1(driver, 30, HeadOfUnitPage.reportSetbtnLink);
			SeleniumCommonFunctions.click(HeadOfUnitPage.reportSetbtnLink, driver);
			Thread.sleep(2000);
			break;

		case "LegalSpecialistAssignment":
			WaitClass.explicitWaitClickable1(driver, 30, HeadOfUnitPage.legalSpecialistIcon);
			SeleniumCommonFunctions.click(HeadOfUnitPage.legalSpecialistIcon, driver);
			Thread.sleep(2000);
			break;

		case "assignLegalSpecialistCheckBox":
			WaitClass.explicitWaitClickable1(driver, 30, HeadOfUnitPage.assignLegalSpecialistCheckBox);
			SeleniumCommonFunctions.click(HeadOfUnitPage.assignLegalSpecialistCheckBox, driver);
			Thread.sleep(2000);
			break;

		case "assignThematicLeadCheckBox":
			WaitClass.explicitWaitClickable1(driver, 30, HeadOfUnitPage.assignThematicLeadCheckBox);
			SeleniumCommonFunctions.click(HeadOfUnitPage.assignThematicLeadCheckBox, driver);
			Thread.sleep(2000);
			break;

		case "save":
			SeleniumCommonFunctions.scrollPageUsingJS(driver, HeadOfUnitPage.saveBtn);
			Thread.sleep(1000);
			WaitClass.explicitWaitClickable1(driver, 50, HeadOfUnitPage.saveBtn);
			SeleniumCommonFunctions.click(HeadOfUnitPage.saveBtn, driver);
			Thread.sleep(2000);
			break;

		case "Close report set":
			Thread.sleep(2000);
			try {
				if (driver.findElement(ChancellerySupervisorPage.closeReportSet).isDisplayed()) {
					WaitClass.waitUntilElementIsLocated(driver, ChancellerySupervisorPage.closeReportSet, 50);
					SeleniumCommonFunctions.scrollPageUsingJS(driver, ChancellerySupervisorPage.closeReportSet);
					Thread.sleep(2000);
					WaitClass.explicitWaitClickable1(driver, 50, ChancellerySupervisorPage.closeReportSet);
					SeleniumCommonFunctions.click(ChancellerySupervisorPage.closeReportSet, driver);
				}
			} catch (Exception e) {
				System.out.println("Close button is not present for the report to be closed");
			}
			// driver.close(); //closing the tab of the application logged in as a specific
			// role"
			break;

		case "ReprtTranslationIconOnChancellerySupervisorPage":
			Thread.sleep(1000);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ChancellerySupervisorPage.reportTranslationIcon);
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.reportTranslationIcon);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.reportTranslationIcon, driver);
			Thread.sleep(2000);
			break;

		case "upload":
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ChancellerySupervisorPage.uploadBtn);
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.uploadBtn);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.uploadBtn, driver);
			Thread.sleep(2000);
			break;

		case "Add File":
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ChancellerySupervisorPage.addFileBtn);
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.addFileBtn);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.addFileBtn, driver);
			Thread.sleep(2000);
			break;

		case "OK":
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.okBtn);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.okBtn);
			Thread.sleep(2000);
			break;

		case "Send above selected docs for translation":
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ChancellerySupervisorPage.sendDocsForTranslationBar);
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.sendDocsForTranslationBar);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.sendDocsForTranslationBar, driver);
			Thread.sleep(2000);
			break;

		case "checkBoxForFileTranslation":
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ChancellerySupervisorPage.checkBoxForFileTranslation);
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.checkBoxForFileTranslation);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.checkBoxForFileTranslation, driver);
			Thread.sleep(2000);
			break;

		case "ReportValidationIconOnHeadOfUnitPage":
			SeleniumCommonFunctions.scrollPageUsingJS(driver, HeadOfUnitPage.reportValidationIcon);
			WaitClass.explicitWaitClickable1(driver, 50, HeadOfUnitPage.reportValidationIcon);
			Thread.sleep(3000);
			SeleniumCommonFunctions.click(HeadOfUnitPage.reportValidationIcon, driver);
			Thread.sleep(2000);
			break;

		case "Observation Checkbox Of First Row":
			SeleniumCommonFunctions.scrollPageUsingJS(driver, HeadOfUnitPage.observationCheckboxFirstRow);
			WaitClass.explicitWaitClickable1(driver, 30, HeadOfUnitPage.observationCheckboxFirstRow);
			SeleniumCommonFunctions.click(HeadOfUnitPage.observationCheckboxFirstRow, driver);
			Thread.sleep(2000);
			break;

		case "Cancel":
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.cancelBtn);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.cancelBtn, driver);
			Thread.sleep(2000);
			break;

		case "Add Files Below":
			WaitClass.waitUntilElementIsLocated(driver, ThematicLeadPage.addFileIcon, 50);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ThematicLeadPage.addFileIcon);
			try {
				if (driver.findElement(ThematicLeadPage.addFileIcon).isDisplayed()) {
					WaitClass.explicitWaitClickable1(driver, 70, ThematicLeadPage.addFileIcon);
					//SeleniumCommonFunctions.click(ThematicLeadPage.addFileIcon, driver);
					driver.findElement(ThematicLeadPage.addFileIcon).click();
					Thread.sleep(2000);
					//driver.findElement(ThematicLeadPage.addFileIcon).click();
				}
			} catch (Exception e) {
				System.out.println("Add files below icon is not clickable");
			}
			//driver.switchTo().frame(0);
			break;

		case "Save Files In WorkFlow":
			Thread.sleep(2000);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ThematicLeadPage.saveFilesInWorkflow);
			WaitClass.explicitWaitClickable1(driver, 50, ThematicLeadPage.saveFilesInWorkflow);
			SeleniumCommonFunctions.click(ThematicLeadPage.saveFilesInWorkflow, driver);
			Thread.sleep(2000);
			break;
			
		case "create_DLC":
			
			Thread.sleep(3000);
			WaitClass.waitUntilElementIsLocated(driver, LegalSpecialistPage.createDLCBtn, 90);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.createDLCBtn);
			//WaitClass.waitUntilElementIsLocated(driver, LegalSpecialistPage.createDLCBtn, 90);
			Thread.sleep(3000);
			try{
				if(driver.findElement(LegalSpecialistPage.createDLCBtn).isDisplayed()){
					
				//SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.createDLCBtn);
				WaitClass.explicitWaitClickable1(driver, 30, LegalSpecialistPage.createDLCBtn);
				SeleniumCommonFunctions.click(LegalSpecialistPage.createDLCBtn, driver);
				Thread.sleep(2000);
				}
			}
				catch (Exception e)
				{
					System.out.println("create DLC button is not clickable");
				}
			break;
			
		case "yesOptionForCaseSensitiveApprovalOfCoB":
			
			SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.caseSensitiveApprovalOfCoB);
			try {
				if(driver.findElement(LegalSpecialistPage.caseSensitiveApprovalOfCoB).isDisplayed()) {
			
			//SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.caseSensitiveApprovalOfCoB);
			WaitClass.explicitWaitClickable1(driver, 30, LegalSpecialistPage.caseSensitiveApprovalOfCoB);
			SeleniumCommonFunctions.click(LegalSpecialistPage.caseSensitiveApprovalOfCoB, driver);
			Thread.sleep(2000);
			}
			}
			
			catch (Exception e)
			{
				System.out.println("case sensitive element not present");
			}
			break;
			
		case "readyForThematicLeadSignOffIcon":
			
			Thread.sleep(3000);
			//SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.draftDLCTab);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ThematicLeadPage.thematicLeadSignOffIcon);	
			
			try {
				Thread.sleep(2000);
				//SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.readyForThematicLeadSignOffIcon);
				if (driver.findElement(ThematicLeadPage.thematicLeadSignOffIcon).isDisplayed()){
			
					//WaitClass.waitUntilElementIsLocated(driver, LegalSpecialistPage.createDLCBtn, 90);
					
					Thread.sleep(3000);
					//WaitClass.waitUntilElementIsLocated(driver, LegalSpecialistPage.createDLCBtn, 90);
					WaitClass.explicitWaitClickable1(driver, 30, ThematicLeadPage.thematicLeadSignOffIcon);
					SeleniumCommonFunctions.clickJS(driver, ThematicLeadPage.thematicLeadSignOffIcon);
					Thread.sleep(2000);
				}
			}
			catch (Exception e) {
				System.out.println ("ThematicLeadSignOffIcon element is not present to be clicked");
			}
			break;
			
		case "technicalDepartmentInputsTab":
			
			Thread.sleep(2000);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.technicalDepartmentInputsTab);
			WaitClass.explicitWaitClickable1(driver, 30, LegalSpecialistPage.technicalDepartmentInputsTab);
			SeleniumCommonFunctions.click(LegalSpecialistPage.technicalDepartmentInputsTab, driver);
			Thread.sleep(2000);
			break;
			
		case "inputNeededYes":
			
			Thread.sleep(2000);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.inputNeededYes);
			WaitClass.explicitWaitClickable1(driver, 30, LegalSpecialistPage.inputNeededYes);
			SeleniumCommonFunctions.click(LegalSpecialistPage.inputNeededYes, driver);
			Thread.sleep(2000);
			break;
			
		case "Assign":
			
			Thread.sleep(2000);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.assignBtn);
			WaitClass.explicitWaitClickable1(driver, 30, LegalSpecialistPage.assignBtn);
			SeleniumCommonFunctions.click(LegalSpecialistPage.assignBtn, driver);
			Thread.sleep(2000);
			break;
			
		case "Endtask":
			
//			String techDepUserName = "techDepUsername";
//			Thread.sleep(2000);
//			SeleniumCommonFunctions.delAddFilesTable(driver, TechnicalDepPage.endTaskBtn, PropertiesClass.loadPropertiesFile("technicalUserStatus", "reportValues_path"), techDepUserName);
			Thread.sleep(2000);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, TechnicalDepPage.endTaskBtn);
			WaitClass.explicitWaitClickable1(driver, 30, TechnicalDepPage.endTaskBtn);
			SeleniumCommonFunctions.click(TechnicalDepPage.endTaskBtn, driver);
			Thread.sleep(2000);
			break;
			
		case "draftDLCTab":
			
			Thread.sleep(2000);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.draftDLCTab);
			WaitClass.explicitWaitClickable1(driver, 30, LegalSpecialistPage.draftDLCTab);
			SeleniumCommonFunctions.click(LegalSpecialistPage.draftDLCTab, driver);
			Thread.sleep(2000);
			break;
			
		case "ProceedBtn":
			
			Thread.sleep(2000);
			WaitClass.explicitWaitClickable1(driver, 30, TechnicalDepPage.proceedBtn);
			SeleniumCommonFunctions.click(TechnicalDepPage.proceedBtn, driver);
			Thread.sleep(2000);
			break;
			
		case "Thematic Lead sign-off":
			
			Thread.sleep(2000);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ThematicLeadPage.thematicLeadSignOffIcon);
			WaitClass.explicitWaitClickable1(driver, 30, ThematicLeadPage.thematicLeadSignOffIcon);
			SeleniumCommonFunctions.clickJS(driver, ThematicLeadPage.thematicLeadSignOffIcon);
			Thread.sleep(2000);
			break;
			
		case "Yes":
			
			Thread.sleep(2000);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.yesBtnUsingButtonTagName);
			break;
			
		case "initialHoUSignOff":
			
			Thread.sleep(2000);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, HeadOfUnitPage.initialHoUSignOffIcon);
			WaitClass.explicitWaitClickable1(driver, 30, HeadOfUnitPage.initialHoUSignOffIcon);
			SeleniumCommonFunctions.clickJS(driver, HeadOfUnitPage.initialHoUSignOffIcon);
			Thread.sleep(2000);
			break;
			
		case "chiefOfBranchSignOff":
			
			Thread.sleep(2000);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ChiefOfBranchPage.chiefOfBranchSignOffIcon);
			WaitClass.explicitWaitClickable1(driver, 30, ChiefOfBranchPage.chiefOfBranchSignOffIcon);
			SeleniumCommonFunctions.clickJS(driver, ChiefOfBranchPage.chiefOfBranchSignOffIcon);
			Thread.sleep(2000);
			break;
			
		case "yesBtnForApproval":
			
			Thread.sleep(2000);
			//SeleniumCommonFunctions.scrollPageUsingJS(driver, ChiefOfBranchPage.chiefOfBranchSignOffIcon);
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.yesBtnForApproval);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.yesBtnForApproval);
			Thread.sleep(2000);
			break;
			
		case "yesReviewForCEACRExpert":
			
			Thread.sleep(2000);
			//SeleniumCommonFunctions.scrollPageUsingJS(driver, ChiefOfBranchPage.chiefOfBranchSignOffIcon);
			WaitClass.explicitWaitClickable1(driver, 30, ExpertReviewPage.yesReviewForCEACRExpert);
			SeleniumCommonFunctions.clickJS(driver, ExpertReviewPage.yesReviewForCEACRExpert);
			Thread.sleep(2000);
			break;
			
		case "endTask":
			
			Thread.sleep(2000);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ExpertReviewPage.endTaskBtn);
			WaitClass.explicitWaitClickable1(driver, 30, ExpertReviewPage.endTaskBtn);
			SeleniumCommonFunctions.clickJS(driver, ExpertReviewPage.endTaskBtn);
			Thread.sleep(3000);
			break;
			
		case "approveRepliesRecievedBtn":
			
			Thread.sleep(2000);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ExpertReviewPage.approveRepliesRecievedBtn);
			WaitClass.explicitWaitClickable1(driver, 30, ExpertReviewPage.approveRepliesRecievedBtn);
			Thread.sleep(1000);
			SeleniumCommonFunctions.clickJS(driver, ExpertReviewPage.approveRepliesRecievedBtn);
			Thread.sleep(3000);
			break;
			
		case "expertReviewCompletionSelection":
			
			Thread.sleep(2000);
			//SeleniumCommonFunctions.scrollPageUsingJS(driver, ExpertReviewPage.approveRepliesRecievedBtn);
			WaitClass.explicitWaitClickable1(driver, 30, ExpertReviewPage.expertReviewCompletionSelection);
			Thread.sleep(1000);
			SeleniumCommonFunctions.clickJS(driver, ExpertReviewPage.expertReviewCompletionSelection);
			Thread.sleep(3000);
			break;
			
		case "HoUSignOffAfterExpertReviews":
			
			Thread.sleep(2000);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, HeadOfUnitPage.HoUSignOffAfterExpertReviews);
			WaitClass.explicitWaitClickable1(driver, 30, HeadOfUnitPage.HoUSignOffAfterExpertReviews);
			Thread.sleep(1000);
			SeleniumCommonFunctions.clickJS(driver, HeadOfUnitPage.HoUSignOffAfterExpertReviews);
			Thread.sleep(3000);
			break;

		default:
			// action = null;
			break;
		}
	}

	@When("^user uploads the file for RELMEETINGS$")
	public void user_uploads_the_file_for_RELMEETINGS() throws Throwable {

		String filePath = System.getProperty("user.dir")
				+ "/src/main/java/com/automation/filesForUpload/file-sample_500kB.docx";
		driver.findElement(ChancellerySupervisorPage.uploadFile).sendKeys(filePath);
		Thread.sleep(1000);
	}

	@When("^user selects \"([^\"]*)\" dropdown$")
	public void user_selects_dropdown(String dropdown) throws Throwable {
		Thread.sleep(2000);

		switch (dropdown) {

		case "Article Type":
			Thread.sleep(3000);
			WebElement element = driver.findElement(ChancellerySupervisorPage.cancelBtn);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, ChancellerySupervisorPage.cancelBtn);
			try {
				if (element.isDisplayed()) {
					SeleniumCommonFunctions.scrollPageUsingJS(driver, ChancellerySupervisorPage.Article_Type_DropDown);
					// WaitClass.explicitWaitClickable1(driver,50,ChancellerySupervisorPage.Article_Type_DropDown);
					SeleniumCommonFunctions.click(ChancellerySupervisorPage.Article_Type_DropDown, driver);
					SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.Article_22);
				}
			} catch (Exception e) {
				System.out.println("Article type drop down is not clickable");
			}

			break;

		case "Select Chancellery Member":
			Thread.sleep(1000);
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.selectChancelleryMemberDropdown);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.selectChancelleryMemberDropdown, driver);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.chancelleryMemberName1);
			break;

		case "assignThematicLeadAndLegalSpecialistOption":
			Thread.sleep(1000);
			WaitClass.explicitWaitClickable1(driver, 30, HeadOfUnitPage.assignThematicLeadAndLegalSpecialistOption);
			SeleniumCommonFunctions.click(HeadOfUnitPage.assignThematicLeadAndLegalSpecialistOption, driver);
			SeleniumCommonFunctions.clickJS(driver, HeadOfUnitPage.assignThematicLeadAndLegalSpecialistOption);
			break;
			
		case "selectTechDepPersonDropDown":
			
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.technicalDepartmentInputsTab);
			Thread.sleep(4000);
			try {
				if(driver.findElement(LegalSpecialistPage.selectTechDepPersonDropDown).isDisplayed()) {
					Thread.sleep(3000);
					SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.selectTechDepPersonDropDown);
					WaitClass.waitUntilElementIsLocated(driver, LegalSpecialistPage.selectTechDepPersonDropDown, 90);
					
					WaitClass.explicitWaitClickable1(driver, 30, LegalSpecialistPage.selectTechDepPersonDropDown);
					Thread.sleep(3000);
					SeleniumCommonFunctions.clickJS(driver, LegalSpecialistPage.selectTechDepPersonDropDown);
					//SeleniumCommonFunctions.clickJS(driver, HeadOfUnitPage.assignThematicLeadAndLegalSpecialistOption);
				}
			}
			catch (Exception e) {
				System.out.println("Select Tech Dep Person Dropdown is not clickable");
			}
			break;
			
		case "techDepAssignedUsername":
			
			Thread.sleep(1000);
			WaitClass.explicitWaitClickable1(driver, 30, LegalSpecialistPage.techDepAssignedUsername);
			SeleniumCommonFunctions.click(LegalSpecialistPage.techDepAssignedUsername, driver);
			//SeleniumCommonFunctions.clickJS(driver, HeadOfUnitPage.assignThematicLeadAndLegalSpecialistOption);
			break;
			
		case "selectDecisionForCreateDLC":

			Thread.sleep(1000);
			WebElement ele = driver.findElement(HeadOfUnitPage.selectDecisionForCreateDLC);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, HeadOfUnitPage.selectDecisionForCreateDLC);
			try {
				if (ele.isDisplayed()) {
					//SeleniumCommonFunctions.scrollPageUsingJS(driver, ChancellerySupervisorPage.Article_Type_DropDown);
					// WaitClass.explicitWaitClickable1(driver,50,ChancellerySupervisorPage.Article_Type_DropDown);
					SeleniumCommonFunctions.selectDropdownByVisibleText(driver, HeadOfUnitPage.selectDecisionForCreateDLC, PropertiesClass.loadPropertiesFile("selectDecisionDoNotCreate", "reportValues_path"));
				}
			} catch (Exception e) {
				System.out.println("Select Decision drop down is not clickable");
			}
			break;
			
		default:
			break;
		}
	}

	@When("^user selects dropdowns for \"([^\"]*)\"$")
	public void user_selects_dropdowns_for(String new_report_set) throws Throwable {
		Thread.sleep(2000);

		switch (new_report_set) {
		case "Article 22 new report set":
			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.Select_Country_DropDown);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Select_Country_DropDown, driver);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.Country_Afghanistan);
			Thread.sleep(1000);

			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.Subject);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Subject, driver);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.Subject_Value);
			Thread.sleep(1000);

			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.Convention_DropDown_Value_1);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Convention_DropDown_Value_1, driver);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.Convention_C138);
			Thread.sleep(1000);

			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.Convention_DropDown_Value_1);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Convention_DropDown_Value_1, driver);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.Convention_C182);
			Thread.sleep(1000);

			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.Select_Year);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.Select_Year, driver);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.Year_2020);
			Thread.sleep(1000);

			WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.Save_Btn);
			SeleniumCommonFunctions.clickJS(driver, ChancellerySupervisorPage.Save_Btn);
			Thread.sleep(1000);
			break;

		default:
			break;
		}
	}

	@Then("^report metadata is displayed successfully for the created report set$")
	public void report_metadata_is_displayed_successfully_for_the_created_report_set() throws Throwable {

		// String abc = driver.getCurrentUrl();
		// System.out.println(abc);

		try {
			if (driver.findElement(ChancellerySupervisorPage.reportSetNameById).isDisplayed())
				Thread.sleep(9000);
			WaitClass.waitUntilElementIsLocated(driver, ChancellerySupervisorPage.Report_Set_Name, 90);
			WaitClass.waitUntilElementIsLocated(driver, ChancellerySupervisorPage.Report_Set_Name, 90);
			WaitClass.explicitWaitVisible(driver, 3000, ChancellerySupervisorPage.Report_Set_Name);
			Thread.sleep(3000);

			String reportNameValue = driver.findElement(ChancellerySupervisorPage.Report_Set_Name).getText().trim();
			System.out.println(reportNameValue);
			softly.assertThat(reportNameValue)
					.isEqualTo(PropertiesClass.loadPropertiesFile("createReportSetName", "reportValues_path"));

			softly.assertAll();
			String reportSetName = "Article22ReportSetName";
			PropertiesClass.storePropertiesFile(reportSetName, reportNameValue); // for storing the name of the
																					// generated report set
			// System.out.println(PropertiesClass.loadPropertiesFile("Article22ReportSet",
			// "writeValues_path"));
			
			//PropertiesClass.readAndWriteProperties(reportSetName, reportNameValue); //checking for overwriting of the file
			
		}

		catch (Exception e) {
			System.out.println("Report Set Name Not Present");
		}
	}

	@When("^user selects the Current Reception Date for the C138 report received$")
	public void user_selects_the_Current_Reception_Date_for_the_C138_report_received() throws Throwable {

		SeleniumCommonFunctions.click(ChancellerySupervisorPage.reportedDateForC138, driver);
		WebElement element = driver.findElement(ChancellerySupervisorPage.reportedDateForC138);
		element.sendKeys(DateTime.currentDate(driver, "dd MMMM yy"));
		Thread.sleep(1000);
		element.sendKeys(Keys.ENTER);
	}

	@When("^user selects the Current Reception Date for the C182 report received$")
	public void user_selects_the_Current_Reception_Date_for_the_C182_report_received() throws Throwable {

		SeleniumCommonFunctions.click(ChancellerySupervisorPage.reportedDateForC182, driver);
		WebElement element = driver.findElement(ChancellerySupervisorPage.reportedDateForC182);
		element.sendKeys(DateTime.currentDate(driver, "dd MMMM yy"));
		Thread.sleep(1000);
		// element.sendKeys(Keys.ENTER);
	}

	@Given("^user logged in to the SharePoint application$")
	public void user_logged_in_to_the_SharePoint_application() throws Throwable {

		launchBrowser();
		Thread.sleep(2000);

		driver.get(PropertiesClass.loadPropertiesFile("deleteReportSetURL", "URL_path"));
		SeleniumCommonFunctions.click(ChancellerySupervisorPage.ISO_HeadQuarters_Login_Path, driver);
		SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Username, driver,
				PropertiesClass.loadPropertiesFile("deleteURLLoginUsername", "URL_path"));
		SeleniumCommonFunctions.sendKeys(ChancellerySupervisorPage.ISO_HeadQuarters_Password, driver,
				PropertiesClass.loadPropertiesFile("deleteURLLoginPassword", "URL_path"));
		SeleniumCommonFunctions.click(ChancellerySupervisorPage.Submit_Btn, driver);

	}

	@Given("^user deletes the Created Report set$")
	public void user_deletes_the_Created_Report_set() throws Throwable {

		try {
			if (driver.findElement(ChancellerySupervisorPage.reportSetName).isDisplayed())

				SeleniumCommonFunctions.click(ChancellerySupervisorPage.deleteReportSetCheckbox, driver);
			Thread.sleep(1000);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.deleteReportSet, driver);
			Thread.sleep(1000);
			SeleniumCommonFunctions.click(ChancellerySupervisorPage.deleteReportSetIcon, driver);
		} catch (Exception e) {
			System.out.println("Report set not present to be deleted");
		}
		driver.close();
	}

	@When("^user selects Select Annex Type, Select Convention\\(s\\), Select Language, Choose File, Language to be translated on the Add government reports and annexes page$")
	public void user_selects_Select_Annex_Type_Select_Convention_s_Select_Language_Choose_File_Language_to_be_translated_on_the_Add_government_reports_and_annexes_page()
			throws Throwable {

		Thread.sleep(1000);
		WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.selectAnnexType);
		SeleniumCommonFunctions.click(ChancellerySupervisorPage.selectAnnexType, driver);
		Thread.sleep(2000);

		WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.selectAnnexTypeValue);
		SeleniumCommonFunctions.click(ChancellerySupervisorPage.selectAnnexTypeValue, driver);
		Thread.sleep(1000);

		WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.selectConvention);
		SeleniumCommonFunctions.click(ChancellerySupervisorPage.selectConvention, driver);
		Thread.sleep(1000);

		WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.selectConventionValue);
		SeleniumCommonFunctions.click(ChancellerySupervisorPage.selectConventionValue, driver);
		Thread.sleep(1000);

		SeleniumCommonFunctions.selectDropdownByVisibleText(driver, ChancellerySupervisorPage.selectLanguage,
				PropertiesClass.loadPropertiesFile("selectLanguage", "reportValues_path"));
		Thread.sleep(1000);

//		WaitClass.explicitWaitClickable1(driver, 30, LoginPage.uploadFile);
//		SeleniumCommonFunctions.click(LoginPage.uploadFile, driver);

		String filePath = System.getProperty("user.dir")
				+ "/src/main/java/com/automation/filesForUpload/Defects logging in uk.pdf";
		driver.findElement(ChancellerySupervisorPage.uploadFile).sendKeys(filePath);
		Thread.sleep(1000);

		SeleniumCommonFunctions.selectDropdownByVisibleText(driver, ChancellerySupervisorPage.selectTranslationLanguage,
				PropertiesClass.loadPropertiesFile("selectTranslationLanguage", "reportValues_path"));
		Thread.sleep(1000);

	}

	@Then("^the HoU is notified about new reports or annexes uploads \"([^\"]*)\"$")
	public void the_HoU_is_notified_about_new_reports_or_annexes_uploads(String HoU_Notification_Msge)
			throws Throwable {

		Thread.sleep(1000);
		// WaitClass.explicitWaitClickable1(driver, 50,
		// ChancellerySupervisorPage.notifyHOUMessage);
		String notifyHoUMsge = driver.findElement(ChancellerySupervisorPage.notifyHOUMessage).getText().substring(0,
				33);
		System.out.println(notifyHoUMsge);

		softly.assertThat(notifyHoUMsge).isEqualTo(HoU_Notification_Msge);
		softly.assertAll();
	}

	@Then("^the user gets the \"([^\"]*)\"$")
	public void the_user_gets_the(String report_translation_message) throws Throwable {

		String reportTranslationMsg = driver.findElement(ChancellerySupervisorPage.reportTranslationMsge).getText()
				.substring(0, 51);
		System.out.println(reportTranslationMsg);

		softly.assertThat(reportTranslationMsg).isEqualTo(report_translation_message);
		softly.assertAll();
		// String reportTranslationMessage = "reportTranslationMsgeIs";
		// PropertiesClass.storePropertiesFile(reportTranslationMessage,
		// reportTranslationMsg);
	}

	@Given("^user enters the report set name in the report set name column$")
	public void user_enters_the_report_set_name_in_the_report_set_name_column() throws Throwable {
		Thread.sleep(1000);

		SeleniumCommonFunctions.scrollPageUsingJS(driver, HeadOfUnitPage.fillReportSetName);
		WaitClass.explicitWaitUntil1(driver, HeadOfUnitPage.fillReportSetName, 90);
		WaitClass.explicitWaitClickable1(driver, 50, HeadOfUnitPage.fillReportSetName);
		SeleniumCommonFunctions.sendKeys(HeadOfUnitPage.fillReportSetName, driver,
				PropertiesClass.loadPropertiesFile("Article22ReportSetName", "writeValues_path"));
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		Thread.sleep(2000);
		try {
			if (driver.findElement(HeadOfUnitPage.nextBtn).isDisplayed()) {
				SeleniumCommonFunctions.scrollPageUsingJS(driver, HeadOfUnitPage.nextBtn);
				SeleniumCommonFunctions.scrollPageUsingJS(driver, HeadOfUnitPage.fillReportSetName);
				WaitClass.explicitWaitClickable1(driver, 50, HeadOfUnitPage.fillReportSetName);
				driver.findElement(HeadOfUnitPage.fillReportSetName).sendKeys(Keys.ENTER);
			}
		} catch (Exception e) {
			System.out.println("Report set is not present");
		}
	}

	@Given("^user assigns the \"([^\"]*)\"$")
	public void user_assigns_the(String role_username) throws Throwable {

		Thread.sleep(1000);
		switch (role_username) {
		case "Legal_Specialist_Role":
//					if(driver.findElement(HeadOfUnitPage.assignLegalSpecialistCheckBox).isSelected())
//							{
			SeleniumCommonFunctions.scrollPageUsingJS(driver, HeadOfUnitPage.selectLegalSpecialistDropDown);
			WaitClass.explicitWaitClickable1(driver, 50, HeadOfUnitPage.selectLegalSpecialistDropDown);
			SeleniumCommonFunctions.click(HeadOfUnitPage.selectLegalSpecialistDropDown, driver);
			WaitClass.explicitWaitClickable1(driver, 50, HeadOfUnitPage.legalSpecialistUsername);
			SeleniumCommonFunctions.click(HeadOfUnitPage.legalSpecialistUsername, driver);
			Thread.sleep(2000);
//					}

			break;

		case "Thematic_Lead_Role":

			SeleniumCommonFunctions.scrollPageUsingJS(driver, HeadOfUnitPage.selectThematicLeadDropDown);
			WaitClass.explicitWaitClickable1(driver, 50, HeadOfUnitPage.selectThematicLeadDropDown);
			SeleniumCommonFunctions.click(HeadOfUnitPage.selectThematicLeadDropDown, driver);
			WaitClass.explicitWaitClickable1(driver, 50, HeadOfUnitPage.thematicLeadUserName);
			SeleniumCommonFunctions.click(HeadOfUnitPage.thematicLeadUserName, driver);
			Thread.sleep(2000);
			break;

		default:
			break;

		}
	}

	@Given("^selects Document Type, Convention Type, Language of the Document, File to be uploaded on the add research background documents page$")
	public void selects_Document_Type_Convention_Type_Language_of_the_Document_File_to_be_uploaded_on_the_add_research_background_documents_page()
			throws Throwable {

		Thread.sleep(1000);
		SeleniumCommonFunctions.selectDropdownByVisibleText(driver, ThematicLeadPage.selectDocumentType,
				PropertiesClass.loadPropertiesFile("selectDocumentType", "reportValues_path"));

		WaitClass.explicitWaitClickable1(driver, 30, ThematicLeadPage.selectConvention);
		SeleniumCommonFunctions.click(ThematicLeadPage.selectConvention, driver);
		Thread.sleep(1000);

		WaitClass.explicitWaitClickable1(driver, 30, ThematicLeadPage.selectConventionValue);
		SeleniumCommonFunctions.click(ThematicLeadPage.selectConventionValue, driver);
		Thread.sleep(1000);

		WaitClass.explicitWaitClickable1(driver, 30, ThematicLeadPage.selectConvention);
		SeleniumCommonFunctions.click(ThematicLeadPage.selectConvention, driver);
		Thread.sleep(1000);

		WaitClass.explicitWaitClickable1(driver, 30, ChancellerySupervisorPage.selectConventionValue);
		SeleniumCommonFunctions.click(ChancellerySupervisorPage.selectConventionValue, driver);
		Thread.sleep(1000);

		SeleniumCommonFunctions.selectDropdownByVisibleText(driver, ThematicLeadPage.selectLanguageOfDocument,
				PropertiesClass.loadPropertiesFile("selectLanguage", "reportValues_path"));
		Thread.sleep(1000);

		String filePath = System.getProperty("user.dir")
				+ "/src/main/java/com/automation/filesForUpload/Agribusiness Sector Strategy.pdf";
		driver.findElement(ChancellerySupervisorPage.uploadFile).sendKeys(filePath);
		Thread.sleep(1000);
}
	
	@Given("^user selects comment needed or not for \"([^\"]*)\"$")
	public void user_selects_comment_needed_or_not_for(String comment_Yes_or_Not) throws Throwable {
	   
		Thread.sleep(2000);
		switch(comment_Yes_or_Not) {
		
		case "convention_138":
			
			SeleniumCommonFunctions.scrollPageUsingJS(driver, HeadOfUnitPage.saveBtn);
			Thread.sleep(2000);
			WaitClass.waitUntilElementIsLocated(driver, LegalSpecialistPage.commentYesCheckBoxForC138, 90);
			SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.commentYesCheckBoxForC138);
			WaitClass.explicitWaitClickable1(driver, 90, LegalSpecialistPage.commentYesCheckBoxForC138);
			SeleniumCommonFunctions.clickJS(driver, LegalSpecialistPage.commentYesCheckBoxForC138);
			
			Thread.sleep(1000);
			try {
				if(driver.findElement(LegalSpecialistPage.repliesReceivedBar).isDisplayed()) {
					Thread.sleep(4000);
					//SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.repliesReceivedBar);
					SeleniumCommonFunctions.click(LegalSpecialistPage.repliesReceivedBar, driver);
				}
			}
			catch (Exception e) {
				System.out.println("Replies' checkbox is not clickable");
			}
			break;
			
		case "convention_182":
			
			SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.commentYesCheckBoxForC182);
			WaitClass.explicitWaitClickable1(driver, 50, LegalSpecialistPage.commentYesCheckBoxForC182);
			Thread.sleep(2000);
			SeleniumCommonFunctions.clickJS(driver, LegalSpecialistPage.commentYesCheckBoxForC182);
			break;
			
			default:
				break;
		}
		
	}
	   
	@Given("^user creates new DLCs for \"([^\"]*)\"$")
	public void user_creates_new_DLCs_for(String convention_located) throws Throwable {
		
		Thread.sleep(1000);
		switch(convention_located) {
		
		case "convention_138":
			
			SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.commentYesCheckBoxForC138);
			WaitClass.explicitWaitClickable1(driver, 50, LegalSpecialistPage.commentYesCheckBoxForC138);
			SeleniumCommonFunctions.click(LegalSpecialistPage.commentYesCheckBoxForC138, driver);
			Thread.sleep(1000);
			
			SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.repliesReceivedBar);
			WaitClass.explicitWaitClickable1(driver, 50, LegalSpecialistPage.repliesReceivedBar);
			SeleniumCommonFunctions.click(LegalSpecialistPage.repliesReceivedBar, driver);
			Thread.sleep(1000);
			break;
			
		case "convention_182":
			
			SeleniumCommonFunctions.scrollPageUsingJS(driver, LegalSpecialistPage.commentYesCheckBoxForC182);
			WaitClass.explicitWaitClickable1(driver, 50, LegalSpecialistPage.commentYesCheckBoxForC182);
			SeleniumCommonFunctions.click(LegalSpecialistPage.commentYesCheckBoxForC182, driver);
			Thread.sleep(1000);
			break;
		}
	}
	
	@Given("^user creates \"([^\"]*)\"$")
	public void user_creates(String new_DLC) throws Throwable {
	   
		Thread.sleep(2000);
		switch(new_DLC) {
		
		case "newDLCForC138":
			
			//WaitClass.explicitWaitClickable1(driver, 50, LegalSpecialistPage.DLCTypeReply);
			SeleniumCommonFunctions.click(LegalSpecialistPage.DLCTypeReply, driver);
			Thread.sleep(1000);
			
			WaitClass.explicitWaitClickable1(driver, 50, LegalSpecialistPage.selectConvention);
			SeleniumCommonFunctions.click(LegalSpecialistPage.selectConvention, driver);
			Thread.sleep(1000);
			
			WaitClass.explicitWaitClickable1(driver, 50, LegalSpecialistPage.selectConventionC138);
			SeleniumCommonFunctions.click(LegalSpecialistPage.selectConventionC138, driver);
			Thread.sleep(1000);
			
			SeleniumCommonFunctions.click(LegalSpecialistPage.createDLCOnCreateNewDLCPopUp, driver);
			Thread.sleep(3000);
			break;
			
		case "newDLCForC182":
			
			//WaitClass.explicitWaitClickable1(driver, 50, LegalSpecialistPage.DLCTypeDirectRequest);
			SeleniumCommonFunctions.click(LegalSpecialistPage.DLCTypeDirectRequest, driver);
			Thread.sleep(1000);
			
			WaitClass.explicitWaitClickable1(driver, 50, LegalSpecialistPage.selectConvention);
			SeleniumCommonFunctions.click(LegalSpecialistPage.selectConvention, driver);
			Thread.sleep(1000);
			
			WaitClass.explicitWaitClickable1(driver, 50, LegalSpecialistPage.selectConventionC182);
			SeleniumCommonFunctions.click(LegalSpecialistPage.selectConventionC182, driver);
			Thread.sleep(1000);
			
			SeleniumCommonFunctions.selectDropdownByVisibleText(driver, ChancellerySupervisorPage.selectLanguage,
					PropertiesClass.loadPropertiesFile("selectTranslationLanguage", "reportValues_path"));
			Thread.sleep(1000);
			
			SeleniumCommonFunctions.click(LegalSpecialistPage.createDLCOnCreateNewDLCPopUp, driver);
			Thread.sleep(3000);
			break;
		}
	}
	@Given("^user deleted the existing added file$")
	public void user_deleted_the_existing_added_file() throws Throwable {
	    
		String FileName = "fileName";
		SeleniumCommonFunctions.delAddFilesTable(driver, LegalSpecialistPage.deleteIconOnAddFilesBelow, PropertiesClass.loadPropertiesFile("fileTitle2", "reportValues_path"),FileName );
		//WaitClass.waitUntilElementIsLocated(driver, ChancellerySupervisorPage.yesBtnUsingButtonTagName, 20);
		Thread.sleep(3000);
		try{
			if(driver.findElement(ChancellerySupervisorPage.yesBtnUsingButtonTagName).isDisplayed()) {
				SeleniumCommonFunctions.click(ChancellerySupervisorPage.yesBtnUsingButtonTagName, driver);
				Thread.sleep(3000);
			}
		}
		catch (Exception e) {
			System.out.println("yes button not present to be clicked");
		}
		
	}

	@Given("^selects Document Type, Convention Type, Language of the Document, File to be uploaded on the add research background documents' page$")
	public void selects_Document_Type_Convention_Type_Language_of_the_Document_File_to_be_uploaded_on_the_add_research_background_documents_page1() throws Throwable {
	    
		Thread.sleep(1000);
		SeleniumCommonFunctions.selectDropdownByVisibleText(driver, ThematicLeadPage.selectDocumentType,
				PropertiesClass.loadPropertiesFile("selectDocumentType", "reportValues_path"));

		WaitClass.explicitWaitClickable1(driver, 30, ThematicLeadPage.selectConvention);
		SeleniumCommonFunctions.click(ThematicLeadPage.selectConvention, driver);
		Thread.sleep(1000);

		WaitClass.explicitWaitClickable1(driver, 30, LegalSpecialistPage.selectConventionC138);
		SeleniumCommonFunctions.click(LegalSpecialistPage.selectConventionC138, driver);
		Thread.sleep(1000);

		WaitClass.explicitWaitClickable1(driver, 30, ThematicLeadPage.selectConvention);
		SeleniumCommonFunctions.click(ThematicLeadPage.selectConvention, driver);
		Thread.sleep(1000);

		WaitClass.explicitWaitClickable1(driver, 30, LegalSpecialistPage.selectConventionC182);
		SeleniumCommonFunctions.click(LegalSpecialistPage.selectConventionC182, driver);
		Thread.sleep(1000);

		SeleniumCommonFunctions.selectDropdownByVisibleText(driver, ThematicLeadPage.selectLanguageOfDocument,
				PropertiesClass.loadPropertiesFile("selectLanguage", "reportValues_path"));
		Thread.sleep(1000);

		String filePath = System.getProperty("user.dir")
				+ "/src/main/java/com/automation/filesForUpload/Agribusiness Sector Strategy.pdf";
		driver.findElement(ChancellerySupervisorPage.uploadFile).sendKeys(filePath);
		Thread.sleep(1000);
		
	}
	
	@Given("^user fills the \"([^\"]*)\" box$")
	public void user_fills_the_box(String fillUpTabs) throws Throwable {
	    
		Thread.sleep(2000);
		switch(fillUpTabs) {
		
		case "techInputCompletion":
			
			SeleniumCommonFunctions.scrollPageUsingJS(driver, TechnicalDepPage.techInputCompletionSelection);
			WaitClass.explicitWaitClickable1(driver, 50, TechnicalDepPage.techInputCompletionSelection);
			SeleniumCommonFunctions.click(TechnicalDepPage.techInputCompletionSelection, driver);
			Thread.sleep(1000);
			break;
		}
		
	}
}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


