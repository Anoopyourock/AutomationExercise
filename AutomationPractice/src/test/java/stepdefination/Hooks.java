package stepdefination;

import org.openqa.selenium.WebDriver;

import com.automationpractice.generics.BrowserSetup;
import com.automationpractice.generics.PropertyFileHandle;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	private WebDriver driver;

	// This method will run before scenario to setup browser
	@Before
	public void openBrowser() {
		driver = BrowserSetup.chooseBrowser(PropertyFileHandle.getpropertyvalue("browsername"));
	}

	// This method will run after scenario to close the browser
	@After
	public void tearDown() {
		driver.quit();
	}

}
