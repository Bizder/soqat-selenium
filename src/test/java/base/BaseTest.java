package base;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static final String USERNAME = "test_username";
    protected static final String PASSWORD = "test_password";

    @Before
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--incognito");
        options.addArguments("--window-size=50,50");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://www.fandom.com/");
        acceptCookiesIfPresent();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void acceptCookiesIfPresent() {
        try {
            By acceptBtn = By.id("onetrust-accept-btn-handler");
            WebDriverWait shortWait = new WebDriverWait(driver, 5);

            WebElement btn = shortWait.until(ExpectedConditions.presenceOfElementLocated(acceptBtn));
            if (btn.isDisplayed() && btn.isEnabled()) {
                btn.click();
                Thread.sleep(1000); // javascript magic
            }
        } catch (TimeoutException e) {
            System.out.println("No cookie popup appeared.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}