package Scripts;

import PageObjects.HomePage;
import Scripts.Trainer.TestTrainerDeleteMyPost;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Scripts.Utils.WEBDRIVER_WAIT_TIME;

public class TestHomePage extends TestBase{
    HomePage homePage;
    Logger logger;

    public TestHomePage() {
        super();
        logger = Logger.getLogger(TestHomePage.class);
        BasicConfigurator.configure();
    }


    @Test(priority=1)
    public void verifyHomePageLogo() throws InterruptedException {
        // Actions act = new Actions(driver);
        homePage = new HomePage(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        boolean flag = homePage.setLogo();
        Assert.assertTrue(flag);

    }
    @Test(priority=2)
    public void categorydropdown() throws InterruptedException {
        homePage=new HomePage(driver);
        Thread.sleep(500);
        homePage.selectCategoriesDropdown();


    }

}

