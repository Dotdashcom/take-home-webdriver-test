package tests;

import org.junit.jupiter.api.*;
import pages.CheckBoxPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CheckBoxTest extends BaseTest {
    private static final String CHECKBOX_URI = "/checkboxes";
    private static final String PAGE_TITLE = "Checkboxes";

    private static CheckBoxPage checkBoxPage;
    @BeforeAll
    static void before() {
        webDriver.get(baseUrl + CHECKBOX_URI);
        checkBoxPage = new CheckBoxPage(webDriver);
    }

    @Test
    @Order(1)
    void validateCheckBoxPage() {
        checkBoxPage.assertElementsAreDisplayed();
        checkBoxPage.assertPageTitle(PAGE_TITLE);
    }

    @Test
    @Order(2)
    void verifyCheckBoxAreChecked() {
        checkBoxPage.uncheckAllCheckBoxes();
        checkBoxPage.clickOnCheckBoxAndVerify(0, false);
        checkBoxPage.clickOnCheckBoxAndVerify(1, false);
    }

    @Test
    @Order(3)
    void verifyCheckBoxAreUnchecked() {
        checkBoxPage.clickOnCheckBoxAndVerify(0, true);
        checkBoxPage.clickOnCheckBoxAndVerify(1, true);
    }
}
