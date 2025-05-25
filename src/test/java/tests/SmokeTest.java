package tests;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class SmokeTest extends BaseTest {

    @Test
    public void canOpenHomePageAndReadTitle() {
        driver.get("https://vitmedical.hu/");
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        assertTrue(title.toLowerCase().contains("vit")); // rough test
    }
}
