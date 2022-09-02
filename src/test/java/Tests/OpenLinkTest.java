package Tests;

import Pages.OpenLinkPage;
import org.junit.jupiter.api.Test;
import utilities.Driver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenLinkTest {
    String baseURL="http://localhost:7080";
    @Test
    public void linkOpen(){
        OpenLinkPage openLinkPage=new OpenLinkPage();
        Driver.getDriver().get(baseURL+"/windows");

        openLinkPage.clickHereButton.click();

        for(String winHandle : Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(winHandle);
            if(Driver.getDriver().getWindowHandle().equals("New Window")){
                break;
            }
        }
        assertEquals("New Window", Driver.getDriver().getTitle());

    }
}
