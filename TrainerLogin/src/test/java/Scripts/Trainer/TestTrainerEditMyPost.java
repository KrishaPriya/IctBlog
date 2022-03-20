package Scripts.Trainer;

import Constants.AutomationConstants;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.Trainer.TrainerEditPost;
import PageObjects.Trainer.TrainerMyPostPage;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Scripts.Utils.WEBDRIVER_WAIT_TIME;

public class TestTrainerEditMyPost extends TestBase {
    LoginPage objLogin;
    TrainerMyPostPage objMyPost;
    TrainerEditPost objEdit;
    HomePage objHome;
    Logger logger;

    public TestTrainerEditMyPost() {
        super();
        logger = Logger.getLogger(TestTrainerEditMyPost.class);
        BasicConfigurator.configure();
    }


    @Test(priority = 1)
    public void verifyEditMyPost() throws IOException, InterruptedException {
        loginToUser();

        TrainerMyPostPage.isPageLoaded(driver);
        objMyPost = new TrainerMyPostPage(driver);
        objMyPost.editMyPost();

        TrainerEditPost.isPageLoaded(driver);
        objEdit = new TrainerEditPost(driver);
        String url = driver.getCurrentUrl();
        String title = ExcelUtility.getTrainerCellData(10, 3);
        String image = ExcelUtility.getTrainerCellData(10, 4);
        String post = ExcelUtility.getTrainerCellData(10, 5);
        objEdit.setTitle(title);
        logger.info("Entered title");
        objEdit.setImage(image);
        logger.info("Entered image");
        objEdit.setPostDesc(post);
        logger.info("Entered description");
        objEdit.setSubmit();
        logger.info("Clicked on submit");

        // Accept Alert
        WebDriverWait w = new WebDriverWait(driver, 2000);
        if(w.until(ExpectedConditions.alertIsPresent())==null) {
            logger.error("We should have got alert");
        }
        else {
            String alertMessage = driver.switchTo().alert().getText();
            String expectedAlert = AutomationConstants.EDITED_ALERT;
            Assert.assertEquals(expectedAlert, alertMessage);
            driver.switchTo().alert().accept();

        }
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }

    @Test(priority = 2)
    public void verifyEditMyPostWithInvalidData() throws InterruptedException, IOException {
        HomePage.isPageLoaded(driver);
        objHome = new HomePage(driver);
        objHome.clickOnMyPost();

        TrainerMyPostPage.isPageLoaded(driver);
        objMyPost = new TrainerMyPostPage(driver);
        objMyPost.editMyPost();

        TrainerEditPost.isPageLoaded(driver);
        objEdit = new TrainerEditPost(driver);
        String title = "HI";
        String image = " ";
        String post = "";
        objEdit.setTitle(title);
        //logger.info("Entered title");
        objEdit.setImage(image);
        //logger.info("Entered image");
        objEdit.setPostDesc(post);
        //logger.info("Entered description");

        Assert.assertEquals(objEdit.btnSubmitNotEnabled(), true);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }

    public void loginToUser() throws IOException, InterruptedException {

        HomePage.isPageLoaded(driver);
        HomePage homePage = new HomePage(driver);
        homePage.selectLoginDropdown();

        LoginPage.isPageLoaded(driver);
        objLogin=new LoginPage(driver);
        String username= ExcelUtility.getTrainerCellData(0,0);
        String password=ExcelUtility.getTrainerCellData(0,1);
        objLogin.loginToUser(username,password);
        //logger.info("Entered username and password");
        String expectedTitle= AutomationConstants.HOME_PAGE_TITLE;
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }

}
