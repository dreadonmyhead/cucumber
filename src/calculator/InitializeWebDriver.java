package calculator;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class InitializeWebDriver {

    public static WebDriver driver = null;
    private final static File file = new File("chromedriver.exe");

    @Before
    public void beforeScenario() {
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @After
    public void afterScenario() {
        driver.quit();
    }
}