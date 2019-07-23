package basepackage;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Config;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    private final Properties config = Config.loadProperties("src/main/resources/test.properties");

    @BeforeTest
    public void setup(){
        //System.out.println(config.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.driver", config.getProperty("chromedriver"));

        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(config.getProperty("baseurl"));
    }


    @AfterTest
    public void cleanup() {
        driver.manage().deleteAllCookies();
        //TestHelper.sleep5Seconds();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}

