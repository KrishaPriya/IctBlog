package Scripts;


import Constants.AutomationConstants;
import PageObjects.*;
import Utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class TestNewPost extends TestBase{
    LoginPage objLogin;
    SignUpPage objSignUp;
    NewPostPage objNewPost;
    MyPostPage objMyPost;
    HomePage objHomePage;

    @AfterTest
    void afterTestDone(){
        objLogin = null;
        objMyPost = null;
        objSignUp = null;
        objNewPost = null;
    }


    @Test(priority = 1)
    public void verifyNewPost() throws IOException, InterruptedException {
        loginToUser();

        // Go to new post.
        objMyPost = new MyPostPage(driver);
        objMyPost.clickOnNewPost();

        Thread.sleep(WEBDRIVER_WAIT_TIME);

        for (int i = 4; i < 10; i++) {
            // update new post
            objNewPost=new NewPostPage(driver);
            String url = driver.getCurrentUrl();
            String Title=ExcelUtility.getCellData(i,0);
            String Image=ExcelUtility.getCellData(i,1);
            String Post=ExcelUtility.getCellData(i,2);
            objNewPost.setTitle(Title);
            objNewPost.setImage(Image);
            objNewPost.setCategory();
            objNewPost.setPost(Post);
            Thread.sleep(5000);
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

    private void loginToUser() throws InterruptedException, IOException {
        Actions act = new Actions(driver);
        objLogin = new LoginPage(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        objLogin.selectLoginDropdown();
        String username = ExcelUtility.getCellData(0, 0);
        String password = ExcelUtility.getCellData(0, 1);
        objLogin.setUserName(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();

        // Check the url
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals(strUrl,"http://64.227.132.106/mypost");

        // Check the title of page.
        String expectedTitle = AutomationConstants.HOMEPAGETITLE;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(WEBDRIVER_WAIT_TIME);

    }


}
