package Scripts;

import Constants.AutomationConstants;
import PageObjects.LoginPage;
import PageObjects.MyPostPage;
import PageObjects.NewPostPage;
import PageObjects.SignUpPage;
import Utilities.ExcelUtility;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static Scripts.Utils.WEBDRIVER_WAIT_TIME;

public class TestLogin extends TestBase {
    LoginPage objLogin;
    SignUpPage objSignUp;
    NewPostPage objNewPost;
    MyPostPage objMyPost;


    @AfterTest
    void afterTest(){
        objLogin = null;
        objMyPost = null;
        objSignUp = null;
        objNewPost = null;
    }


    @Test(priority = 0)
    public void verifyInvalidUserInvalidPassword() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        objLogin = new LoginPage(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        objLogin.selectLoginDropdown();
        objLogin.setUserName("asdfsdfs");
        objLogin.setPassword("asdfasd");

        objLogin.clickLogin();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebDriverWait w = new WebDriverWait(driver, 2);

        if(w.until(ExpectedConditions.alertIsPresent())==null) {
            Assert.assertFalse(false, "We should have got alert");
        }
        else {
            Assert.assertEquals("User not found", driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
        }
    }

    @Test(priority = 1)
    public void verifyValidUserInvalidPassword() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        objLogin = new LoginPage(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        String username = ExcelUtility.getCellData(0, 0);
        String password = ExcelUtility.getCellData(0, 1);
        objLogin.setUserName(username);
        objLogin.setPassword("asdfdsaf");

        objLogin.clickLogin();

        // user should be in login page only
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals(strUrl,"http://64.227.132.106/login");

        driver.navigate().refresh();
    }

    @Test(priority = 2)
    public void verifyValidLogin() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        objLogin = new LoginPage(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
//        objLogin.selectLoginDropdown();
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

        logoutAfterTest();

    }

//    @Test(priority = 1)
//    public void verifyValidSignUp() throws IOException, InterruptedException {
//        Actions act = new Actions(driver);
//        objSignUp = new SignUpPage(driver);
//        objSignUp.selectSignUpDrop();
//        String User = ExcelUtility.getCellData(4, 0);
//        String Email = ExcelUtility.getCellData(4, 1);
//        String Password = ExcelUtility.getCellData(4, 2);
//        objSignUp.setName(User);
//        objSignUp.setAccount();
//        objSignUp.setQualification();
//        objSignUp.setEmail(Email);
//        objSignUp.setPassword(Password);
//        objSignUp.clickSubmit();
//        Thread.sleep(WEBDRIVER_WAIT_TIME);
//        String expectedTitle = AutomationConstants.SIGNUPPAGETITLE;
//        String actualTitle = objSignUp.setSignupHeader();
//
//
//        System.out.println(actualTitle);
//        Assert.assertEquals(expectedTitle, actualTitle);
//        Thread.sleep(WEBDRIVER_WAIT_TIME);
//
//        logoutAfterTest();
//    }


    private void logoutAfterTest() {
        // Logout
        objMyPost = new MyPostPage(driver);
        objMyPost.logout();

        // Check the url
        String homeUrl = driver.getCurrentUrl();
        Assert.assertEquals(homeUrl,"http://64.227.132.106/#");
    }

    /*@Test(priority = 1)
    public void verifyEditPost(){
        driver.navigate().refresh();
        objMyPost=new MyPostPage(driver);
        objMyPost.clickEdit();
        String expectedTitle= AutomationConstants.HOMEPAGETITLE;
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }



   @Test(priority = 1)
    public void verifyDeletePost(){
        driver.navigate().refresh();
       objMyPost= new MyPostPage(driver);
       objMyPost.clickDelete();
       String expectedTitle= AutomationConstants.MYPOSTTITLE;
       String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

   @Test(priority = 1)
    public void verifyNewPost() throws IOException, InterruptedException {
        driver.navigate().refresh();
        objNewPost=new NewPostPage(driver);
        objNewPost.setNewpost();
        String Title=ExcelUtility.getCellData(4,0);
        String Image=ExcelUtility.getCellData(4,1);
        String Post=ExcelUtility.getCellData(4,2);
        objNewPost.setTitle(Title);
        objNewPost.setImage(Image);
        objNewPost.setCategory();
        objNewPost.setPost(Post);
        objNewPost.clickSubmit();
        Thread.sleep(5000);
        String expectedTitle=AutomationConstants.NEWPOSTPAGETITLE;
        String  actualTitle=objNewPost.getHeading();
        Assert.assertEquals(expectedTitle,actualTitle);

    }*/

    /* @Test(priority = 1)
    public void verifyInValidLogin() throws IOException {
        driver.navigate().refresh();
        objLogin=new LoginPage(driver);
        String username= ExcelUtility.getCellData(1,0);
        String password=ExcelUtility.getCellData(1,1);
        objLogin.setUserName(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        String expectedTitle= AutomationConstants.HOMEPAGETITLE;
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }*/


}
