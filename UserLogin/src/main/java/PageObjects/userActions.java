package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userActions {
	WebDriver driver;

	@FindBy(linkText = "New post")
	private WebElement newPost;
	
	@FindBy(css = "button[type=submit]")
	 private WebElement btnApprove;
	public userActions(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	//
	public void NewPost() {
		newPost.click();
	}

	// Send for approval
	public void sendForPost() {
		btnApprove.click();
	}

	/*
	 * //// Editing post public void EditPost() { btnEdit.click(); }
	 */

}
