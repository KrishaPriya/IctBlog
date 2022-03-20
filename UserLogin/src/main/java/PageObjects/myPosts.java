package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class myPosts {
	WebDriver driver;
	
	@FindBy(linkText = "New post")
	private WebElement lnkNewPost;
	
	public void NewPost() {
		lnkNewPost.click();
		WaitHelper.waitForElementTobeVisible(driver,lnkNewPost,90);
	}
	
	public myPosts(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

}
