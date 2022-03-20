package PageObjects;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.WaitHelper;

public class newPosts {
	WebDriver driver;

	@FindBy(name = "P_title")
	private WebElement title;
	@FindBy(name ="P_author")
	private WebElement author;

	@FindBy(xpath = "/html/body/app-root/app-editpost/form/div[3]/input")
	private WebElement postImage;

	@FindBy(xpath = "/html/body/app-root/app-usernewpost/form/div[4]/select")
	private WebElement category;

	@FindBy(name = "p_post")
	private WebElement posts;

	// @FindBy(className = "btn-primary")
	// @FindBy(css = "button[type=submit]")

	@FindBy(xpath = "/html/body/app-root/app-editpost/form/button")
	private WebElement btnSubmitEditPost;

	@FindBy(xpath = "/html/body/app-root/app-usernewpost/form/button")
	private WebElement btnApprove;

	public void setAuthor(String strAuthor) {
		if (author != null) {
			author.clear();
			WaitHelper.waitForElementTobeVisible(driver, author, 500);
			author.sendKeys(strAuthor);
		}
	}

	public void setImages(String strImages) {
		
		if (postImage != null) {
			//System.out.println(postImage);
			
			postImage.sendKeys(strImages);
			WaitHelper.waitForElementTobeVisible(driver, postImage, 5000);
		}
	}

	public void setCategory(String strCategory) {
		WaitHelper.waitForElementTobeVisible(driver, category, 1000);
		if (category != null) {
			//System.out.println(category);
			Select cat = new Select(category);
			cat.selectByVisibleText(strCategory);
		}
	}

	public void setPosts(String strPosts) {
		if (posts != null) {
			WaitHelper.waitForElementTobeVisible(driver, posts, 500);
			posts.sendKeys(strPosts);
		}
	}

	public void setTitle(String strTitle) {
		if (title != null) {
			WaitHelper.waitForElementTobeVisible(driver, title, 500);
			title.sendKeys(strTitle);
		}
	}

	public newPosts(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void addNewPost() throws Exception {
		WaitHelper.waitForElementTobeVisible(driver, btnApprove, 5000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", btnApprove);
	}

	public void submitEditPost() {
		Actions act = new Actions(driver);
		WaitHelper.waitForElementTobeVisible(driver,btnSubmitEditPost,500);
	//	btnSubmitEditPost.click();
		
		
}

	public void editFirstPostfromUser(String userName) throws InterruptedException {
		List<WebElement> cards = driver.findElements(By.xpath("//*[contains(@class, 'card-body')]"));
		for (WebElement card : cards) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card);
			Thread.sleep(2000);
			// System.out.println(card.getText());
			WebElement userDescription = card.findElement(By.xpath(".//p"));
			if (userDescription.getText().contains(userName)) {
				// System.out.println("Found Card of user.. "+ card);
				WebElement editButton = card.findElement(By.xpath(".//button[contains(text(), 'Edit')]"));
				if (editButton != null) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);
					WaitHelper.waitForElementTobeVisible(driver, editButton, 500);
					editButton.click();
					//System.out.println("inside Edit user name: " + userName);
					break;
				}
			}
		}
	}

	public void deletePostFromMyUserPost(String postName) throws InterruptedException {
		List<WebElement> cards = driver.findElements(By.xpath("//*[contains(@class, 'card-body')]"));
		for (WebElement card : cards) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card);
			Thread.sleep(2000);
			System.out.println(card.getText());
			WebElement userDescription = card.findElement(By.xpath(".//p"));
			String str = userDescription.getText();
			if (userDescription.getText().contains(postName)) {
				// System.out.println("Found Card of user.. "+ str);
				WebElement deleteButton = card.findElement(By.xpath(".//button[contains(text(), 'Delete')]"));
				if (deleteButton != null) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteButton);
					Thread.sleep(2000);
					//System.out.println("inside delete user name: " + postName);
					deleteButton.click();
					break;
				}
			}
		}
	}

}
