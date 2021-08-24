package com.automotion.locators.constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CountryClass{
 By getCountryClassLocatorValue(final String locator) {
 switch(locator) {

case "USA" : return By.xpath("//*[contains(text(),'USA')]");
case "Costa Rica" : return By.xpath("//*[contains(text(),'Costa Rica')]");
case "Afghanistan" : return By.xpath("//*[contains(text(),'Afghanistan')]");
case "Belgium" : return By.xpath("//*[contains(text(),'Belgium')]");
default : return null;
    }
   }
 }

