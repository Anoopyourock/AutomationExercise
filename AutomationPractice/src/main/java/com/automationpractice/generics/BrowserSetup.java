package com.automationpractice.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> threadlocal = new ThreadLocal<>();

// To open the browser, passing the browser name in the method 
	public static WebDriver chooseBrowser(String browserName) {
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			threadlocal.set(new FirefoxDriver());
		}

		else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			threadlocal.set(new ChromeDriver());
		} else if (browserName.equals("IE")) {
			WebDriverManager.edgedriver().setup();
			threadlocal.set(new EdgeDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().get(PropertyFileHandle.getpropertyvalue("url"));
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return threadlocal.get();

	}
}
