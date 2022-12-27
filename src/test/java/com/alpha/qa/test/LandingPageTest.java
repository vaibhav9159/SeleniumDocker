package com.alpha.qa.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.alpha.qa.base.BaseTest;
import com.alpha.qa.pages.LandingPage;

public class LandingPageTest extends BaseTest{

	LandingPage lp = new LandingPage(BaseTest.getDriver());
	BaseTest b = new BaseTest();
	
	public LandingPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void launchBrowserUrl()
	{
		b.launchBrowser();
	 //   BaseTest.getDriver().get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");	
	}
	
	
	@Test(priority=1)
	public void verifyLandingPage()
	{
		String text = lp.verifyPageTitle();	
		System.out.println(text + " is the title");
		AssertJUnit.assertEquals(text," Docker Flight Booking Application ");
	}
	
	@Test(priority=2)
	public void verifyLandingPageSSS()
	{
		System.out.print("siya ram");
	}
	
	
	
}
