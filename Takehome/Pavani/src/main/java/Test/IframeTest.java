package Test;

import Utilities.DriverHelper;
import Main.IframePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest {

    IframePage iframe = new IframePage();

    @Test
    public void IframeTest() {

        DriverHelper.getDriver().get("http://localhost:7080/iframe");

        DriverHelper.getDriver().manage().window().maximize();

        DriverHelper.getDriver().switchTo().frame(0);

        System.out.println(iframe.text.getText());

        Assert.assertEquals(iframe.text.getText(), "Your content goes here.");

        DriverHelper.closeDriver();

    }


}
