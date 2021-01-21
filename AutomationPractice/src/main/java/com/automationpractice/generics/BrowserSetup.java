package com.automationpractice.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BrowserSetup {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> threadlocal=new ThreadLocal<>();
	
// To open the browser, passing the browser name in the method 
	public static WebDriver choosebrowser(String browsername ) {
		if (browsername.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			threadlocal.set(new FirefoxDriver());
		}

		else if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			threadlocal.set(new ChromeDriver());
		} else if (browsername.equals("IE")) 
		{
			WebDriverManager.edgedriver().setup();
			threadlocal.set(new EdgeDriver());
		}
		getdriver().manage().window().maximize();
		getdriver().get(PropertyFileHandle.getpropertyvalue("url"));
		getdriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return getdriver();
	}
	
	public static synchronized WebDriver getdriver()
	{
		return threadlocal.get();
		
	}
}
