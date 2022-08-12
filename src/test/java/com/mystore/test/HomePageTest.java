package com.mystore.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

public class HomePageTest extends BaseClass{
	
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	
	@BeforeMethod
	public void setUp()
	{
		launchApp();
	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	@Test
	public void wishListTest()
	{
		ip=new IndexPage();
		lp=new LoginPage();
		lp=ip.clickonSignIn();
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));	
		boolean result = hp.validateMyVishList();
		Assert.assertTrue(result);
	}
	@Test
	public void validateOrderHistoryTest()
	{
		ip=new IndexPage();
		lp=new LoginPage();
		lp=ip.clickonSignIn();
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));	
		boolean result = hp.validateOrderHistory();
		Assert.assertTrue(result);
	}
	
	
}
