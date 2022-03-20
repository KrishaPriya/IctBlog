package Scripts.Trainer;

import Constants.AutomationConstants;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import PageObjects.Trainer.TrainerMyPostPage;
import PageObjects.Trainer.TrainerNewPostPage;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static Scripts.Utils.WEBDRIVER_WAIT_TIME;
import static Scripts.Utils.WEBDRIVER_WAIT_TIME_SEC;

public class TestTrainerLogin extends TestBase {
    LoginPage objLogin;
    SignUpPage objSignUp;
    TrainerNewPostPage objNewPost;
    TrainerMyPostPage objMyPost;
    HomePage objHomePage;
    Logger logger;

    public TestTrainerLogin() {
        super();
        logger = Logger.getLogger(TestTrainerLogin.class);
        BasicConfigurator.configure();
    }

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

        LoginPage.isPageLoaded(driver);
        objLogin = new LoginPage(driver);
        objLogin.clickLogin();
        //logger.info("Login button clicked");

        // user should be in login page only
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals(strUrl, "http://64.227.132.106/login");

        String usernameAssertExpectedTitle = AutomationConstants.USERNAME_ASSERTION;
        String usernameAssertActualTitle = objLogin.validationAssertUsername();
        Assert.assertEquals(usernameAssertExpectedTitle, usernameAssertActualTitle);

        String passwordAssertExpectedTitle = AutomationConstants.PASSWORD_ASSERTTION;
        String passwordAssertActualTitle = objLogin.passwordValidation();
        Assert.assertEquals(passwordAssertExpectedTitle, passwordAssertActualTitle);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }

    @Test(priority = 2)
    public void verifyValidUserWithoutPassword() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        LoginPage.isPageLoaded(driver);
        objLogin = new LoginPage(driver);
        String username = ExcelUtility.getTrainerCellData(1, 0);
        objLogin.setUserName(username);
      //  logger.info("Username entered");
        objLogin.clickLogin();
      //  logger.info("Login button clicked");

        // user should be in login page only
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals(strUrl, "http://64.227.132.106/login");

        String passwordAssertExpectedTitle = AutomationConstants.PASSWORD_ASSERTTION;
        String passwordAssertActualTitle = objLogin.passwordValidation();
        Assert.assertEquals(passwordAssertExpectedTitle, passwordAssertActualTitle);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }

    @Test(priority = 3)
    public void verifyInvalidUserInvalidPassword() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        LoginPage.isPageLoaded(driver);
        objLogin = new LoginPage(driver);
        String username = ExcelUtility.getTrainerCellData(4, 0);
        String password = ExcelUtility.getTrainerCellData(4, 1);
        objLogin.loginToUser(username, password);
        logger.info("Entered username and password");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WEBDRIVER_WAIT_TIME_SEC));

        WebDriverWait w = new WebDriverWait(driver, WEBDRIVER_WAIT_TIME_SEC);

        if (w.until(ExpectedConditions.alertIsPresent()) == null) {
            Assert.assertFalse(false, "We should have got alert");
        } else {
            Assert.assertEquals("User not found", driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
        }
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }

    @Test(priority = 4)
    public void verifyValidUserInvalidPassword() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        LoginPage.isPageLoaded(driver);
        objLogin = new LoginPage(driver);
        objLogin.clearUserName();
        objLogin.clearPwd();
        String username = ExcelUtility.getTrainerCellData(1, 0);
        String password = ExcelUtility.getTrainerCellData(1, 1);
        objLogin.loginToUser(username, password);
        logger.info("Entered username and password");

        // user should be in login page only
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals(strUrl, "http://64.227.132.106/login");
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");

    }

    @Test(priority = 5)
    public void findNoOfElementsInLoginPage() throws InterruptedException {
        //new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id("checkoutLink")));
        driver.navigate().refresh();
        objLogin= new LoginPage(driver);
        //  Thread.sleep(500);
        int headerlinks = objLogin.findNoOfElementsInHeader();
        System.out.println("Number of headerlinks is:" +headerlinks);
        Assert.assertEquals(headerlinks, 5);

        int noOfTextBoxes=objLogin.findNoOfTextBoxesInLogin();
        System.out.println("Number of textboxes is:" +noOfTextBoxes);
        Assert.assertEquals(noOfTextBoxes,2);



        int noOfButton=objLogin.findNoOfButtonInLogin();
        System.out.println("Number of button is:" +noOfButton);
        Assert.assertEquals(noOfButton,1);



        int noOfLinksInFooter=objLogin.findNoOfElementsInFooter();
        System.out.println("Number of links in footer is :" +noOfLinksInFooter);
        Assert.assertEquals(noOfLinksInFooter,3);
    }

    @Test(priority = 6)
    public void verifyValidLogin() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        LoginPage.isPageLoaded(driver);
        objLogin = new LoginPage(driver);
        objLogin.clearUserName();
        objLogin.clearPwd();
        String username = ExcelUtility.getTrainerCellData(0, 0);
        String password = ExcelUtility.getTrainerCellData(0, 1);
        objLogin.loginToUser(username, password);
      //  logger.info("Entered username and password");

        // Check the url
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals(strUrl, "http://64.227.132.106/mypost");
        // Check the title of page.
        String expectedTitle = AutomationConstants.HOME_PAGE_TITLE;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
        logoutAfterTest();

    }



   /* @Test(priority=4)
    public  void findNoOfTextBoxInLogin(){
        driver.navigate().refresh();
        objLogin= new LoginPage(driver);
        int noOfTextBoxes=objLogin.findNoOfTextBoxesInLogin();
        System.out.println(noOfTextBoxes);
        Assert.assertEquals(noOfTextBoxes,2);
    }

    @Test(priority = 5)
    public void findNoOfLinksInFooter(){
        driver.navigate().refresh();
        objLogin=new LoginPage(driver);
    }

    */
    private void logoutAfterTest() {
        TrainerMyPostPage.isPageLoaded(driver);
        // Logout
        objMyPost = new TrainerMyPostPage(driver);
        objMyPost.logout();

        // Check the url
        String homeUrl = driver.getCurrentUrl();
        Assert.assertEquals(homeUrl, "http://64.227.132.106/#");
    }
}

