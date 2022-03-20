package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.WaitHelper;

public class LoginPage {

	WebDriver driver;

	/* All WebElements are identified by @FindBy annotation */
	@FindBy(name = "username")
	private WebElement username;
	@FindBy(id = "pwd")
	private WebElement password;
	@FindBy(id = "logbut")
	private WebElement login;
	
	@FindBy(xpath = "/html/body/app-root/app-login/form/small[2]")
	private WebElement lblError;  
   

	// Set user name in textbox
	public void setUserName(String strUserName) {
		username.clear();
		WaitHelper.waitForElementTobeVisible(driver,username,5000);
		username.sendKeys(strUserName);
	}

	// Set password in password textbox
	public void setPassword(String strPassword) {
		password.clear();
		WaitHelper.waitForElementTobeVisible(driver,password,5000);
		password.sendKeys(strPassword);
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Selecting user icon
	
	public void clickLogin() throws InterruptedException {

		WaitHelper.waitForElementTobeVisible(driver,login,500);
		login.click();
		WaitHelper.waitForElementTobeVisible(driver,login,500);
		
		//WaitHelper.hitenter(driver, login);
	}
	
	public String getError()
	{
		String str="";
		
		if(lblError!=null)
		{
			 str = lblError.getText().trim();
		}
		return str;
	}
	
	
}
