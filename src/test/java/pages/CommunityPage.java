package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunityPage extends BasePage {

    public CommunityPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedIn(String expectedUsername) {
        try {
            wait.until(ExpectedConditions.titleContains("Community Central | Fandom"));
            click(avatarButton);
            String actualUsername = getText(userPanelName);
            click(avatarButton);
            System.out.println("Expected: " + expectedUsername + ", Found: " + actualUsername);
            return actualUsername.equalsIgnoreCase(expectedUsername);
        } catch (TimeoutException e) {
            System.out.println("Page title: " + driver.getTitle());
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLogoutSuccessful(String expectedUsername) {
        try {
            wait.until(ExpectedConditions.titleContains("Community Central | Fandom"));
            click(avatarButton);
            String actualUsername = getText(userPanelName);
            click(avatarButton);
            System.out.println("Expected: " + expectedUsername + ", Found: " + actualUsername);
            return actualUsername.equalsIgnoreCase(expectedUsername);
        } catch (TimeoutException e) {
            System.out.println("Page title: " + driver.getTitle());
            return false;
        }
    }



}
