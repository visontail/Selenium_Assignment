package tests;

import org.junit.Test;
import pages.StaticPage;
import utils.ConfigReader;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class MultiStaticPageTest extends BaseTest {

    @Test
    public void testStaticPages() {
        StaticPage staticPage = new StaticPage(driver);
        List<String> urls = Arrays.asList(
                ConfigReader.get("static.url"),
                ConfigReader.get("static.page.shipping"),
                ConfigReader.get("static.page.payment")
        );

        for (String url : urls) {
            System.out.println("Testing static page: " + url);
            staticPage.open(url);

            String pageText = "";
            if (url.contains("klub")) {
                pageText = staticPage.getClubMemberText();
            } else if (url.contains("szallitasi")) {
                pageText = staticPage.getShippingText();
            } else if (url.contains("fizetesi")) {
                pageText = staticPage.getPaymentText();
            } else {
                throw new IllegalArgumentException("Unknown static page URL: " + url);
            }

            assertFalse("The text on the static page should not be empty: " + url, pageText.isEmpty());
        }
    }
}
