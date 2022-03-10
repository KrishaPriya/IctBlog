package PageObjects.Admin;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

//CAN DELETE GENERAL METHODS FOR ADDING POST
public class AllPostsPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"nav\"]")
    private WebElement home;

    @FindBy(xpath = "//p[contains(text(),'Actions')]")
    private WebElement actiondrpdown;

    @FindBy(xpath = "//a[contains(text(),'New post')]")
    private WebElement newpostlink;

    @FindBy(xpath = "//a[contains(text(),'My posts')]")
    private WebElement myPost;

    @FindBy(xpath = "//a[contains(text(),'Pending Approvals')]")
    private WebElement pendingApprovals;

    @FindBy(xpath = "//input[@id='exampleInputEmail1']")
    private WebElement txttitle;


    @FindBy(xpath = "//body/app-root[1]/app-newpost[1]/form[1]/div[3]/input[1]")
    private WebElement txtimageurl;
    @FindBy(xpath = " //body/app-root[1]/app-editpost[1]/form[1]/div[3]/input[1]")
    private WebElement editallposttxtimageurl;


    @FindBy(xpath = "/html/body/app-root/app-newpost/form/div[4]/select")
    private WebElement categorydrpdown;

    @FindBy(xpath = "//body/app-root[1]/app-newpost[1]/form[1]/div[5]/textarea[1]")
    private WebElement txtpost;
    @FindBy(xpath = "//body/app-root[1]/app-editpost[1]/form[1]/div[4]/textarea[1]")
    private WebElement editallposttxtpost;

    @FindBy(xpath = "/html/body/app-root/app-newpost/form/button")
    private WebElement btnsubmitnewpost;
    @FindBy(xpath = "/html/body/app-root/app-editpost/form/button")
    private WebElement editallpostbtnsubmitnewpost;

    @FindBy(xpath = "/html/body/app-root/app-admin/div[1]/h2")
    private WebElement ALLPosttitle;


    @FindBy(xpath = "//a[contains(text(),'All posts')]")
    private WebElement Allpostslink;

    @FindBy(xpath = "/html/body/app-root/app-admin/div[2]/li[5]/div/div/div/button[1]")
    private WebElement editallpost;
    @FindBy(xpath = "/html/body/app-root/app-admin/div[2]/li[5]/div/div/div/button[2]")
    private WebElement deleteallpost;

    @FindBy(xpath = "/html/body/app-root/app-admin/app-header/nav/div/div/ul/li[11]/a")
    private WebElement logout;

    public AllPostsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    //selecting from Actions menu
    public void selectactionsdropdown() throws InterruptedException {
        Thread.sleep(2000);
        actiondrpdown.click();
        Actions act = new Actions(driver);
        act.click(newpostlink).perform();

    }

    //selecting from Actions menu
    public void selectPendingApprvalDropDown() throws InterruptedException {
        Thread.sleep(2000);
        actiondrpdown.click();
        Actions act = new Actions(driver);
        act.click(pendingApprovals).perform();
    }

    //entering title in new post
    public void entertitle(String title) {
        txttitle.clear();
        txttitle.sendKeys(title);
    }

    //entering image url in new post

    public void enterimageurl(String imageurl) {
        txtimageurl.clear();
        txtimageurl.sendKeys(imageurl);
    }

    //entering image url in edit  post
    public void editallpostimageurl(String imageurl) {
        editallposttxtimageurl.clear();
        editallposttxtimageurl.sendKeys(imageurl);
    }

    //entering category in new post

    public void selectcategory() throws InterruptedException {
        Thread.sleep(4000);
        Select drpcategory = new Select(categorydrpdown);
        drpcategory.selectByVisibleText("SPACE");
    }


    //click submit in new post
    public void btnsubmit() {

        btnsubmitnewpost.sendKeys(Keys.RETURN);
    }

    //click submit in edit post
    public void btnsubmiteditallpostpage() {

        editallpostbtnsubmitnewpost.sendKeys(Keys.RETURN);

    }


    //CLICK SUBMIT EDIT POST INVALI DATA
    public Boolean btnsubmiteditallpostpageINVALIDATA() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", editallpostbtnsubmitnewpost);
        Thread.sleep(2000);
        if (editallpostbtnsubmitnewpost.isEnabled())

            return true;
        else
            return false;


    }

    //entering post in text area
    public void enternewpost(String post) {
        txtpost.clear();
        txtpost.sendKeys(post);
    }

    public void clickMyPosts(){
        myPost.click();
    }

    //entering post in text area when editing
    public void editenterallpost(String post) {
        editallposttxtpost.clear();
        editallposttxtpost.sendKeys(post);
    }

    //welcome to ALLPOSTS
    public String allposttext() {
        return ALLPosttitle.getText();
    }

    //CLICKING edit button in homepage
    public void editallpostclick() throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", Allpostslink);
        Thread.sleep(4000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", Allpostslink);
        Thread.sleep(4000);
        JavascriptExecutor ijs = (JavascriptExecutor) driver;
        ijs.executeScript("arguments[0].scrollIntoView(true);", editallpost);
        Thread.sleep(4000);
        JavascriptExecutor pjs = (JavascriptExecutor) driver;
        pjs.executeScript("arguments[0].click();", editallpost);
        Thread.sleep(4000);


    }


    //CLICKING delete button in homepage
    public void deleteallpostclick() throws InterruptedException {

        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", Allpostslink);
        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", Allpostslink);
        Thread.sleep(2000);
        JavascriptExecutor ijs = (JavascriptExecutor) driver;
        ijs.executeScript("arguments[0].scrollIntoView(true);", deleteallpost);
        Thread.sleep(4000);
        JavascriptExecutor pjs = (JavascriptExecutor) driver;
        pjs.executeScript("arguments[0].click();", deleteallpost);
        deleteallpost.click();
        Thread.sleep(4000);

    }
    public void logout()
    {
        logout.click();
    }

    //for editing post of user login from admin
    public void editFirstPostByUser(String userName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        List<WebElement> cards = driver.findElements(By.xpath("//*[contains(@class, 'card-body')]"));
        for (WebElement card:cards) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card);
            wait.until(ExpectedConditions.visibilityOf(card));
            System.out.println(card.getText());
            WebElement userDescription = card.findElement(By.xpath(".//p"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", userDescription);
            wait.until(ExpectedConditions.visibilityOf(userDescription));
            if (userDescription.getText().contains(userName)){
                System.out.println("Found Card of user.. "+ card);
                WebElement editButton = card.findElement(By.xpath(".//button[contains(text(), 'Edit')]"));
                if (editButton != null){
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);
                    Thread.sleep(1000);
                    editButton.click();
                    break;
                }
            }
        }
    }

    //for deleting post of user login from admin
    public void deleteFirstPostByUser(String userName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        List<WebElement> cards = driver.findElements(By.xpath("//*[contains(@class, 'card-body')]"));
        for (WebElement card:cards) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card);
            wait.until(ExpectedConditions.visibilityOf(card));
            System.out.println(card.getText());
            WebElement userDescription = card.findElement(By.xpath(".//p"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", userDescription);
            wait.until(ExpectedConditions.visibilityOf(userDescription));
            if (userDescription.getText().contains(userName)){
                System.out.println("Found Card of user.. "+ card);
                WebElement editButton = card.findElement(By.xpath(".//button[contains(text(), 'Delete')]"));
                if (editButton != null){
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);
                    Thread.sleep(1000);
                    editButton.click();
                    break;
                }
            }
        }
    }

    public static void isPageLoaded(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement title = driver.findElement(By.xpath("//a[contains(text(),'All posts')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
    }

}