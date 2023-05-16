package homework.tests;

import homework.test.TestBase;
import homework.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JS_errorStepDef extends TestBase {

    @Test
    public void verifyErrorMessage(){

        Driver.getDriver().get("http://localhost:7080/javascript_error");

        String actual=Driver.getDriver().findElement(By.xpath("//body[@onload='loadError()']/p")).getText();
        String expectedError= "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.";

        Assert.assertEquals(expectedError,actual);
    }


}
