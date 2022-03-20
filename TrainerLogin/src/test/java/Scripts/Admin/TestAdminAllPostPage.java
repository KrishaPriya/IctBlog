package Scripts.Admin;

import PageObjects.Admin.AllPostsPage;
import PageObjects.LoginPage;
import Scripts.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAdminAllPostPage extends TestBase {
    LoginPage login;
    AllPostsPage allPostsPage;
    @AfterTest
    void afterTest() {
        login = null;
        allPostsPage = null;
    }

    @Test(priority=1)
    public  void checkAllPostLandingPage() throws InterruptedException, IOException
    {
        login=new LoginPage(driver);
        Thread.sleep(2000);
        login.loginAsAdmin();

        Thread.sleep(2000);
        allPostsPage = new AllPostsPage(driver);
        String allpostText=allPostsPage.allposttext();
        Assert.assertEquals(allpostText,"All Posts");
    }
}
