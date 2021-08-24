package com.automation.locator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//pranav Doshi
public class LocatorCreator {

	public static void main(String[] args) {
		LocatorCreator lc = new LocatorCreator();
		Properties prop = lc.readLocatorProperties();
		List<String> locatorFiles = lc.getAllLocatorsFiles();

		Iterator itrLocatorFiles = locatorFiles.iterator();

		while (itrLocatorFiles.hasNext()) {
			String strLocatorFile = itrLocatorFiles.next().toString();
			System.out.println("in Main >> strLocatorFile : " + strLocatorFile);
			List<String> locatorNames = lc.getLocatorNames(strLocatorFile);
			String strClassFileLocation = lc.getInterfacePath(prop);

			int dotIndex = strLocatorFile.indexOf(".");
			strLocatorFile = strLocatorFile.substring(0, dotIndex);
			String strClassBody = lc.getInterfaceContent(prop, locatorNames, strLocatorFile);

			String strClassname = strLocatorFile.concat("Class");
			String strClassFile = strClassFileLocation.concat(strClassname).concat(FileInterface.DOT)
					.concat("java");
			System.out.println(strClassFileLocation+ " strClassFileLocation "+strClassFile + "  strClassFile " + strClassBody  + "  strClassBody ");
			lc.createClassFile(strClassFile, strClassBody);

		}

	}

	private Properties readLocatorProperties() {
		System.out.println(FileInterface.BASEDIR + "   nnnn");
		String locatorFile = FileInterface.BASEDIR.concat(FileInterface.FILE_SEPERATOR)
				.concat(FileInterface.LOCATOR_PROPERTIES_FILE);
		Properties prop = new Properties();

		try {
			System.out.println("locatorFile " + locatorFile);
			locatorFile = FileInterface.BASEDIR + "\\Locators\\locator.properties";
			FileReader reader = new FileReader(locatorFile);
			prop.load(reader);
		} catch (Exception e) {

		}
		System.out.println(prop + " readLocatorProperties");
		return prop;
	}

	private List<String> getAllLocatorsFiles() {
		String strLocatorDir = FileInterface.BASEDIR.concat(FileInterface.FILE_SEPERATOR)
				.concat(FileInterface.LOCATOR_FILE_DIR);
		System.out.println(strLocatorDir+ "  ppp");
		File folder = new File(strLocatorDir);
		File[] files = folder.listFiles();
		List<String> xlFileList = new ArrayList<String>();

		for (File file : files) {
			String fileName = file.getName();

			if (fileName.endsWith("xlsx")) {
				xlFileList.add(fileName);
				System.out.println("FileName: " + fileName);
			}
		}
		return xlFileList;
	}

	private String getInterfacePath(Properties prop) {
		System.out.println(prop);
		String strPackage = prop.getProperty(LocatorInterface.PACKAGE);
		System.out.println(strPackage + "  -----");
		String[] strArr = strPackage.split(" ");
		strPackage = strArr[1];
		strPackage = strPackage.trim();
		strPackage = strPackage.replace(FileInterface.SEMICOLON, FileInterface.EMPTY);
		strPackage = strPackage.replace(FileInterface.DOT, File.separator);
		strPackage = FileInterface.BASEDIR.concat(File.separator).concat(FileInterface.SRCDIR).concat(File.separator)
				.concat(FileInterface.MAINDIR).concat(File.separator).concat(FileInterface.JAVADIR).concat(File.separator).concat(strPackage).concat(File.separator);
		System.out.println(strPackage + "    strPackage");
//		strPackage = FileInterface.BASEDIR + "\\src\\main\\java\\com\\automotion\\locators\\constant\\";
		return strPackage;
	}

	private List<String> getLocatorNames(String strFileName) {
		List<String> keysCollection = null;
		System.out.println("FIle To Read: " + strFileName);
		try {
			String strLocatorDir = FileInterface.BASEDIR.concat(FileInterface.FILE_SEPERATOR)
					.concat(FileInterface.LOCATOR_FILE_DIR).concat(FileInterface.FILE_SEPERATOR);

			String strFile = strLocatorDir.concat(strFileName);
			FileInputStream fis = new FileInputStream(strFile);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
//	         int lastRow = sheet.getLastRowNum();

			keysCollection = new ArrayList<String>();
			boolean isfirstRow = false;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (!isfirstRow) {
					isfirstRow = true;
					continue;
				}
				Cell cell = row.getCell(0);
				String strCellContent = cell.getStringCellValue();
				if (!strCellContent.trim().equalsIgnoreCase(FileInterface.EMPTY)) {
					keysCollection.add(strCellContent);
				}
			}

		} catch (Exception e) {

		}
		return keysCollection;
	}

	private void createClassFile(String strFileLocation, String strFileContent) {
		try {
			FileWriter fw = new FileWriter(strFileLocation);
			fw.write(strFileContent);
			fw.close();
		} catch (Exception e) {
			System.out.println("createClassFile catch");
			System.out.println(e);
		}
		System.out.println("Success...");

	}

	@Override
	public String toString() {
		return "LocatorCreator [readLocatorProperties()=" + readLocatorProperties() + ", getAllLocatorsFiles()="
				+ getAllLocatorsFiles() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	private String getInterfaceContent(Properties prop, List<String> locatorNames, String strClassname) {
		String strContent = FileInterface.EMPTY;
		strContent = strContent.concat(createPackage(prop.getProperty(LocatorInterface.PACKAGE)));
		
		strContent = strContent.concat(createImportStatement(prop.getProperty(LocatorInterface.IMPORT_STATEMENT)));
		
		strContent = strContent
				.concat(startInterface(prop.getProperty(LocatorInterface.CLASS_START), strClassname));
		
		Iterator locIterator = locatorNames.iterator();
		while (locIterator.hasNext()) {
			String strLocatorName = locIterator.next().toString().trim();

			strContent = strContent
					.concat(createInterfaceBody(prop.getProperty(LocatorInterface.STATEMENT), strLocatorName));
		}
		strContent = strContent.concat(closeInterface(prop.getProperty(LocatorInterface.CLASS_CLOSE)));

		return strContent;
	}

	private String createImportStatement(String strImport) {
		strImport = strImport.replace(";", ";\n");
		strImport = strImport.concat("\n");

		return strImport;
	}
	
	private String createPackage(String strPackage) {
		strPackage = strPackage.concat("\n");

		return strPackage;
	}

	private String startInterface(String strClassBody, String interFaceName) {
		interFaceName = interFaceName.concat("Class");
		strClassBody = strClassBody.replace("<INTERFACENAME>", interFaceName);
		strClassBody = strClassBody.replace(";", ";\n");
		strClassBody = strClassBody.replace("{", "{\n");
		strClassBody = strClassBody.concat("\n");

		return strClassBody;
	}

	private String createInterfaceBody(String strStatement, String strValue) {
	 //public static final By <VARIABLENAME> = By.xpath("//*[contains(text(),'<VALUE>')]");, 
		/// Costa Risa
		String strVariable = strValue;
		strStatement = strStatement.replace("<VARIABLENAME>", strVariable);
		strStatement = strStatement.replace("<VALUE>", strValue);
		strStatement = strStatement.concat("\n");

		return strStatement;
	}

	private String closeInterface(String strClassClose) {
		strClassClose = strClassClose.replace(";", ";\n");
		strClassClose = strClassClose.replace("}", "}\n");
		strClassClose = strClassClose.concat("\n");

		return strClassClose;
	}
}