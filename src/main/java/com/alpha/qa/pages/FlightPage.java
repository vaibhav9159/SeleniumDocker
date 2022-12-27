package com.alpha.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(css="select[id='passCount']")
	private WebElement passengersCount;
	
	@FindBy(css="a[id='flight-link']")
	private WebElement flightLink;
	
	@FindBy(css="input[id='findFlights']")
	private WebElement continueButton;
	
	public FlightPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		PageFactory.initElements(driver, this);
		
	}
	
	public void addPassengersCount(String passenegers)
	{	
		this.wait.until(ExpectedConditions.visibilityOf(passengersCount));
		Select s = new Select(passengersCount);
		s.selectByValue(passenegers);	
	}

	public void goToFlightCOnfirmationPage()
	{	
		this.continueButton.click();
		
	}
	
	
}
