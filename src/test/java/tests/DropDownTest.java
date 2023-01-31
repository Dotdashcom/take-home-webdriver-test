package tests;

import org.junit.jupiter.api.*;
import pages.DropDownPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DropDownTest extends BaseTest {
    private static final String DROPDOWN_URI = "/dropdown";
    private static final String PAGE_TITLE = "Dropdown List";
    private static final String DEFAULT_OPTION_VALUE = "";

    private static DropDownPage dropDownPage;

    @BeforeAll
    static void before() {
        webDriver.get(baseUrl + DROPDOWN_URI);
        dropDownPage = new DropDownPage(webDriver);
    }

    @Test
    @Order(1)
    void validateDropDownPage() {
        dropDownPage.assertElementsAreDisplayed();
        dropDownPage.assertPageTitle(PAGE_TITLE);
        // Validating that initial option is selected by default
        dropDownPage.assertOptionIsSelected(DEFAULT_OPTION_VALUE);
    }

    @Test
    @Order(2)
    void verifySelectedOptions() {
        dropDownPage.selectOptionByValue("1");
        dropDownPage.assertOptionIsSelected("1");
        dropDownPage.selectOptionByValue("2");
        dropDownPage.assertOptionIsSelected("2");
    }

    @Test
    @Order(3)
    void verifyDeselectedOptions() {
        dropDownPage.selectOptionByValue("1");
        dropDownPage.assertOptionIsDeselected("2");
        dropDownPage.selectOptionByValue("2");
        dropDownPage.assertOptionIsDeselected("1");
    }
}
