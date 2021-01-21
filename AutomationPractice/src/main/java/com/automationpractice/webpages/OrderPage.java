package com.automationpractice.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automationpractice.generics.WebDriverCommonActions;

public class OrderPage 
{
	private WebDriver driver;
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement summaryproceedtocheckout;
			
	@FindBy(id="cgv")
	private WebElement checkbox;
	
	@FindBy(xpath="(//button[@type='submit']//span)[2]")
	private WebElement shippingcheckout;
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	private WebElement paybywire; 
	
	@FindBy(xpath="//span[text()='I confirm my order']")
	private WebElement confirmorder;
	
	@FindBy(xpath="//div[@class='box']")
	private WebElement taketext;
	
	public OrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	//To perform click on proceed to checkout on order summary
	public void scrolltoproceedtocheckout()
	{	
		WebDriverCommonActions.scrolltoelement(driver, summaryproceedtocheckout);
		summaryproceedtocheckout.click();
	}		
	//To perform click on check box on order shipping
	public void clickcheckboxonshippingpage()
	{
		WebDriverCommonActions.scrolltoelement(driver, checkbox);
		checkbox.click();
	}
	//To perform click on proceed to checkout on order shipping
	public void clickonshippingpagecheckout()
	{
		shippingcheckout.click();	
	}
	//To perform click on pay-by-wire on order payment
	public void clickonpaybywireonpaymetpage()
	{
		WebDriverCommonActions.scrolltoelement(driver, paybywire);
		paybywire.click();
	}	
	//To perform click on confirm order
	public void clickonconfirmorder()
	{
		WebDriverCommonActions.scrolltoelement(driver, confirmorder);
		confirmorder.click();
	}
	//To get text of order confirmation 
	public String orderpagetext()
	{
		String text=taketext.getText();
		String refrencenumber=text.substring(216,225);
		return refrencenumber;
		
	}
	
	public String orderpagetitle()
	{
		String orderpagetitle=driver.getTitle();
		return orderpagetitle;
	}
	//This method perform below steps:
	//click on proceed to checkout on order summary
	//click on proceed to checkout on order shipping
	//click on pay-by-wire on order payment
	//click on confirm order
	public void orderpageactions()
	{
		OrderPage Order =new OrderPage(driver);
		Order.scrolltoproceedtocheckout();
		Order.clickcheckboxonshippingpage();
		Order.clickonshippingpagecheckout();
		Order.clickonpaybywireonpaymetpage();
		Order.clickonconfirmorder();
		
	}
	
	
}
