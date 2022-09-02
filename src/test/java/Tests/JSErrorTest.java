package Tests;

import Pages.JSError;
import org.junit.jupiter.api.Test;
import utilities.Driver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JSErrorTest {
    String baseURL="http://localhost:7080";
    @Test
    public void JSError(){
        JSError jsError=new JSError();
        Driver.getDriver().get(baseURL+"/javascript_error");
        assertTrue(jsError.errorMessage.isDisplayed());
    }
}
