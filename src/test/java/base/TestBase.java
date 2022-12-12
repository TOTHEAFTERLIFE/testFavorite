package base;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import util.TestSettings;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase extends TestSettings {
    protected static WebDriver driver;
    protected static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/config/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("Start the test, open https://www.ivi.ru website")
    @BeforeTest
    public static void start() {
        System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");

        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestSettings.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestSettings.IMPLICIT_WAIT));
        driver.get(prop.getProperty("url"));
    }

    @AfterTest
    public static void end() {
        driver.quit();
    }
}
