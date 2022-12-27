package com.alpha.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightsPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	
	@FindBy(css="input[id='reserveFlights']")
	private WebElement continueButton;
	
	@FindBy(css="input[id='buyFlights']")
	private WebElement bookFlightButton;
	
	
	public FindFlightsPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnContinueButton()
	{	
		this.wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		this.continueButton.click();
	}

	public void clickOnBookFlightButton()
	{	
		this.wait.until(ExpectedConditions.elementToBeClickable(bookFlightButton));
		this.bookFlightButton.click();
		
	}
	
	
}