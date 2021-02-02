package base;

import driver.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class TestUtils {
    private String url;
    private int implicitWait;
    public WebDriver driver;

    @BeforeSuite
    public void readConfigProperties(){
        try(FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")){
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            //browser to be taken from property file!!!
            log.info("Url is: " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void initTest(){
        setupBrowserDriver();
        loadUrl();
    }

    @AfterTest
    public void tearDownDriver(){
        driver.quit();
    }

    private void setupBrowserDriver(){
        driver = DriverFactory.getFirefoxDriver(implicitWait);
        //maybe add something more?
//            driver = DriverFactory.getChromeDriver(implicitWait);
    }

    private void loadUrl(){
        driver.get(url);
    }
}
