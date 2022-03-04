package Scripts.Trainer;

import PageObjects.SignUpPage;
import Scripts.TestBase;
import Utilities.ExcelUtility;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestTrainerSignup extends TestBase {
   SignUpPage objSignUp;

   @Test(priority = 0)
   public void verifyValidSignUp() throws IOException, InterruptedException {
      driver.navigate().refresh();
      Actions act=new Actions(driver);
      objSignUp = new SignUpPage(driver);
      objSignUp.selectSignUpDrop();
      String User=ExcelUtility.getCellData(6,0);
      String Email=ExcelUtility.getCellData(6,1);
      String Password=ExcelUtility.getCellData(6,2);
      objSignUp.setName(User);
      objSignUp.setAccount();
      objSignUp.setQualification();
      objSignUp.setEmail(Email);
      objSignUp.setPassword(Password);
      Thread.sleep(7000);
      objSignUp.clickSubmit();
      String expectedTitle="successfully created an account login to continue.";
      String actualTitle=driver.switchTo().alert().getText();
      System.out.println(actualTitle);
      Assert.assertEquals(expectedTitle,actualTitle);
      Thread.sleep(7000);
   }

   @Test(priority = 1)
   public void verifySignUpWithAlreadyCreatedAccount() throws IOException, InterruptedException {
      driver.navigate().refresh();
      Actions act = new Actions(driver);
      objSignUp = new SignUpPage(driver);
      objSignUp.selectSignUpDrop();
      String User = ExcelUtility.getCellData(7, 0);
      String Email = ExcelUtility.getCellData(7, 1);
      String Password = ExcelUtility.getCellData(7, 2);
      objSignUp.setName(User);
      objSignUp.setAccount();
      objSignUp.setQualification();
      objSignUp.setEmail(Email);
      objSignUp.setPassword(Password);
      Thread.sleep(7000);
      objSignUp.clickSubmit();
      String expectedTitle = "User Credentials already exist try again";
      String actualTitle = driver.switchTo().alert().getText();
      System.out.println(actualTitle);
      Assert.assertEquals(expectedTitle, actualTitle);
      Thread.sleep(7000);
   }

   @Test(priority = 2)
   public void verifySignUpWithInvalidUserNameInvalidPassword() throws IOException, InterruptedException {
      driver.navigate().refresh();
      Actions act=new Actions(driver);
      objSignUp = new SignUpPage(driver);
      objSignUp.selectSignUpDrop();
      String User=ExcelUtility.getCellData(8,0);
      String Email=ExcelUtility.getCellData(8,1);
      String Password=ExcelUtility.getCellData(8,2);
      objSignUp.setName(User);
      objSignUp.setAccount();
      objSignUp.setQualification();
      objSignUp.setEmail(Email);
      objSignUp.setPassword(Password);
      Thread.sleep(7000);
      objSignUp.clickSubmit();
      String expectedTitle="Enter Valid Email";
      String actualTitle=objSignUp.validUserText();
      System.out.println(actualTitle);
      Assert.assertEquals(expectedTitle,actualTitle);
      String expectedPwdTitle="Password must contain 8 characters\n" +
              "(atleast one number one uppercase and one lowercase)\n";
      String actualPwdTitle=objSignUp.validPasswordText();
      Thread.sleep(7000);
   }





}






