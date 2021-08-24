package com.automation.runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

/**
 * @author ST57752 Shivangi Tripathi (Quality Analyst)
 *
 */

		// this class is for running the test cases in the parallel mode
	   //  further changes are yet to be done

@CucumberOptions(plugin = { "pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/ParallelRunResults.html",
		"timeline:test-output-thread/" }, 
				 monochrome = true, 
				 glue = { "com.automation.stepDefinitions" }, 
				 tags = {"@ILONormes" }, 
				 features = { "src/test/java/com/automation/featureFiles" })

public class ParallelRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)

	public Object[][] features() {
		return super.features();
	}
	
//	@AfterClass(alwaysRun = true)
//	public void tearDownClass() throws Exception {
//		super.finish();
//	}
}
