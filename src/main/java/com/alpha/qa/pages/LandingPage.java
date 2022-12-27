package com.alpha.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alpha.qa.base.BaseTest;

public class LandingPage extends BaseTest{

	
	private WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	} 
	
	@FindBy(css="#header_14")
	private WebElement landingPageTitle;
	
	public String verifyPageTitle()
	{
		return landingPageTitle.getText();
	}
	
	/*
	
	private By landingPageTitle = By.cssSelector("#header_14");
	
	public String verifyPageTitle()
	{
		return driver.findElement(landingPageTitle).getText();
	}
*/
	
}
