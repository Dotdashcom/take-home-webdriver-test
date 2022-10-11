package assessment;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MouseHoverPage;
import util.Driver;

public class MouseHover extends Driver {

    MouseHoverPage page = new MouseHoverPage(Driver.getDriver());

    @Test
    public void mouse_hover_test() {
        Driver.getDriver().get("http://localhost:7080/hovers");

        int originalFooterYAxis = page.pageFooter.getLocation().y;

        try {
            for (WebElement image : page.images) {
                Driver.getActions().moveToElement(image).build().perform();
                Assert.assertNotEquals(page.pageFooter.getLocation().getY() , originalFooterYAxis);
            }
        } catch (IndexOutOfBoundsException e) {
            Assert.fail("list of images not located -> confirm that locator is still valid");
        }
    }
}
