package Scripts;

import Constants.AutomationConstants;
import PageObjects.AboutUs;
import PageObjects.ContactUs;
import PageObjects.HomePage;
import Utilities.ExcelUtility;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;



import static Scripts.Utils.WEBDRIVER_WAIT_TIME;

public class TestContactUs extends TestBase{
    ContactUs contactUs;
    HomePage homePage;
    Logger logger;

    public TestContactUs() {
        super();
        logger = Logger.getLogger(TestContactUs.class);
        BasicConfigurator.configure();
    }

    @AfterTest
    void afterTestDone() {
        homePage = null;
        contactUs = null;
    }

    @Test(priority=0)
    public void verifyHomePageLogo() throws InterruptedException {
        // Actions act = new Actions(driver);
        HomePage.isPageLoaded(driver);
        homePage= new HomePage(driver);
        boolean flag = homePage.setLogo();
        Assert.assertTrue(flag);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }

    @Test(priority=1)
    public void verifyContactUsTitle() throws InterruptedException {
        HomePage.isPageLoaded(driver);
        homePage=new HomePage(driver);
        homePage.clickOnContactUs();
        ContactUs.isPageLoaded(driver);
        contactUs=new ContactUs(driver);
        String expectedTitle="CONTACT US";
        String actualTitle=contactUs.setContactusTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");

    }
       @Test(priority=2)
        public void verifyContactUsForm() throws InterruptedException {
            ContactUs.isPageLoaded(driver);
            contactUs = new ContactUs(driver);

            String name="test";
            //String name= ExcelUtility.getCellDataFormat();
            String email="abc@gmail.com";
          // String email= ExcelUtility.getCellDataFormat();
            String message="hi";
            //String message=ExcelUtility.getCellDataFormat();
            contactUs.setName(name);
            logger.info("Entered name");
            contactUs.setMessage(message);
            logger.info("Entered message");
            contactUs.setEmail(email);
            logger.info("Entered email");
            contactUs.setSubmit();
            logger.info("Submit button clicked");

           WebDriverWait w = new WebDriverWait(driver, 2000);
           if(w.until(ExpectedConditions.alertIsPresent())==null) {
               logger.error("We should have got alert");
           }
           else {
               String expectedTitle="Message is send successfully";
               String actualTitle=driver.switchTo().alert().getText();
               driver.switchTo().alert().accept();
               Assert.assertFalse(expectedTitle == actualTitle);
               logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
           }
    }

    @Test(priority=3)
    public void verifySendMessageWithoutName() throws InterruptedException {
        ContactUs.isPageLoaded(driver);
        contactUs = new ContactUs(driver);
        contactUs.resetAllFields();
        String email="abc@gmail.com";
        String message="hi";
        contactUs.setMessage(message);
        contactUs.setEmail(email);
        Assert.assertEquals(contactUs.setSubmitEnabled(), true);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }
    @Test(priority=4)
    public void verifySendMessageWithoutEmail() throws InterruptedException {
        ContactUs.isPageLoaded(driver);
        contactUs = new ContactUs(driver);
        contactUs.resetAllFields();
        String name="ASDF";
        String message="hi";
        contactUs.setName(name);
        contactUs.setMessage(message);
        Assert.assertEquals(contactUs.setSubmitEnabled(), true);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");

    }

    @Test(priority=5)
    public void verifyContactlistItemsArePresent() throws InterruptedException {
        ContactUs.isPageLoaded(driver);
        contactUs =new ContactUs(driver);
       boolean flag= contactUs.facebookImage();
        Assert.assertTrue(flag);
       boolean flags= contactUs.twitterImage();
       Assert.assertTrue(flags);
       boolean ip= contactUs.instagramImage();
       Assert.assertTrue(ip);
       boolean op= contactUs.linkedinImage();
       Assert.assertTrue(op);
    }
    @Test(priority=6)
    public void verifyTextInFooter() throws InterruptedException {
        ContactUs.isPageLoaded(driver);
        contactUs=new ContactUs(driver);
        boolean flag=contactUs.versionText();
        Assert.assertTrue(flag);
        boolean ip=contactUs.termsConditionText();
        Assert.assertTrue(ip);
        boolean op=contactUs.copyrightText();
        Assert.assertTrue(op);
        logger.info("Footer text are checked");

    }

    @Test(priority=8)
    public void verifySocialMediaImagesArePresent() throws InterruptedException {
        ContactUs.isPageLoaded(driver);
        contactUs=new ContactUs(driver);

      boolean flag=  contactUs.setSocialMediaLogo1();
      Assert.assertTrue(flag);
       boolean flags= contactUs.setSocialMediaLogo2();
       Assert.assertTrue(flags);
       boolean ip=contactUs.setSocialMediaLogo3();
       Assert.assertTrue(ip);
       boolean op= contactUs.setSocialMediaLogo4();
       Assert.assertTrue(op);
       boolean allright= contactUs.allrightstext();
       Assert.assertTrue(allright);
       logger.info("Checked social media logos");
    }

    @Test(priority=9)
    public void verifyContactListItemsArePresent() throws InterruptedException {
        ContactUs.isPageLoaded(driver);
        contactUs=new ContactUs(driver);
        boolean flag=contactUs.checkCity();
        Assert.assertTrue(flag);
        boolean flags=contactUs.checkId();
        Assert.assertTrue(flags);
        boolean ip=contactUs.checkPhone();
        Assert.assertTrue(ip);
        logger.info("Checked contact list items");
    }

    @Test(priority = 10)
    public void verifyNoOfElementsInContactForm() throws InterruptedException {
        contactUs=new ContactUs(driver);
        int count= contactUs.noOfTextBoxInForm();
        System.out.println("No of textboxes is:" +count);
        Assert.assertEquals(count,2);
        int textareaCount=contactUs.noOfTextAreaInForm();
        System.out.println("No of textarea is:" +textareaCount);
        Assert.assertEquals(textareaCount,1);

        int buttonCount=contactUs.noOfButton();
        System.out.println("No of button is:" +buttonCount);
        Assert.assertEquals(buttonCount,1);

    }

    @Test(priority=11)
    public void verifyFooterLinks() throws InterruptedException {
        ContactUs.isPageLoaded(driver);
        contactUs=new ContactUs(driver);
        contactUs.setHomePageLink();

        HomePage.isPageLoaded(driver);
        HomePage homePage = new HomePage(driver);
        String expectedHomePageUrl="http://64.227.132.106/";
        String actualHomePageUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedHomePageUrl,actualHomePageUrl);
        homePage.clickOnContactUs();

        ContactUs.isPageLoaded(driver);
        contactUs=new ContactUs(driver);
        String expectedContactUsUrl="http://64.227.132.106/contactus";
        String actualContactUsUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedContactUsUrl,actualContactUsUrl);
        contactUs.setAboutUsLink();

        String expectedAboutUsUrl="http://64.227.132.106/aboutus";
        String actualAboutUsUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedAboutUsUrl,actualAboutUsUrl);
        logger.info("Footer links are checked");
    }



}
