package PageObjects.Admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ActionsPage {

    WebDriver driver;

    @FindBy(xpath = "//p[contains(text(),'Actions')]")
    private WebElement actiondrpdown;

    @FindBy(xpath = "//a[contains(text(),'New post')]")
    private WebElement newpostlink;

    @FindBy(xpath = "//input[@id='exampleInputEmail1']")
    private WebElement txttitle;


    @FindBy(xpath = "//body/app-root[1]/app-newpost[1]/form[1]/div[3]/input[1]")
    private WebElement txtimageurl;

    @FindBy(xpath = "//body/app-root[1]/app-editpost[1]/form[1]/div[3]/input[1]")
    private WebElement edittxtimageurl;

    @FindBy(xpath = "/html/body/app-root/app-newpost/form/div[4]/select")
    private WebElement categorydrpdown;

    @FindBy(xpath = "//body/app-root[1]/app-newpost[1]/form[1]/div[5]/textarea[1]")
    private WebElement txtpost;

    @FindBy(xpath = "/html/body/app-root/app-editpost/form/div[4]/textarea")
    private WebElement edithomepagetxtpost;

    @FindBy(xpath = "/html/body/app-root/app-newpost/form/button")
    private WebElement btnsubmitnewpost;

    @FindBy(xpath = "/html/body/app-root/app-editpost/form/button")
    private WebElement btnsubmiteditnewpost;

    @FindBy(xpath = "/html/body/app-root/app-home/div/div[1]/div/div/h2")
    private WebElement homepagetitle;

    @FindBy(xpath = "//*[@id=\"nav\"]")
    private WebElement home;


    @FindBy(xpath = "/html/body/app-root/app-singlepost/div/div[2]/div/div/button[1]")
    private WebElement edithomepost;

    @FindBy(xpath = "/html/body/app-root/app-singlepost/div/div[2]/div/div/button[2]")
    private WebElement deletehomepost;

    @FindBy(xpath = "//h5[contains(text(),'mypost2')]")
    private WebElement POSTTITLE;


    public ActionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //selecting from Actions menu
    public void selectactionsdropdown() throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", actiondrpdown);
        //actiondrpdown.click();
        Thread.sleep(4000);
        Actions act = new Actions(driver);
        act.click(newpostlink).perform();

    }


    //entering title in new post
    public void entertitle(String title) {
        txttitle.clear();
        txttitle.sendKeys(title);
    }

    //TITILE ASSERT
    public String titleAssert(String title) {

        return txttitle.getText();

    }
    //entering image url in new post

    public void enterimageurl(String imageurl) {
        txtimageurl.clear();
        txtimageurl.sendKeys(imageurl);
    }

    //entering image url in edit  post
    public void editimageurl(String imageurl) {
        edittxtimageurl.clear();
        edittxtimageurl.sendKeys(imageurl);
    }

    //entering category in new post

    public void selectcategory() throws InterruptedException {
        Thread.sleep(4000);
        Select drpcategory = new Select(categorydrpdown);
        drpcategory.selectByIndex(1);
    }


    //click submit in new post
    public void btnsubmit() throws InterruptedException {
        JavascriptExecutor ijs = (JavascriptExecutor) driver;
        ijs.executeScript("arguments[0].scrollIntoView(true);", btnsubmitnewpost);
        Thread.sleep(2000);
        btnsubmitnewpost.click();
    }

    //click submit in new post(INVALID DATA)
    public boolean btnsubmitnotenabled() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btnsubmitnewpost);
        Thread.sleep(2000);

        if (btnsubmitnewpost.isEnabled())

            System.out.println("hi");
        return false;


    }

    //click submit in edit post
    public void btnsubmiteditnewposthomepage() {

        btnsubmiteditnewpost.sendKeys(Keys.RETURN);

    }

    ////click submit in edit post INVALID DATA
    public Boolean btnsubmiteditnewposthomepageINVALIDATA() throws InterruptedException {
        Thread.sleep(4000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btnsubmiteditnewpost);
        Thread.sleep(2000);
        if (btnsubmiteditnewpost.isEnabled())

            return true;
        else return false;


    }

    //entering post in text area
    public void enternewpost(String post) {
        txtpost.clear();
        txtpost.sendKeys(post);
    }

    //entering post in text area when editing
    public void editenterpost(String post) {
        edithomepagetxtpost.clear();
        edithomepagetxtpost.sendKeys(post);
    }

    //welcome to ICTAKTECHBLOG
    public String homepagetext() {
        return homepagetitle.getText();
    }


    public void home() {
        home.click();
    }

    //CLICKING edit button in homepage
    public void edithomeclick() throws InterruptedException {

        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", home);
        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", home);
        Thread.sleep(2000);
        JavascriptExecutor ijs = (JavascriptExecutor) driver;
        ijs.executeScript("arguments[0].scrollIntoView(true);", POSTTITLE);
        Thread.sleep(4000);
        JavascriptExecutor pjs = (JavascriptExecutor) driver;
        pjs.executeScript("arguments[0].click();", POSTTITLE);


        edithomepost.click();
    }


    //CLICKING delete button in homepage
    public void deletehomeclick() throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", home);
        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", home);
        Thread.sleep(2000);
        JavascriptExecutor ijs = (JavascriptExecutor) driver;
        ijs.executeScript("arguments[0].scrollIntoView(true);", POSTTITLE);
        Thread.sleep(4000);
        JavascriptExecutor pjs = (JavascriptExecutor) driver;
        pjs.executeScript("arguments[0].click();", POSTTITLE);
        Thread.sleep(4000);
        deletehomepost.click();
    }


}