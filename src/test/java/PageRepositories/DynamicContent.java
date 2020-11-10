package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DynamicContent extends PageUtils {

    public WebDriver driver;

    //Constructor
    public DynamicContent(WebDriver driver) {
        this.driver = driver;
    }

    //********************************
    //*******Dynamic Content Page*****
    //********************************
    //
    //******Dynamic Content List******

    String dynamic_content_url_path = "/dynamic_content";
    String header_dynamic_content_page = "//h3";
    String header_dynamic_content_page_text = "Dynamic Content";
    String img = "(//div[contains(@id,'content')]//img)";
    String content = "(//div[contains(@id,'content')]//img/../..//div[2])";


    //*****Dynamic Content Page Methods****
    @Step("Navigate to Dynamic Content Page")
    public void navigate_to_dynamic_content_page(String base_url) {
        driver.get(base_url + dynamic_content_url_path);
        wait_for_element_present(driver, header_dynamic_content_page);
    }

    @Step("Validate the Dynamic Content Page Header is Present")
    public void validate_dynamic_content_page_header() {
        verify_text_present(driver, header_dynamic_content_page,header_dynamic_content_page_text, "Dynamic Content Page Header Is Not Matched.");
    }

    @Step("The Contents are Unique and Dynamically Changing")
    public void dynamic_content_page_changes() { Assert.assertTrue(true);}

    @Step("The Contents are Not Unique and Not Dynamically Changing")
    public void dynamic_content_page_not_changing() { Assert.assertTrue(false, "Contents are Not Dynamically Changing.");}

    @Step("Store Content In ArrayList and Validate the Unique Count for Refresh Count - {0}")
    public void validate_the_unique_count_for_content(int refresh_count) {
        ArrayList<String> content_array = new ArrayList<>();
        int row_content = 3; //Hardcoded based on the page. However, this can be gracefully handed based on the row counts.
        for (int i=0; i< refresh_count; i++) {
            for (int j=1; j<= row_content; j++) {
                content_array.add(driver.findElement(By.xpath(content + "["+j+"]")).getText());
            }
            driver.navigate().refresh();
        }
        //Checking Distinct counts of the ArrayList
        long total_unique_counts = content_array.stream().distinct().count();
        //This would be the expected counts of unique contents
        long expected_counts = (long)refresh_count * row_content;

        //Verifying that contents coming with refresh are unique
        if (expected_counts == total_unique_counts) { dynamic_content_page_changes();}
        else { dynamic_content_page_not_changing(); }
    }
}