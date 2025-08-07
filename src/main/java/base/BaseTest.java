package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import utils.WebDriverFactory;
import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader config;

    @BeforeClass
    public void setUp() {
        config = new ConfigReader();
        driver = WebDriverFactory.createDriver(config.getProperty("browser"));
        driver.manage().window().maximize();
        driver.get(config.getProperty("baseUrl"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
