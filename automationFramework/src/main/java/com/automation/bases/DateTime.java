package com.automation.bases;

/**
 * @author ST57752 Shivangi Tripathi (Quality Analyst)
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DateTime {

WebDriver driver;
	
	public static File f1;
	public static FileInputStream file;
	public static Properties properties;
	
			public static String currentDate(WebDriver driver,String Format) {
				Format formatter = new SimpleDateFormat(Format);
				String today = formatter.format(new Date());
				return today;
				}
		
			private static Date yesterday() {
		    	final Calendar cal = Calendar.getInstance();
		    	cal.add(Calendar.DATE, -1);
		    	return cal.getTime();
				}
		
		public static String yesterdayDate(WebDriver driver,String Format) {
		        DateFormat dateFormat = new SimpleDateFormat(Format);
		        return dateFormat.format(yesterday());
		        
		       }
		
		private static Date tommorow() {
		    	final Calendar cal = Calendar.getInstance();
		    	cal.add(Calendar.DATE, +1);
		    	return cal.getTime();
				}
		
		public static String tommorowDate(WebDriver driver,String Format) {
		        DateFormat dateFormat = new SimpleDateFormat(Format);
		       return dateFormat.format(tommorow());
		        }
		
		public static String tommorowNewDate(WebDriver driver,String Format,int i) {
			DateFormat dateFormat = new SimpleDateFormat(Format);
			final Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, +i);
			return dateFormat.format(cal.getTime());
		    }
		
		public static String currentYear(WebDriver driver) {
				Calendar now = Calendar.getInstance();
				return String.valueOf(now.get(java.util.Calendar.YEAR));
				}
		
		public static String previousYear(WebDriver driver) {
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int lastYear = year - 1;
			return Integer.toString(lastYear);
			}
		
		public static String nextYear(WebDriver driver) {
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int lastYear = year + 1;
			return Integer.toString(lastYear);
			}
		
		public static String previousMonth(WebDriver driver){
			Calendar cal =  Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			return new SimpleDateFormat("MMMMM").format(cal.getTime());
			}		
		
		public static String currentWeek(WebDriver driver) {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			DateFormat df = new SimpleDateFormat("EEEEEEE dd/MMMMMM/yyyy");
		      for (int i = 0; i <4; i++) {
		        c.add(Calendar.DATE, 1);
		          }
		       String lastday = df.format(c.getTime()).substring(7, 9) +" "+ df.format(c.getTime()).substring(10, 12);
			   return lastday;
			}		
			
		public static String currentDay(WebDriver driver) {
			
			Calendar calendar = Calendar.getInstance();
			Date date = calendar.getTime();
			String str =  new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
			return str;
			
			}
		public static String nextWeek(WebDriver driver) {
		LocalDate today = LocalDate.now();

	    // Go backward to get Monday
	    LocalDate monday = today;
	    while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
	      monday = monday.minusDays(2);
	    }

	    // Go forward to get Sunday
	    LocalDate sunday = today;
	    while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
	      sunday = sunday.plusDays(8);
	    }
	    
	    return monday.toString().substring(8,10) +" " + currentDate(driver, "MMMM") + " " +currentYear(driver)+ " " + "to" + " "+ sunday.toString().substring(8,10) + " " + currentDate(driver, "MMMM") + " " +currentYear(driver);
	  }
		
		public static String nextMonth(WebDriver driver){
			Calendar cal =  Calendar.getInstance();
			cal.add(Calendar.MONTH, +1);
			return new SimpleDateFormat("MMMMM").format(cal.getTime());
			}
		}
