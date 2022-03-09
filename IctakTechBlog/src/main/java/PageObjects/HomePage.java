package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    public  HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void logout()
    {
        logout.click();
    }

   /* public void clickOnNewPost(){
        driver.findElement(By.xpath("/html/body/app-root/app-mypost/app-header/nav/div/div/ul/li[5]/a")).click();
    }
    */

    public void clickOnNewPost() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",newpost);
        Thread.sleep(2000);
        newpost.click();
    }

    public void clickOnMyPost() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",myPost);
        Thread.sleep(2000);
        myPost.click();

    }
    public void clickOnAboutUs(){
        driver.findElement(By.xpath("//*[@id=\"nav\"]"));
    }
    public void clickOnContactUs(){
        driver.findElement(By.xpath("/html/body/app-root/app-home/app-header/nav/div/div/ul/li[9]/a")).click();
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
}
