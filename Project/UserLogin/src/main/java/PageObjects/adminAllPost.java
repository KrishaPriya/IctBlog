package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class adminAllPost {
	WebDriver driver;

public void deleteByUser(String userName) throws InterruptedException {
        List<WebElement> cards = driver.findElements(By.xpath("//*[contains(@class, 'card-body')]"));
        for (WebElement card:cards) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card);
            Thread.sleep(2000);
           // System.out.println(card.getText());
            WebElement userDescription = card.findElement(By.xpath(".//p"));
            if (userDescription.getText().contains(userName)){
              //  System.out.println("Found Card of user.. "+ card);
                WebElement deleteButton = card.findElement(By.xpath(".//button[contains(text(), 'Delete')]"));
                if (deleteButton != null){
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteButton);
                    Thread.sleep(2000);
                    System.out.println("inside delete user name: "+userName);
                    deleteButton.click();
                    break;
                }
            }
        }
    }



public void editFirstPostByUser(String userName) throws InterruptedException {
    List<WebElement> cards = driver.findElements(By.xpath("//*[contains(@class, 'card-body')]"));
    for (WebElement card:cards) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card);
        Thread.sleep(2000);
      //  System.out.println(card.getText());
        WebElement userDescription = card.findElement(By.xpath(".//p"));
        if (userDescription.getText().contains(userName)){
         //   System.out.println("Found Card of user.. "+ card);
            WebElement editButton = card.findElement(By.xpath(".//button[contains(text(), 'Edit')]"));
            if (editButton != null){
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);
                Thread.sleep(2000);
                editButton.click();
                System.out.println("inside Edit user name: "+userName);
                break;
            }
        }
    }
}




public adminAllPost(WebDriver driver) {
	this.driver = driver;
	// This initElements method will create all WebElements
	PageFactory.initElements(driver, this);
}


}
