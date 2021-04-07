package Dynamics;

import Pages.DynamicContentPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import static org.testng.AssertJUnit.assertTrue;

public class DynamicContentTest extends TestBase {
    @BeforeClass
    public void loginUrl(){
        driver.get(TestBase.BASEURL.concat("/dynamic_content"));
    }
    @Test
    public void DynamicContenttest() {

        DynamicContentPage dy=new DynamicContentPage();
       String s= dy.contentext.getText();
        driver.navigate ().refresh ();
      //  System.out.println(s);
        assertTrue(!dy.contentext.equals(s));

    }
}
