package com.Techblog1.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Techblog1.utilities.PageUtility;

public class CategoriesPage {
	//Create a variable of WebDriver
		WebDriver driver;
	 // categories icons are identified by @FindBy annotation
	@FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[7]/a/p")
	 private WebElement categories;
	//SPACE(sub element of categories dropdown menu)is identified by @FindBy annotation
	@FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[7]/ul/li[2]/a")
	 private WebElement SPACE;
	 
	//initializing page objects
	 public CategoriesPage (WebDriver driver)
	    {
	        this.driver=driver;
	        PageFactory.initElements(driver,this);
	    }
	// select SPACE (sub element of categories dropdown menu )
	 public void selectCategory ()
	    {
		    PageUtility.waitForElementTobeclickable(driver,categories ,200);
	        categories.click();
	        Actions act=new Actions(driver);
	        PageUtility.waitForElementTobeclickable(driver, SPACE,200);
	        act.click(SPACE).perform();
	    }
      
}
