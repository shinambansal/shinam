package org.demo.selenium.test;

import org.demo.selenium.pages.MercuryFindFlightPage;
import org.demo.selenium.pages.MercuryLoginPage;
import testUtils.BaseClass;
import testUtils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Testcase for MercuryTest
 */
public class MercuryTest extends BaseClass
{
	WebDriver driver;
	String strLoginID, strPassword;
	//Sachin
   @Test(enabled=false)
   public void ValidLoginToMercury() throws InterruptedException
   {
	   driver = DriverManager.getDriver();	
	   strLoginID ="mercury"; strPassword ="mercury";
	   MercuryLoginPage loginPage = new MercuryLoginPage(driver);
	   MercuryFindFlightPage mercuryFindFlightPage = new MercuryFindFlightPage(driver);
	   mercuryFindFlightPage = loginPage.performMercuryLogin(strLoginID, strPassword);
	   mercuryFindFlightPage.validateMercuryFindFlightPage();
   }
 
   @Test
   public void InvalidLoginToMercury() throws InterruptedException
   {
	   driver = DriverManager.getDriver();	
	   strLoginID ="mercury"; strPassword ="mercury1";
	   MercuryLoginPage loginPage = new MercuryLoginPage(driver);
	   MercuryFindFlightPage mercuryFindFlightPage = new MercuryFindFlightPage(driver);
	   mercuryFindFlightPage = loginPage.performMercuryLogin(strLoginID, strPassword);
	   mercuryFindFlightPage.validateMercuryFindFlightPage();
   }
   
}