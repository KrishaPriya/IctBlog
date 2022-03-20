package Scripts.Admin;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Constants.AutomationConstants;

import PageObjects.LoginPage;
import PageObjects.adminAllPost;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.newPosts;
import PageObjects.setUpApp;
import Scripts.TestBase;
import Scripts.User.testUserLogin;
import Utilities.ExcelUtility;
import Utilities.WaitHelper;

public class testAdminLogin  extends TestBase {

	LoginPage objLogin;
	setUpApp objSetUp;
	adminAllPost objAdmin;
	newPosts objNew;    
//	Logger logger = LogManager.getLogger(testAdminLogin.class);


	// @before from TestBase.cs will execute first and load the site in browser then
	// control comes to @test
	@Test(priority = 0,enabled=true)
	public void launchApp() throws IOException, InterruptedException {

		objSetUp = new setUpApp(driver);// login to application

		objSetUp.selectLoginDropdown();
	}

	@Test(priority = 1,enabled=true)

	public void verifyInValidLoginWithInvalidEmail() throws IOException, InterruptedException {
		// Create Login Page object
		objLogin = new LoginPage(driver);

		String username = ExcelUtility.getAdminCellData(1, 0);
		String password = ExcelUtility.getAdminCellData(1, 1); ;
		objLogin.setUserName(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		Thread.sleep(2000);
		CheckingAlerts();
		//logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");
	}
	@Test(priority = 2,enabled=true)
	public void verifyInValidLoginWithInavalidPassword() throws IOException, InterruptedException {
		// Create Login Page object
		objLogin = new LoginPage(driver);
		String username = ExcelUtility.getAdminCellData(2, 0);
		String password = ExcelUtility.getAdminCellData(2, 1); 
		objLogin.setUserName(username);
		objLogin.setPassword(password);
		//Thread.sleep(2000);
		objLogin.clickLogin();
		
		CheckingAlerts();
		Thread.sleep(2000);
	}
	
	@Test(priority = 3,enabled=true)
	public   void verifyValidLogin() throws IOException, InterruptedException {
		// Create Login Page object
		objLogin = new LoginPage(driver);
		String username = ExcelUtility.getAdminCellData(0, 0);
		String password = ExcelUtility.getAdminCellData(0, 1); 
		
		objLogin.setUserName(username);
		objLogin.setPassword(password);
		Thread.sleep(2000);
		objLogin.clickLogin();
		Thread.sleep(2000);
		//WaitHelper.hitenter(driver,);
		
		/*try {
			objLogin.clickLogin();
			sy
		} catch (UnhandledAlertException f) {
		    try {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();
		    } catch (NoAlertPresentException e) {
		        e.printStackTrace();
		    }
		}*/
		
		//WaitForAlerts();
		
		String expectedTitle = AutomationConstants.LoginAdminURL;
		String actualTitle = driver.getCurrentUrl();
		Assert.assertEquals(expectedTitle, actualTitle);
	
	}
	
	public void CheckingAlerts()
	{
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	if(wait.until(ExpectedConditions.alertIsPresent()) != null) {
	//wait.until(ExpectedConditions.alertIsPresent());
	//Reporter.log(driver.switchTo().alert().getText(), true);
	Assert.assertEquals(driver.switchTo().alert().getText(),"User not found");
	}else 
	{
		System.out.println("1");
		Assert.assertEquals(driver.switchTo().alert().getText()," User not found");
	}
	driver.switchTo().alert().accept();
	//logger.info("User not found");

	}
	
	public void WaitForAlerts()
	{
		WebDriverWait w = new WebDriverWait(driver, 50);
		// alertIsPresent() condition applied
		try {
			if (w.until(ExpectedConditions.alertIsPresent()) != null) {
				System.out.println("Alert  exists");
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
			} 
			/*else {
				try {

					/*String expectedError = AutomationConstants.LOGIN_ERROR_MESSAGE;
					String actualError = objUser.getError();

					Reporter.log("---eoor mesg---" + actualError, true);
					if (actualError != null) {
						Assert.assertEquals(expectedError, actualError);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				Reporter.log("---ALL attributes for New posts clicked ---", true);

			//}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
	

}
