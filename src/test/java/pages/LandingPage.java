package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    private static final By logo = By.cssSelector("img.feed-header__logo");

    public boolean isLogoDisplayed() {
        WebElement logoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
        return logoElement.isDisplayed();
    }
}
