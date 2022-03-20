package Scripts.User;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Constants.AutomationConstants;
import PageObjects.LoginPage;
import PageObjects.myPosts;
import PageObjects.newPosts;
import PageObjects.setUpApp;
import PageObjects.userActions;
import Scripts.TestBase;
import Utilities.ExcelUtility;

public class testUserDeletePost extends TestBase {

	LoginPage objLogin;
	userActions objActionsUser;
	setUpApp objSetUp;
	newPosts objNew;
	myPosts objMyposts;
	String Title = "POst-user";
	Logger logger = LogManager.getLogger(testUserEditPost.class);

	// @before from TestBase.cs will execute first and load the site in browser then
	// control comes to @test
	@Test(priority = 0)
	public void launchApp() throws IOException, InterruptedException {
		// Create Login Page object
		objSetUp = new setUpApp(driver);// login to application
		objSetUp.selectLoginDropdown();
	}

	@Test(priority = 1, enabled = true)

	public void verifyValidLogin() throws IOException, InterruptedException {
		// Create Login Page object
		objLogin = new LoginPage(driver);
		String username = ExcelUtility.getAdminCellData(7, 0);
		String password = ExcelUtility.getAdminCellData(7, 1);
		objLogin.setUserName(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();

		logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");
		String expectedTitle = AutomationConstants.LoginURL;
		String actualTitle = driver.getCurrentUrl();
		Assert.assertEquals(expectedTitle, actualTitle);

	}

	@Test(priority = 2)
	public void deleteUserogin() throws InterruptedException, IOException {

		objNew = new newPosts(driver);
		objNew.deletePostFromMyUserPost("Nasia");
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
