package com.automation.bases;

/**
 * @author ST57752 Shivangi Tripathi (Quality Analyst)
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class PropertiesClass {

	public static File f1;
	public static FileInputStream file;
	
	public static FileOutputStream writefile;

	static SoftAssert softly = new SoftAssert();
	public static Properties OR;

	public static String loadPropertiesFile(String str, String filename) throws IOException {

		switch (filename) {

		case "URL_path":
			OR = new Properties();
			f1 = new File(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\automation\\propertiesFiles\\URL.properties");
			file = new FileInputStream(f1);
			OR.load(file);
			break;
			
		case "reportConfigPath_path":
			OR = new Properties();
			f1 = new File(System.getProperty("user.dir")
					+ "src\\main\\java\\com\\automation\\propertiesFiles\\reportConfigPath.properties");
			file = new FileInputStream(f1);
			OR.load(file);
			break;
			
		case "reportValues_path":
			OR = new Properties();
			f1 = new File(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\automation\\propertiesFiles\\reportValues.properties");
			file = new FileInputStream(f1);
			OR.load(file);
			break;
			
		case "storeOtherValues_path":
			OR = new Properties();
			f1 = new File(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\automation\\propertiesFiles\\storeOtherValues.properties");
			file = new FileInputStream(f1);
			OR.load(file);
			break;
			
		case "writeValues_path":
			OR = new Properties();
			f1 = new File(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\automation\\propertiesFiles\\writeValues.properties");
			file = new FileInputStream(f1);
			OR.load(file);
			break;
			
		}
		return OR.getProperty(str);

	}
	
	public static void storePropertiesFile(String name , String value) throws IOException{
		
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\automation\\propertiesFiles\\writeValues.properties";
		
		 f1 = new File(path);
		OR = new Properties();
		OR.setProperty(name, value);
		writefile = new FileOutputStream(f1);
		OR.store(writefile, "ReportName");
		
		writefile.flush();
		writefile.close();	
	}
	
	public static String getProperty(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getReportConfigPath() {
		String reportConfigPath = System.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}


public static void readAndWriteProperties(String data, String value) throws IOException {
	
	String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\automation\\propertiesFiles\\storeOtherValues.properties";
	
	 f1 = new File(path);
	OR = new Properties();
	
	 file = new FileInputStream(f1);
	 
	 if (file != null) {
         OR.load(file);
         OR.setProperty(data, value);
         writefile = new FileOutputStream(f1);
         OR.store(writefile, "save");
}}

}



























