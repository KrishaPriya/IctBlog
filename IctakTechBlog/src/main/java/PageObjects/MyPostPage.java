package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPostPage {
    WebDriver driver;

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




    public  MyPostPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickEdit()
    {
        Edit.click();
    }

    public void setTitle(String strTitle)
    {
        Title.sendKeys(strTitle);
    }

    public void setImage(String strImage)
    {
        Image.sendKeys(strImage);
    }

    public void setPostDesc(String strPostDesc)
    {
        PostDesc.sendKeys(strPostDesc);
    }

    public void submit()
    {
        SubmitBtn.click();
    }
    public void clickDelete()
    {
        Delete.click();
    }


}
