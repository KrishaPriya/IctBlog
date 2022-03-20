package com.Techblog1.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {
	 public static WebElement waitForElementTobeVisible(WebDriver driver, WebElement elementToBeLoaded, int Time) {
	        WebDriverWait wait = new WebDriverWait(driver, Time);
	        WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
	        return element;
	    }
	 

	
	 public static WebElement waitForElementTobeclickable(WebDriver driver, WebElement elementToBeLoaded, int Time) {
	        WebDriverWait wait = new WebDriverWait(driver, Time);
	        WebElement element = wait.until(ExpectedConditions .elementToBeClickable(elementToBeLoaded));
	        return element;
	    }     
}
