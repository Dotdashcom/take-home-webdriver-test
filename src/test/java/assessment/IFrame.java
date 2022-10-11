package assessment;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IFramePage;
import util.Driver;

public class IFrame extends Driver {

    IFramePage page = new IFramePage(Driver.getDriver());

    @Test
    public void iframe_test() {
        Driver.getDriver().get("http://localhost:7080/iframe");

//        Driver.getDriver().switchTo().frame(0);
        Driver.getDriver().switchTo().frame(page.iFrameWithTextField);

        page.textField.clear();

        String text = "Hello World!";

        page.textField.sendKeys(text);

        Assert.assertEquals(page.textField.getText() , text , "text does not match");
    }
}
