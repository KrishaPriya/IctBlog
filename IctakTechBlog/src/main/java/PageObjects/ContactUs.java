package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {
    WebDriver driver;
    @FindBy(xpath="//*[@id=\"contact\"]/h1")
    private WebElement contactusTitle;

    @FindBy(xpath="//*[@id=\"name\"]")
    private WebElement name;

    @FindBy(xpath="//*[@id=\"email\"]")
    private WebElement email;

    @FindBy(xpath="//*[@id=\"contact-form\"]/div[3]/textarea")
    private WebElement message;

    @FindBy(xpath="//*[@id=\"submit\"]")
    private WebElement submit;

    @FindBy(xpath="//*[@id=\"contact\"]/div/div/ul[2]/li[1]/a")
    private WebElement socialmedialogo1;
    @FindBy(xpath="//*[@id=\"contact\"]/div/div/ul[2]/li[2]/a")
    private WebElement socialmedialogo2;
    @FindBy(xpath="//*[@id=\"contact\"]/div/div/ul[2]/li[3]/a")
    private WebElement socialmedialogo3;
    @FindBy(xpath="//*[@id=\"contact\"]/div/div/ul[2]/li[4]/a")
    private WebElement socialmedialogo4;

    @FindBy(xpath="//*[@id=\"contact\"]/div/div/div")
    private WebElement allrightstext;





    public ContactUs(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
