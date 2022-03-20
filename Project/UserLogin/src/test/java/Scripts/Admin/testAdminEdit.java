package Scripts.Admin;

import java.io.IOException;
import java.lang.System.Logger;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Constants.AutomationConstants;
import PageObjects.LoginPage;
import PageObjects.adminAllPost;
import PageObjects.newPosts;
import PageObjects.setUpApp;
import Scripts.TestBase;
import Utilities.ExcelUtility;

public class testAdminEdit extends TestBase {
	LoginPage objLogin;
	setUpApp objSetUp;
	adminAllPost objAdmin;
	newPosts objNew;
	//Logger logger;
	testAdminLogin objAdminLog;
	public String userEdit;
	//Logger logger = LogManager.getLogger(testAdminEdit.class);


	@Test(priority = 0)
	public void launchApp() throws IOException, InterruptedException {
		objSetUp = new setUpApp(driver);// login to application
		objSetUp.selectLoginDropdown();

	}

	@Test(priority = 1)
	public void verifyValidLogin() throws IOException, InterruptedException {
		// Create Login Page object
		objLogin = new LoginPage(driver);
		String username = ExcelUtility.getAdminCellData(0, 0);
		userEdit = username;
		String password = ExcelUtility.getAdminCellData(0, 1);
		objLogin.setUserName(username);
		objLogin.setPassword(password);

		objLogin.clickLogin();

		String expectedTitle = AutomationConstants.LoginURL;
		String actualTitle = driver.getCurrentUrl();
		Assert.assertEquals(expectedTitle, actualTitle);
		//Reporter.log("---endlogin---" + actualTitle, true);
	}

	@Test(priority = 2, enabled = true)
	public void editUserPostByAdminLogin() throws InterruptedException, IOException {
		objAdmin = new adminAllPost(driver);
		// Reporter.log("---start admin edit---", true);
		// for(int i=4;i<9;i++)
		// {
		objAdmin.editFirstPostByUser(userEdit);
		// Reporter.log("---end admin editl---", true);
		SetValuesforEditPosts(5);
		// }
	}

	// Function for passing value to post
	public void SetValuesforEditPosts(int row) throws IOException, InterruptedException {
		objNew = new newPosts(driver);
		// objNew.NewPost();
		Reporter.log("---EditAdmin posts clicked ---", true);

		// Reading from Excel
		String title = ExcelUtility.getAdminCellData(row, 0);
		String author = ExcelUtility.getAdminCellData(row, 1);
		;
		String imgs = ExcelUtility.getAdminCellData(row, 2);
		String category = ExcelUtility.getAdminCellData(row, 3);
		String posts = ExcelUtility.getAdminCellData(row, 4);
		WebDriverWait w = new WebDriverWait(driver, 5);

		// passing values to page
		objNew.setTitle(title);
		objNew.setImages(imgs);
		objNew.setAuthor(author);
		objNew.setCategory(category);
		objNew.setPosts(posts);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		objNew.submitEditPost();

		try {
			if (w.until(ExpectedConditions.alertIsPresent()) != null) {
				System.out.println("Alert  exists");
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
			} else {
				try {

					// String expectedError = AutomationConstants.LOGIN_ERROR_MESSAGE;
					// String actualError = objUser.getError();

				//	Reporter.log("---eoor mesg---" + actualError, true);
					// if (actualError != null) {
					// Assert.assertEquals(expectedError, actualError);
					// }

					// } catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					Reporter.log("---ALL attributes for New posts clicked ---", true);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Reporter.log("--end-Admin  posts ---" + objLogin, true); //
			// (driver.switchTo().alert()).sendKeys(Keys.ENTER);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}
}
