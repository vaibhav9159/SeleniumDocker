package com.alpha.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsConfirmationPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	
	@FindBy(xpath="//font[contains(text(),'Confirmation')]")
	private WebElement confirmationText;
	
	@FindBy(xpath="//font[contains(text(),'USD')]")
	private List<WebElement> amountList;
	
	@FindBy(xpath="//a[contains(text(),'SIGN-OFF')]")
	private WebElement signOffLink;
	
	public FlightsConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPrice()
	{	
		this.wait.until(ExpectedConditions.visibilityOf(this.confirmationText));
		String text = this.confirmationText.getText();
		System.out.println(text);
		String price = this.amountList.get(1).getText();
		System.out.println(price);
		this.signOffLink.click();
		
		return price;
		
	}


	
	
}
