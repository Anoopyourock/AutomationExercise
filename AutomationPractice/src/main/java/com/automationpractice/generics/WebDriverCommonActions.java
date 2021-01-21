package com.automationpractice.generics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class WebDriverCommonActions 
{

	//To perform mouse hover actions
	public static void mouseaction(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	//To perform scroll to a element 
	public static void scrolltoelement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor javascript=(JavascriptExecutor)(driver);
		javascript.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
}
