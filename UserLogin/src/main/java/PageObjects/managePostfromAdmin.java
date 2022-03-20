package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class managePostfromAdmin {
	WebDriver driver;


//for editing post in admin login


public void editFirstPostByUser(String userName) throws InterruptedException {
        List<WebElement> cards = driver.findElements(By.xpath("//*[contains(@class, 'card-body')]"));
        for (WebElement card:cards) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card);
            Thread.sleep(2000);
            System.out.println(card.getText());
            WebElement userDescription = card.findElement(By.xpath(".//p"));
            if (userDescription.getText().contains(userName)){
                System.out.println("Found Card of user.. "+ card);
                WebElement editButton = card.findElement(By.xpath(".//button[contains(text(), 'Edit')]"));
                if (editButton != null){
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);
                    Thread.sleep(2000);
                    editButton.click();
                    break;
                }
            }
        }
    }


//deleting post in admin login

public void deleteFirstPostByUser(String userName) throws InterruptedException {
        List<WebElement> cards = driver.findElements(By.xpath("//*[contains(@class, 'card-body')]"));
        for (WebElement card:cards) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card);
            Thread.sleep(2000);
            System.out.println(card.getText());
            WebElement userDescription = card.findElement(By.xpath(".//p"));
            if (userDescription.getText().contains(userName)){
                System.out.println("Found Card of user.. "+ card);
                WebElement deleteButton = card.findElement(By.xpath(".//button[contains(text(), 'Delete')]"));
                if (deleteButton != null){
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteButton);
                    Thread.sleep(2000);
                    deleteButton.click();
                    break;
                }
            }
        }
    }




	public managePostfromAdmin(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
}
