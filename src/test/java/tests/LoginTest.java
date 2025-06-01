package tests;

import base.BaseTest;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import pages.LoginPage;
import pages.CommunityPage;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLogin();
        loginPage.login(USERNAME, PASSWORD);

        CommunityPage communityPage = new CommunityPage(driver);
        assertTrue("Login failed", communityPage.isLoggedIn(USERNAME));
    }

    @Test
    public void testLogout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLogin();
        loginPage.login(USERNAME, PASSWORD);

        CommunityPage communityPage = new CommunityPage(driver);
        assertTrue("Login failed", communityPage.isLoggedIn(USERNAME));
        communityPage.logout();

        assertNotNull("Sign in button not visible", loginPage.getSignInButton());
    }
}
