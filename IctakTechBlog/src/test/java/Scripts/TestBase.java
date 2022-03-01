package Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static Properties prop = null;
    WebDriver driver;
    String driverpath = "/Users/naveenmurthy/Documents/Priya/FirefoxWebDriver/geckodriver";

    public static void TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Parameters("browser")
    @BeforeClass
    public void onSetup(String browserName) {
        Thread.currentThread().getStackTrace();
        System.out.println("onSetup is called....");
        TestBase();
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverpath);
            driver = new ChromeDriver();
        }
        if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", driverpath);
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

}

