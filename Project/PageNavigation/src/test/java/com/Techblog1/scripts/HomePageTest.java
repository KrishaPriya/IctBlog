package com.Techblog1.scripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import com.Techblog1.pages.HomePage;
import com.Techblog1.utilities.Excelutility;






public class HomePageTest extends TestBase {
	
	 Logger logger=LogManager.getLogger(HomePageTest.class);
	
	HomePage homePage;
	
	//verify  HomePage Title
	 @Test(priority=0)
	        public void verifyHomePageTitle() throws InterruptedException {
		        homePage =new HomePage(driver);
                String Title = homePage.validateHomePageTitle();
	            Assert.assertEquals(Title,"Frontend");
	            logger.info("Techblog site opened sucessfully");
	        }
 //verify ICTAK logo
          @Test(priority=1)
            public void verifyICTAKlogoTest() throws InterruptedException {
 	            homePage = new HomePage(driver); 
             	boolean Flag= homePage.validateICTAKlogo();
 	            Assert.assertTrue(Flag);
 	           logger.info("ICTAK logo visibiled at the left top of the page");
 	            
           }
         //verify Welcome Text
           @Test(priority=2)
             public void verifyWelcomeText() throws InterruptedException {
 	            homePage= new HomePage(driver);
                 String Title=homePage.validateWelcomeText();
                 Assert.assertEquals(Title,"WELCOME TO ICTAK TECH BLOG");
                 logger.info("Welcome text is visibiled");
    
    
             }
           //verify Morelink under Latest articles
	@Test(priority=11)
    public void verifyLatestarticlesMorelink()  throws InterruptedException   {
	  homePage = new HomePage(driver);
	  Thread.sleep(1000);
      boolean Flag = homePage.validateLatestarticlesMorelink();
      Thread.sleep(1000);
      Assert.assertTrue(Flag);
      homePage.clickHome();
      logger.info("Read more link under Latest article section sucessfully opened to a new page");
  }  
	//verify Readmorelink under Technews
           @Test(priority=12)
	        public void verifyTechnewsReadmorelink()  throws InterruptedException  {
	           homePage = new HomePage(driver);
	           Thread.sleep(1000);
	           boolean Flag=homePage.validateTechnewsReadmorelink();
	           WebDriverWait wait = new WebDriverWait(driver, 15);
	           Thread.sleep(1000);
	           Assert.assertTrue(Flag);
	           Thread.sleep(1000);
	           homePage.clickHome();
	           Thread.sleep(1000);
	           logger.info("Read more link under technews section sucessfully opened to a new page");
	       }
         //verify morelink under Technews
             @Test(priority=13)
	        public void verifyTechnewsMorelink() throws InterruptedException   {
	            homePage=new HomePage(driver);
	            Thread.sleep(1000);
	            boolean Flag =homePage.validateTechnewsMorelink();
	           
	            Thread.sleep(1000);
	            homePage.clickHome(); 
	            Assert.assertTrue(Flag);
	            logger.info("More link under technews section sucessfully opened to a new page");
		  }
             
	   //verify PrevBtn   
	@Test(priority=3)
	public void verifyPrevBtn() throws InterruptedException {
		homePage= new HomePage(driver);
	    Thread.sleep(1000);
		boolean Flag= homePage.validatePrevbtn();
		Assert.assertTrue(Flag);
		Thread.sleep(1000);
		 logger.info("prev button is enabled");
	}
	//verify NextBtn
	@Test(priority=4)
	public void verifyNextBtn() throws InterruptedException {
		homePage = new HomePage(driver);
	    Thread.sleep(1000);
		boolean Flag= homePage.validateNextbtn();
		Assert.assertTrue(Flag);
		 logger.info("next button is enabled");
	}
	

       
          //verify FeedBack Form
          
      @Test(priority=8)
           public void verifyFeedBackForm() throws InterruptedException, IOException {
       	    homePage = new HomePage(driver); 
       	 Thread.sleep(1000);
               String Firstname= Excelutility.getCellData(0,0);
               String Lastname=Excelutility.getCellData(0,1);
               String subject=Excelutility.getCellData(0,2);
               homePage.setfirstName(Firstname);
               Thread.sleep(1000);
               logger.info("valid Firstname entered");
               homePage.setLastName(Lastname);
               Thread.sleep(1000);
               logger.info("valid Lastname entered");
               homePage.setCountry();
               Thread.sleep(1000);
               logger.info("valid country name selected");
               homePage.sendFeedback(subject);
               Thread.sleep(1000);
               logger.info("valid subject entered");
               homePage.clickSubmit();
               Thread.sleep(1000);
               logger.info("submit clicked");
               String expectedTitle="Thanks for your feedback";
               String actualTitle=driver.switchTo().alert().getText();
               driver.switchTo().alert().accept();
               Assert.assertEquals(expectedTitle,actualTitle);
               Thread.sleep(1000);
               logger.info("Feedback form submitted sucessfully");
       }
     // verify FeedBackForm Without FirstName
           @Test(priority=5)
   	    public void verifyFeedBackFormWithoutFirstName() throws InterruptedException, IOException {
   	    	 homePage = new HomePage(driver);
   	            Thread.sleep(1000);
   	            String Firstname=" ";
   	            String Lastname=Excelutility.getCellData(3,0);
   	            String Subject=Excelutility.getCellData(3,1);
   	            homePage .setfirstName(Firstname);
   	            Thread.sleep(1000);
   	            logger.info("invalid Firstname entered");
   	            homePage.setLastName(Lastname);
   	            Thread.sleep(1000);
   	            logger.info("valid Lastname entered"); 
   	            homePage.setCountry();
   	            Thread.sleep(1000);
   	            logger.info("valid country name selected");
   	            homePage .sendFeedback(Subject);
   	            Thread.sleep(1000);
   	            logger.info("valid subject entered");
   	            homePage.clickSubmit();
   	             Thread.sleep(1000);
   	            logger.info("submit clicked");
   	            String expectedTitle="http://icttechblog.herokuapp.com/";
                String actualTitle="http://icttechblog.herokuapp.com/";
   	            Assert.assertEquals(expectedTitle,actualTitle);
   	            Thread.sleep(1000);
   	            logger.info("Feedback form submitted sucessfully");
   	       

   	    }
          //verify FeedBackForm Without LastName
       @Test(priority=6)
           public void verifyFeedBackFormWithoutLastName() throws InterruptedException, IOException {
       	   homePage = new HomePage(driver);
       	       Thread.sleep(1000);
               String Firstname=Excelutility.getCellData(2,0);
               String Lastname=" ";
               String Subject=Excelutility.getCellData(2,1);
               homePage.setfirstName(Firstname);
               Thread.sleep(1000);
               logger.info("valid Firstname entered");
               homePage.setLastName(Lastname);
               Thread.sleep(1000);
               logger.info("invalid Lastname entered");
               homePage.setCountry();
               Thread.sleep(1000);
               logger.info("valid country name selected");
               homePage.sendFeedback(Subject); 
               Thread.sleep(1000);
               logger.info("valid subject entered");
               homePage.clickSubmit();
               Thread.sleep(1000);
               logger.info("submit clicked");
               String expectedTitle="http://icttechblog.herokuapp.com/";
               String actualTitle="http://icttechblog.herokuapp.com/";
               Assert.assertEquals(expectedTitle,actualTitle); 
               Thread.sleep(1000);
   	           logger.info("Feedback form was not submitted sucessfully");
       }
               

	  
	  //verify FeedBackForm Without FeedBack
	   
      @Test(priority=7)
        public void verifyFeedBackFormWithoutFeedBack() throws InterruptedException, IOException {
    	   homePage = new HomePage(driver);
    	   Thread.sleep(1000);
            String Firstname=Excelutility.getCellData(1,0);
            String Lastname=Excelutility.getCellData(1,1);
            String Subject=" ";
            homePage .setfirstName(Firstname);
            Thread.sleep(1000);
            logger.info("valid Firstname entered");
            homePage.setLastName(Lastname);
            Thread.sleep(1000);
            logger.info("valid Lastname entered");
            homePage.setCountry();
            Thread.sleep(1000);
            logger.info("valid country name selected");
            homePage .sendFeedback(Subject); 
            Thread.sleep(1000);
            logger.info("invalid subject entered");
            homePage.clickSubmit();
            Thread.sleep(1000);
            logger.info("submit clicked");
            String expectedTitle="http://icttechblog.herokuapp.com/";
            String actualTitle="http://icttechblog.herokuapp.com/";
            Assert.assertEquals(expectedTitle,actualTitle); 
            Thread.sleep(1000);
            logger.info("Feedback form was not submitted sucessfully");
    }
	    
//verify Footer Links

	  @Test(priority=9)
	    public void verifyFooterLinks() throws InterruptedException {
	        homePage= new HomePage(driver);
	        homePage .clickHomeLink();
	        logger.info("homelink clicked");
	        String expectedHomePageUrl="http://icttechblog.herokuapp.com/";
	        String actualHomePageUrl=driver.getCurrentUrl();
	        Assert.assertEquals(expectedHomePageUrl,actualHomePageUrl);
	        logger.info("homepage opened sucessfully");
	        homePage .clickContactusLink();
	        logger.info("contactuslink clicked");
	        String expectedContactUsUrl="http://icttechblog.herokuapp.com/contactus";
	        String actualContactUsUrl=driver.getCurrentUrl();
	        Assert.assertEquals(expectedContactUsUrl,actualContactUsUrl);
	        logger.info("contactus page opened sucessfully");
	        homePage.clickAboutusLink();
	        logger.info("aboutuslink clicked");
	        String expectedAboutUsUrl="http://icttechblog.herokuapp.com/aboutus";
	        String actualAboutUsUrl=driver.getCurrentUrl();
	        Assert.assertEquals(expectedAboutUsUrl,actualAboutUsUrl);
	        logger.info("aboutus page opened sucessfully");
	        }
	 // verify Contactlist Items Are Present
	     @Test(priority=10)
		    public void verifyContactlistItemsArePresent() throws InterruptedException {
		     homePage =new HomePage(driver);
		     boolean flag= homePage.facebookImage();
		     Assert.assertTrue(flag);
		     logger.info("verified the presence of facebook Image ");
		     boolean flags= homePage.twitterImage();
		     Assert.assertTrue(flags);
		     logger.info("verified the presence of twitter Image");
		     boolean ip= homePage.instagramImage();
		     Assert.assertTrue(ip);
		     logger.info("verified the presence of instagram Image");
		     boolean op= homePage.linkedinImage();
		     Assert.assertTrue(op);
		     logger.info("verified the presence oflinkedin Image");
		    }
	    //VerifyTotalElementsHomePage
	     @Test(priority=6)

			public void VerifyTotalElementsHomePage() throws InterruptedException, IOException
			{
	    	 homePage =new HomePage(driver);
	    	 
	    	 int headerlinks=homePage .findNoOfElementsInHeader();
			  System.out.println(headerlinks);
             Assert.assertEquals(headerlinks,5);
             
				int textboxes=homePage .findNoOfTextBoxesInHomePage();
				 System.out.println(textboxes);
				Assert.assertEquals(textboxes,2);
				
				int submitBtn=homePage .findNoOfButtonInHomepage();
	             System.out.println(submitBtn);
	             Assert.assertEquals(submitBtn,1);

				int footerlinks=homePage .findNoOfElemeentsInFooter();
				System.out.println(footerlinks);
				Assert.assertEquals(footerlinks,3);

				logger.info("Counted the elements in Homepage");
			}

 
	   


}
