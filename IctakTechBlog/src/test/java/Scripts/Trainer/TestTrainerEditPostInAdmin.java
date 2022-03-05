package Scripts.Trainer;

import Constants.AutomationConstants;
import PageObjects.Admin.AllPostsPage;
import PageObjects.LoginPage;
import PageObjects.Trainer.TrainerEditPost;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static Scripts.Utils.WEBDRIVER_WAIT_TIME;

public class TestTrainerEditPostInAdmin extends TestBase {

    LoginPage login;
    AllPostsPage allPostsPage;
    TrainerEditPost objEdit;
    @AfterTest
    void afterTest() {
        login = null;
        allPostsPage = null;
    }

    @Test(priority=1)
    public  void editTrainerPostByAdminLogin() throws InterruptedException, IOException
    {
        login=new LoginPage(driver);
        Thread.sleep(2000);
        login.loginAsAdmin();

        Thread.sleep(2000);
        allPostsPage = new AllPostsPage(driver);
        String allposttext=allPostsPage.allposttext();
        Assert.assertEquals(allposttext,"All Posts");

        allPostsPage.editFirstPostByUser("krishna");

        Thread.sleep(5000);
        objEdit = new TrainerEditPost(driver);
        String url=driver.getCurrentUrl();
        String title= ExcelUtility.getTrainerCellData(10,3);
        String image=ExcelUtility.getTrainerCellData(10,4);
        String post=ExcelUtility.getTrainerCellData(10,5);
        objEdit.setTitle(title);
        objEdit.setImage(image);
        objEdit.setPostDesc(post);
        objEdit.setSubmit();
        String alertMessage=driver.switchTo().alert().getText();
        String expectedAlert= AutomationConstants.EDITEDALERT;
        Assert.assertEquals(expectedAlert,alertMessage);
        Alert al=driver.switchTo().alert();
        al.accept();
        Thread.sleep(WEBDRIVER_WAIT_TIME);
    }
}