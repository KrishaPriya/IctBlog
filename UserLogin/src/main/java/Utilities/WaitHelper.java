package Utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class WaitHelper {

	public static WebElement waitForElementTobeVisible(WebDriver driver, WebElement elementToBeLoaded, int Time) {
		WebDriverWait wait = new WebDriverWait(driver, Time);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
		return element;
	}

	public static void hitenter(WebDriver driver, WebElement element) {
		// Retrieve WebElemnt to perform mouse hover
		Actions actions = new Actions(driver);
		actions.sendKeys(element, Keys.ENTER);
		actions.build().perform();
	}

}
