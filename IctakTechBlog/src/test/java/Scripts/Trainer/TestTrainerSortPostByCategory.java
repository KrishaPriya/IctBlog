package Scripts.Trainer;

import Constants.AutomationConstants;
import PageObjects.LoginPage;
import PageObjects.Trainer.TrainerMyCategory;
import PageObjects.Trainer.TrainerMyPostPage;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestTrainerSortPostByCategory extends TestBase {
    TrainerMyPostPage objMyPost;
    TrainerMyCategory objMyCategory;
    LoginPage objLogin;


    @Test(priority=0)
    public void validatePostByCategory() throws IOException, InterruptedException {
        loginToUser();
        Thread.sleep(2000);
        objMyPost=new TrainerMyPostPage(driver);
        objMyPost.selectCategoriesDropdown("SPACE");

        Thread.sleep(2000);
        objMyCategory = new TrainerMyCategory(driver);

        Assert.assertEquals(objMyCategory.getTitle(),"SPACE");
        Assert.assertEquals(objMyCategory.sortByCategoryCount("SPACE"),3);
    }


    public void loginToUser() throws IOException, InterruptedException {
        Actions act=new Actions(driver);
        objLogin=new LoginPage(driver);
        objLogin.loginAsTrainer();
        String expectedTitle= AutomationConstants.HOME_PAGE_TITLE;
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }


}
