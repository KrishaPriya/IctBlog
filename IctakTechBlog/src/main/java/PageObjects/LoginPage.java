package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class LoginPage {
    WebDriver driver;

   @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/a")
    private WebElement selOption;

    @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/ul/li[1]/a")
    private WebElement login;


    @FindBy(id="user")
    private WebElement Emailid;
    @FindBy(id="pwd")
    private WebElement Password;
    @FindBy(id="logbut")
    private WebElement Login;


    @FindBy(xpath="//*[@id=\"nav\"]")
    private WebElement Logout;


    public LoginPage (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



   public void selectLoginDropdown()
    {
        selOption.click();
        Actions act=new Actions(driver);
        act.click(login).perform();

    }




    //Set emailid in textbox
      public void setUserName(String strUserName)
      {
          Emailid.sendKeys(strUserName);
      }
    //set password in textbox
     public void setPassword(String strPassword)
     {
         Password.sendKeys(strPassword);
     }
    //click on login button
    public void clickLogin()
    {
        Login.click();
    }


    public void clickLogout(){
        Logout.click();
    }

}
