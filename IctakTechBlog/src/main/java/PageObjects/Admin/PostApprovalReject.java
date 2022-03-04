package PageObjects.Admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PostApprovalReject {
    //2 posts must be there
    WebDriver driver;


    @FindBy(xpath = "//a[contains(text(),'New post')]")
    private WebElement newpostlink;


    @FindBy(xpath = "//button[contains(text(),'Approve')]")
    private WebElement btnApprove;

    @FindBy(xpath = "//button[contains(text(),'Reject')]")

    private WebElement btnReject;
    @FindBy(xpath = "/html/body/app-root/app-comment/form/div/textarea")

    private WebElement txtcomment;
    @FindBy(xpath = "//button[contains(text(),'send')]")
    private WebElement btnsend;

    @FindBy(xpath = "//p[contains(text(),'Actions')]")
    private WebElement actiondrpdown;

    @FindBy(xpath = "//a[contains(text(),'Pending Approvals')]")
    private WebElement pendingapproval;

    @FindBy(xpath = "//body/app-root[1]/app-usernewpost[1]/form[1]/div[3]/input[1]")
    private WebElement txtimageurluser;

    @FindBy(xpath = "/html/body/app-root/app-usernewpost/form/div[4]/select")
    private WebElement categorydrpdownuser;

    @FindBy(xpath = "//body/app-root[1]/app-usernewpost[1]/form[1]/div[5]/textarea[1]")
    private WebElement txtpostuser;

    @FindBy(xpath = "/html/body/app-root/app-usernewpost/form/button")
    private WebElement sendforapproval;


    public PostApprovalReject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    //selecting from Actions menu
    public void selectactionsdropdown() throws InterruptedException {
        Thread.sleep(4000);
        actiondrpdown.click();
        Actions act = new Actions(driver);
        act.click(pendingapproval).perform();

    }


    //entering image url in new post
    public void enterimageurluser(String imageurl) {
        txtimageurluser.clear();
        txtimageurluser.sendKeys(imageurl);
    }


    //entering category in new post

    public void selectcategory() throws InterruptedException {
        Thread.sleep(4000);
        Select drpcategory = new Select(categorydrpdownuser);
        drpcategory.selectByIndex(1);
    }

    //entering post in text area
    public void enternewpostuser(String post) {
        txtpostuser.clear();
        txtpostuser.sendKeys(post);
    }


    //SELECT NEWPOST LINK
    public void NewPostLink() throws InterruptedException {
        Thread.sleep(2000);


        Actions act = new Actions(driver);
        act.click(newpostlink).perform();

        newpostlink.click();
    }

    public void clickapproval() {
        btnApprove.click();

    }


    public void sendforapproval() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", sendforapproval);
        Thread.sleep(2000);
    }

    public void clickreject() {
        btnReject.click();

    }

    public void entercomments(String comment) {
        txtcomment.clear();
        txtcomment.sendKeys(comment);


    }

    public void clicksend() throws InterruptedException {
        // btnsend.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", btnsend);
        Thread.sleep(2000);
    }
}
