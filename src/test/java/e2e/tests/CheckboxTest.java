package e2e.tests;

import e2e.pages.CheckboxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckboxTest extends BaseSpec {
    CheckboxPage checkboxPage;
    public final String checkboxEndpoint = configReader.getCheckboxEndpoint();

    @BeforeEach
    public void open(){
        checkboxPage = new CheckboxPage(driver);
        checkboxPage.visit(checkboxEndpoint);
    }

    @Test
    public void validateCheckboxesAreChecked(){
        checkboxPage.click(1);
        Assertions.assertTrue(checkboxPage.isCheckboxSelected(1));
        Assertions.assertTrue(checkboxPage.isCheckboxSelected(2));
    }

    @Test
    public void validateCheckboxesAreUnchecked(){
        checkboxPage.click(2);
        Assertions.assertFalse(checkboxPage.isCheckboxSelected(1));
        Assertions.assertFalse(checkboxPage.isCheckboxSelected(2));
    }
}
