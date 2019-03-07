package org.demo.selenium.pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class MercuryLoginPage {
	WebDriver driver;
	
	By txtBox_loginID = (By.cssSelector("input[name='userName']"));
	By txtBox_password = (By.cssSelector("input[name='password']"));
	By btn_signin = (By.cssSelector("input[name='login']"));
	By lbl_Date = (By.cssSelector("form[name='home']>table>tbody>tr>td>font>b"));
	
	public MercuryLoginPage(WebDriver driver){
		this.driver = driver;
	}
		
	public MercuryLoginPage setLoginValue(String strLoginID){
		driver.findElement(txtBox_loginID).sendKeys(strLoginID);
		return this;
	}
	
	public MercuryLoginPage setPasswdValue(String strPassword){
		driver.findElement(txtBox_password).sendKeys(strPassword);
		return this;
	}
	
	public MercuryLoginPage clicklogin(){
		driver.findElement(btn_signin).click();		
		return this;//new MercuryFindFlightPage(driver);		
	}
	
	public String MercuryGetDate(){
		String strDateTxt = driver.findElement(lbl_Date).getText();
		return strDateTxt;		
	} 
	
	public MercuryFindFlightPage performMercuryLogin(String strLoginID, String strPassword) throws InterruptedException {

		setLoginValue(strLoginID);
		setPasswdValue(strPassword);
		clicklogin();
		Thread.sleep(10000);
		//check for landing of page after entering credentials
//		try{
//			driver.findElement(btn_signin).isDisplayed();
//			System.out.println("Incorrect Login: user ID-" + strLoginID +"  password-" + strPassword );
//			return null;
//		}
//		catch(Exception NoSuchElementException)
//		{
			System.out.println("Correct Login");
			return new MercuryFindFlightPage(driver);

//		}
					
		
	}
	
}