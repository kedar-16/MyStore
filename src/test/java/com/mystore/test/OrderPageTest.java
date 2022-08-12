package com.mystore.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.SearchResultPage;

public class OrderPageTest extends BaseClass {
	
	LoginPage lp;
	IndexPage ip;
	SearchResultPage srp;
	AddToCartPage atcp;
	OrderPage op;
	
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

	public void verifyTotalPrice() throws InterruptedException
	{
		ip=new IndexPage();
		srp=ip.searchProduct("t-shirt");
		atcp=srp.clickOnProduct();
		atcp.enterQuantity("2");
		atcp.selectSize("L");
		op= new OrderPage();
		atcp.clickOnaddToCartPage();
		Thread.sleep(5000);
		op=atcp.clickOnCheckOut();
		Double unitprice= op.getUnitPrice();
		Double totalprice=op.getTotalPrice();
		Double totalExpectedprice=(unitprice*2)+2;
		Assert.assertEquals(totalprice, totalExpectedprice);
	}
}
