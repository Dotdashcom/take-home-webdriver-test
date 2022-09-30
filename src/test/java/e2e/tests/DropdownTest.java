package e2e.tests;

import e2e.pages.DropdownPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DropdownTest extends BaseSpec {
    DropdownPage dropdownPage;
    public final String dropdownEndpoint = configReader.getDropdownEndpoint();

    @BeforeEach
    public void open(){
        dropdownPage = new DropdownPage(driver);
        dropdownPage.visit(dropdownEndpoint);
    }
    @Test
    public void verifyDropdownOption1IsSelected(){
        dropdownPage.select("Option 1");
        Assertions.assertEquals(dropdownPage.getOptionSelected(), "Option 1");
        dropdownPage.select("Option 2");
        Assertions.assertEquals(dropdownPage.getOptionSelected(), "Option 2");
    }

}
