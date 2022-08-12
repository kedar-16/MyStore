package com.mystore.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AccountCreationPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

public class LoginPageTest extends BaseClass 
{	
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	AccountCreationPage ap;
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
	public void LoginPageTest()
	{
		ip=new IndexPage();
		lp=new LoginPage();
		hp=new HomePage();
		lp=ip.clickonSignIn();
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));	
		String actualurl = hp.getCurrUrl();
		String expected="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualurl,expected);
	}	
}


