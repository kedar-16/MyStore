package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMyVishList()
	{
		return myWishList.isDisplayed();
	}
	public boolean validateOrderHistory()
	{
		return orderHistory.isDisplayed();
	}
	public  String getCurrUrl()
	{
		String homePageUrl = driver.getCurrentUrl();
		return homePageUrl;
	}
	
}
