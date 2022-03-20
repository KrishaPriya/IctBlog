package PageObjects.Trainer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainerEditPost {
    WebDriver driver;
    TrainerEditPost objEdit;

    @FindBy(xpath="/html/body/app-root/app-editpost/form/div[1]/input")
    private WebElement title;

    @FindBy(xpath="/html/body/app-root/app-editpost/form/div[3]/input")
    private WebElement image;

    @FindBy(xpath="/html/body/app-root/app-editpost/form/div[4]/textarea")
    private WebElement postDesc;

    @FindBy(xpath="/html/body/app-root/app-editpost/form/button")
    private WebElement submit;

    //initialization
    public TrainerEditPost(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //for entering title
    public void setTitle(String strTitle) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",title);
        Thread.sleep(3000);
        title.clear();
        title.sendKeys(strTitle);
    }
    //for entering image
    public void setImage(String strImage)
    {
        image.clear();
        image.sendKeys(strImage);
    }

    //for entering post
    public void setPostDesc(String strPost)
    {
        postDesc.clear();
        postDesc.sendKeys(strPost);
    }

    //for submit
    public void setSubmit() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);" ,submit);
        wait.until(ExpectedConditions.visibilityOf(submit));
        submit.click();
    }
    //for checking is submit is enabled
    public boolean btnSubmitNotEnabled() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);" ,submit);
        wait.until(ExpectedConditions.visibilityOf(submit));
        return submit.isEnabled();
    }

    public static void isPageLoaded(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement title = driver.findElement(By.xpath("//h2[contains(text(),'Edit post')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
    }


}
