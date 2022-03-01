package Scripts;

import Constants.AutomationConstants;
import PageObjects.LoginPage;
import PageObjects.MyPostPage;
import PageObjects.NewPostPage;
import PageObjects.SignUpPage;
import Utilities.ExcelUtility;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestLogin extends TestBase {
    LoginPage objLogin;
    SignUpPage objSignUp;
    NewPostPage objNewPost;
    MyPostPage objMyPost;


    @Test(priority = 0)
    public void verifyValidLogin() throws IOException, InterruptedException {


        driver.navigate().refresh();
        Actions act = new Actions(driver);
        objLogin = new LoginPage(driver);
        Thread.sleep(4000);
        objLogin.selectLoginDropdown();
        String username = ExcelUtility.getCellData(0, 0);
        String password = ExcelUtility.getCellData(0, 1);
        objLogin.setUserName(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        String expectedTitle = AutomationConstants.HOMEPAGETITLE;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(4000);


    }


    @Test(priority = 1)
    public void verifyValidSignUp() throws IOException, InterruptedException {
        driver.navigate().refresh();
        Actions act = new Actions(driver);
        objSignUp = new SignUpPage(driver);
        objSignUp.selectSignUpDrop();
        String User = ExcelUtility.getCellData(4, 0);
        String Email = ExcelUtility.getCellData(4, 1);
        String Password = ExcelUtility.getCellData(4, 2);
        objSignUp.setName(User);
        objSignUp.setAccount();
        objSignUp.setQualification();
        objSignUp.setEmail(Email);
        objSignUp.setPassword(Password);
        Thread.sleep(7000);
        objSignUp.clickSubmit();
        String expectedTitle = AutomationConstants.SIGNUPPAGETITLE;
        String actualTitle = objSignUp.setSignupHeader();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(7000);
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



   /* @Test(priority = 1)
    public void verifyDeletePost(){
        driver.navigate().refresh();
        objMyPost= new MyPostPage(driver);
        objMyPost.clickDelete();
        String expectedTitle= AutomationConstants.HOMEPAGETITLE;
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
