package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MouseHover;

public class MousHoverTest extends TestBase {
    @Test
    public void test() {
        driver.get("http://localhost:7080/hovers");
        MouseHover hover = new MouseHover(driver);
        String[] expected = {"name: user1" + "\n" + "View profile", "name: user2" + "\n" + "View profile", "name: user3" + "\n" + "View profile"};

        for (int i = 0; i <= 2; i++) {

            Assert.assertEquals(hover.hoverImage(driver, i), expected[i]);
        }

    }

}
