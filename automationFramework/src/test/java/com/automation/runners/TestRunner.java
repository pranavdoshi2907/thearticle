package com.automation.runners;

import java.io.File;

import org.apache.logging.log4j.core.appender.FileManager;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

/**
 * 
 * @author ST57752 Shivangi Tripathi (Quality Analyst)
 *
 */

// Integrating Cucumber with TestNG

@CucumberOptions(features = { "src/test/java/com/automation/featureFiles" }, glue = {
		"com.automation.stepDefinitions" }, tags = {"@CS&HoU"},

		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/result.html", "json:target/Result.json" })

public class TestRunner extends AbstractTestNGCucumberTests { // used to run cucumber files along with the TestNG
																// framework
																// running Cucumber via TestNG

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider(parallel = false) // for parallel run
	public Object[][] features() {
		// return testNGCucumberRunner.provideFeatures();
		if (testNGCucumberRunner == null) {
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		}
		return testNGCucumberRunner.provideFeatures();
	}

	/**
	 * Passing path for extent reports
	 */
//	@BeforeSuite
//	public static void setup() {
//		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
//		extentProperties.setReportPath("ExtentReports/myreport.html");
//	}
	// extra code for report generation [line no 65-72]

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}
}
