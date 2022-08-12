package com.mystore.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.SearchResultPage;

public class SearchResultPageTest extends BaseClass{
	IndexPage ip;
	LoginPage lp;
	SearchResultPage srp;
	AddToCartPage acp;
	
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
	public void ProductAvailableTest()
	{
		srp= new SearchResultPage();
		ip=new IndexPage();
		srp=ip.searchProduct("t-shirt");
		boolean result = srp.isProductAvailable();
		Assert.assertTrue(result);
	}
	
	
}
