package tests;

import base.BaseTest;
import org.junit.Test;
import pages.LoginPage;
import pages.CommunityPage;
import pages.SettingsPage;
import static org.junit.Assert.assertTrue;

public class ProfileTest extends BaseTest {

    @Test
    public void testChangePronoun() {
        driver.get("https://www.fandom.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLogin();
        loginPage.login(USERNAME, PASSWORD);

        CommunityPage communityPage = new CommunityPage(driver);
        assertTrue("Login failed", communityPage.isLoggedIn(USERNAME));

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.openSettings();
        settingsPage.changePronoun("female");
        settingsPage.confirmChanges();
    }
}