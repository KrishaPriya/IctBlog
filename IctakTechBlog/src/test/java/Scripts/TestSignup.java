package Scripts;

import Constants.AutomationConstants;
import PageObjects.SignUpPage;
import Utilities.ExcelUtility;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestSignup extends TestBase {
   SignUpPage objSignUp;

   @Test(priority = 1)
   public void verifyValidSignUp() throws IOException, InterruptedException {
      driver.navigate().refresh();
      Actions act=new Actions(driver);
      objSignUp = new SignUpPage(driver);
      objSignUp.selectSignUpDrop();
      String User=ExcelUtility.getCellData(3,0);
      String Email=ExcelUtility.getCellData(3,1);
      String Password=ExcelUtility.getCellData(3,2);
      objSignUp.setName(User);
      objSignUp.setAccount();
      objSignUp.setQualification();
      objSignUp.setEmail(Email);
      objSignUp.setPassword(Password);
      Thread.sleep(7000);
      objSignUp.clickSubmit();
      String expectedTitle=AutomationConstants.SIGNUPPAGETITLE;
      String actualTitle=objSignUp.setSignupHeader();
      System.out.println(actualTitle);
      Assert.assertEquals(expectedTitle,actualTitle);
      Thread.sleep(7000);
   }


   }






