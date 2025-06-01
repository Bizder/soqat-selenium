package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class SettingsPage extends BasePage {

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    private static final By preferencesLink = By.xpath("//a[@href='/wiki/Special:Preferences']");
    private static final By pronounDropdown = By.cssSelector("select[name='pronoun']");
    private static final By saveButton = By.xpath("//button[span[text()='Save']]");

    public void openSettings() {
        click(avatarButton);
        click(preferencesLink);
    }

    public void changePronoun(String genderValue) {
        // Match value must be "unknown", "male", or "female"
        String selector = String.format("input[name='wpgender'][value='%s']", genderValue.toLowerCase());
        WebElement radio = driver.findElement(By.cssSelector(selector));

        // Actions are not present in the selenium version 2.52
        // due to this i did not bother use scrolling anymore
        ((JavascriptExecutor) driver).executeScript(
            "const element = arguments[0];" +
            "const rect = element.getBoundingClientRect();" +
            "const headerOffset = 100;" +
            "window.scrollTo({" +
            "  top: window.scrollY + rect.top - headerOffset," +
            "  behavior: 'smooth'" +
            "});", radio);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        if (!radio.isSelected()) {
            radio.click();
        }
    }

    public void confirmChanges() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        click(saveButton);
    };
}
