package Scripts.User;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class testUserEditPost extends TestBase {

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

	// test for deleting post

	@Test(priority = 2, enabled = true)
	public void EditUserFromlogin() throws InterruptedException, IOException {

		objNew = new newPosts(driver);
		objNew.editFirstPostfromUser("Nasia");
		logger.info(" inside edit from EditUserFromlogin: success");
		EditPostTitle();
		// CheckingAlerts();

	}

	
	// Adding new post without name entered name as 3 space
	public void EditPostTitle() throws IOException, InterruptedException {
		logger.info(" entered edit from EditPostTitle: start");
		objNew.setTitle("Edit-Nasia");
		objNew.setAuthor("Edit-Nasia");
		objNew.setImages("#");
		objNew.setCategory("SPACE");
		objNew.setCategory("Editing content");
		Thread.sleep(1000);
		EditUserPosts();
		//Thread.sleep(4000);
		logger.info(" entered edit from EditPostTitle: End");
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " :Title Edited Sucess");
	}

/*	@Test(priority = 4, enabled = false)
	// Adding new post without name entered name as 3 space
	public void EditPostAuthor() throws IOException, InterruptedException {
		objNew = new newPosts(driver);
		EditUserFromlogin();
		objNew.setAuthor("Edit-Nasia");
		EditUserPosts();
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " :Author Edited Sucess");
	}

	@Test(priority =5 ,enabled = false)
	// Adding new post without name entered name as 3 space
	public void EditPostImageURL() throws IOException, InterruptedException {
		objNew = new newPosts(driver);
		EditUserFromlogin();
		objNew.setImages("#");
		EditUserPosts();
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " :Image Edited Sucess");
	}
	
	@Test(priority =6, enabled = false)
	// Adding new post without name entered name as 3 space
	public void EditPostCategory() throws IOException, InterruptedException {
		objNew = new newPosts(driver);
		objNew.setCategory("SPACE");
		EditUserPosts();
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " :category Edited Sucess");
	}
	@Test(priority =7, enabled = false)
	// Adding new post without name entered name as 3 space
	public void EditPostContent() throws IOException, InterruptedException {
		objNew = new newPosts(driver);
		EditUserFromlogin();
		objNew.setCategory("Editing content");
		EditUserPosts();
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " :Content Edited Sucess");
	}
*/
	

	// test for deleting post

	public void EditUserPosts() throws IOException, InterruptedException {
		//objNew = new newPosts(driver);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		objNew.submitEditPost();
	//	CheckingAlerts();
		//EditPostTitle();
	}

	public void CheckingAlerts() {

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertEquals(driver.switchTo().alert().getText(), "Updated Successfully");
		driver.switchTo().alert().accept();
		// logger.info("User not found");

	}

}
