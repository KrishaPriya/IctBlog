package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class setUpApp {
	public static WebDriver driver;

	// txtpwd = driver.findElement(By.xpath("//*[@id=\"password\"]"));
	
	@FindBy(xpath = "/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/a")
	private WebElement selOption;

	@FindBy(xpath = "/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/ul/li[1]/a")
	private WebElement loginlink;

	@FindBy(xpath = "/html/body/app-root/app-home/app-header/nav/div/div/ul/li[11]/ul/li[2]/a")
	private WebElement signUplink;

	public void selectLoginDropdown() throws InterruptedException {
		selOption.click();
		// selecting login from dropdown
		loginlink.click();

	}

	public void selectSignUpDropdown() throws InterruptedException {
		System.out.println("calling user icon");
		if (selOption != null) {
			System.out.println("user icon");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", signUplink);

			//selOption.click();
		}
		else
		{
			System.out.println("sel icon is null ");
		}
		

	}

	public void selectUserLogin() {

		loginlink.click();

	}

	public setUpApp(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

}
