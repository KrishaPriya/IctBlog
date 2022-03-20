package com.Techblog1.scripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Techblog1.pages.HomePage;
import com.Techblog1.pages.LoginPage;

public class LoginPageTest extends TestBase  {
	 Logger logger=LogManager.getLogger(LoginPageTest.class);
	LoginPage objLogin;
	HomePage homePage;
	@Test(priority=1)
	public void verifyLogin() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        objLogin = new LoginPage(driver);
        objLogin .selectLoginDropdownLogin();  
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals(strUrl,"http://icttechblog.herokuapp.com/login");
        logger.info("Form to login opened sucessfully");
	}
	@Test(priority=2)
	  public void verifySignup() throws IOException, InterruptedException {
		  Actions act = new Actions(driver); 
		  objLogin = new LoginPage(driver);
		  objLogin .selectLoginDropdownSignUp();  
          String strUrl = driver.getCurrentUrl();
          Assert.assertEquals(strUrl,"http://icttechblog.herokuapp.com/signup");
          logger.info("Form to signup opened sucessfully");
	} 

	 

    }
	
