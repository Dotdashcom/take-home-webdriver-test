package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxes extends PageUtils {

    public WebDriver driver;

    //Constructor
    public CheckBoxes(WebDriver driver) {
        this.driver = driver;
    }

    //********************************
    //**********Checkbox Page*********
    //********************************
    //
    //**********Checkbox Elements*****

    String checkbox_url_path = "/checkboxes";
    String header_checkboxes_page = "//h3";
    String header_checkboxes_page_text = "Checkboxes";
    String select_checkboxes = "//input[regex]";

    //*****Checkboxes Page Methods****
    @Step("Navigate to Checkboxes Page")
    public void navigate_to_checkboxes_page(String base_url) {
        driver.get(base_url + checkbox_url_path);
        wait_for_element_present(driver, header_checkboxes_page);
    }

    @Step("Validate the Checkboxes Page Header is Present")
    public void validate_checkboxes_page_header() {
        verify_text_present(driver, header_checkboxes_page,header_checkboxes_page_text, "Checkboxes Page Header Is Not Matched.");
    }

    @Step ("Checkbox Already Selected")
    public void confirmation_on_already_checkbox_selected () {}

    @Step ("Checkbox Selected")
    public void confirmation_on_checkbox_selected () {}

    @Step ("Checkbox Already Unselected")
    public void confirmation_on_already_checkbox_unselected () {}

    @Step ("Checkbox Unselected")
    public void confirmation_on_checkbox_unselected () {}

    //The Parameter will be appended in the Step Description
    @Step("Select Checkbox - [{0}]")
    public void select_checkbox(String checkbox_name) {
        //Dynamically setting XPath for the checkboxes
        String[] temp_checkbox_split = checkbox_name.trim().split("\\s+");
        String temp_checkbox_xpath = select_checkboxes.replaceAll("regex",temp_checkbox_split[1]);

        //Check to see if the checkbox is selected and perform operation accordingly
        if(driver.findElement(By.xpath(temp_checkbox_xpath)).isSelected())
        {
            confirmation_on_already_checkbox_selected();
        } else
        {
            driver.findElement(By.xpath(temp_checkbox_xpath)).click();
            confirmation_on_checkbox_selected();
        }
        custom_wait(1000);
    }

    //Reverse logic of Selecting a Checkbox
    @Step("Unselect Checkbox - [{0}]")
    public void unselect_checkbox(String checkbox_name) {
        String[] temp_checkbox_split = checkbox_name.trim().split("\\s+");
        String temp_checkbox_xpath = select_checkboxes.replaceAll("regex",temp_checkbox_split[1]);

        if(driver.findElement(By.xpath(temp_checkbox_xpath)).isSelected())
        {
            driver.findElement(By.xpath(temp_checkbox_xpath)).click();
            confirmation_on_checkbox_unselected();
        } else
        {
            confirmation_on_already_checkbox_unselected();
        }
        custom_wait(1000);
    }
}