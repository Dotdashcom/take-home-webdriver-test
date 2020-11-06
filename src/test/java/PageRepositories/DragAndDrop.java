package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DragAndDrop extends PageUtils {

    public WebDriver driver;

    //Constructor
    public DragAndDrop(WebDriver driver) {
        this.driver = driver;
    }

    //********************************
    //******Drag and Drop Menu********
    //********************************
    //
    //***Drag and Drop Menu Elements**

    String drag_and_drop_menu_url_path = "/drag_and_drop";
    String header_drag_and_drop_menu_page = "//h3";
    String header_drag_and_drop_menu_page_text = "Drag and Drop";
    String drop_box_column_a = "#column-a"; //must be in CSS
    String drop_box_column_b = "#column-b"; //must be in CSS
    String drop_box_column_a_text = "//div[contains(@id,'column-a')]/header";
    String drop_box_column_b_text = "//div[contains(@id,'column-b')]/header";
    String column_a_text_when_switched = "B";
    String column_b_text_when_switched = "A";;

    //*****Drag And Drop Menu Page Methods****
    @Step("Navigate to Drag And Drop Menu Page")
    public void navigate_to_drag_and_drop_menu_page(String base_url) {
        driver.get(base_url + drag_and_drop_menu_url_path);
        wait_for_element_present(driver, header_drag_and_drop_menu_page);
    }

    @Step("Validate the Drag And Drop Menu Page Header is Present")
    public void validate_drag_and_drop_menu_page_header() {
        verify_text_present(driver, header_drag_and_drop_menu_page,header_drag_and_drop_menu_page_text, "Drag and Drop Menu Page Header Is Not Matched.");
    }

    //Actions DragAndDrop functionality is not working. Hence native JS is used
    //The JS file is located under ExternalLibs folder.
    //https://stackoverflow.com/questions/32200709/can-we-retrieve-text-drag-n-drop-elements-using-javascriptexecutor-similarly-we
    @Step ("Drag Element A to Element B")
    public void drag_element_a_to_element_b(String js_file_path) throws IOException {
        StringBuffer buffer = new StringBuffer();
        String line;
        BufferedReader br = new BufferedReader(new FileReader(js_file_path));
        while((line = br.readLine())!=null)
            buffer.append(line);

        String javaScript = buffer.toString();

        javaScript = javaScript + "$('" + drop_box_column_a + "').simulateDragDrop({ dropTarget: '" + drop_box_column_b + "'});";
        ((JavascriptExecutor)driver).executeScript(javaScript);
    }

    @Step ("Verify the Text on Element A to Element B are Switched")
    public void verify_text_element_a_and_element_b_switched() {
        verify_text_present(driver, drop_box_column_a_text, column_a_text_when_switched, "The Elements Headers are not Switched." );
        verify_text_present(driver, drop_box_column_b_text, column_b_text_when_switched, "The Elements Headers are not Switched." );

    }
}