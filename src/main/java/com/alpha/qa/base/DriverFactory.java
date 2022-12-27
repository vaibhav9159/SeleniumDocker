package com.alpha.qa.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public Properties prop;
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tdriver =  new ThreadLocal<WebDriver>();
	
	
	public WebDriver launchBrowser(String browserName)
	{
		switch(browserName)
		{
		case "chrome" :
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			tdriver.set(driver);
			System.out.println("Browser is : " + browserName);
			break;
		}
		case "firefox":
		{
			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver());
			System.out.println("Browser is : " + browserName);
			break;
		}
		
		default:
		{
			System.out.println("Please select valid browser");
		}
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		}
		return getDriver();
	}
	
	
	public static synchronized WebDriver getDriver()
	{
		return tdriver.get();
	}
	
	
	
	
}
