package Scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Constants.AutomationConstants;

import org.openqa.selenium.Alert;
import Scripts.TestBase;
import PageObjects.LoginPage;
import PageObjects.myPosts;
import PageObjects.setUpApp;
import PageObjects.userActions;
import PageObjects.newPosts;

//All commonly used functions
public class TestLogin extends TestBase {

	LoginPage objLogin;
	userActions objActionsUser;
	setUpApp objSetUp;
	newPosts objNew;
	myPosts objMyposts;
	String Title = "POst-user";

	// @before from TestBase.cs will execute first and load the site in browser then
	// control comes to @test
	@Test(priority = 0)
	public void launchApp() throws IOException, InterruptedException {
		// Create Login Page object
		Reporter.log("---Launch Login---", true);
		objSetUp = new setUpApp(driver);// login to application
		Reporter.log("---App -1.Selct icon--", true);

		objSetUp.selectLoginDropdown();
		Reporter.log("---App end-1.Selct icon--", true);
	}

	@Test(priority = 1)

	public void verifyValidLogin() throws IOException, InterruptedException {
		// Create Login Page object
	//	Reporter.log("---Start Login---", true);
		// TestBase();

		objLogin = new LoginPage(driver);
		//Reporter.log("---objlog Login-1.Selct icon--", true);
		// String username = "admin";
		// String password = "1234";

		String username = "mohammed.nasia@gmail.com";
		String password = "Nasia1243";
		objLogin.setUserName(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		
		String expectedError=AutomationConstants.LOGIN_ERROR_MESSAGE;
		String actualError=objLogin.getError();
		Assert.assertEquals(expectedError,actualError);
		

		//Reporter.log("---end Login---", true);
		
		//Thread.sleep(2000);

		//Alert alert = driver.switchTo().alert();
		//alert.accept();
	}

	@Test(priority = 3)
	public void newPosts() throws IOException, InterruptedException {
		objNew = new newPosts(driver);
		// objNew.NewPost();
		Reporter.log("---New posts clicked ---", true);

		// Reading from Excel
		String title = Title;
		String author = "Nasia";
		String imgs = "https://pixabay.com/photos/landscape-gold-agriculture-nature-3604825/";
		String category = "SPACE";
		String posts = "Loreum Isum......";// Assiging values to Textbox

		objNew.setTitle(title);
		objNew.setAuthor(author);
		objNew.setImages(imgs);
		objNew.setCategory(category);
		objNew.setPosts(posts);
		Reporter.log("---ALL attributes for New posts clicked ---", true);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			objNew.addNewPost();
			Thread.sleep(2000);

			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Reporter.log("failed", true);
		}
		Reporter.log("--end-New  posts ---" + objLogin, true); //

	}

	// test for deleting post

	@Test(priority = 4)
	public void EditUserFromlogin() throws InterruptedException, IOException {

		objNew = new newPosts(driver);
		objNew.editFirstPostfromUser("Nasia");
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	// test for deleting post

	@Test(priority = 5)
	public void deleteUserogin() throws InterruptedException, IOException {

		objNew = new newPosts(driver);
		objNew.deletePostFromMyUserPost("Nasia");
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	@Test(priority = 2)
	public void navigateNewPosts() throws IOException {
		objMyposts = new myPosts(driver);
		Reporter.log("---My posts DELETE ---" + objActionsUser, true); // Adding post btn click
																		// objActionsUser.NewPost();
		objMyposts.NewPost();
	}

	public void EditUserPosts() throws IOException, InterruptedException {
		objNew = new newPosts(driver);
		// objNew.NewPost();
		Reporter.log("---Edit user posts clicked ---", true);

// Reading from Excel
//String title = "Post-Space";
		String author = "Raahiol";
		String imgs = "#";
//String category = "SPACE";
//  String posts = "Loreum Isum......" ;// Assiging values to Textbox

// objNew.setTitle(title);

		objNew.setImages(imgs);
		objNew.setAuthor(author);
// objNew.setCategory(category);
// objNew.setPosts(posts);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		objNew.submitEditPost();
// accepting javascript alert
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Alert alert = driver.switchTo().alert();
		//alert.accept();

		Reporter.log("--end-Admin  posts ---" + objLogin, true); //
// (driver.switchTo().alert()).sendKeys(Keys.ENTER);

	}
}
