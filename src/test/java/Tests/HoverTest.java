package Tests;

import Pages.HoverPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HoverTest {

    String baseURL="http://localhost:7080";

    @Test
    public void hoverTest(){
        HoverPage hoverPage=new HoverPage();
        Driver.getDriver().get(baseURL+"/hovers");
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hoverPage.firstWindow).perform();
        assertTrue(hoverPage.message.isDisplayed());
    }
}
