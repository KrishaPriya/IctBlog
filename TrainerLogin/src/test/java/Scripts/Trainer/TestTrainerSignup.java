package Scripts.Trainer;

import Constants.AutomationConstants;
import PageObjects.HomePage;
import PageObjects.SignUpPage;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
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
      //  Logger logger= LogManager.getLogger(TestTrainerSignup.class);
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
        logger.info("Entered username");
        objSignUp.setTrainerAccount();
        logger.info("Selected trainer account");
        objSignUp.setQualification();
        logger.info("Selected qualification");
        objSignUp.setEmail(Email);
        logger.info("Added email");
        objSignUp.setPassword(Password);
        logger.info("Added password");
        objSignUp.clickSubmit();
        logger.info("Submit button clicked");


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
        logger.info("Entered username");
        objSignUp.setTrainerAccount();
        logger.info("Selected trainer account");
        objSignUp.setQualification();
        logger.info("Selected qualification");
        objSignUp.setEmail(Email);
        logger.info("Entered email");
        objSignUp.setPassword(Password);
        logger.info("Entered password");


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
        logger.info("Entered username");
        objSignUp.setTrainerAccount();
        logger.info("Selected trainer account");
        objSignUp.setQualification();
        logger.info("Selected qualification");
        String expectedText=AutomationConstants.QUALIFICATION_MESSAGE;
        Assert.assertTrue(objSignUp.qualificationIsDisplayed(),expectedText);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }

//    @Test(priority = 3)
//    public void verifyNoQualificationForUserAccount() throws IOException, InterruptedException {
//        SignUpPage.isPageLoaded(driver);
//        objSignUp = new SignUpPage(driver);
//        objSignUp.clearTextFields();
//
//        String User = ExcelUtility.getTrainerCellData(8, 0);
//        objSignUp.setName(User);
//        logger.info("Entered username");
//        objSignUp.setUserAccount();
//        logger.info("Selected user account");
//         String expectedText=AutomationConstants.TRAINER_QUALIFICATION_MESSAGE;
//        Assert.assertFalse(objSignUp.qualificationIsDisplayed(),expectedText);
//        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
//    }

    @Test(priority = 4)
    public void findNoOfElementsInSignUpForTrainer(){
        objSignUp = new SignUpPage(driver);
        int noOfTextBoxes= objSignUp.findNoOfTextBoxes();
        System.out.println("Number of textboxes is:" +noOfTextBoxes);
        Assert.assertEquals(noOfTextBoxes,3);

        int noOfButton= objSignUp.findNoOfButton();
        System.out.println("Number of button is:" +noOfButton);
        Assert.assertEquals(noOfButton,1);

        int noOfDropdown= objSignUp.findNoOfDropdown();
        System.out.println("Number of dropdown is:" +noOfDropdown);
        Assert.assertEquals(noOfDropdown,2);
    }

    @Test(priority = 5)
    public void verifyValidSignUp() throws IOException, InterruptedException {
        SignUpPage.isPageLoaded(driver);
        objSignUp = new SignUpPage(driver);
        objSignUp.clearTextFields();

        String User = ExcelUtility.getTrainerCellData(6, 0);
        String Password = ExcelUtility.getTrainerCellData(6, 2);
        objSignUp.setName(User);
        logger.info("Entered username");
        objSignUp.setTrainerAccount();
        logger.info("Selected trainer account");
        objSignUp.setQualification();
        logger.info("Selected qualification");
        objSignUp.enterNewRandomMailId();
        logger.info("Mail id entered");
        objSignUp.setPassword(Password);
        logger.info("Entered password");
        objSignUp.clickSubmit();
        logger.info("Submit button clicked");

        WebDriverWait w = new WebDriverWait(driver, 2000);
        if(w.until(ExpectedConditions.alertIsPresent())==null) {
            logger.error("We should have got alert");
        }
        else {
            String actualTitle = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            String expectedTitle = AutomationConstants.SIGNUP_SUCCESS_MESSAGE;
            Assert.assertEquals(expectedTitle, actualTitle);
            logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
        }
    }
}




