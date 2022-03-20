package Scripts.Trainer;

import Constants.AutomationConstants;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.Trainer.TrainerMyCategory;
import PageObjects.Trainer.TrainerMyPostPage;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestTrainerSortPostByCategory extends TestBase {
    TrainerMyPostPage objMyPost;
    TrainerMyCategory objMyCategory;
    LoginPage objLogin;

    Logger logger;

    public TestTrainerSortPostByCategory() {
        super();
        logger = Logger.getLogger(TestTrainerSortPostByCategory.class);

        BasicConfigurator.configure();
    }

    @Test(priority=0)
    public void validatePostByCategory() throws IOException, InterruptedException {
        loginToUser();
        TrainerMyPostPage.isPageLoaded(driver);
        objMyPost=new TrainerMyPostPage(driver);
        objMyPost.selectCategoriesDropdown("SPACE");
        logger.info("Space category is selected");


        TrainerMyCategory.isPageLoaded(driver,"SPACE");
        logger.info("Space navigation page is opened");
        objMyCategory = new TrainerMyCategory(driver);

        Assert.assertEquals(objMyCategory.getTitle(),"SPACE");
        Assert.assertEquals(objMyCategory.sortByCategoryCount("krishna priya"),2);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }


    public void loginToUser() throws IOException, InterruptedException {
        HomePage.isPageLoaded(driver);
        HomePage homePage = new HomePage(driver);
        homePage.selectLoginDropdown();

        LoginPage.isPageLoaded(driver);
        objLogin=new LoginPage(driver);
        objLogin.loginAsTrainer();

        String expectedTitle= AutomationConstants.HOME_PAGE_TITLE;
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }




}
