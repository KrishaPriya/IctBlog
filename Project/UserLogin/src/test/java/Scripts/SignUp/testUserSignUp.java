package Scripts.SignUp;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.WaitHelper;
import Constants.AutomationConstants;
import PageObjects.userSignUp;
import Scripts.TestBase;
import Scripts.User.testUserEditPost;
import PageObjects.setUpApp;

public class testUserSignUp extends TestBase {

	// public WebDriver driver;
	setUpApp objSetUp;
	userSignUp objUser;
	WaitHelper objWait;
	Logger logger = LogManager.getLogger(testUserEditPost.class);

	@Test(priority = 0)
	public void launchApp() throws IOException, InterruptedException {
		objSetUp = new setUpApp(driver);// login to application
		objSetUp.selectSignUpDropdown();
	}

	@Test(priority = 1, enabled = true)
	public void newUserWithoutName() throws Exception {
		objUser = new userSignUp(driver);//
		// Reporter.log("---New user clicked ---", true);

		// Reading from Excel
		String name = ExcelUtility.getAdminCellData(12, 0);
		String role = ExcelUtility.getAdminCellData(12, 1);
		String email = ExcelUtility.getAdminCellData(12, 2);
		String password = ExcelUtility.getAdminCellData(12, 3);

		objUser.setUser(name);
		objUser.setuserRole(role);
		objUser.setEmail(email);
		objUser.setPassword(password);
		// Thread.sleep(4000);
		objUser.addNewUser();

		String lblname=objUser.getlblName();
		System.out.println("inside Name " + lblname   +"  "+AutomationConstants.UserName);
		Assert.assertEquals(lblname,AutomationConstants.UserName);
		//objUser.addNewUser();
		//Thread.sleep(1000);
		

	
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " : "+lblname);
		// wait.until(ExpectedConditions.alertIsPresent());
		
		CheckingAlerts();
		// driver.switchTo().alert().accept();
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");

	}

	@Test(priority = 2, enabled = true)
	public void newUserInvalidEmail() throws Exception {
		objUser = new userSignUp(driver);//

		// Reading from Excel

		String name = ExcelUtility.getAdminCellData(13, 0);
		String role = ExcelUtility.getAdminCellData(13, 1);
		String email = ExcelUtility.getAdminCellData(13, 2);
		String password = ExcelUtility.getAdminCellData(13, 3);
		objUser.setUser(name);
		objUser.setuserRole(role);
		objUser.setEmail(email);
		objUser.setPassword(password);
		objUser.setUser(name);
		objUser.setuserRole(role);
		objUser.setEmail(email);
		objUser.addNewUser();

		String lblname=objUser.getlEmail();
		//System.out.println("inside Name " + lblname   +"  "+AutomationConstants.u);
		Assert.assertEquals(lblname,AutomationConstants.Email);
		// Thread.sleep(4000);
		// logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
		// Explicit wait condition for alert
		// WaitHelper.waitForElementTobeVisible(driver,lblError,500);
//Thread.sleep(4000);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// WaitForAlerts();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.alertIsPresent());
		// Assert.assertEquals(driver.switchTo().alert().getText(),"User not found");
		// driver.switchTo().alert().accept();
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");


	}

	@Test(priority = 3, enabled = false)
	public void newUserInvalidPassword() throws Exception {
		objUser = new userSignUp(driver);//

		String name = ExcelUtility.getAdminCellData(14, 0);
		String role = ExcelUtility.getAdminCellData(14, 1);
		String email = ExcelUtility.getAdminCellData(14, 2);
		String password = ExcelUtility.getAdminCellData(14, 3);
		objUser.setUser(name);
		objUser.setuserRole(role);
		objUser.setEmail(email);
		objUser.addNewUser();

		//String lblname=objUser.();
		//System.out.println("inside Name " + lblname   +"  "+AutomationConstants.u);
		//Assert.assertEquals(lblname,AutomationConstants.Email);
		//objUser.setPassword(password);
		WaitForAlerts();
		// Thread.sleep(4000);
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");


		// logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
		// Explicit wait condition for alert
		// WaitHelper.waitForElementTobeVisible(driver,lblError,500);
//Thread.sleep(4000);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// WaitForAlerts();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.alertIsPresent());
		// Assert.assertEquals(driver.switchTo().alert().getText(),"User not found");
		// driver.switchTo().alert().accept();

	}

	@Test(priority = 4, enabled = false)
	public void newUserPasswordwithSpecialCharecter() throws Exception {
		objUser = new userSignUp(driver);//
		// Reporter.log("---New user clicked ---", true);

		String name = ExcelUtility.getAdminCellData(15, 0);
		String role = ExcelUtility.getAdminCellData(15, 1);
		String email = ExcelUtility.getAdminCellData(15, 2);
		String password = ExcelUtility.getAdminCellData(15, 3);
		objUser.setUser(name);
		objUser.setuserRole(role);
		objUser.setEmail(email);
		objUser.setPassword(password);
		// Thread.sleep(4000);
		objUser.addNewUser();
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");

		// logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
		// Explicit wait condition for alert
		// WaitHelper.waitForElementTobeVisible(driver,lblError,500);
//Thread.sleep(4000);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WaitForAlerts();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.alertIsPresent());
		// Assert.assertEquals(driver.switchTo().alert().getText(),"User not found");
		// driver.switchTo().alert().accept();

	}

	@Test(priority = 5, enabled = true)
	public void newUser() throws Exception {
		objUser = new userSignUp(driver);//
		String name = ExcelUtility.getAdminCellData(16, 0);
		String role = ExcelUtility.getAdminCellData(16, 1);
		String email = ExcelUtility.getAdminCellData(16, 2);
		String password = ExcelUtility.getAdminCellData(16, 3);
		objUser.setUser(name);
		objUser.setuserRole(role);
		objUser.setEmail(email);
		objUser.setPassword(password);
		// Thread.sleep(4000);
		objUser.addNewUser();
		logger.info(new Exception().getStackTrace()[0].getMethodName() + " : success");

		// logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
		// Explicit wait condition for alert
		// WaitHelper.waitForElementTobeVisible(driver,lblError,500);
//Thread.sleep(4000);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WaitForAlerts();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.alertIsPresent());
		// Assert.assertEquals(driver.switchTo().alert().getText(),"User not found");
		// driver.switchTo().alert().accept();

	}

	@Test(priority = 6, enabled = false)
	public void getText() throws IOException, InterruptedException {
		objUser = new userSignUp(driver);//
		//Reporter.log("---get mesg start---", true);
		try {
			String txt = objUser.getError();
		//	Reporter.log("---get mesg start---" + txt, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void WaitForAlerts() {
		WebDriverWait w = new WebDriverWait(driver, 50);
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

					//Reporter.log("---eoor mesg---" + actualError, true);
					if (actualError != null) {
						Assert.assertEquals(expectedError, actualError);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//	Reporter.log("---ALL attributes for New posts clicked ---", true);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void CheckingAlerts() {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertEquals(driver.switchTo().alert().getText(), "User Credentials already exist try again");
		driver.switchTo().alert().accept();
		// logger.info("User not found");

	}

}
