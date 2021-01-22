package com.automationpractice.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.generics.WebDriverCommonActions;

public class HomePage {
	private WebDriver driver;
	@FindBy(xpath = "(//a[@title='T-shirts'])[2]")
	private WebElement tshirt;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// To Perform click on T-Shirt
	public void clickOnTshirt() {
		WebDriverCommonActions.mouseAction(driver, tshirt);
	}

	// To get the title of current page
	public String titleOfPage() {
		String Title = driver.getTitle();
		return Title;

	}

}
