package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass {
	
	

	@FindBy(xpath = "//h1[text()='Create an account']")
	private WebElement formTitle;

	public AccountCreationPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean validateAcccreatePage()
	{
		return formTitle.isDisplayed();
	}
}
