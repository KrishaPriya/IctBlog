package com.Techblog1.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Techblog1.utilities.PageUtility;

public class LoginPage {
	//Create a variable of WebDriver
	  WebDriver driver;
	 // login icon is identified by @FindBy annotation
	  @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/a")
	    private WebElement selOption;
	  // login icon in login page is identified by @FindBy annotation
	  @FindBy(xpath="/html/body/app-root/app-login/app-header/nav/div/div/ul/li[11]/a/img")
	    private WebElement SelOption ;
	  //login option in login dropdown menuis identified by @FindBy annotation

	    @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/ul/li[1]/a")
	    private WebElement login;
	    // signup option in login dropdown menu is identified by @FindBy annotation
	  
	    @FindBy(xpath="/html/body/app-root/app-login/app-header/nav/div/div/ul/li[11]/ul/li[2]/a")
	    private WebElement signup;
	    
	  //initializing page objects
	    public LoginPage (WebDriver driver)
	    {
	        this.driver= driver;
	        PageFactory.initElements(driver,this);
	    }
	    //select login option from login dropdown menu
	    public void selectLoginDropdownLogin() throws InterruptedException 
	    {
	    	PageUtility.waitForElementTobeclickable(driver, selOption,200);
	        selOption.click();
	        Actions act=new Actions(driver);
	        PageUtility.waitForElementTobeclickable(driver,login,200);
	        act.click(login).perform();
	    }
	    //select signup option from login dropdown menu
	    public void selectLoginDropdownSignUp() throws InterruptedException
	    {
	    	PageUtility.waitForElementTobeclickable(driver, SelOption,200);
	        SelOption.click();
	        Actions act=new Actions(driver);
	        PageUtility.waitForElementTobeclickable(driver, signup,200);
	        act.click(signup).perform();

	    }
	    

	    
	
}
