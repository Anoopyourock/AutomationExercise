package com.automationpractice.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.generics.PropertyFileHandle;
import com.automationpractice.generics.WebDriverCommonActions;


public class MyAccount 
{
	private WebDriver driver;
	@FindBy(xpath="//a[@title='View my customer account']")
	private WebElement viewmyaccount;

	@FindBy(xpath="//span[text()='Order history and details']")
	private WebElement orderhistory;
	
	@FindBy(xpath="//tr[@class='first_item ']/td[1]")
	private WebElement orderrefrence;
	
	@FindBy(linkText="Sign in")	
	private WebElement signinhomepage;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailid;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="(//button[@type='submit']//span)[3]")
	private WebElement signin;
	
	@FindBy(xpath="//span[text()='My personal information']")
	private WebElement mypersonalinformation;
	
	public MyAccount(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	//To perform click on my account
	public void clickonmyaccount()
	{
		WebDriverCommonActions.mouseaction(driver, viewmyaccount);
		viewmyaccount.click();
	}
	//To perform click on sign-in button on home page
	public void clickonsiginlink()
	{
		signinhomepage.click();
	}
	//To perform click on Order history
	public void clickonorderhistory()
	{
		orderhistory.click();
	}
	//To get text of order text reference
	public String orderrefrencetext()
	{
		return orderrefrence.getText();
	}
	//To perform click on sign-in button on order page
	public void clickonsignin()
	{
		signin.click();
	}
	//To enter email id on order page
	public void enteremailid()
	{
		WebDriverCommonActions.scrolltoelement(driver, emailid);
		emailid.sendKeys(PropertyFileHandle.getpropertyvalue("Username"));
		
	}
	//To enter password on order page
	public void enterpassword()
	{
		password.sendKeys(PropertyFileHandle.getpropertyvalue("Password"));
	}
	
	//To click on my personal information on My Account page
	public void ClickOnMyPersonalInformation()
	{
		mypersonalinformation.click();
	}
	//To get title of account page
	public String accountpagetitle()
	{
		String accountpagetitle=driver.getTitle();
		return accountpagetitle;
	}
	//This method perform below steps:
	//Click on Sign in link on my store page
	//Enter email id into email field on login page
	//Enter password into password field on login page
	//click on sign-in button on login page
	public void signintoaccount()
	{
		MyAccount account =new MyAccount(driver);
		account.clickonsiginlink();
		account.enteremailid();
		account.enterpassword();
		account.clickonsignin();
	}
	
	//This method perform below steps:
	//Enter email id into email field on order page
	//Enter password into password field on order page
	//click on sign-in button on order page
	public void myaccountactioninorderpage()
	{
		
		MyAccount account=new MyAccount(driver);
		account.enteremailid();
		account.enterpassword();
		account.clickonsignin();
	}

}
