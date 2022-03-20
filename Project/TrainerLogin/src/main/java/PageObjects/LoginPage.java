package PageObjects;


import Constants.AutomationConstants;
import Utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.datatype.Duration;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;


public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/a")
    private WebElement selOption;

    @FindBy(xpath = "/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/ul/li[1]/a")
    private WebElement login;


    @FindBy(id = "user")
    private WebElement emailId;
    @FindBy(id = "pwd")
    private WebElement password;
    @FindBy(id = "logbut")
    private WebElement Login;

    @FindBy(xpath = "//*[@id=\"log\"]/small[1]")
    private WebElement userNameTextTitle;

    @FindBy(xpath = "//*[@id=\"log\"]/small[2]")
    private WebElement pwdTxtTitle;

    @FindBy(xpath = "//*[@id=\"nav\"]")
    private WebElement Logout;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //for selecting login from dropdown
    public void selectLoginDropdown() {
        selOption.click();
        Actions act = new Actions(driver);
        act.click(login).perform();
    }

    public static void isPageLoaded(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement title = driver.findElement(By.id("user"));
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    //for username
    public void setUserName(String strUserName) {
        emailId.sendKeys(strUserName);
    }

    //for clearing username
    public void clearUserName() {

        emailId.clear();
    }
     //for clearing password
    public void clearPwd() {
        password.clear();
    }
    //set password in textbox
    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    //click on login button
    public void clickLogin() {
        Login.click();
    }

    //for logout
    public void clickLogout() {

        Logout.click();
    }

    //for password field validation
    public String passwordValidation() {
        String pwdValidation= pwdTxtTitle.getText();
       return pwdValidation;

    }

    //for username field validation
    public String validationAssertUsername() {
        String usernameValidation = userNameTextTitle.getText();
        return usernameValidation;
    }

    //for login using username,password
    public void loginToUser(String userName, String password) throws InterruptedException, IOException {
        this.setUserName(userName);
        this.setPassword(password);
        this.clickLogin();
    }

    //for login as admin
    public void loginAsAdmin() throws InterruptedException, IOException{
//        this.selectLoginDropdown();
        String username = ExcelUtility.getAdminCellData(0, 0);
        String password = ExcelUtility.getAdminCellData(0, 1);
        this.loginToUser(username,password);
    }

    //for login as trainer
    public void loginAsTrainer() throws InterruptedException, IOException{
//        this.selectLoginDropdown();
        String username= ExcelUtility.getTrainerCellData(0,0);
        String password=ExcelUtility.getTrainerCellData(0,1);
        this.loginToUser(username,password);
    }

    //finding no of links in header
    public int findNoOfElementsInHeader() throws InterruptedException {

        List<WebElement> elements=driver.findElements(By.xpath("//a[contains(@class, 'nav-link')]"));
        int links=elements.size();

        return links;
    }

    //finding no of textbox in login
    public int findNoOfTextBoxesInLogin() {
        List<WebElement> elements = driver.findElements(By.xpath("//input"));
        int count = elements.size();
        int totalCount = 0;
        System.out.println(count);

        for (WebElement element:  elements) {
            if (element.isEnabled() && element.isDisplayed()    ){
                totalCount ++;
            }
        }
        return totalCount;
    }





      //for finding no of elements in footer
    public int findNoOfElementsInFooter(){
        List<WebElement> elements=driver.findElements(By.xpath("//a[contains(@class, 'text-white')]"));
        int count=elements.size();
        return count;
    }

    //for finding no of button in login
    public int findNoOfButtonInLogin(){
        List<WebElement> elements=driver.findElements(By.xpath("//button[contains(text(),'Login')]"));
        int count=elements.size();
        return count;
    }
}
