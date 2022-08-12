package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass
{
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname,String pass)
	{
		userName.sendKeys(uname);
		password.sendKeys(pass);
		signInBtn.click();
		return new HomePage();
	}
	
	public AccountCreationPage createNewAcc(String newmail)
	{
		emailForNewAccount.sendKeys(newmail);
		createNewAccountBtn.click();
		return new AccountCreationPage();
	}
	
	
	
}
