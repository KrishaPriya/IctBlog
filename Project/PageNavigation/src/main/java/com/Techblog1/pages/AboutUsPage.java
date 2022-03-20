package com.Techblog1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Techblog1.utilities.PageUtility;


public class AboutUsPage {
	
	//Create a variable of WebDriver
	WebDriver driver;
	// aboutus text is identified by @FindBy annotation
	@FindBy(xpath="//*[@id=\"about\"]/header/h2")
    private WebElement aboutustext;
	
	
	//initializing page objects
	 public AboutUsPage (WebDriver driver)
	    {
	        this.driver=driver;
	        PageFactory.initElements(driver,this);
	    }
	 
	// check the visibility of aboutus text
	 public String validateaboutusText() {
		 PageUtility.waitForElementTobeclickable(driver, aboutustext,200);
		 return aboutustext.getText();
			 
	    }
	
	
}

