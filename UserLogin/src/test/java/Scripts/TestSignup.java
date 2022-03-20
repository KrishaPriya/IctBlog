package Scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Constants.AutomationConstants;
import PageObjects.userSignUp;

import PageObjects.newPosts;
import PageObjects.setUpApp;

//for browser setup,loading browser and other reusable methods

public class TestSignup extends TestBase {

	// public WebDriver driver;
	setUpApp objSetUp;
	userSignUp objUser;

	@Test(priority = 0)
	//Starting browser and launching app
	public void launchApp() throws IOException, InterruptedException {
		objSetUp = new setUpApp(driver);// login to application
		objSetUp.selectSignUpDropdown();
	}

	@Test(priority = 1)
	public void newUser() throws Exception {
		objUser = new userSignUp(driver);//
		Reporter.log("---New user clicked ---", true);

		// Reading from Excel
		String name = "Nasia";
		String role = "user";
		String email = "nasia20@gmail.com";
		String password = "Nasia56";
		objUser.setUser(name);
		objUser.setuserRole(role);
		objUser.setEmail(email);
		objUser.setPassword(password);

		objUser.addNewUser();
		// Explicit wait condition for alert
		WebDriverWait w = new WebDriverWait(driver, 5);
		// alertIsPresent() condition applied
		try {
			if (w.until(ExpectedConditions.alertIsPresent()) != null) {
				System.out.println("Alert  exists");
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
			} else {
				try {

					String expectedError = AutomationConstants.LOGIN_ERROR_MESSAGE;
					String actualError = objUser.getError();

					Reporter.log("---eoor mesg---" + actualError, true);
					if (actualError != null) {
						Assert.assertEquals(expectedError, actualError);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Reporter.log("---ALL attributes for New posts clicked ---", true);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 2, enabled = false)
	public void getText() throws IOException, InterruptedException {
		objUser = new userSignUp(driver);//
		Reporter.log("---get mesg start---", true);
		try {
			String txt = objUser.getError();
			Reporter.log("---get mesg start---" + txt, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
