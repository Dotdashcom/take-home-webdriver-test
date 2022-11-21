package tests;

import Pages.DragAndDrop_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DragAndDropTest {
    public String Url_DragNdDrop= "drag_and_drop";
    WebDriver driverDotDash;
    DragAndDrop_Page dragAndDrop_page;
    @Before
    public void setUp(){
        dragAndDrop_page=new DragAndDrop_Page(driverDotDash);
        dragAndDrop_page.setChrome();
        dragAndDrop_page.setUrl(Url_DragNdDrop);
    }

    @Test
    public void performDragNdDrop() {
        dragAndDrop_page.goTodragndDropNdAssert();
    }

    @After
    public void tearDown() {
        dragAndDrop_page.closeAllWindows();
    }
}
