package Tests;

import Baseclass.BaseClass;
import Pages.DynamicContentPage;
import org.testng.annotations.Test;

public class TestsDynamicContent extends BaseClass {

    @Test
    public void T007_DynamicContent_Testing() {
        DynamicContentPage dynamic_content_page = new DynamicContentPage(driver);
        dynamic_content_page.GoToDynamicPage();
        dynamic_content_page.refreshPage();
        dynamic_content_page.Validation_changes_upon_refresh();


    }

}
