package com.alpha.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.alpha.qa.base.BaseTest;
import com.alpha.qa.pages.FindFlightsPage;
import com.alpha.qa.pages.FlightPage;
import com.alpha.qa.pages.FlightsConfirmationPage;
import com.alpha.qa.pages.RegistrationConfirmationPage;
import com.alpha.qa.pages.RegistrationPage;
import com.alpha.qa.pages.SearchFunctionality;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFuncTest extends BaseTest{

//	private WebDriver driver;
	
	@Test(priority=1)
	@Parameters({"keyword"})
	public void search(String keyword)
	{
		SearchFunctionality sf = new SearchFunctionality(driver);
		sf.launchSearchURL();
		sf.enterSearchText(keyword);
		sf.goToVideos();
		int size = sf.printResult();
		System.out.println(size + " is the total count of videos");
		
		Assert.assertTrue(size>0);
	}
	

	
}
