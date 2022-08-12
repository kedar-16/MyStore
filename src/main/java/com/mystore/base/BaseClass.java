package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite (groups = {"Regression","sanity"})
	public void readConfig()
	{
		com.mystore.utility.ExtentReport.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try 
		{
			prop=new Properties();
		FileInputStream file=new FileInputStream("D:\\kp\\Automation\\MyStore\\config\\config.properties");
			prop.load(file);

		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e);
		}
	}
	
	//@Parameters("browser")
	public static void launchApp()
	{
		WebDriverManager.chromedriver().setup();
		String browserName=prop.getProperty("browser");
		
		if (browserName.contains("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (browserName.contains("FireFox"))
		{
			driver=new ChromeDriver();
		}
		else if (browserName.contains("IE"))
		{
			driver=new ChromeDriver();
		}
		 ChromeOptions chrome_Profile = new ChromeOptions();
		 chrome_Profile.addArguments("chrome.switches","--disable-extensions"); 
//		 System.setProperty("webdriver.chrome.driver","D:\\kp\\Automation\\MyStore\\chromedriver.exe");
//		 driver = new ChromeDriver(chrome_Profile);
		 driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);;
		 driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get(prop.getProperty("url"));
//		 driver.get("http://automationpractice.com/index.php?");
		 driver.manage().window().maximize();;
	}
	
	public void CloseBrowser()
	{
		driver.close();
	}
	@AfterSuite(groups = {"sanity","Regression"})
	public void AfterSuite()
	{
		com.mystore.utility.ExtentReport.endReport();
	}
	
}
