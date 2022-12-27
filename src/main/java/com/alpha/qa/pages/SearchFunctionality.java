package com.alpha.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFunctionality {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(css="#search_form_input_homepage")
	private WebElement searchBar;
	
	@FindBy(css="#search_button_homepage")
	private WebElement searchBarButton;
	
	@FindBy(xpath="(//*[text()='Videos'])[1]")
	private WebElement videosSearchLink;
	
	@FindBy(css=".tile--vid")
	private List <WebElement> videosCount;
	
	public SearchFunctionality(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(7));
		PageFactory.initElements(driver, this);
	}
	
	public void launchSearchURL()
	{
		this.driver.get("https://duckduckgo.com/");
	}
	
	public void enterSearchText(String text)
	{
		this.wait.until(ExpectedConditions.visibilityOf(searchBar));
		this.searchBar.sendKeys(text);
		this.searchBarButton.click();
		
	}
	
	public void goToVideos()
	{
		this.wait.until(ExpectedConditions.visibilityOf(videosSearchLink));
		this.videosSearchLink.click();
	}
	
	public int printResult()
	{	
		By by = By.cssSelector(".tile--vid");
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
		int size = this.videosCount.size();
		System.out.println(this.videosCount.size());
		
	return size;
	}
	
}
