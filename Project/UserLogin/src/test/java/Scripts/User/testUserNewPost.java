package Scripts.User;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.AutomationConstants;
import PageObjects.LoginPage;
import PageObjects.myPosts;
import PageObjects.newPosts;
import PageObjects.setUpApp;
import PageObjects.userActions;
import Scripts.TestBase;
import Utilities.ExcelUtility;

public class testUserNewPost extends TestBase {

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

	@Test(priority = 2, enabled = true)
	// Navigating to New page
	public void navigateNewPosts() throws IOException {
		objMyposts = new myPosts(driver);
		
		objMyposts.NewPost();
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");
	}

	
	@Test(priority = 3, enabled = true)
	// Adding new post without name entered name as 3 space
	public void newPostsWithoutName() throws IOException, InterruptedException {
		objNew = new newPosts(driver);
		String title = ExcelUtility.getAdminCellData(8, 0);
		String author = ExcelUtility.getAdminCellData(8, 1);
		String imgs = ExcelUtility.getAdminCellData(8, 2);
		String category = ExcelUtility.getAdminCellData(8, 3);
		String posts = ExcelUtility.getAdminCellData(8, 4);

		objNew.setTitle(title);
		objNew.setAuthor(author);
		objNew.setImages(imgs);
		objNew.setCategory(category);
		objNew.setPosts(posts);

		try {
			objNew.addNewPost();

			logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");
			CheckingAlerts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(new Exception().getStackTrace()[0].getMethodName() + " : failure");
		}

	}
	
	
	@Test(priority = 4, enabled = true)
	// Adding new post without name entered name as 3 space
	public void newPostsWithoutAuthor() throws IOException, InterruptedException {
		objNew = new newPosts(driver);
		navigateNewPosts();
		
		String title = ExcelUtility.getAdminCellData(9, 0);
		String author = ExcelUtility.getAdminCellData(9, 1);
		String imgs = ExcelUtility.getAdminCellData(9, 2);
		String category = ExcelUtility.getAdminCellData(9, 3);
		String posts = ExcelUtility.getAdminCellData(9, 4);

		objNew.setTitle(title);
		objNew.setAuthor(author);
		objNew.setImages(imgs);
		objNew.setCategory(category);
		objNew.setPosts(posts);

		try {
			objNew.addNewPost();

			logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");
			CheckingAlerts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(new Exception().getStackTrace()[0].getMethodName() + " : failure");
		}

	}

	@Test(priority = 5, enabled = true)
	// Adding new post without name entered name as 3 space
	public void newPostsWithoutValidUrl() throws IOException, InterruptedException {
		objNew = new newPosts(driver);
		navigateNewPosts();
		
		String title = ExcelUtility.getAdminCellData(10, 0);
		String author = ExcelUtility.getAdminCellData(10, 1);
		String imgs = ExcelUtility.getAdminCellData(10, 2);
		String category = ExcelUtility.getAdminCellData(10, 3);
		String posts = ExcelUtility.getAdminCellData(10, 4);

		objNew.setTitle(title);
		objNew.setAuthor(author);
		objNew.setImages(imgs);
		objNew.setCategory(category);
		objNew.setPosts(posts);

		try {
			objNew.addNewPost();

			logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");
			CheckingAlerts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(new Exception().getStackTrace()[0].getMethodName() + " : failure");
		}

	}
	
	@Test(priority = 6, enabled = true)
	// Adding new post without name entered name as 3 space
	public void newPostsWithValidElemets() throws IOException, InterruptedException {
		objNew = new newPosts(driver);
		navigateNewPosts();
		
		String title = ExcelUtility.getAdminCellData(11, 0);
		String author = ExcelUtility.getAdminCellData(11, 1);
		String imgs = ExcelUtility.getAdminCellData(11, 2);
		String category = ExcelUtility.getAdminCellData(11, 3);
		String posts = ExcelUtility.getAdminCellData(11, 4);

		objNew.setTitle(title);
		objNew.setAuthor(author);
		objNew.setImages(imgs);
		objNew.setCategory(category);
		objNew.setPosts(posts);

		try {
			objNew.addNewPost();

			logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");
			CheckingAlerts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(new Exception().getStackTrace()[0].getMethodName() + " : failure");
		}

	}

	// test for deleting post
	public void CheckingAlerts() {

		WebDriverWait wait = new WebDriverWait(driver, 9000);
		wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertEquals(driver.switchTo().alert().getText(), "Post send for approval from admin");
		driver.switchTo().alert().accept();
		// logger.info("User not found");

	}
}
