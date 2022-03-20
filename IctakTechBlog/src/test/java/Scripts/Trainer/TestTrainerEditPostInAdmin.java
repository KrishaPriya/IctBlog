package Scripts.Trainer;

import Constants.AutomationConstants;
import PageObjects.Admin.AllPostsPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.Trainer.TrainerEditPost;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static Scripts.Utils.WEBDRIVER_WAIT_TIME;

public class TestTrainerEditPostInAdmin extends TestBase {

    LoginPage login;
    AllPostsPage allPostsPage;
    TrainerEditPost objEdit;
    Logger logger;

    public TestTrainerEditPostInAdmin() {
        super();
        logger = Logger.getLogger(TestTrainerEditPostInAdmin.class);
        BasicConfigurator.configure();
    }


    @AfterTest
    void afterTest() {
        login = null;
        allPostsPage = null;
    }

    @Test(priority=1)
    public  void editTrainerPostByAdminLogin() throws InterruptedException, IOException
    {
        HomePage.isPageLoaded(driver);
        HomePage page = new HomePage(driver);
        page.selectLoginDropdown();

        LoginPage.isPageLoaded(driver);
        login=new LoginPage(driver);
        login.loginAsAdmin();
        logger.info("Admin login opened");

        AllPostsPage.isPageLoaded(driver);
        allPostsPage = new AllPostsPage(driver);
        String allposttext=allPostsPage.allposttext();
        Assert.assertEquals(allposttext,"All Posts");
        allPostsPage.editFirstPostByUser("krishna");


        TrainerEditPost.isPageLoaded(driver);
        objEdit = new TrainerEditPost(driver);
        String url=driver.getCurrentUrl();
        String title= ExcelUtility.getTrainerCellData(10,3);
        String image=ExcelUtility.getTrainerCellData(10,4);
        String post=ExcelUtility.getTrainerCellData(10,5);
        objEdit.setTitle(title);
        logger.info("Entered title");
        objEdit.setImage(image);
        logger.info("Entered image");
        objEdit.setPostDesc(post);
        logger.info("Added description");
        objEdit.setSubmit();

        // Accept Alert
        WebDriverWait w = new WebDriverWait(driver, 2000);
        if(w.until(ExpectedConditions.alertIsPresent())==null) {
            logger.error("We should have got alert");
        }
        else {
            String alertMessage=driver.switchTo().alert().getText();
            String expectedAlert= AutomationConstants.EDITED_ALERT;
            Assert.assertEquals(expectedAlert,alertMessage);
            driver.switchTo().alert().accept();
            logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
        }
    }
}