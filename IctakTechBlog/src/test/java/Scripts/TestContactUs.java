package Scripts;

import PageObjects.ContactUs;
import PageObjects.HomePage;
import Scripts.Trainer.TestTrainerDeleteMyPost;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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
        homePage= new HomePage(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        boolean flag = homePage.setLogo();
        Assert.assertTrue(flag);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }

    @Test(priority=1)
    public void verifyContactUsTitle() throws InterruptedException {
        homePage=new HomePage(driver);
        homePage.clickOnContactUs();
        contactUs=new ContactUs(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        String expectedTitle="CONTACT US";
        String actualTitle=contactUs.setContactusTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");


    }
       @Test(priority=2)
        public void verifyContactUsForm() throws InterruptedException {
            contactUs = new ContactUs(driver);
            Thread.sleep(WEBDRIVER_WAIT_TIME);
            String name="test";
            String email="abc@gmail.com";
            String message="hi";
            contactUs.setName(name);
            contactUs.setMessage(message);
            contactUs.setEmail(email);
            contactUs.setSubmit();
            Thread.sleep(WEBDRIVER_WAIT_TIME);
            String expectedTitle="Message is send successfully";
            String actualTitle=driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            Assert.assertFalse(expectedTitle == actualTitle);
            Thread.sleep(WEBDRIVER_WAIT_TIME);
           logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }

    @Test(priority=3)
    public void verifySendMessageWithoutName() throws InterruptedException {
        contactUs = new ContactUs(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        String name=" ";
        String email="abc@gmail.com";
        String message="hi";
        contactUs.setName(name);
        contactUs.setMessage(message);
        contactUs.setEmail(email);
        contactUs.setSubmit();
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        String expectedTitle="Message is send successfully";
        String actualTitle=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(expectedTitle,actualTitle);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");
    }
    @Test(priority=4)
    public void verifySendMessageWithoutEmail() throws InterruptedException {
        contactUs = new ContactUs(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        String name="test";
        String email="";
        String message="hi";
        contactUs.setName(name);
        contactUs.setMessage(message);
       // contactUs.setSubmit();
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        String expectedUrl="http://64.227.132.106/contactus";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        logger.info(new Exception().getStackTrace()[0].getMethodName()+" : success");

    }

    @Test(priority=5)
    public void verifyContactlistItemsArePresent() throws InterruptedException {
        contactUs =new ContactUs(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
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
        contactUs=new ContactUs(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        boolean flag=contactUs.versionText();
        Assert.assertTrue(flag);
        boolean ip=contactUs.termsConditionText();
        Assert.assertTrue(ip);
        boolean op=contactUs.copyrightText();
        Assert.assertTrue(op);

    }

    @Test(priority=8    )
    public void verifyFooterLinks() throws InterruptedException {
        contactUs=new ContactUs(driver);
        Thread.sleep(4000);
        contactUs.setHomePageLink();
        String expectedHomePageUrl="http://64.227.132.106/";
        String actualHomePageUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedHomePageUrl,actualHomePageUrl);
        Thread.sleep(3000);
        contactUs.setContactUsLink();
        Thread.sleep(3000);
        String expectedContactUsUrl="http://64.227.132.106/contactus";
        String actualContactUsUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedContactUsUrl,actualContactUsUrl);

        contactUs.setAboutUsLink();
        String expectedAboutUsUrl="http://64.227.132.106/aboutus";
        String actualAboutUsUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedAboutUsUrl,actualAboutUsUrl);
    }

    @Test(priority=7)
    public void verifySocialMediaImagesArePresent() throws InterruptedException {
        contactUs=new ContactUs(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
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
    }

    @Test(priority=8)
    public void verifyContactListItemsArePresent() throws InterruptedException {
        contactUs=new ContactUs(driver);
        Thread.sleep(WEBDRIVER_WAIT_TIME);
        boolean flag=contactUs.checkCity();
        Assert.assertTrue(flag);
        boolean flags=contactUs.checkId();
        Assert.assertTrue(flags);
        boolean ip=contactUs.checkPhone();
        Assert.assertTrue(ip);
    }





}
