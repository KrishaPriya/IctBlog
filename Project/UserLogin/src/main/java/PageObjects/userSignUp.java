package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.WaitHelper;

public class userSignUp {

	WebDriver driver;

	@FindBy(id = "first")
	private WebElement userName;
	@FindBy(xpath = "/html/body/app-root/app-signup/form/select")
	private WebElement userRole;

	@FindBy(xpath = "/html/body/app-root/app-signup/form/input[2]")
	private WebElement email;

	@FindBy(xpath = "/html/body/app-root/app-signup/form/input[3]")
	private WebElement password;

	@FindBy(xpath = "/html/body/app-root/app-signup/form/button")
	private WebElement btnSubmit;

	// @FindBy(className = "btn-primary")
	// @FindBy(css = "button[type=submit]")
	// labels for displaying messages
	@FindBy(xpath = "/html/body/app-root/app-signup/form/small[2]")
	private WebElement lblError;

	@FindBy(xpath = "/html/body/app-root/app-signup/form/small[4]/b")
	private WebElement lblPassword;

	@FindBy(xpath = "/html/body/app-root/app-signup/form/small[1]/b")
	private WebElement lblName;
	@FindBy(xpath = "/html/body/app-root/app-signup/form/small[2]/b")
	private WebElement lblUserRole;
	@FindBy(xpath = "/html/body/app-root/app-signup/form/small[3]/b")
	private WebElement lblUserEmail;
	
	
	public void setUser(String strUser) {
		if (userName != null) {
			userName.clear();
			WaitHelper.waitForElementTobeVisible(driver,userName,1000);
			userName.sendKeys(strUser);
		}
	}

	public void setuserRole(String struserRole) {
		if (userRole != null) {
			Select cat = new Select(userRole);
			WaitHelper.waitForElementTobeVisible(driver,userRole,2000);
			cat.selectByVisibleText(struserRole);
		}
		else
		{
			System.out.println("cant new ");
		}
	}

	public void setEmail(String strEmail) {
		WaitHelper.waitForElementTobeVisible(driver,email,3000);
		if (email != null) {
			email.clear();
			email.sendKeys(strEmail);
		}
	}

	public void setPassword(String strpassword) {
		WaitHelper.waitForElementTobeVisible(driver,password,4000);
		if (password != null) {
			password.clear();
			password.sendKeys(strpassword);
		}
	}

	public userSignUp(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//for displaying password error
	public String  getError( ) throws Exception {
		String str="TESTING";
		System.out.println("inside getError " + lblError);
		WaitHelper.waitForElementTobeVisible(driver,lblError,500);
		
		if(lblError.isEnabled())
		{
			if(lblError.isDisplayed())
			str= lblError.getText();
		}
		else
		{
			System.out.println("element null");
		
		}
             return str;
		////JavascriptExecutor jse = (JavascriptExecutor) driver;
		//return jse.executeScript("arguments[0].getTex();", lblPassword);

		//System.out.println("end add new ");
	}
	
	//for displaying name error
		public String  getlblName( ) throws Exception {
			String str="no Name";
			if(lblName!=null)
			{
			//System.out.println("inside Name " + lblName);
			WaitHelper.waitForElementTobeVisible(driver,lblName,500);
			
			if(lblName.isEnabled())
			{
				if(lblName.isDisplayed())
				str= lblName.getText();
			}
			}
	             return str;
		}
		
		
		//for displaying userRole
				public String  getlblRole( ) throws Exception {
					String str="user";
					System.out.println("inside getError " + lblUserRole );
					WaitHelper.waitForElementTobeVisible(driver,lblUserRole,500);
					
					if(lblUserRole.isEnabled())
					{
						if(lblUserRole.isDisplayed())
						str= lblUserRole.getText();
					}
					
			             return str;
				}
				
				//for displaying Email
				public String  getlEmail( ) throws Exception {
					String str="no mail";
					System.out.println("inside getError " + lblUserEmail );
					WaitHelper.waitForElementTobeVisible(driver,lblUserEmail,500);
					
					if(lblUserEmail.isEnabled())
					{
						if(lblUserEmail.isDisplayed())
						str= lblUserEmail.getText();
					}
					
			             return str;
				}
				
				
				
	
	public void addNewUser() throws Exception {
		System.out.println("inside Add new post " + btnSubmit);

		WaitHelper.waitForElementTobeVisible(driver,btnSubmit,10);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", btnSubmit);


		//System.out.println("error "+ getError());
		System.out.println("end add new ");
	}
	

}
