package Tests;

import Pages.ContextMenuPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContextMenuTest {
    String baseURL="http://localhost:7080";
    @Test
    public void contextMenu(){
        ContextMenuPage contextMenuPage=new ContextMenuPage();
        Driver.getDriver().get(baseURL+"/context_menu");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions actions=new Actions(Driver.getDriver());
        actions.contextClick(contextMenuPage.context);

        Alert alert=Driver.getDriver().switchTo().alert();
        String alertMessage=alert.getText();
        assertEquals("You selected a context menu", alertMessage);
    }
}
