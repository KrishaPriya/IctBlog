package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContactUs {
    WebDriver driver;


    @FindBy(xpath = "/html/body/app-root/app-home/app-header/nav/div/a/img")
    private WebElement logo;
    @FindBy(xpath = "//*[@id=\"contact\"]/h1")
    private WebElement contactusTitle;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement name;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"contact-form\"]/div[3]/textarea")
    private WebElement message;

    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement submit;
    //contactlist
    @FindBy(xpath = "//*[@id=\"contact\"]/div/div/ul[1]/li[1]/i/span")
    private WebElement location;
    @FindBy(xpath = "//*[@id=\"contact\"]/div/div/ul[1]/li[2]/i/span/a")
    private WebElement phone;
    @FindBy(xpath = "//*[@id=\"contact\"]/div/div/ul[1]/li[3]/i/span/a")
    private WebElement mailId;


    //socialMediaLinks
    @FindBy(xpath = "//*[@id=\"contact\"]/div/div/ul[2]/li[1]/a")
    private WebElement socialmedialogo1;
    @FindBy(xpath = "//*[@id=\"contact\"]/div/div/ul[2]/li[2]/a")
    private WebElement socialmedialogo2;
    @FindBy(xpath = "//*[@id=\"contact\"]/div/div/ul[2]/li[3]/a")
    private WebElement socialmedialogo3;
    @FindBy(xpath = "//*[@id=\"contact\"]/div/div/ul[2]/li[4]/a")
    private WebElement socialmedialogo4;

    @FindBy(xpath = "//*[@id=\"contact\"]/div/div/div")
    private WebElement allrightstext;

    //footer links
    @FindBy(xpath = "/html/body/app-root/app-footer/footer/div[1]/a[1]")
    private WebElement homePageLink;
    @FindBy(xpath = "/html/body/app-root/app-footer/footer/div[1]/a[2]")
    private WebElement contactUsLink;
    @FindBy(xpath = "/html/body/app-root/app-footer/footer/div[1]/a[3]")
    private WebElement aboutUsLink;

    //socialMedia images
    @FindBy(xpath = "/html/body/app-root/app-footer/footer/div[2]/img[1]")
    private WebElement facebookImage;
    @FindBy(xpath = "/html/body/app-root/app-footer/footer/div[2]/img[2]")
    private WebElement instagramImage;
    @FindBy(xpath = "/html/body/app-root/app-footer/footer/div[2]/img[3]")
    private WebElement linkedinImage;
    @FindBy(xpath = "/html/body/app-root/app-footer/footer/div[2]/img[4]")
    private WebElement twitterImage;

    //version text
    @FindBy(xpath = "/html/body/app-root/app-footer/footer/div[3]/p[1]")
    private WebElement versionText;
    //
    @FindBy(xpath = "/html/body/app-root/app-footer/footer/div[3]/p[2]")
    private WebElement termsconditiontext;
    //copyright text
    @FindBy(xpath = "/html/body/app-root/app-footer/footer/p")
    private WebElement copyrightText;


    public ContactUs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //for getting contact us title
    public String setContactusTitle() {
        String title = contactusTitle.getText();
        return title;
    }

   //for name in contact us form
    public void setName(String userName) {
        name.clear();
        name.sendKeys(userName);
    }


    //for email
    public void setEmail(String emailid) {
        email.clear();
        try {
            email.sendKeys(emailid);
        } catch (Exception e) {

        }
    }

    //for message
    public void setMessage(String text) {
        message.clear();
        message.sendKeys(text);
    }
    //for checking submit button enabled
    public boolean setSubmitEnabled() throws InterruptedException {
       WebDriverWait wait = new WebDriverWait(driver,5);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);" ,submit);
        wait.until(ExpectedConditions.visibilityOf(submit));
        return submit.isEnabled();
    }

    //for clciking submit
    public void setSubmit() {
        submit.click();
    }

    //for validating logo
    public boolean validateLogo() {
        return logo.isDisplayed();
    }

    //for facebook image
    public boolean facebookImage() {
        return facebookImage.isDisplayed();
    }

    //for instagram image
    public boolean instagramImage() {
        return instagramImage.isDisplayed();
    }

    //for linkein image
    public boolean linkedinImage() {
        return linkedinImage.isDisplayed();
    }

    //for twitter image
    public boolean twitterImage() {
        return twitterImage.isDisplayed();
    }

    //for copyright text
    public boolean copyrightText() {
        return copyrightText.isDisplayed();
    }

    //for version text
    public boolean versionText() {
        return versionText.isDisplayed();
    }

    //for terms and conditions text
    public boolean termsConditionText() {
        return termsconditiontext.isDisplayed();
    }

    //for home page link
    public void setHomePageLink() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePageLink);
        Thread.sleep(1000);
        homePageLink.click();
    }

    //for contactus link
    public void setContactUsLink() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactUsLink);
        Thread.sleep(1000);
        contactUsLink.click();
    }

    //for about us link
    public void setAboutUsLink() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutUsLink);
        Thread.sleep(1000);
        aboutUsLink.click();
    }

    //for socia media logos
    public boolean setSocialMediaLogo1() {
        return socialmedialogo1.isDisplayed();
    }

    public boolean setSocialMediaLogo2() {
        return socialmedialogo2.isDisplayed();
    }

    public boolean setSocialMediaLogo3() {
        return socialmedialogo3.isDisplayed();
    }

    public boolean setSocialMediaLogo4() {
        return socialmedialogo4.isDisplayed();
    }

    //for allright text
    public boolean allrightstext() {
        return allrightstext.isDisplayed();
    }

    //for checking city
    public boolean checkCity() {
        return location.isDisplayed();
    }

    //for checking mail id
    public boolean checkId() {
        return mailId.isDisplayed();
    }

    //for checking phone no
    public boolean checkPhone() {
        return phone.isDisplayed();
    }

    //find no of textbox in contact form
    public int noOfTextBoxInForm() {
        List<WebElement> elements = driver.findElements(By.xpath("//input"));
        int count = elements.size();
        return count;
    }

    //find no of textarea in contact form
    public int noOfTextAreaInForm() {
        List<WebElement> elements = driver.findElements(By.xpath("//textarea"));
        int count = elements.size();
        return count;
    }

    //find no of button in contact form
    public int noOfButton() {
        List<WebElement> elements = driver.findElements(By.xpath("//button[contains(@id,'submit')]"));
        int count = elements.size();
        return count;
    }

    public void resetAllFields(){
        name.clear();
        message.clear();
        email.clear();
    }

    public static void isPageLoaded(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement title = driver.findElement(By.xpath("//*[@id=\"contact\"]/h1"));
        wait.until(ExpectedConditions.visibilityOf(title));
    }
}

