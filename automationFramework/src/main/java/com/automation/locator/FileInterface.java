package com.automation.locator;

import java.io.File;

public interface FileInterface {
	public static final String BASEDIR = System.getProperty("user.dir");
	public static final String FILE_SEPERATOR = File.separator;
	public static final String SRCDIR = "src";
	public static final String MAINDIR = "main";
	public static final String TESTDIR = "test";
	public static final String JAVADIR = "java";
	public static final String LOCATOR_FILE_DIR = "Locators";
	public static final String LOCATOR_PROPERTIES_FILE = "locator.properties";
	public static final String EMPTY = "";
	public static final String SPACE = " ";
	public static final String SEMICOLON = ";";
	public static final String DOT = ".";
	
	
	
	public static final String PROPERTYSEPARATOR = "##";
}