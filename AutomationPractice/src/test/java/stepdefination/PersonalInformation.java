package stepdefination;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.automationpractice.webpages.MyAccount;
import com.automationpractice.generics.BrowserSetup;
import com.automationpractice.webpages.IdentityPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalInformation {
	// To perform actions home page, get the title of current page and assert it
	@When("User sign into account")
	public void userSiginToAccount() {
		MyAccount account = new MyAccount(BrowserSetup.getDriver());
		account.signinToAccount();
		String pageTitle = account.accountPageTitle();
		Assert.assertEquals(pageTitle, "My account - My Store");
	}

	// To perform actions on My Account page, get the title of current page and
	// assert it
	@And("User Click on my personal information on My Account page")
	public void userClickOnMyPersonalInformation() {
		MyAccount account = new MyAccount(BrowserSetup.getDriver());
		account.clickOnMyPersonalInformation();
		String pageTitle = account.accountPageTitle();
		Assert.assertEquals(pageTitle, "Identity - My Store");
	}

	// To perform actions on identity page, pass the credentials into fields
	@And("User Enter details in key and value and save them")
	public void userenterdetailsinkeyandvalueandsavethem(DataTable credentials) {
		List<List<String>> data = credentials.asLists(String.class);
		String firstName = data.get(0).get(1);
		String lastName = data.get(1).get(1);
		String oldPassword = data.get(2).get(1);
		String newPassword = data.get(3).get(1);
		String confirmPassword = data.get(4).get(1);
		IdentityPage identity = new IdentityPage(BrowserSetup.getDriver());
		identity.identityPageActions(firstName, lastName, oldPassword, newPassword, confirmPassword);

	}

	// To check the success message for changed credentials and verify
	@Then("User verify details are saved")
	public void userverifydetailssaved() {
		IdentityPage identity = new IdentityPage(BrowserSetup.getDriver());
		String successMessage = identity.successMessage();
		Assert.assertEquals(successMessage, "Your personal information has been successfully updated.");
	}
}
