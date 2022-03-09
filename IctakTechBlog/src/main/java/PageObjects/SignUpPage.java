package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class SignUpPage {
    WebDriver driver;





    @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/a/img")
    private WebElement selOptions;
    @FindBy(xpath="/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/ul/li[2]/a")
    private WebElement signUp;
    //Identify elements
    @FindBy(id="first")
    private WebElement Name;

    @FindBy(xpath="//*[@id=\"sign\"]/select[1]")
    private WebElement Account;

    @FindBy(xpath="//*[@id=\"sign\"]/select[2]")
    private WebElement Qualification;

    @FindBy(id="em")
    private WebElement Email;

    @FindBy(id="pw")
    private WebElement Password;

    @FindBy(xpath="//*[@id=\"but\"]")
    private WebElement Submit;

    @FindBy(xpath="//*[@id=\"sign\"]/h3")
    private WebElement signupHeader;

    @FindBy(xpath="//*[@id=\"sign\"]/small[3]/b")
    private WebElement usernameValidMsg;
    @FindBy(xpath="//*[@id=\"sign\"]/small[4]/b ")
    private WebElement passwordValidMsg;

    //Initialization
    public  SignUpPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //for selecting signup from dropdown
    public void selectSignUpDrop()
    {
        selOptions.click();
        Actions act=new Actions(driver);
        act.click(signUp).perform();
    }

    //for entering name
    public void setName(String strName){
        Name.sendKeys(strName);
    }

    //for selecting trainer account
    public void setTrainerAccount(){
        Select acctDrp=new Select(Account);
        acctDrp.selectByIndex(1);
    }

    //for selecting user account
    public void setUserAccount(){
        Select acctDrp=new Select(Account);
        acctDrp.selectByIndex(0);
    }

    //for selecting qualification from dropdown
    public void setQualification(){
        Select qualifyDrp=new Select(Qualification);
        qualifyDrp.selectByIndex(2);
    }

    //for entering email
    public void setEmail(String strEmail){
        Email.clear();
        Email.sendKeys(strEmail);
    }

    //for entering password
    public void setPassword(String strPassword){
        Password.clear();
        Password.sendKeys(strPassword);
    }

    //for clearing textfield
    public void clearTextFields(){
        Password.clear();
        Email.clear();
        Name.clear();
    }

    //click on signup submit
    public void clickSubmit(){
      //  Actions action = new Actions(driver);
       // action.moveToElement(Submit).click().perform();

        Submit.click();
    }

    //signup heading
    public String setSignupHeader()
    {
        String actSignUpTitle=signupHeader.getText();
        return actSignUpTitle;
    }

    //for validating signed up user
    public String validUserText()
    {
        String usernameTextValidMsg=usernameValidMsg.getText();
        return usernameTextValidMsg;

    }

    //for validating password field
    public String validPasswordText()
    {
        String passwordTextValidMsg=passwordValidMsg.getText();
        return passwordTextValidMsg;

    }

    //for generating random email id
    public void enterNewRandomMailId(){
        Email.click();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        Email.sendKeys("username"+ randomInt +"@gmail.com");
    }

    //for validating qualification for trainer signup
    public Boolean qualificationIsDisplayed(){
        try {
            return Qualification.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}
