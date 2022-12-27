package com.alpha.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

	public Properties prop;
	protected WebDriver driver;
	public static String browser;
	
	public static ThreadLocal<WebDriver> tdriver =  new ThreadLocal<WebDriver>();
	
	
	
	@BeforeTest
	public void initializeDriver()
	{	
		WebDriverManager.chromedriver().setup();
		this.driver= new ChromeDriver();
	}
	
	
	@AfterTest
	public void tearDown()
	{
		this.driver.quit();
		
	}
	
	public BaseTest()
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("/Users/vsrivastava/eclipse-workspace/SeleniumDocker/src/main/java/com/qa/alpha/config/data.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/*	public WebDriver launchBrowser()
	{
		switch(browser)
		{
		case "chrome" :
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
		//	tdriver.set(driver);
		//	return getDriver();	
		}
		case "firefox":
		{
			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			driver.manage().window().maximize();
			return getDriver();
		}
	
		default:
		{
			System.out.println("Please select valid browser");
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		}
		return getDriver();
	}
	
	*/
	
	
	
	public void launchBrowser()
	{ 
		String browser = prop.getProperty("browser");
		switch(browser)
		{
		case "chrome" :
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			break;
		//	tdriver.set(driver);
		//	return getDriver();	
		
		case "firefox":
		
			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			driver.manage().window().maximize();
			break;
			
	
		default:
		{
			System.out.println("Please select valid browser");
		}
		
		}
	}
	
	
	
	
	public static synchronized WebDriver getDriver()
	{
		return tdriver.get();
	}
	
}
