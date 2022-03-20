# IctBlog

This project contains the automation code for ICT website. http://64.227.132.106/

The Project structure have 
1. Demo : This contains all the demo videos
2. Report: This folder contains combined reports from the TestNG/Extent Report / JMeter 
3. Project : This is divided in 3 main seperate Eclipse/Intellij project. 
⋅⋅* Trainer Feature
⋅⋅* User Feature
⋅⋅* Admin Feature
⋅⋅* Page Navigation 


To run the project for the individual feature open /Projects/<Feature> in Eclipse and Intellij and run the TestNG test.xml file from the run configuration. 
  The demo video show how to open the Trainer project and run in eclipse in mac enviroment. 

  
# Demo
  
  [![IMAGE ALT TEXT HERE](http://img.youtube.com/vi/W1L_wc9cjNo/0.jpg)](http://www.youtube.com/watch?v=W1L_wc9cjNo)

  
# NOTE
  Each Feature are currently  build in seperate env (Windows / Mac) So before running the code we need to change the driver path. 

```java
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
```
