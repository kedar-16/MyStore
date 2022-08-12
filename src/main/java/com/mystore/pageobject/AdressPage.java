package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.mystore.base.BaseClass;

public class AdressPage extends BaseClass{
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;

	public AdressPage() {
		PageFactory.initElements(driver,this);
	}

	public  ShippingPage clickOnCheckOut()
	{
		proceedToCheckOut.click();
		return new ShippingPage();
	}
}
