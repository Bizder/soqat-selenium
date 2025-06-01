package tests;

import base.BaseTest;
import org.junit.Test;
import pages.LandingPage;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StaticPageTest extends BaseTest {

    @Test
    public void testLandingPage() {
        LandingPage landingPage = new LandingPage(driver);
        assertTrue(landingPage.isLogoDisplayed());
        assertEquals("Fandom", driver.getTitle());
        assertEquals("https://www.fandom.com/", driver.getCurrentUrl());

        // 4 extra points
        driver.navigate().back();
        wait.until(ExpectedConditions.urlContains("data:,"));
    }
}
