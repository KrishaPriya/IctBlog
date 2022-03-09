package Scripts.Trainer;

import Constants.AutomationConstants;
import PageObjects.Admin.AllPostsPage;
import PageObjects.LoginPage;
import Scripts.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestTrainerDeletePostInAdmin extends TestBase {

    LoginPage login;
    AllPostsPage allPostsPage;
    @AfterTest
    void afterTest() {
        login = null;
        allPostsPage = null;
    }

    @Test(priority=1)
    public  void deleteTrainerPostByAdminLogin() throws InterruptedException, IOException
    {
        login=new LoginPage(driver);
        Thread.sleep(2000);
        login.loginAsAdmin();

        Thread.sleep(2000);
        allPostsPage = new AllPostsPage(driver);
        String allposttext=allPostsPage.allposttext();
        String expectedText= AutomationConstants.ALL_POST_TITLE_TEXT;
        Assert.assertEquals(allposttext,expectedText);

        allPostsPage.deleteFirstPostByUser("krishna priya");
    }
}
