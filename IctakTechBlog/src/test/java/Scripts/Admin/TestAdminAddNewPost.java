package Scripts.Admin;

import PageObjects.Admin.ActionsPage;
import PageObjects.Admin.AllPostsPage;
import PageObjects.LoginPage;
import PageObjects.Trainer.TrainerNewPostPage;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static Scripts.Utils.WEBDRIVER_WAIT_TIME_SEC;

public class TestAdminAddNewPost extends TestBase {
    LoginPage login;
    AllPostsPage allPostsPage;
    TrainerNewPostPage objNewPost;
    ActionsPage actionsPage;

    @AfterTest
    void afterTest() {
        login = null;
        allPostsPage = null;
        objNewPost = null;
    }

    @Test(priority=1)
    public  void verifyAddNewPost() throws InterruptedException, IOException
    {
        login=new LoginPage(driver);
        Thread.sleep(2000);
        login.loginAsAdmin();

        Thread.sleep(2000);
        allPostsPage = new AllPostsPage(driver);
        String allposttext=allPostsPage.allposttext();
        Assert.assertEquals(allposttext,"All Posts");
        allPostsPage.selectactionsdropdown();

        Thread.sleep(2000);
        actionsPage=new ActionsPage(driver);
        String title = ExcelUtility.getAdminCellData(8, 0);
        String imageurl = ExcelUtility.getAdminCellData(8, 1);
        String post = ExcelUtility.getAdminCellData(8, 2);
        actionsPage.entertitle(title);
        actionsPage.enterimageurl(imageurl);
        actionsPage.selectcategory();
        actionsPage.enternewpost(post);
        Thread.sleep(2000);
        actionsPage.btnsubmit();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WEBDRIVER_WAIT_TIME_SEC));

        WebDriverWait w = new WebDriverWait(driver, 3);

        if(w.until(ExpectedConditions.alertIsPresent())==null) {
            Assert.assertFalse(false, "We should have got alert");
        }
        else {
            Assert.assertEquals("New Post Added", driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
        }
    }
}
