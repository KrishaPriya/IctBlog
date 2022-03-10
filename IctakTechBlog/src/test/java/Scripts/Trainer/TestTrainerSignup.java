package Scripts.Trainer;

import Constants.AutomationConstants;
import PageObjects.HomePage;
import PageObjects.SignUpPage;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static Scripts.Utils.WEBDRIVER_WAIT_TIME;

public class TestTrainerSignup extends TestBase {
    SignUpPage objSignUp;

    Logger logger;

    public TestTrainerSignup() {
        super();
        logger = Logger.getLogger(TestTrainerSignup.class);
        BasicConfigurator.configure();
    }

    @AfterTest
    public void resetTrainerSignup(){
        objSignUp = null;
    }

    @Test(priority = 0)
    public void verifySignUpWithAlreadyCreatedAccount() throws IOException, InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.selectSignUpDropdown();

        SignUpPage.isPageLoaded(driver);
        objSignUp = new SignUpPage(driver);
        String User = ExcelUtility.getTrainerCellData(7, 0);
        String Email = ExcelUtility.getTrainerCellData(7, 1);
        String Password = ExcelUtility.getTrainerCellData(7, 2);
        objSignUp.setName(User);
        objSignUp.setTrainerAccount();
        objSignUp.setQualification();
        objSignUp.setEmail(Email);
        objSignUp.setPassword(Password);
        objSignUp.clickSubmit();


        // Accept Alert
        WebDriverWait w = new WebDriverWait(driver, 2000);
        if(w.until(ExpectedConditions.alertIsPresent())==null) {
            logger.error("We should have got alert");
        }
        else {
            String expectedTitle = AutomationConstants.SIGNUP_MESSAGE_FOR_EXISTING_ACCOUNT;
            String actualTitle = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            logger.info(actualTitle);
            Assert.assertEquals(expectedTitle, actualTitle);
            logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
        }

    }


    @Test(priority = 1)
    public void verifySignUpWithInvalidUserNameInvalidPassword() throws IOException, InterruptedException {
        SignUpPage.isPageLoaded(driver);
        objSignUp = new SignUpPage(driver);
        objSignUp.clearTextFields();

        String User = ExcelUtility.getTrainerCellData(8, 0);
        String Email = ExcelUtility.getTrainerCellData(8, 1);
        String Password = ExcelUtility.getTrainerCellData(8, 2);
        objSignUp.setName(User);
        objSignUp.setTrainerAccount();
        objSignUp.setQualification();
        objSignUp.setEmail(Email);
        objSignUp.setPassword(Password);


        String expectedTitle = AutomationConstants.SIGNUP_EMAIL_VALIDATION_TEXT;
        String actualTitle = objSignUp.validUserText();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle, actualTitle);
        String expectedPwdTitle = AutomationConstants.PASSWORD_VALIDATION_TEXT;
        String actualPwdTitle = objSignUp.validPasswordText();
        Assert.assertEquals(expectedPwdTitle, actualPwdTitle);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");

    }

    @Test(priority = 2)
    public void verifyQualificationForTrainerAccount() throws IOException, InterruptedException {
        objSignUp = new SignUpPage(driver);
        objSignUp.clearTextFields();

        String User = ExcelUtility.getTrainerCellData(8, 0);
        objSignUp.setName(User);
        objSignUp.setTrainerAccount();
        objSignUp.setQualification();
        String expectedText=AutomationConstants.QUALIFICATION_MESSAGE;
        Assert.assertTrue(objSignUp.qualificationIsDisplayed(),expectedText);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }

    @Test(priority = 3)
    public void verifyNoQualificationForUserAccount() throws IOException, InterruptedException {
        SignUpPage.isPageLoaded(driver);
        objSignUp = new SignUpPage(driver);
        objSignUp.clearTextFields();

        String User = ExcelUtility.getTrainerCellData(8, 0);
        objSignUp.setName(User);
        objSignUp.setUserAccount();
         String expectedText=AutomationConstants.TRAINER_QUALIFICATION_MESSAGE;
        Assert.assertFalse(objSignUp.qualificationIsDisplayed(),expectedText);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }

    @Test(priority = 4)
    public void verifyValidSignUp() throws IOException, InterruptedException {
        SignUpPage.isPageLoaded(driver);
        objSignUp = new SignUpPage(driver);
        objSignUp.clearTextFields();

        String User = ExcelUtility.getTrainerCellData(6, 0);
        String Password = ExcelUtility.getTrainerCellData(6, 2);
        objSignUp.setName(User);
        objSignUp.setTrainerAccount();
        objSignUp.setQualification();
        objSignUp.enterNewRandomMailId();
        objSignUp.setPassword(Password);
        objSignUp.clickSubmit();

        Thread.sleep(WEBDRIVER_WAIT_TIME);
        String actualTitle = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        String expectedTitle = AutomationConstants.SIGNUP_SUCCESS_MESSAGE;
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }
}




