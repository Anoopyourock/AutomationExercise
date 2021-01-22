package com.automationpractice.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.generics.WebDriverCommonActions;

public class IdentityPage {
	private WebDriver driver;
	@FindBy(id = "firstname")
	private WebElement firstName;

	@FindBy(id = "lastname")
	private WebElement lastName;

	@FindBy(id = "old_passwd")
	private WebElement oldPassword;

	@FindBy(id = "passwd")
	private WebElement newPassword;

	@FindBy(id = "confirmation")
	private WebElement confirmation;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement save;

	@FindBy(xpath = "//p[@class='alert alert-success']")
	private WebElement successMessage;

	public IdentityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// To enter the first name in first name field on identity page
	public void enterFirstName(String name) {
		WebDriverCommonActions.scrollToElement(driver, firstName);
		firstName.clear();
		firstName.sendKeys(name);
	}

	// To enter the last name in last name field on identity page
	public void enterLastName(String name) {
		lastName.clear();
		lastName.sendKeys(name);
	}

	// To enter the old password in password field on identity page
	public void enterOldPassword(String oldpass) {
		oldPassword.sendKeys(oldpass);
	}

	// To enter the new password in password field on identity page
	public void enterNewPassowrd(String newpass) {
		newPassword.sendKeys(newpass);
	}

	// To re-enter the password in confirm password field on identity page
	public void confirmationPassword(String confirm) {
		confirmation.sendKeys(confirm);
	}

	// To click on save button on identity page
	public void clickOnSave() {
		save.click();
	}

	// To take the text of success message
	public String successMessage() {
		String successText = successMessage.getText();
		return successText;
	}

	// This method is used to perform below steps:
	// enter first name
	// enter last name
	// enter old password
	// enter new password
	// re-enter the password in confirm password
	// click on save button
	public void identityPageActions(String firstname, String lastname, String oldpassword, String newpassword,
			String confirmpassword) {

		enterFirstName(firstname);
		enterLastName(lastname);
		enterOldPassword(oldpassword);
		enterNewPassowrd(newpassword);
		confirmationPassword(confirmpassword);
		clickOnSave();

	}

}
