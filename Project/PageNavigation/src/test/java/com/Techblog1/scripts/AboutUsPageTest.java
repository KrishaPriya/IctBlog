package com.Techblog1.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Techblog1.pages.AboutUsPage;
import com.Techblog1.pages.HomePage;
import com.Techblog1.utilities.PageUtility;

public class AboutUsPageTest extends TestBase{
	  Logger logger=LogManager.getLogger(AboutUsPageTest.class);
	//Create variables
	AboutUsPage aboutuspage;
	    HomePage homePage;
	    PageUtility pageuty;
	  //  verify AboutUs Title
	    @Test(priority=1)
	    public void verifyAboutUsTitle() throws InterruptedException {
	        homePage=new HomePage(driver);
	        homePage.clickAboutUs();
	        logger.info("Aboutus icon clicked");
	        aboutuspage= new AboutUsPage(driver);
	        String expectedTitle="ABOUT US";
	        String actualTitle= aboutuspage.validateaboutusText();
	        Assert.assertEquals(expectedTitle,actualTitle);
	        logger.info("functioning of Aboutus icon verified ");
	     }
	    
	   
}
