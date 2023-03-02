package tests;

import enums.Headers;
import enums.Pages;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.DropdownPage;
import utilities.BrowserUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class DropdownTest extends TestBase {

    @Test(description = "Dropdown test")
    public void dropDownTest() {
        DropdownPage dropdownPage = new DropdownPage();
        BrowserUtils.openPage(driver, Pages.DROPDOWN_PAGE);
        BrowserUtils.waitUntilVisible(driver, dropdownPage.dropDownHeader, Duration.ofSeconds(15));
        assertThat(dropdownPage.dropDownHeader.getText()).isEqualTo(Headers.DROPDOWN.getName());
        Select select = new Select(dropdownPage.selectDropDown);
        select.selectByValue("1");
        String firstOption = select.getFirstSelectedOption().getText();
        assertThat(firstOption).isEqualTo("Option 1");
        select.selectByValue("2");
        String secondOption = select.getFirstSelectedOption().getText();
        assertThat(secondOption).isEqualTo("Option 2");
    }
}
