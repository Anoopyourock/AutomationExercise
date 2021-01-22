package stepdefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.automationpractice.generics.BrowserSetup;
import com.automationpractice.webpages.HomePage;
import com.automationpractice.webpages.MyAccount;
import com.automationpractice.webpages.OrderPage;
import com.automationpractice.webpages.TshirtsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderTShirt {
	// To check user is on home page
	@Given("User is on My Store page")
	public void userIsOnHomePage() {
		HomePage homepage = new HomePage(BrowserSetup.getDriver());
		String homepagetitle = homepage.titleOfPage();
		Assert.assertEquals(homepagetitle, "My Store");
	}

	// To perform action on home page
	@When("User click on Tshirt and navigate to T-Shirts Page")
	public void userIsOnTshirtsPage() throws InterruptedException {
		HomePage homepage = new HomePage(BrowserSetup.getDriver());
		homepage.clickOnTshirt();
		TshirtsPage tshirt = new TshirtsPage(BrowserSetup.getDriver());
		String Tshirtgetitle = tshirt.tshirtPageTitle();
		Assert.assertEquals(Tshirtgetitle, "My Store");
	}

	// To perform actions on T-shirt to add it to cart
	@And("User Add T-shirt To cart")
	public void userAddTshirtToCart() throws InterruptedException {
		TshirtsPage tshirt = new TshirtsPage(BrowserSetup.getDriver());
		tshirt.tshirtPageAction();
		OrderPage Order = new OrderPage(BrowserSetup.getDriver());
		String orderpagetitle = Order.orderPageTitle();
		Assert.assertEquals(orderpagetitle, "Order - My Store");
	}

	// To perform actions on order page to place order and then verify that order is
	// placed
	@Then("User verify order History for T-Shirt")
	public void verifyOrderHistoryForTshirt() {
		OrderPage Order = new OrderPage(BrowserSetup.getDriver());
		Order.scrollToProceedToCheckout();
		MyAccount account = new MyAccount(BrowserSetup.getDriver());
		account.myAccountActionInOrderPage();
		Order.PaymentsActions();
		String orderRefrenceNumber = Order.orderPageText();
		account.clickOnMyAccount();
		account.clickOnOrderHistory();
		String accountRefrence = account.orderRefrenceText();
		Assert.assertEquals(orderRefrenceNumber, accountRefrence);
	}

}
