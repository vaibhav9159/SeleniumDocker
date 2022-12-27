package com.alpha.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//*[@name='firstName']")
	private WebElement firstName;
	
	@FindBy(xpath="//*[@name='lastName']")
	private WebElement lastName;
	
	@FindBy(css="#email")
	private WebElement userName;
	
	@FindBy(css="input[name='password']")
	private WebElement password;
	
	@FindBy(css="input[name='confirmPassword']")
	private WebElement confirmPassword;
	
	@FindBy(css="input[name='register']")
	private WebElement submitButton;
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		PageFactory.initElements(driver, this);
		
	}
	
	public void launchURL()
	{
		this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
		this.wait.until(ExpectedConditions.visibilityOf(this.firstName));
	}
	
	public void enterUserNameDetails(String firstname, String lastname)
	{
		this.firstName.sendKeys(firstname);
		this.lastName.sendKeys(lastname);
	}
	
	
	public void enterUserCredentials(String usrname, String psswrd)
	{
		this.userName.sendKeys(usrname);
		this.password.sendKeys(psswrd);
		this.confirmPassword.sendKeys(psswrd);
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	
}
