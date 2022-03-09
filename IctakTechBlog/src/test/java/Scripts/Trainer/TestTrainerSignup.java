package Scripts.Trainer;

import Constants.AutomationConstants;
import PageObjects.SignUpPage;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static Scripts.Utils.WEBDRIVER_WAIT_TIME;

public class TestTrainerSignup extends TestBase {
    SignUpPage objSignUp;

    @AfterTest
    public void resetTrainerSignup(){
        objSignUp = null;
    }

    @Test(priority = 0)
    public void verifySignUpWithAlreadyCreatedAccount() throws IOException, InterruptedException {
        objSignUp = new SignUpPage(driver);
        objSignUp.selectSignUpDrop();
        String User = ExcelUtility.getTrainerCellData(7, 0);
        String Email = ExcelUtility.getTrainerCellData(7, 1);
        String Password = ExcelUtility.getTrainerCellData(7, 2);
        objSignUp.setName(User);
        objSignUp.setTrainerAccount();
        objSignUp.setQualification();
        objSignUp.setEmail(Email);
        objSignUp.setPassword(Password);
        objSignUp.clickSubmit();

        Thread.sleep(1000);
        String expectedTitle = AutomationConstants.SIGNUP_MESSAGE_FOR_EXISTING_ACCOUNT;
        String actualTitle = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(1000);
    }


    @Test(priority = 1)
    public void verifySignUpWithInvalidUserNameInvalidPassword() throws IOException, InterruptedException {
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

    }

    @Test(priority = 3)
    public void verifyNoQualificationForUserAccount() throws IOException, InterruptedException {
        objSignUp = new SignUpPage(driver);
        objSignUp.clearTextFields();

        String User = ExcelUtility.getTrainerCellData(8, 0);
        objSignUp.setName(User);
        objSignUp.setUserAccount();
         String expectedText=AutomationConstants.TRAINER_QUALIFICATION_MESSAGE;
        Assert.assertFalse(objSignUp.qualificationIsDisplayed(),expectedText);
    }

    @Test(priority = 4)
    public void verifyValidSignUp() throws IOException, InterruptedException {
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
    }
}




