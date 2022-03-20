package Scripts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestBase {
    public static Properties prop = null;
    public WebDriver driver;
    public static String driverpath = "";
    public static int retryCount = 0;

    public static void TestBase() {
        try {
            driverpath = System.getProperty("user.dir") + "/src/test/resources/geckodriver";
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
        TestBase();
        System.out.println("onSetup is called....");
        try {
            if (browserName.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", driverpath);
                driver = new ChromeDriver();
            }
            if (browserName.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", driverpath);
                driver = new FirefoxDriver();
            }
            driver.get(prop.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.urlToBe(prop.getProperty("url")));
        }catch (Exception e) {
            if (retryCount < 5){
                retryCount ++;
                onSetup(browserName);
                return;
            }
            System.out.println("Failed to setup webderiver");
        }



//        driver.manage().window().maximize();
//        driver.manage().window().setPosition(new Point(1024,0));
//        driver.manage().window().setSize(new Dimension(1024,728));
    }


    @AfterClass
    public void teardown() {
        driver.quit();
    }

}

