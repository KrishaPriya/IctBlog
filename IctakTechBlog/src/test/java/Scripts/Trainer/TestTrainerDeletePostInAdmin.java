package Scripts.Trainer;

import Constants.AutomationConstants;
import PageObjects.Admin.AllPostsPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Scripts.TestBase;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestTrainerDeletePostInAdmin extends TestBase {

    LoginPage login;
    AllPostsPage allPostsPage;
    Logger logger;
    public TestTrainerDeletePostInAdmin() {
        super();
        logger = Logger.getLogger(TestTrainerDeletePostInAdmin.class);
        BasicConfigurator.configure();
    }

    @AfterTest
    void afterTest() {
        login = null;
        allPostsPage = null;
    }

    @Test(priority=1)
    public  void deleteTrainerPostByAdminLogin() throws InterruptedException, IOException
    {
        HomePage.isPageLoaded(driver);
        HomePage homePage = new HomePage(driver);
        homePage.selectLoginDropdown();

        LoginPage.isPageLoaded(driver);
        login=new LoginPage(driver);
        login.loginAsAdmin();

        Thread.sleep(2000);
        allPostsPage = new AllPostsPage(driver);
        String allposttext=allPostsPage.allposttext();
        String expectedText= AutomationConstants.ALL_POST_TITLE_TEXT;
        Assert.assertEquals(allposttext,expectedText);

        allPostsPage.deleteFirstPostByUser("krishna priya");
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }
}
