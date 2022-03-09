package Scripts.Trainer;

import Constants.AutomationConstants;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import PageObjects.Trainer.TrainerMyPostPage;
import PageObjects.Trainer.TrainerNewPostPage;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static Scripts.Utils.WEBDRIVER_WAIT_TIME;
import static Scripts.Utils.WEBDRIVER_WAIT_TIME_SEC;

public class TestTrainerLogin extends TestBase {
    LoginPage objLogin;
    SignUpPage objSignUp;
    TrainerNewPostPage objNewPost;
    TrainerMyPostPage objMyPost;
    HomePage objHomePage;

    @AfterTest
    void afterTest() {
        objLogin = null;
        objMyPost = null;
        objSignUp = null;
        objNewPost = null;
        objHomePage = null;
    }


    @Test(priority = 1)
    public void verifyLoginWithoutUsernameWithoutPassword() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        objHomePage = new HomePage(driver);
        objHomePage.selectLoginDropdown();

        Thread.sleep(WEBDRIVER_WAIT_TIME);
        objLogin = new LoginPage(driver);
        objLogin.clickLogin();

        // user should be in login page only
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals(strUrl, "http://64.227.132.106/login");
        Thread.sleep(WEBDRIVER_WAIT_TIME);

        String usernameAssertExpectedTitle = AutomationConstants.USERNAME_ASSERTION;
        String usernameAssertActualTitle = objLogin.validationAssertUsername();
        Assert.assertEquals(usernameAssertExpectedTitle, usernameAssertActualTitle);

        String passwordAssertExpectedTitle = AutomationConstants.PASSWORD_ASSERTTION;
        String passwordAssertActualTitle = objLogin.passwordValidation();
        Assert.assertEquals(passwordAssertExpectedTitle, passwordAssertActualTitle);

    }

    @Test(priority = 2)
    public void verifyValidUserWithoutPassword() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        objLogin = new LoginPage(driver);

        Thread.sleep(WEBDRIVER_WAIT_TIME);
        String username = ExcelUtility.getTrainerCellData(1, 0);
        objLogin.setUserName(username);
        objLogin.clickLogin();

        // user should be in login page only
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals(strUrl, "http://64.227.132.106/login");
        Thread.sleep(WEBDRIVER_WAIT_TIME);

        String passwordAssertExpectedTitle = AutomationConstants.PASSWORD_ASSERTTION;
        String passwordAssertActualTitle = objLogin.passwordValidation();
        Assert.assertEquals(passwordAssertExpectedTitle, passwordAssertActualTitle);
    }

    @Test(priority = 3)
    public void verifyInvalidUserInvalidPassword() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        objLogin = new LoginPage(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        String username = ExcelUtility.getTrainerCellData(4, 0);
        String password = ExcelUtility.getTrainerCellData(4, 1);
        objLogin.loginToUser(username, password);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WEBDRIVER_WAIT_TIME_SEC));

        WebDriverWait w = new WebDriverWait(driver, WEBDRIVER_WAIT_TIME_SEC);

        if (w.until(ExpectedConditions.alertIsPresent()) == null) {
            Assert.assertFalse(false, "We should have got alert");
        } else {
            Assert.assertEquals("User not found", driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
        }
    }

    @Test(priority = 4)
    public void verifyValidUserInvalidPassword() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        objLogin = new LoginPage(driver);
        objLogin.clearUserName();
        objLogin.clearPwd();
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        String username = ExcelUtility.getTrainerCellData(1, 0);
        String password = ExcelUtility.getTrainerCellData(1, 1);
        objLogin.loginToUser(username, password);

        // user should be in login page only
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals(strUrl, "http://64.227.132.106/login");

    }

    @Test(priority = 5)
    public void verifyValidLogin() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        objLogin = new LoginPage(driver);
        objLogin.clearUserName();
        objLogin.clearPwd();
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        String username = ExcelUtility.getTrainerCellData(0, 0);
        String password = ExcelUtility.getTrainerCellData(0, 1);
        objLogin.loginToUser(username, password);

        // Check the url
        String strUrl = driver.getCurrentUrl();
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        Assert.assertEquals(strUrl, "http://64.227.132.106/mypost");
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        // Check the title of page.
        String expectedTitle = AutomationConstants.HOME_PAGE_TITLE;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        logoutAfterTest();
    }


    private void logoutAfterTest() {
        // Logout
        objMyPost = new TrainerMyPostPage(driver);
        objMyPost.logout();

        // Check the url
        String homeUrl = driver.getCurrentUrl();
        Assert.assertEquals(homeUrl, "http://64.227.132.106/#");
    }
}

