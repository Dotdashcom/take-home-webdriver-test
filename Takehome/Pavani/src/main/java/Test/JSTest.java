package Test;

import Main.JSPage;
import Utilities.DriverHelper;
import org.testng.annotations.Test;

public class JSTest {

    JSPage jsPage =new JSPage(DriverHelper.getDriver());


    @Test
    public void JSAlert() throws InterruptedException {
        jsPage.JSAlert();
    }

    @Test
    public void JSError() {
        jsPage.JSError();
    }
}
