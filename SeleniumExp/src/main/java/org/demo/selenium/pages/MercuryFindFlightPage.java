package org.demo.selenium.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MercuryFindFlightPage {
	WebDriver driver;
	
	
	By rdb_FlightType = (By.cssSelector("input[name='tripType']"));
	By rdb_FlightTypeOneway = (By.cssSelector("input[name='tripType'][value='oneway']"));
	By rdb_FlightTypeRndTrip = (By.cssSelector("input[name='tripType'][value='roundtrip']"));
	By cmb_Passengers = (By.cssSelector("select[name='passCount']"));
	By cmb_DepartFrom = (By.cssSelector("select[ name='fromPort']"));
	By cmb_DepartTo= (By.cssSelector("select[ name='toPort']"));
	By rdb_ServiceClass = (By.cssSelector("input[name='servClass']"));
	By btn_Continue = (By.cssSelector("input[name='findFlights']"));
	
	
	public MercuryFindFlightPage(WebDriver driver){
		this.driver = driver;
		if(driver.getTitle().contains("Find a Flight: Mercury Tours"))
		{
			System.out.println("Constructor : Landed to Expected Page: " + driver.getTitle());
				
		}
		else
		{
			System.out.println("Constructor : Landed to Incorrect Page: " + driver.getTitle());
			this.driver = null;
		}
	}
	
	public void validateMercuryFindFlightPage(){
		
		if(driver.getTitle().contains("Find a Flight: Mercury Tours"))
		{
			System.out.println("Landed to Expected Page: " + driver.getTitle());
				
		}
		else
		{
			System.out.println("Landed to Incorrect Page: " + driver.getTitle());		
		}
		driver.navigate().refresh();
		
	}

	public MercuryFindFlightPage selectFlightType(String strFlightType){			
		
		List<WebElement> radbtnlist= driver.findElements(rdb_FlightType);
		for (int i =0; i < radbtnlist.size() ; i++ ) {
				
			String dpValue= radbtnlist.get(i).getAttribute("value");
			System.out.println(dpValue);
			if(dpValue.equalsIgnoreCase(strFlightType))
			{
				radbtnlist.get(i).click();		
				break;
			}
		}

		return this;
	
	}
	
	 
	public String getDepartFrom(){
			
			Select oSelect = new Select(driver.findElement(cmb_DepartFrom));
			System.out.println(oSelect.getFirstSelectedOption().getText());
			return oSelect.getFirstSelectedOption().getText();
		}
	
	public void validateDepartFrom(String strDepartFrom){
		
		int flag= 0;
		
		Select oSelect = new Select(driver.findElement(cmb_DepartFrom));
		
		List<WebElement> options = oSelect.getOptions();
		for (WebElement option : options) {
			System.out.println("depart from values... " + option.getText());
			if(option.getText().trim().equalsIgnoreCase(strDepartFrom.trim()))
			{
				flag = 1;
			}
		}		
		if(flag == 0){
			System.out.println(strDepartFrom + " is not found for Depart from");
		}
		else{
			System.out.println(strDepartFrom + " is found for Depart from");
		}
		
	}
	public MercuryFindFlightPage selectPassengers(String strPassengers){
		Select oSelect = new Select(driver.findElement(cmb_Passengers));
		oSelect.selectByVisibleText(strPassengers);
		return this;
	}
	
	public MercuryFindFlightPage selectDepartFrom(String strDepartFrom){
		Select oSelect = new Select(driver.findElement(cmb_DepartFrom));
		oSelect.selectByVisibleText(strDepartFrom);
		return this;
	}
	
	public MercuryFindFlightPage selectDepartTo(String strDepartTo){
		Select oSelect = new Select(driver.findElement(cmb_DepartTo));
		oSelect.selectByVisibleText(strDepartTo);
		return this;
	}
	
	public MercuryFindFlightPage selectServiceClass(String strServiceClass){
		List<WebElement> radbtnlist= driver.findElements(rdb_ServiceClass);
		for (int i =0; i < radbtnlist.size() ; i++ ) {
				
			String dpValue= radbtnlist.get(i).getAttribute("value");
			System.out.println(dpValue);
			if(dpValue.equalsIgnoreCase(strServiceClass))
			{
				radbtnlist.get(i).click();		
				break;
			}
		}

		return this;
	}
//	public MercurySelectFlightPage clickContinue(){
//		driver.findElement(btn_Continue).click();
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return new MercurySelectFlightPage(driver);
//	}
	
	
}