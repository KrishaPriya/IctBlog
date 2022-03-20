package Scripts.User;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Constants.AutomationConstants;
import Log.userLog;
import PageObjects.LoginPage;
import PageObjects.myPosts;
import PageObjects.newPosts;
import PageObjects.setUpApp;
import PageObjects.userActions;
import Scripts.TestBase;
import Utilities.ExcelUtility;

public class testUserLogin extends TestBase {

	LoginPage objLogin;
	userActions objActionsUser;
	setUpApp objSetUp;
	newPosts objNew;
	myPosts objMyposts;
	String Title = "POst-user";

	Logger logger = LogManager.getLogger(testUserLogin.class);

	@AfterTest
	void afterTest() {
	/*	objLogin = null;
		objActionsUser = null;
		objSetUp = null;
		objNew = null;
		objMyposts = null;*/
	}

	// @before from TestBase.cs will execute first and load the site in browser then
	// control comes to @test
	@Test(priority = 0)
	// Launching web page
	public void launchApp() throws IOException, InterruptedException {

		objSetUp = new setUpApp(driver);// login to application
		objSetUp.selectLoginDropdown();// select login rom dropdown
	}

	@Test(priority = 1)
	// try to login with wrong password
	public void verifyInValidLoginWithInavalidPassword() throws IOException, InterruptedException {

		objLogin = new LoginPage(driver);
		String username = ExcelUtility.getAdminCellData(4, 0);
		String password = ExcelUtility.getAdminCellData(4, 1);

		// Reporter.log("---end amin Login---"+username +"...."+password, true);
		objLogin.setUserName(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");

		CheckingAlerts();

	}

	@Test(priority = 2, enabled = true)

	public void verifyInValidLoginWithInvalidEmail() throws IOException, InterruptedException {
		// Create Login Page object
		objLogin = new LoginPage(driver);

		String username = ExcelUtility.getAdminCellData(5, 0);
		String password = ExcelUtility.getAdminCellData(5, 1);

		objLogin.setUserName(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");
		CheckingAlerts();
	}

	@Test(priority = 3, enabled = true)

	public void verifyLoginWithSpecialCharecter() throws IOException, InterruptedException {
		// Create Login Page object
		objLogin = new LoginPage(driver);

		String username = ExcelUtility.getAdminCellData(6, 0);
		String password = ExcelUtility.getAdminCellData(6, 1);
		objLogin.setUserName(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		CheckingAlerts();
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");
	}

	@Test(priority = 4, enabled = true)
	public void verifyValidLogin() throws IOException, InterruptedException {
		// Create Login Page object
		objLogin = new LoginPage(driver);
		String username = ExcelUtility.getAdminCellData(7, 0);
		String password = ExcelUtility.getAdminCellData(7, 1);
		objLogin.setUserName(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");
		String expectedTitle =AutomationConstants.LoginURL;
		String actualTitle =driver.getCurrentUrl(); 
		Assert.assertEquals(expectedTitle,actualTitle);

	}

	public void CheckingAlerts() {

		WebDriverWait wait = new WebDriverWait(driver, 9000);
		wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertEquals(driver.switchTo().alert().getText(), "User not found");
		driver.switchTo().alert().accept();
		// logger.info("User not found");

	}
	

}
