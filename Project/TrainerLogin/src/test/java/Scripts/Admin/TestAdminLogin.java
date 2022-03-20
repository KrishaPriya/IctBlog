package Scripts.Admin;

import PageObjects.Admin.AdminMyPostsPage;
import PageObjects.Admin.AllPostsPage;
import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import PageObjects.Trainer.TrainerMyPostPage;
import PageObjects.Trainer.TrainerNewPostPage;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAdminLogin extends TestBase {
    LoginPage login;
    AllPostsPage allPostsPage;
    @AfterTest
    void afterTest() {
        login = null;
        allPostsPage = null;
    }

    @Test(priority=1)
    public  void verifyValidAdminValidPassword() throws InterruptedException, IOException
    {
        login=new LoginPage(driver);
        Thread.sleep(2000);
        login.loginAsAdmin();

        Thread.sleep(2000);
        allPostsPage = new AllPostsPage(driver);
        String allposttext=allPostsPage.allposttext();
        Assert.assertEquals(allposttext,"All Posts");

        // Logout
        allPostsPage.logout();

        // Check the url after logout to validate its success
        Thread.sleep(2000);
        String homeUrl = driver.getCurrentUrl();
        Assert.assertEquals(homeUrl, "http://64.227.132.106/#");
    }

}

