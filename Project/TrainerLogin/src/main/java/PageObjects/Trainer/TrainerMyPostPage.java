package PageObjects.Trainer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TrainerMyPostPage {
    private static final long WEBDRIVER_WAIT_TIME_SEC = 3000;
    WebDriver driver;
    //@FindBy(xpath="/html/body/app-root/app-trainerpost/app-header/nav/div/div/ul/li[5]/a")
    //private WebElement newpost;

   @FindBy(xpath="/html/body/app-root/app-mypost/app-header/nav/div/div/ul/li[5]/a")
   public WebElement newPost;

    @FindBy(xpath="/html/body/app-root/app-mypost/div[2]/li[1]/div/div/div/button[1]")
    private WebElement Edit;

    @FindBy(xpath="//*[@id=\"exampleInputEmail1\"]")
    private WebElement Title;

    @FindBy(xpath="//*[@id=\"exampleInputPassword1\"]")
    private WebElement Image;

    @FindBy(xpath="/html/body/app-root/app-editpost/form/div[4]/textarea")
    private WebElement PostDesc;

    @FindBy(xpath="/html/body/app-root/app-editpost/form/button")
    private WebElement SubmitBtn;

    @FindBy(xpath = "/html/body/app-root/app-mypost/div[2]/li[1]/div/div/div/button[2]")
    private WebElement Delete;



    @FindBy(xpath="/html/body/app-root/app-mypost/div[2]/li[1]/div/div/div/button[1]")
    private WebElement editBtn;


    @FindBy(xpath = "/html/body/app-root/app-mypost/app-header/nav/div/div/ul/li[10]/a")
    private WebElement logout;

    @FindBy(xpath = "/html/body/app-root/app-mypost/app-header/nav/div/div/ul/li[7]/a")
    private WebElement categories;

    public TrainerMyPostPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //for editing post
    public void clickEdit()
    {
        Edit.click();
    }

    //for editing title
    public void setTitle(String strTitle)
    {
        Title.sendKeys(strTitle);
    }

    //for editing image
    public void setImage(String strImage)
    {
        Image.sendKeys(strImage);
    }

    //for editing post
    public void setPostDesc(String strPostDesc)
    {
        PostDesc.sendKeys(strPostDesc);
    }

    //for submit
    public void submit()
    {
        SubmitBtn.click();
    }

    //for delete
    public void clickDelete()
    {
        Delete.click();
    }

    //for logout
    public void logout()
    {
        logout.click();
    }

    //for deleting post
    public void deletePost() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",Delete);

        Thread.sleep(1000);
        Delete.click();
    }

    public static void isPageLoaded(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement title = driver.findElement(By.xpath("//h2[contains(text(),'My Posts')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    //for deleting all post
    public int deleteAllPost() throws InterruptedException {
        Thread.sleep(3000);
        WebElement button = getNextDeleteButton();
        int count = 0;
        while (button != null){
            count++;
            // scroll to button.
            System.out.println("Found Delete Button "+ button.getText());
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);Thread.sleep(1000);

            // Delete action
            button.click();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WEBDRIVER_WAIT_TIME_SEC));
            WebDriverWait w = new WebDriverWait(driver, WEBDRIVER_WAIT_TIME_SEC);

            // Accept Delete
            if(w.until(ExpectedConditions.alertIsPresent())==null) {
              System.out.println("We should have got alert");
            }
            else {
                driver.switchTo().alert().getText();
                driver.switchTo().alert().accept();
            }


            // Get next delete.
            if (w.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("button")))) == null){
                System.out.println("page refresh failed...");
            }else{
                Thread.sleep(1000);
                button = getNextDeleteButton();
            }
        }

        return count;
    }

    private WebElement getNextDeleteButton(){
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        int count1 =0;
        for(WebElement button : buttons){
            if(button.getText().equals("Delete")){
               return button;
            }
        }

        return null;
    }

    //for clicking new post
   public void clickOnNewPost(){
        driver.findElement(By.xpath("/html/body/app-root/app-mypost/app-header/nav/div/div/ul/li[5]/a")).click();
    }


    //for clicking edit my post
    public void  editMyPost() throws InterruptedException {
        Thread.sleep(WEBDRIVER_WAIT_TIME_SEC);
        WebElement button = getNextEditButton();
        if (button != null) {
            // scroll to button.

            System.out.println("Found Edit Button " + button.getText());
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

            Thread.sleep(1000);
            // Edit action
            button.click();
            Thread.sleep(2000);

        }
    }

    private WebElement getNextEditButton(){
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        int count1 =0;
        for(WebElement button : buttons){
            if(button.getText().equals("Edit")){
                return button;
            }
        }

        return null;
    }


    //Select for categories from dropdown
    public void selectCategoriesDropdown(String category) throws InterruptedException {
        Thread.sleep(2000);
        categories.click();
        List<WebElement> cards = driver.findElements(By.xpath("//*[contains(@class, 'dropdown-item')]"));
        for (WebElement card : cards) {
            if (card.getText().equals(category)) {
                System.out.println(card.getText());
                card.click();
                break;
            }
        }
    }

}
