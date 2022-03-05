package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static final long WEBDRIVER_WAIT_TIME_SEC = 2000;
    WebDriver driver;
    @FindBy(xpath="/html/body/app-root/app-trainerpost/app-header/nav/div/div/ul/li[5]/a")
    public WebElement newpost;

    @FindBy(xpath = "/html/body/app-root/app-mypost/app-header/nav/div/div/ul/li[10]/a")
    private WebElement logout;

    @FindBy(xpath = "/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/a")
    private WebElement selOption;

    @FindBy(xpath = "/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/ul/li[1]/a")
    private WebElement login;


    public  HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void logout()
    {
        logout.click();
    }

    public void clickOnNewPost(){
        driver.findElement(By.xpath("/html/body/app-root/app-mypost/app-header/nav/div/div/ul/li[5]/a")).click();
    }

    public void clickOnMyPost(){
        driver.findElement(By.xpath("/html/body/app-root/app-home/app-header/nav/div/div/ul/li[3]/a")).click();
    }

    public void selectLoginDropdown() {
        selOption.click();
        Actions act = new Actions(driver);
        act.click(login).perform();

    }
}
