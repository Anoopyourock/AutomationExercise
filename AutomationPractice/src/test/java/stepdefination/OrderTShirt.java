package stepdefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.automationpractice.generics.BrowserSetup;
import com.automationpractice.webpages.Homepage;
import com.automationpractice.webpages.MyAccount;
import com.automationpractice.webpages.OrderPage;
import com.automationpractice.webpages.TshirtsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class OrderTShirt
{ 
	//To check user is on home page
	@Given("User is on My Store page")
	public void userisonhomepage() 
	{
		Homepage homepage =new Homepage(BrowserSetup.getdriver());
		String homepagetitle=homepage.titleofpage();
		Assert.assertEquals(homepagetitle, "My Store");
	}
	//To perform action on home page 
	@When("User click on Tshirt and navigate to T-Shirts Page")
	public void userisonshirtspage() throws InterruptedException 
	{
		Homepage homepage =new Homepage(BrowserSetup.getdriver());
		homepage.clickontshirt();
		TshirtsPage tshirt=new TshirtsPage(BrowserSetup.getdriver());
		String Tshirtgetitle=tshirt.tshirtpagetitle();
		Assert.assertEquals(Tshirtgetitle, "My Store");
	}
	//To perform actions on T-shirt to add it to cart
	@And("User Add T-shirt To cart")
	public void useraddtshirttocart() throws InterruptedException
	{
		TshirtsPage tshirt=new TshirtsPage(BrowserSetup.getdriver());
		tshirt.tshirtpageaction();
		OrderPage Order =new OrderPage(BrowserSetup.getdriver());
		String orderpagetitle=Order.orderpagetitle();
		Assert.assertEquals(orderpagetitle, "Order - My Store");
	}
	// To perform actions on order page to place order and then verify that order is placed
	@Then("User verify order History for T-Shirt")
	public void verifyorderhistoryfortshirt() 
	{	
		OrderPage Order =new OrderPage(BrowserSetup.getdriver());
		Order.scrolltoproceedtocheckout();
		MyAccount account=new MyAccount(BrowserSetup.getdriver());
		account.myaccountactioninorderpage();
		Order.orderpageactions();
		String orderRefrencenumber=Order.orderpagetext();
		account.clickonmyaccount();
		account.clickonorderhistory();
		String accountRefrence=account.orderrefrencetext();
		Assert.assertEquals(orderRefrencenumber, accountRefrence);
	}

}
