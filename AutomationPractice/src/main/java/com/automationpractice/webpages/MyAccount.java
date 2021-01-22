package com.automationpractice.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.generics.PropertyFileHandle;
import com.automationpractice.generics.WebDriverCommonActions;

public class MyAccount {
	private WebDriver driver;
	@FindBy(xpath = "//a[@title='View my customer account']")
	private WebElement viewMyAccount;

	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;

	@FindBy(xpath = "//tr[@class='first_item ']/td[1]")
	private WebElement orderRefrence;

	@FindBy(linkText = "Sign in")
	private WebElement signinLinkOnHomePage;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailId;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(xpath = "(//button[@type='submit']//span)[3]")
	private WebElement signin;

	@FindBy(xpath = "//span[text()='My personal information']")
	private WebElement myPersonalInformation;

	public MyAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// To perform click on my account
	public void clickOnMyAccount() {
		WebDriverCommonActions.mouseAction(driver, viewMyAccount);
		viewMyAccount.click();
	}

	// To perform click on sign-in button on home page
	public void clickOnSiginLink() {
		signinLinkOnHomePage.click();
	}

	// To perform click on Order history
	public void clickOnOrderHistory() {
		orderHistory.click();
	}

	// To get text of order text reference
	public String orderRefrenceText() {
		return orderRefrence.getText();
	}

	// To perform click on sign-in button on order page
	public void clickOnSignin() {
		signin.click();
	}

	// To enter email id on order page
	public void enterEmailId() {
		WebDriverCommonActions.scrollToElement(driver, emailId);
		emailId.sendKeys(PropertyFileHandle.getpropertyvalue("Username"));

	}

	// To enter password on order page
	public void enterpassword() {
		password.sendKeys(PropertyFileHandle.getpropertyvalue("Password"));
	}

	// To click on my personal information on My Account page
	public void clickOnMyPersonalInformation() {
		myPersonalInformation.click();
	}

	// To get title of account page
	public String accountPageTitle() {
		String accountPageTitle = driver.getTitle();
		return accountPageTitle;
	}

	// This method perform below steps:
	// Click on Sign in link on my store page
	// Enter email id into email field on login page
	// Enter password into password field on login page
	// click on sign-in button on login page
	public void signinToAccount() {
		clickOnSiginLink();
		enterEmailId();
		enterpassword();
		clickOnSignin();
	}

	// This method perform below steps:
	// Enter email id into email field on order page
	// Enter password into password field on order page
	// click on sign-in button on order page
	public void myAccountActionInOrderPage() {

		enterEmailId();
		enterpassword();
		clickOnSignin();
	}

}
