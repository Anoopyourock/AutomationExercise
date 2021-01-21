package com.automationpractice.webpages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.generics.WebDriverCommonActions;


public class IdentityPage
{
	private WebDriver driver;
	@FindBy(id="firstname")
	private WebElement firstname;
	
	@FindBy(id="lastname")
	private WebElement lastname;
	
	@FindBy(id="old_passwd")
	private WebElement oldpassword;
	
	@FindBy(id="passwd")
	private WebElement newpassword;
	
	@FindBy(id="confirmation")
	private WebElement confirmation;
	
	@FindBy(xpath="//span[text()='Save']")
	private WebElement save;
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	private WebElement successmessage;
	
	public IdentityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver =driver;
	}
	//To enter the first name in first name field on identity page
	public void enterfirstname(String name)
	{	WebDriverCommonActions.scrolltoelement(driver, firstname);
		firstname.clear();	
		firstname.sendKeys(name);
	}
	//To enter the last name in last name  field on  identity page 
	public void enterlastname(String name)
	{	lastname.clear();
		lastname.sendKeys(name);
	}
	//To enter the old password in password field on  identity page 
	public void enteroldpassword(String oldpass)
	{
		oldpassword.sendKeys(oldpass);
	}
	//To enter the new password in password field on identity page 
	public void enternewpassowrd(String newpass)
	{
		newpassword.sendKeys(newpass);
	}
	//To re-enter the password in confirm password field on identity page 
	public void confirmationpassword(String confirm)
	{
		confirmation.sendKeys(confirm);
	}
	//To click on save button on identity page
	public void clickonsave()
	{
		save.click();
	}
	//To take the text of success message 
	public String successmessage()
	{
		String successtext=successmessage.getText();
		return successtext;
	}
	
	//This method is used to perform below steps:
	//enter first name
	//enter last name
	//enter old password
	//enter new password
	//re-enter the password in confirm password
	//click on save button
	public void identitypageactions(String firstname,String lastname, String oldpassword, String newpassword, String confirmpassword)
	{
		IdentityPage identity =new IdentityPage(driver);
		identity.enterfirstname(firstname);
		identity.enterlastname(lastname);
		identity.enteroldpassword(oldpassword);
		identity.enternewpassowrd(newpassword);
		identity.confirmationpassword(confirmpassword);
		identity.clickonsave();

	}
	
}
