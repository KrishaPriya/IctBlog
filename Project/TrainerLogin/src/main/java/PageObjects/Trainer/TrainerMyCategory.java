package PageObjects.Trainer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TrainerMyCategory {

    private static final long WEBDRIVER_WAIT_TIME_SEC = 3000;
    WebDriver driver;

    @FindBy(xpath = "/html/body/app-root/app-group/div[1]/h2")
    private WebElement tittle;

    @FindBy(xpath = "/html/body/app-root/app-group/app-header/nav/div/div/ul/li[10]/a")
    private WebElement logout;

    @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[7]/ul/li[10]/a")
    private WebElement space;

    @FindBy(xpath = "/html/body/app-root/app-group/app-header/nav/div/div/ul/li[7]/a")
    private WebElement categories;

    public TrainerMyCategory(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    //for getting title
    public String getTitle() {
        return tittle.getText();
    }

    //for logout
    public void clickLogout() {
        logout.click();
    }

    //for sorting
    public int sortByCategoryCount(String userName) throws InterruptedException {
//        List<WebElement> cards = driver.findElements(By.xpath("//*[contains(@class, 'card-body')]"));
        List<WebElement> userNames = driver.findElements(By.xpath("//p[contains(text(),'By "+userName+"')]"));
        return userNames.size();
    }

    public static void isPageLoaded(WebDriver driver, String category){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement title = driver.findElement(By.xpath("//h2[contains(text(),'"+category+"')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
    }
}
