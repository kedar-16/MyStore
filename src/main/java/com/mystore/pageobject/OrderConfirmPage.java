package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmPage extends BaseClass {


	@FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
	private WebElement confirmMessag;

	public OrderConfirmPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String  validateConfirmMessage()
	{
		String confmsg = confirmMessag.getText();
		return confmsg;
	}
	
}
