package com.Techblog1.scripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Techblog1.pages.CategoriesPage;
import com.Techblog1.pages.HomePage;
import com.Techblog1.pages.LoginPage;

public class CategoriesPageTest extends TestBase {
	Logger logger=LogManager.getLogger(CategoriesPageTest.class);
	//Create variable for category page
	CategoriesPage objcategories; 
	//
	@Test(priority=1)
	public void verifyCategory() throws IOException, InterruptedException {
        Actions act = new Actions(driver);
        objcategories = new CategoriesPage(driver);
        objcategories.selectCategory();
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals(strUrl,"http://icttechblog.herokuapp.com/categorywise");
        logger.info("functioning of catrgories icon verified ");
	}
	
	  
		
		
	}


