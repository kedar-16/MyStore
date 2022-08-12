package com.mystore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent()
	{
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("My Store Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "MyStrore Project");
		extent.setSystemInfo("Tester", "kp");
		extent.setSystemInfo("OS", "Win8.1");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	public static void endReport()
	{
		extent.flush();
	}

}


