package SimpleSelenium;

import Util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class ContextMenu extends Base {
    @Test
    public void ContextMenu() {
        Driver.getDriver().get(baseUrl + "/context_menu");
        Actions action = new Actions(Driver.getDriver());
        action.contextClick(Driver.getDriver().findElement(By.id("hot-spot"))).build().perform();
        assertTrue(Driver.getDriver().switchTo().alert().getText().equals("You selected a context menu"));
    }
}