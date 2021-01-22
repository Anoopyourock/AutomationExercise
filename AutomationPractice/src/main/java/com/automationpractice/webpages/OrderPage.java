package com.automationpractice.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automationpractice.generics.WebDriverCommonActions;

public class OrderPage {
	private WebDriver driver;
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	private WebElement summaryProceedToCheckout;

	@FindBy(id = "cgv")
	private WebElement checkbox;

	@FindBy(xpath = "(//button[@type='submit']//span)[2]")
	private WebElement shippingCheckout;

	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	private WebElement payByWire;

	@FindBy(xpath = "//span[text()='I confirm my order']")
	private WebElement confirmOrder;

	@FindBy(xpath = "//div[@class='box']")
	private WebElement takeText;

	public OrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// To perform click on proceed to checkout on order summary
	public void scrollToProceedToCheckout() {
		WebDriverCommonActions.scrollToElement(driver, summaryProceedToCheckout);
		summaryProceedToCheckout.click();
	}

	// To perform click on check box on order shipping
	public void clickCheckboxOnShippinPpage() {
		WebDriverCommonActions.scrollToElement(driver, checkbox);
		checkbox.click();
	}

	// To perform click on proceed to checkout on order shipping
	public void clickOnShippingPageCheckout() {
		shippingCheckout.click();
	}

	// To perform click on pay-by-wire on order payment
	public void clickOnPayByWireOnPaymetPage() {
		WebDriverCommonActions.scrollToElement(driver, payByWire);
		payByWire.click();
	}

	// To perform click on confirm order
	public void clickOnConfirmOrder() {
		WebDriverCommonActions.scrollToElement(driver, confirmOrder);
		confirmOrder.click();
	}

	// To get text of order confirmation
	public String orderPageText() {
		String text = takeText.getText();
		String refrenceNumber = text.substring(216, 225);
		return refrenceNumber;

	}

	public String orderPageTitle() {
		String orderPageTitle = driver.getTitle();
		return orderPageTitle;
	}

	// This method perform below steps:
	// click on proceed to checkout on order summary
	// click on proceed to checkout on order shipping
	// click on pay-by-wire on order payment
	// click on confirm order
	public void PaymentsActions() {
		scrollToProceedToCheckout();
		clickCheckboxOnShippinPpage();
		clickOnShippingPageCheckout();
		clickOnPayByWireOnPaymetPage();
		clickOnConfirmOrder();

	}

}
