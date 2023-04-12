package page_reload_content_changes_tests;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.page_reload_content_changes.PageReload;

import java.util.ArrayList;

import static org.testng.Assert.assertNotEquals;

public class PageReloadTest extends Base {
    @Test
    public void contentChangesTest() {
        PageReload pageReload = new PageReload();
        // store displayed text of each element in list before refreshing the page
        ArrayList<String> beforeReload = pageReload.getContentTextOfEachElement();
        //refresh the page
        driver.navigate().refresh();
        // we store again displayed text of each element in list after refreshing the page
        ArrayList<String> afterReload = pageReload.getContentTextOfEachElement();
        assertNotEquals(beforeReload, afterReload);
    }

    @Test
    public void contentChangeUsingStaticLinkTest() {
        PageReload pageReload = new PageReload();
        //click on the link to make some element static
        pageReload.makeSomeElementsStatic();
        // store displayed text of each element in list before refreshing the page
        ArrayList<String> beforeReload = pageReload.getContentTextOfEachElement();
        //refresh the page
        driver.navigate().refresh();
        // we store again displayed text of each element in list after refreshing the page
        ArrayList<String> afterReload = pageReload.getContentTextOfEachElement();
        assertNotEquals(beforeReload, afterReload);
    }


}
