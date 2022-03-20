package PageObjects;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private static final long WEBDRIVER_WAIT_TIME_SEC = 2000;
    WebDriver driver;
     // @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[5]/a")
      //private WebElement newpost;


   @FindBy(xpath="/html/body/app-root/app-trainerpost/app-header/nav/div/div/ul/li[5]/a")
   private WebElement newpost;

    @FindBy(xpath = "/html/body/app-root/app-mypost/app-header/nav/div/div/ul/li[10]/a")
    private WebElement logout;

    @FindBy(xpath = "/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/a")
    private WebElement selOption;

    @FindBy(xpath = "/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/ul/li[1]/a")
    private WebElement login;

    @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[7]/a/p")
    private WebElement categories;

    @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/a/img")
    private WebElement logo;

    @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[7]/ul/li[10]/a")
    private WebElement space;

    @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[3]/a")
    private WebElement myPost;

    @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/ul/li[2]/a")
    private WebElement signUp;

    @FindBy(xpath="//a[contains(@class, 'nav-link')]")
    private WebElement headerLinks;

    public  HomePage(WebDriver driver)
    {
        HomePage.isPageLoaded(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //for clicking logout
    public void logout()
    {
        logout.click();
    }

   /* public void clickOnNewPost(){
        driver.findElement(By.xpath("/html/body/app-root/app-mypost/app-header/nav/div/div/ul/li[5]/a")).click();
    }
    */

    //for clicking new post
    public void clickOnNewPost() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",newpost);
        Thread.sleep(2000);
        newpost.click();
    }
    //for clikcing mypost
    public void clickOnMyPost() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("/html/body/app-root/app-home/app-header/nav/div/div/ul/li[3]/a"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(1000);
        element.click();

    }
    //for clicking About us
    public void clickOnAboutUs(){
        driver.findElement(By.xpath("//*[@id=\"nav\"]"));
    }

    //for clicking contact us
    public void clickOnContactUs() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("/html/body/app-root/app-home/app-header/nav/div/div/ul/li[9]/a"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(1000);
        element.click();
    }

    //Select for categories from dropdown
    public void selectCategoriesDropdown(){
        categories.click();
        Actions act=new Actions(driver);
        act.click(space).perform();
    }

    //Select for login from dropdown
    public void selectLoginDropdown() {
        selOption.click();
        Actions act = new Actions(driver);
        act.click(login).perform();

    }
    //Select for login from dropdown
    public void selectSignUpDropdown() {
        selOption.click();
        Actions act = new Actions(driver);
        act.click(signUp).perform();

    }
     //for validating logo
    public boolean setLogo(){
        return logo.isDisplayed();
    }



    public void findNoOfElementsInDropDown(){
        //for selecting space

        driver.findElement(By.xpath("/html/body/app-root/app-home/app-header/nav/div/div/ul/li[7]/a")).click();
        List<WebElement> elements=driver.findElements(By.xpath("/html/body/app-root/app-home/app-header/nav/div/div/ul/li[7]/ul"));
        System.out.println("No of elements:" +elements.size());
        for(WebElement element:elements){

        }
    }





    public static void isPageLoaded(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement title = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
    }

}
