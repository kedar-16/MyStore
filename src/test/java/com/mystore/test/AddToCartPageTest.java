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

public class AddToCartPageTest extends BaseClass {
	LoginPage lp;
	IndexPage ip;
	SearchResultPage srp;
	AddToCartPage atcp;
	
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
	public void addToCartTest() throws InterruptedException 
	{
		ip=new IndexPage();
		srp=ip.searchProduct("t-shirt");
		atcp=srp.clickOnProduct();
		atcp.enterQuantity("2");
		atcp.selectSize("L");
		atcp.clickOnaddToCartPage();
		Thread.sleep(5000);
		boolean result=atcp.validateAddToCart();
		Assert.assertTrue(result);
	}

	

}
