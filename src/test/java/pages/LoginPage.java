package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginButtonOnHome = By.cssSelector("a[data-tracking-label='account.sign-in']");
    private final By usernameInput = By.cssSelector("input#identifier");
    private final By passwordInput = By.cssSelector("input#password");
    private final By loginSubmit = By.cssSelector("button[type='submit']");

    public WebElement getSignInButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(loginButtonOnHome));
    }

    public void openLogin() {
        getSignInButton().click();
    }

    public void login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginSubmit);
    }
}
