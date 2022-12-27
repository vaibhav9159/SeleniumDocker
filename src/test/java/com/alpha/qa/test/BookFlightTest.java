package com.alpha.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
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

import com.alpha.qa.pages.FindFlightsPage;
import com.alpha.qa.pages.FlightPage;
import com.alpha.qa.pages.FlightsConfirmationPage;
import com.alpha.qa.pages.RegistrationConfirmationPage;
import com.alpha.qa.pages.RegistrationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookFlightTest {

	private WebDriver driver;
	private String expectedPrice;
	private String passengers;
	
	@BeforeTest
	@Parameters({"expectedPrice","passengers"})
	public void initializeDriver(String expectedPrice, String passengers)
	{	
		this.expectedPrice=expectedPrice;
		this.passengers=passengers;
		WebDriverManager.chromedriver().setup();
		this.driver= new ChromeDriver();
	}
	
	@Test(priority=1)
	public void registrationPageTest()
	{
		RegistrationPage rp = new RegistrationPage(driver);
		rp.launchURL();
		rp.enterUserNameDetails("Shiva", "Shakti");
		rp.enterUserCredentials("Shiva", "Shakti");		
		rp.clickOnSubmit();
	}
	
	@Test(priority=2)
	public void registrationConfirmationPageTest()
	{
		RegistrationConfirmationPage rp = new RegistrationConfirmationPage(driver);
		rp.goToFlightPage();
	}
	
	@Test(priority=3)
	public void FlightPageTest()
	{
		FlightPage fp = new FlightPage(driver);
		fp.addPassengersCount(passengers);
		fp.goToFlightCOnfirmationPage();
	}
	
	@Test(priority=4)
	public void FindFlightPageTest()
	{
		FindFlightsPage fp = new FindFlightsPage(driver);
		fp.clickOnContinueButton();
		fp.clickOnBookFlightButton();
	}
	
	
	@Test(priority=5)
	public void FlightConfirmationPageTest()
	{
		FlightsConfirmationPage fp = new FlightsConfirmationPage(driver);
		String actualPrice = fp.verifyPrice();
		AssertJUnit.assertEquals(actualPrice, expectedPrice);
		
	}
	

	@AfterTest
	public void tearDown()
	{
		this.driver.quit();
		
	}
}
