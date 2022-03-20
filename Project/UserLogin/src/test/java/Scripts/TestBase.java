package Scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

//All annotation
public class TestBase {

	public WebDriver driver;
	public static Properties prop = null;
	String driverPath = "D:\\Driver\\chromedriver.exe";

	public static void TestBase() {
		try {
			// Below line creates an object of Properties called 'prop'
			prop = new Properties();
			// Below line creates an object of FileInputStream called 'ip'. //Give the path
			// of the properties file which you have created
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources" + "/config.properties");
			// Below line of code will load the property file

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void onSetup() {
		// prop = new Properties();
		// for loading the configurations
		TestBase();

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			Reporter.log("---Chrome  loading setup---", true);
		}

		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Reporter.log("---end  loading setup---", true);

	}
	
	 @AfterTest
     public void tearDown() {      
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.quit();
     }
}
