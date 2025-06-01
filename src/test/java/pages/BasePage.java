package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static final By avatarButton = By.cssSelector("button[aria-label='User menu']");
    protected static final By userPanelName = By.cssSelector(".user-panel__name");
    protected static final By signOutLink = By.cssSelector("a.user-panel__sign-out");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        waitForVisibility(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    public void logout() {
        click(avatarButton);
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(signOutLink));
        click(signOutLink);
    }
}