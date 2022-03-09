package Scripts.Trainer;


import Constants.AutomationConstants;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import PageObjects.Trainer.TrainerMyPostPage;
import PageObjects.Trainer.TrainerNewPostPage;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static Scripts.Utils.WEBDRIVER_WAIT_TIME;
import static Scripts.Utils.WEBDRIVER_WAIT_TIME_SEC;

public class TestTrainerNewPost extends TestBase {
    LoginPage objLogin;
    SignUpPage objSignUp;
    TrainerNewPostPage objNewPost;
    TrainerMyPostPage objMyPost;
    HomePage objHomePage;


    @AfterTest
    void afterTestDone() {
        objLogin = null;
        objMyPost = null;
        objSignUp = null;
        objNewPost = null;
    }


//    @Test(priority = 0)
//    public void AddNewPost() throws IOException, InterruptedException {
//        loginToUser();
//        objMyPost = new TrainerMyPostPage(driver);
//        objMyPost.clickOnNewPost();
//        Thread.sleep(WEBDRIVER_WAIT_TIME);
//        objNewPost = new TrainerNewPostPage(driver);
//        String url = driver.getCurrentUrl();
//        String title = ExcelUtility.getTrainerCellData(16, 0);
//        String image = ExcelUtility.getTrainerCellData(16, 1);
//        String post = ExcelUtility.getTrainerCellData(16, 2);
//        objNewPost.setTitle(title);
//        objNewPost.setImage(image);
//        objNewPost.setCategory();
//        Thread.sleep(WEBDRIVER_WAIT_TIME);
//        objNewPost.setPost(post);
//        Thread.sleep(1000);
//        objNewPost.clickSubmit();
//        Thread.sleep(1000);
//        String expectedMessage = "New Post Added";
//        Thread.sleep(1000);
//        String actualMessage = driver.switchTo().alert().getText();
//        Thread.sleep(1000);
//        Assert.assertEquals(expectedMessage, actualMessage);
//        driver.switchTo().alert().accept();
//        Thread.sleep(WEBDRIVER_WAIT_TIME);
//
//    }

//    @Test(priority = 2)
//    public void addNewPostWithInvalidData() throws InterruptedException, IOException {
//        //   objHomePage=new HomePage(driver);
//        //objHomePage.clickOnNewPost();
//        Thread.sleep(WEBDRIVER_WAIT_TIME);
//        //objNewPost=new TrainerNewPostPage(driver);
//        String url = driver.getCurrentUrl();
//        driver.get(url);
//        Thread.sleep(WEBDRIVER_WAIT_TIME);
//        String title = ExcelUtility.getTrainerCellData(16, 0);
//        String image = "";
//        String post = "";
//        Thread.sleep(WEBDRIVER_WAIT_TIME);
//        objNewPost.setTitle(title);
//        objNewPost.setImage(image);
//        objNewPost.setCategory();
//        objNewPost.setPost(post);
//        Thread.sleep(1000);
//        objNewPost.clickSubmit();
//        Thread.sleep(1000);
//        Assert.assertFalse(objNewPost.btnSubmitNotEnabled());
//        driver.get(url);
//
//    }



    @Test(priority = 1)
    public void addingNewPost() throws IOException, InterruptedException {
        loginToUser();
        Thread.sleep(WEBDRIVER_WAIT_TIME);

        // Go to new post.
        objMyPost = new TrainerMyPostPage(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        objMyPost.clickOnNewPost();

        Thread.sleep(WEBDRIVER_WAIT_TIME);

        for (int i = 9; i < 11; i++) {
            // update new post
            objNewPost=new TrainerNewPostPage(driver);
            String url = driver.getCurrentUrl();
            String Title=ExcelUtility.getTrainerCellData(i,0);
            String Image=ExcelUtility.getTrainerCellData(i,1);
            String Post=ExcelUtility.getTrainerCellData(i,2);
            objNewPost.setTitle(Title);
            objNewPost.setImage(Image);
            objNewPost.setCategory();
            objNewPost.setPost(Post);
            Thread.sleep(2000);
            objNewPost.clickSubmit();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WEBDRIVER_WAIT_TIME_SEC));

            WebDriverWait w = new WebDriverWait(driver, 3);

            if(w.until(ExpectedConditions.alertIsPresent())==null) {
                Assert.assertFalse(false, "We should have got alert");
            }
            else {
                Assert.assertEquals("New Post Added", driver.switchTo().alert().getText());
                driver.switchTo().alert().accept();
            }

            driver.get(url);
        }
    }

    @Test(priority = 2)
    public void addNewPostWithInvalidData() throws InterruptedException, IOException {
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        objNewPost=new TrainerNewPostPage(driver);

        String title = ExcelUtility.getTrainerCellData(16, 0);
        String image = "";
        String post = "";
        Thread.sleep(1000);
        objNewPost.setTitle(title);
        objNewPost.setImage(image);
        objNewPost.setCategory();
        objNewPost.setPost(post);
        //Thread.sleep(2000);
        objNewPost.clickSubmit();
        Thread.sleep(2000);
        boolean value = objNewPost.btnSubmitNotEnabled();
        Assert.assertEquals(value, false);
       Thread.sleep(1000);
    }



    public void loginToUser() throws IOException, InterruptedException {
        driver.navigate().refresh();

        Actions act = new Actions(driver);
        objLogin = new LoginPage(driver);
        //Thread.sleep(500);
        objLogin.selectLoginDropdown();
        String username = ExcelUtility.getTrainerCellData(0, 0);
        String password = ExcelUtility.getTrainerCellData(0, 1);
        objLogin.loginToUser(username, password);
        String expectedTitle = AutomationConstants.HOME_PAGE_TITLE;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }


}
