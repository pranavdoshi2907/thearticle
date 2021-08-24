//package com.automation.bases;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class WriteFile {
//	
//	public static void WriteFile(){
//		//Create File In D: Driver.  
//	
//	  String TestFile = "/src/main/java/com/automation/bases/writeValues.properties";
//	  File FC = new File(TestFile);//Created object of java File class.
//	  FC.createNewFile();//Create file
//	
//	//Writing In to file.
//	  //Create Object of java FileWriter and BufferedWriter class.
//	FileWriter FW = new FileWriter(TestFile);
//	  BufferedWriter BW = new BufferedWriter(FW);
//	  BW.write(StepDefinitions.reportName); //Writing In To File.
//	  BW.newLine();//To write next string on new line.
//	  BW.write("This Is Second Line."); //Writing In To File.
//	  BW.close();
//	}
//}
