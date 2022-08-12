package com.mystore.pageobject;

import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.stat.ranking.TiesStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	private WebElement unitPrice;
	
	@FindBy(id="total_price")
	private WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	public OrderPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice()
	{
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}

	public double getTotalPrice()
	{
		String totalPrice1=unitPrice.getText();
		String total=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finaltotalPrice=Double.parseDouble(total);
		return finaltotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut()
	{
		
		proceedToCheckOut.click();
		return new LoginPage();
	}
	
	
}
