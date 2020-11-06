package Tests;

import PageRepositories.DragAndDrop;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


@Listeners({ UITestListeners.class })
public class DragAndDropTest extends BaseTest {
    @Test(priority=1)
    @Description("Test Drags Element A to Element B and Verify the Text are Switched")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Drag and Drop")
    public void drag_element_a_to_element_b() throws IOException{
        DragAndDrop dragAndDrop = new DragAndDrop(driver);
        String path_to_js_file = System.getProperty("user.dir") + File.separator + "ExternalLibs" + File.separator + "drag_and_drop.js";
        dragAndDrop.navigate_to_drag_and_drop_menu_page(base_url);
        dragAndDrop.validate_drag_and_drop_menu_page_header();
        dragAndDrop.drag_element_a_to_element_b(path_to_js_file);
        dragAndDrop.custom_wait(3000);
        dragAndDrop.verify_text_element_a_and_element_b_switched();
    }
}