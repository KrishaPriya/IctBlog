package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHepler {
    public static WebDriver driver;

    public void WaitHelper(WebDriver driver)
    {
        WaitHepler.driver=driver;
    }

    public static void  WaitForElement(WebElement element, long timeoutinseconds)
    {
        WebDriverWait mywait=new WebDriverWait(driver,timeoutinseconds);
        mywait.until(ExpectedConditions.visibilityOf(element));

    }
}
