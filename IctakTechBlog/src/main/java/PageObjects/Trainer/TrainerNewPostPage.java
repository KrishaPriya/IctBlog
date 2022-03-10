package PageObjects.Trainer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainerNewPostPage {
    WebDriver driver;

    @FindBy(id = "exampleInputEmail1")
    private WebElement Title;

    @FindBy(xpath = "/html/body/app-root/app-trainerpost/form/div[3]/input")
    private WebElement Image;

    @FindBy(xpath = "/html/body/app-root/app-trainerpost/form/div[4]/select")
    private WebElement Category;

    @FindBy(xpath = "/html/body/app-root/app-trainerpost/form/div[5]/textarea")
    private WebElement Post;

    @FindBy(xpath = "/html/body/app-root/app-trainerpost/form/button")
    private WebElement Submit;

    @FindBy(xpath = "/html/body/app-root/app-trainerpost/div/h2")
    private WebElement actualTitle;

    @FindBy(xpath = "//*[@id=\"nav\"]")
    private WebElement Logout;


    public TrainerNewPostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //for adding title
    public void setTitle(String strTitle) {
        Title.sendKeys(strTitle);

    }

    //for adding image
    public void setImage(String imgurl) {
        Image.sendKeys(imgurl);
    }

    //for selecting from category
    public void setCategory() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Category);
        Select categoryMenu = new Select(Category);
        categoryMenu.selectByVisibleText("SPACE");
    }


    //for adding post
    public void setPost(String postdesc) {
        Post.sendKeys(postdesc);
    }

    //for submit
    public void clickSubmit() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Submit);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(Submit));
        Submit.click();
    }

    public boolean isSubmitButtonEnabled(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Submit);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(Submit));
        return Submit.isEnabled();
    }

    //for logout
    public void clickLogout() {
        Logout.click();
    }

    //for getting title of the page
    public String getHeading() {
        String actTitle = actualTitle.getText();
        return actTitle;
    }

    //for checking submit button is enabled
    public boolean btnSubmitNotEnabled() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Submit);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(Submit));
        if (Submit.isEnabled())
            System.out.println("We got alert");
        return false;

    }

    public static void isPageLoaded(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement title = driver.findElement(By.xpath("//h2[contains(text(),'Add new post')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
    }

}



