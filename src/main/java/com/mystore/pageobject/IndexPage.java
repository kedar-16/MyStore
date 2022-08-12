package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement btnsign;
	
	@FindBy(xpath = "//input[@class='search_query form-control ac_input']")
	WebElement serchbx;
	
	@FindBy(name ="submit_search")
	WebElement btnsearch;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo;
	
	public IndexPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public LoginPage clickonSignIn()
	{
		btnsign.click();
		return new LoginPage();
	}
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	public String validateTitle()
	{
		String myStroreTitle=driver.getTitle();
		return myStroreTitle;
	}
	public SearchResultPage searchProduct(String ProductName)
	{
		serchbx.sendKeys(ProductName);
		btnsearch.click();
		return new SearchResultPage();
	}
}
