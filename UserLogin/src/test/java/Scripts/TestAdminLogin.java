package Scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Constants.AutomationConstants;
import PageObjects.LoginPage;
import PageObjects.adminAllPost;
import org.openqa.selenium.Alert;
import PageObjects.newPosts;
import PageObjects.setUpApp;
import Utilities.WaitHelper;

//for browser setup,loading browser and other reusable methods
public class TestAdminLogin extends TestBase {

/*	LoginPage objLogin;
	setUpApp objSetUp;
	adminAllPost objAdmin;
	newPosts objNew;

	// @before from TestBase.cs will execute first and load the site in browser then
	// control comes to @test
	@Test(priority = 0)
	public void launchApp() throws IOException, InterruptedException {

		objSetUp = new setUpApp(driver);// login to application

		objSetUp.selectLoginDropdown();
	}

	@Test(priority = 1)

	public void verifyValidLogin() throws IOException, InterruptedException {
		// Create Login Page object
		objLogin = new LoginPage(driver);
		Reporter.log("---Start admin Login---", true);

		String username = "admin";
		String password = "1234";
		objLogin.setUserName(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		
		//String expectedError=AutomationConstants.LOGIN_ERROR_MESSAGE;
	//	String actualError=objLogin.getError();
	//	Assert.assertEquals(expectedError,actualError);
		
		Reporter.log("---end amin Login---", true);
	}

	// test for deleting post

	/*@Test(priority = 2)
	public void deleteTrainerPostByAdminLogin() throws InterruptedException, IOException {
		objAdmin = new adminAllPost(driver);
		Thread.sleep(2000);

		/*
		 * Thread.sleep(2000); 
		 * allPostsPage = new AllPostsPage(driver); String
		 * allposttext=allPostsPage.allposttext();
		 * Assert.assertEquals(allposttext,"All Posts");
		 * 
		 * allPostsPage.deleteFirstPostByUser("krishna priya");
		 
		Reporter.log("---start admindel---", true);
		objAdmin.deleteFirstPostByUser("Nasia");
		Reporter.log("---end admindel---", true);
	}
*/
	
	 

}
