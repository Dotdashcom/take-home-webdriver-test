package iframe_test;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.iframe_page.IframePage;

import static org.testng.Assert.assertEquals;

public class IframeTest extends Base {

    @Test
    public void iframeTest(){
        IframePage iframePage = new IframePage();
        String word = "hello world";
        String expectedText="Your content goes here.hello world";
        iframePage.switchIframe().write(word);
        assertEquals(IframePage.areaText.getText(),expectedText);
    }
}
