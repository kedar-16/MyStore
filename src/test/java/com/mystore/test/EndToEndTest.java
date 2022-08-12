package com.mystore.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.AdressPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.OrderConfirmPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.OrderSummaryPage;
import com.mystore.pageobject.PaymentPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.ShippingPage;
import com.mystore.utility.Log;

public class EndToEndTest extends BaseClass {
	IndexPage ip;
	LoginPage lp;;
	SearchResultPage srp;
	AddToCartPage atcp;
	OrderPage op;
	AdressPage ap;
	ShippingPage sp;
	PaymentPage pp;
	OrderSummaryPage osp;
	OrderConfirmPage ocp;
	
	@BeforeMethod (groups = {"Regression","smoke"})
	public void setUp()
	{
		launchApp();
	}

	@AfterMethod (groups = {"Regression","smoke"})
	public void tearDown()
	{
		driver.close();
	}
	
	@Test (groups = "Regression")
	public void endToEndTest() throws InterruptedException
	{
		Log.startTestCase("End To End Test");
		ap=new AdressPage();
		ip=new IndexPage();
		pp=new PaymentPage();
		osp=new OrderSummaryPage();
		ocp=new OrderConfirmPage();
		Log.info(null);
		Log.info("User going search product");
		srp=ip.searchProduct("t-shirt");
		
		atcp=srp.clickOnProduct();
		Log.info("User click On Product");
		
		atcp.enterQuantity("2");
		Log.info("User Provid quantity");
		

		atcp.selectSize("L");
		Log.info("User Provid Size");
		

		op= new OrderPage();
		Log.info("User Going On Order Page ");
	
		atcp.clickOnaddToCartPage();
		Thread.sleep(5000);
		Log.info("User Click On Add To Cart Page Button");

		

		op=atcp.clickOnCheckOut();
		Thread.sleep(3000);
		Log.info("User Going On Order Page ");
		
		lp=op.clickOnCheckOut();
		Thread.sleep(3000);
		Log.info("User Click On Check Out Button");

		Log.info("User Provid Login Details");
		lp.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(3000);
		Log.info("Login Succesfull");
		
		sp=ap.clickOnCheckOut();
		Log.info("User Going On Shipping Page");
		Thread.sleep(3000);
		
		sp.checkTheTerms();
		Log.info("Click On Term And Condition Box");
		
		sp.clickOnProceedToCheckOut();
		Log.info("Click On Proceed To Cj=hekc Out Button");
		
		osp=pp.clickOnPaymentMethod();
		Log.info("Click On Click on Payment");

		ocp=osp.clickOnconfirmOrderBtn();
		Log.info("User Click on Confirm Ordr Button & On Order confirmation PAge");
		
		String actualmsg = ocp.validateConfirmMessage();
		String expectedmsg="Your order on My Store is complete.";
		Assert.assertEquals(actualmsg, expectedmsg);
		
		Log.endTestCase("Test Case Pass");
	}

}
