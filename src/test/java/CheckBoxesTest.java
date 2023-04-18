import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckBoxesPage;
import util.Constants;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckBoxesTest {

    WebDriver driver;

    CheckBoxesPage checkBoxesPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        checkBoxesPage = new CheckBoxesPage(driver);
        driver.get(Constants.baseUrl+ checkBoxesPage.url);
    }

    @Test
    void checkbox1CheckedUnchecked() {
        boolean test2 = false;
        boolean isSelectedPrev = checkBoxesPage.checkbox1IsSelected();
        checkBoxesPage.clickCheckBox1();
        boolean test1 = isSelectedPrev != checkBoxesPage.checkbox1IsSelected();
        if (test1) {
            isSelectedPrev = checkBoxesPage.checkbox1IsSelected();
            checkBoxesPage.clickCheckBox1();
            test2 = isSelectedPrev != checkBoxesPage.checkbox1IsSelected();
        }
        assertTrue(test1 && test2);
    }

    @Test
    void checkbox2CheckedUnchecked() {
        boolean test2 = false;
        boolean isSelectedPrev = checkBoxesPage.checkbox2IsSelected();
        checkBoxesPage.clickCheckBox2();
        boolean test1 = isSelectedPrev != checkBoxesPage.checkbox2IsSelected();
        if (test1) {
            isSelectedPrev = checkBoxesPage.checkbox2IsSelected();
            checkBoxesPage.clickCheckBox2();
            test2 = isSelectedPrev != checkBoxesPage.checkbox2IsSelected();
        }
        assertTrue(test1 && test2);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}