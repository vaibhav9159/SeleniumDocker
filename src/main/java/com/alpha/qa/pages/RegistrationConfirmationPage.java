package com.alpha.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//*[text()=' sign-in ']")
	private WebElement signInLink;
	
	@FindBy(css="a[id='flight-link']")
	private WebElement flightLink;
	
	public RegistrationConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		PageFactory.initElements(driver, this);
		
	}
	
	public void goToFlightPage()
	{
		this.wait.until(ExpectedConditions.visibilityOf(this.signInLink));
		this.flightLink.click();
	}

	
}
