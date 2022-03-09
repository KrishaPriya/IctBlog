package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {
    WebDriver driver;


    @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/a/img")
    private WebElement logo;
    @FindBy(xpath="//*[@id=\"contact\"]/h1")
    private WebElement contactusTitle;

    @FindBy(xpath="//*[@id=\"name\"]")
    private WebElement name;

    @FindBy(xpath="//*[@id=\"email\"]")
    private WebElement email;

    @FindBy(xpath="//*[@id=\"contact-form\"]/div[3]/textarea")
    private WebElement message;

    @FindBy(xpath="//*[@id=\"submit\"]")
    private WebElement submit;
//contactlist
    @FindBy(xpath="//*[@id=\"contact\"]/div/div/ul[1]/li[1]/i/span")
    private WebElement location;
    @FindBy(xpath="//*[@id=\"contact\"]/div/div/ul[1]/li[2]/i/span/a")
    private WebElement phone;
    @FindBy(xpath="//*[@id=\"contact\"]/div/div/ul[1]/li[3]/i/span/a")
    private WebElement mailId;


//socialMediaLinks
    @FindBy(xpath="//*[@id=\"contact\"]/div/div/ul[2]/li[1]/a")
    private WebElement socialmedialogo1;
    @FindBy(xpath="//*[@id=\"contact\"]/div/div/ul[2]/li[2]/a")
    private WebElement socialmedialogo2;
    @FindBy(xpath="//*[@id=\"contact\"]/div/div/ul[2]/li[3]/a")
    private WebElement socialmedialogo3;
    @FindBy(xpath="//*[@id=\"contact\"]/div/div/ul[2]/li[4]/a")
    private WebElement socialmedialogo4;

    @FindBy(xpath="//*[@id=\"contact\"]/div/div/div")
    private WebElement allrightstext;

    //footer links
    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[1]/a[1]")
    private WebElement homePageLink;
    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[1]/a[2]")
    private WebElement contactUsLink;
    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[1]/a[3]")
    private WebElement aboutUsLink;

    //socialMedia images
    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[2]/img[1]")
    private WebElement facebookImage;
    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[2]/img[2]")
    private WebElement instagramImage;
    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[2]/img[3]")
    private WebElement linkedinImage;
    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[2]/img[4]")
    private WebElement twitterImage;

    //version text
    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[3]/p[1]")
    private WebElement versionText;
    //
    @FindBy(xpath="/html/body/app-root/app-footer/footer/div[3]/p[2]")
    private WebElement termsconditiontext;
    //copyright text
    @FindBy(xpath="/html/body/app-root/app-footer/footer/p")
    private WebElement copyrightText;



    public ContactUs(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String setContactusTitle(){
     String title=   contactusTitle.getText();
     return title;
    }


    public void setName(String userName){
        name.clear();
        name.sendKeys(userName);
    }



    public void setEmail(String emailid){
        email.clear();
        try
        {
            email.sendKeys(emailid);
        }catch(Exception e){

        }
    }
    public void setMessage(String text){
        message.clear();
        message.sendKeys(text);
    }
    public void setSubmit(){
        submit.click();
    }
    public boolean validateLogo(){
        return logo.isDisplayed();
    }

    public boolean facebookImage() {
        return facebookImage.isDisplayed();
    }

    public boolean instagramImage() {
        return instagramImage.isDisplayed();
    }
    public boolean linkedinImage() {
        return linkedinImage.isDisplayed();
    }
    public boolean twitterImage() {
        return twitterImage.isDisplayed();
    }

    public boolean copyrightText(){
        return copyrightText.isDisplayed();
    }
    public boolean versionText(){
        return versionText.isDisplayed();
    }
    public boolean termsConditionText(){
        return termsconditiontext.isDisplayed();
    }
    public void setHomePageLink() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",homePageLink);
        Thread.sleep(2000);
        homePageLink.click();
    }
    public void setContactUsLink() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",contactUsLink);
        Thread.sleep(2000);
        contactUsLink.click();
    }
    public void setAboutUsLink() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", aboutUsLink);
        Thread.sleep(2000);
        aboutUsLink.click();
    }

    public boolean setSocialMediaLogo1(){
        return socialmedialogo1.isDisplayed();
    }

    public boolean setSocialMediaLogo2(){
        return socialmedialogo2.isDisplayed();
    }
    public boolean setSocialMediaLogo3(){
        return socialmedialogo3.isDisplayed();
    }

    public boolean setSocialMediaLogo4(){
        return socialmedialogo4.isDisplayed();
    }
    public boolean allrightstext(){
        return allrightstext.isDisplayed();
    }

    public boolean checkCity(){
        return location.isDisplayed();
    }
    public boolean checkId(){
        return mailId.isDisplayed();
    }
    public boolean checkPhone(){
        return phone.isDisplayed();
    }



}

