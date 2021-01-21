package com.automationpractice.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automationpractice.generics.WebDriverCommonActions;

public class TshirtsPage {
	private WebDriver driver;
	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement image;

	@FindBy(xpath = "//span[text()='Add to cart']")
	private WebElement addtocart;

	@FindBy(xpath = "//a[@title='Proceed to checkout']//span[1]")
	private WebElement checkout;

	public TshirtsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	//To perform scroll to the T-shirt
	public void scrolltotshirt() {
		WebDriverCommonActions.scrolltoelement(driver, image);
	}
	//To perform mouse hover option on T-shirt  
	public void movetotshirt() {
		
		WebDriverCommonActions.mouseaction(driver, image);
	}
	// To click on cart button
	public void clickonaddtocart() {
		addtocart.click();
	}
	//To click on checkout 
	public void clickoncheckOut() {
		checkout.click();
	}
	//This method will perform below steps:
	//scroll to the T-shirt
	//mouse hover option on T-shirt 
	//click on cart button
	//click on checkout
	public void tshirtpageaction() {
		TshirtsPage tshirt = new TshirtsPage(driver);
		tshirt.scrolltotshirt();
		tshirt.movetotshirt();
		tshirt.clickonaddtocart();
		tshirt.clickoncheckOut();
	}
	
	//To get tile of page
	public String tshirtpagetitle()
	{
		String tshirttitle=driver.getTitle();
		return tshirttitle;
		
	}

}
