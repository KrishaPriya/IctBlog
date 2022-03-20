package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.font.TextHitInfo;

public class AboutUs {
    WebDriver driver;
    //Title
    @FindBy(xpath="//*[@id=\"about\"]/header/h2")
    private WebElement aboutUsTitle;

    //Image
    @FindBy(xpath="//*[@id=\"about\"]/div/div/div[1]/div/div/img")
    private WebElement aboutusImage;


    public AboutUs(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    // check the visibility of aboutus text
        public String validateaboutusText() {
           // PageUtility.waitForElementTobeclickable(driver, aboutustext,200);
            return aboutUsTitle.getText();

        }

        public void setAboutUsTitle(String title)
    {
        aboutUsTitle.getText();
    }

}
