package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.DynamicContent;

public class DynamicContentTest extends TestBase {


    @Test
    public void dynamicContentTest(){
        DynamicContent dynamicContent = new DynamicContent(driver);
        dynamicContent.isChanged(driver);
    }
}
