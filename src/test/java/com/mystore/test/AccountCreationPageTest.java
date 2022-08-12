package com.mystore.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AccountCreationPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

public class AccountCreationPageTest extends BaseClass {

	IndexPage ip;
	HomePage hp;
	LoginPage lp;
	AccountCreationPage acp;
	@BeforeMethod
	public void setup()
	{
		launchApp();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
	@Test
	public void ValidateAccCreationPageTest()
	{
		ip=new IndexPage();
		lp=new LoginPage();
		lp=ip.clickonSignIn();
		acp=lp.createNewAcc(prop.getProperty("gmail"));
		boolean title = acp.validateAcccreatePage();
		assertTrue(title);
	}
}
