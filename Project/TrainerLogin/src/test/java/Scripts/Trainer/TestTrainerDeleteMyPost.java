package Scripts.Trainer;

import Constants.AutomationConstants;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.Trainer.TrainerMyPostPage;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestTrainerDeleteMyPost extends TestBase {
    TrainerMyPostPage objMyPost;
    LoginPage objLogin;
    Logger logger;

    public TestTrainerDeleteMyPost() {
        super();
        logger = Logger.getLogger(TestTrainerDeleteMyPost.class);
        BasicConfigurator.configure();


    }

    @Test(priority=0)
  public void deletePost() throws IOException, InterruptedException {
      loginToUser();
      TrainerMyPostPage.isPageLoaded(driver);
      objMyPost=new TrainerMyPostPage(driver);
      int count = objMyPost.deleteAllPost();
      logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
  }

    /* @Test(priority = 0)
    public void deleteAllExistingPost() throws InterruptedException, IOException {
        loginToUser();
        // Go to new post.
        objMyPost = new TrainerMyPostPage(driver);
        objMyPost.deleteAllPost();
    }


    */
    @AfterTest
    void afterTestDone(){
        objMyPost = null;
    }

    public void loginToUser() throws IOException, InterruptedException {
        HomePage.isPageLoaded(driver);
        HomePage homePage = new HomePage(driver);
        homePage.selectLoginDropdown();

        LoginPage.isPageLoaded(driver);
        objLogin=new LoginPage(driver);
        String username= ExcelUtility.getTrainerCellData(0,0);
        String password=ExcelUtility.getTrainerCellData(0,1);
        objLogin.loginToUser(username,password);
        //logger.info("Entered username and password");
        String expectedTitle= AutomationConstants.HOME_PAGE_TITLE;
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }
/*
    private void loginToUser() throws InterruptedException, IOException {
        Actions act = new Actions(driver);
        objLogin = new LoginPage(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        objLogin.selectLoginDropdown();

        String username = ExcelUtility.getTrainerCellData(0, 0);
        String password = ExcelUtility.getTrainerCellData(0, 1);

        objLogin.loginToUser(username,password);

        // Check the url
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals(strUrl,"http://64.227.132.106/mypost");

        // Check the title of page.
        String expectedTitle = AutomationConstants.HOMEPAGETITLE;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(WEBDRIVER_WAIT_TIME);

    }


/*
    @Test(priority = 0)
    public void verifyEditPost(){
        driver.navigate().refresh();
        objMyPost=new MyPostPage(driver);
        objMyPost.clickEdit();
        //String Title= ExcelUtility.getCellData();
       // String Image=ExcelUtility.getCellData();
       // String Post=ExcelUtility.getCellData();
        objMyPost.setTitle(Title);
        objMyPost.setImage(Image);
        objMyPost.setPostDesc(Post);
        objMyPost.submit();
        String expectedTitle= AutomationConstants.HOMEPAGETITLE;
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
    */


//    @Test(priority = 1)
//    public void verifyDeletePost(){
//        driver.navigate().refresh();
//       objMyPost= new MyPostPage(driver);
//       objMyPost.clickDelete();
//       String expectedTitle= AutomationConstants.MYPOSTTITLE;
//       String actualTitle= driver.getTitle();
//        Assert.assertEquals(expectedTitle,actualTitle);
//    }
}