package Scripts.Admin;

import PageObjects.Admin.AdminMyPostsPage;
import PageObjects.Admin.AllPostsPage;
import PageObjects.LoginPage;
import Scripts.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAdminMyPostPage extends TestBase {
    LoginPage login;
    AllPostsPage allPostsPage;
    @AfterTest
    void afterTest() {
        login = null;
        allPostsPage = null;
    }

    @Test(priority=1)
    public  void checkMyPostLandingPage() throws InterruptedException, IOException
    {
        login=new LoginPage(driver);
        Thread.sleep(2000);
        login.loginAsAdmin();

        Thread.sleep(2000);
        allPostsPage = new AllPostsPage(driver);
        String allPostText=allPostsPage.allposttext();
        Assert.assertEquals(allPostText,"All Posts");
        allPostsPage.clickMyPosts();

        Thread.sleep(2000);
        AdminMyPostsPage adminMyPostsPage = new AdminMyPostsPage(driver);
        String myPostText = adminMyPostsPage.allposttext();
        Assert.assertEquals(myPostText,"My Posts");
    }
}
