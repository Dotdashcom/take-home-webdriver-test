package Tests;

import Pages.IframePage;
import org.junit.jupiter.api.Test;
import utilities.Driver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IframeTest {
    String baseURL="http://localhost:7080";
    @Test
    public void iframeTest(){
        IframePage iframePage=new IframePage();
        Driver.getDriver().get(baseURL+"/iframe");
        Driver.getDriver().switchTo().frame(iframePage.iframe);
        assertTrue(iframePage.iframeMessage.isDisplayed());
    }
}
