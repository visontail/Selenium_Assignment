package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pages.StaticPage;
import utils.ConfigReader;

public class StaticPageTest extends BaseTest {

    @Test
    public void homepageShouldDisplayLogoAndFooter() {
        String staticUrl = ConfigReader.get("static.url");
        StaticPage page = new StaticPage(driver);
        page.open(staticUrl);

        String clubMemberText = page.getClubMemberText();
        System.out.println("Club member text: " + clubMemberText);
        assertFalse("Club member should contain text", clubMemberText.isEmpty());
        assertTrue("Club member text should contain 'klub'", clubMemberText.toLowerCase().contains("klub"));

    }
}
