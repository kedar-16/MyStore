package com.mystore.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	@FindBy(id="quantity_wanted")
	private WebElement quantity;
	
	@FindBy(name="group_1")
	private WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	private WebElement addToCartMessag;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;

	
	public AddToCartPage() {
	
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String size)
	{
		quantity.sendKeys(size);
	}
	
	public void selectSize(String size1)
	{
		Select s=new Select(size);
		s.selectByVisibleText(size1);
	}
	public void clickOnaddToCartPage()
	{
		addToCartBtn.click();
	}
	
	public boolean validateAddToCart()
	{
		return addToCartMessag.isDisplayed();
	}
		
	public OrderPage clickOnCheckOut()
	{
		JavascriptExecutor  ele =(JavascriptExecutor) driver;
		ele.executeScript("arguments[0].click();",proceedToCheckOutBtn);
		return new OrderPage();
	}
	
}
