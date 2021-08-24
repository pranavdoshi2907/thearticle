package com.automation.runners;

import com.github.mkolisnyk.cucumber.reporting.CucumberCoverageOverview;

public class ReportCoverageHTML {

	
	public static void main(String[] args) throws Exception {
    	CucumberCoverageOverview results = new CucumberCoverageOverview();
    	results.setOutputDirectory("C:\\Users\\ST57752\\workspace\\automationFramework\\target");
    	results.setOutputName("cucumber-results");
    	results.setSourceFile("C:\\Users\\ST57752\\workspace\\automationFramework\\target\\Result.json");
    	results.execute();
    }
}
