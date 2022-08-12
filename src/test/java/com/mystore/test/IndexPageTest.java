package com.mystore.test;

import org.apache.poi.ss.formula.functions.Index;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.IndexPage;
import com.mystore.utility.Log;

public class IndexPageTest extends BaseClass
{
	public IndexPage ip;
	
	@BeforeMethod(groups = {"Regression","sanity"})
	public void setup()
	{
		launchApp();
		ip=new IndexPage();
	}
	
	@AfterMethod(groups = {"Regression","sanity"})
	public void tearDown()
	{
		CloseBrowser();
	}
	
	@Test(groups = "sanity")
	public void verifyLogo()
	{
		Log.startTestCase("Index Test1 Start");
		Reporter.log("start test case");
		boolean result = ip.validateLogo();
		Assert.assertTrue(result);
		Log.info("Validate Logo");
		Reporter.log("end test case");
		Log.startTestCase("Index Test1 End");

	}
	
	@Test (enabled = false,groups = "sanity")
	public void verifyTitle()
	{
		Log.startTestCase("Index Test2 Start");
		Reporter.log("start test case");
		String myStroreTitle = ip.validateTitle();
		Log.info("Vefiy Title");
		Assert.assertEquals(myStroreTitle,"My Store");
		Log.startTestCase("Index Test2 End");

	}
	
	
}
