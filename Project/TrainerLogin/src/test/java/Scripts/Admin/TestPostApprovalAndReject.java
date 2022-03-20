package Scripts.Admin;

import PageObjects.Admin.AllPostsPage;
import PageObjects.Admin.PostApprovalReject;
import PageObjects.LoginPage;
import Scripts.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestPostApprovalAndReject extends TestBase {
    LoginPage login;
    AllPostsPage allPostsPage;

    @AfterTest
    void afterTest() {
        login = null;
        allPostsPage = null;
    }

    @Test(priority=1)
    public  void verifyApprovalLandingPage() throws InterruptedException, IOException {
        login = new LoginPage(driver);
        Thread.sleep(2000);
        login.loginAsAdmin();

        Thread.sleep(2000);
        allPostsPage = new AllPostsPage(driver);
        String allposttext = allPostsPage.allposttext();
        Assert.assertEquals(allposttext, "All Posts");
        allPostsPage.selectPendingApprvalDropDown();

        Thread.sleep(2000);
        PostApprovalReject postApprovalReject =  new PostApprovalReject(driver);
        String title = postApprovalReject.getTitleOfPage();
        Assert.assertEquals(title, "Pending Approvals");
    }
}
