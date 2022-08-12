package com.mystore.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenShot  {
	
	public static void TakeScreshot(WebDriver driver,String FileName)
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ss=(TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File destination=new File(".\\Screenshot\\ "+FileName+".jpeg");
		
		try 
		{
			org.openqa.selenium.io.FileHandler.copy(source, destination);
		} catch (IOException e) 
		{
			e.getMessage();
		}
//		//this is for jenkins
//		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + FileName + "_"
//				+ dateName + ".png";
//		return newImageString;
	
		
		
	}
}
