package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.CheckboxesPage;
import org.junit.Test;

public class CheckboxesTest extends BaseTest {

    public CheckboxesTest(){
        super();
    }

    @Test
    public void SelectCheckbox1UnselectCheckbox2(){

        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.clickCheckbox1();
        checkboxesPage.clickCheckbox2();

        checkboxesPage.verifyCheckboxIsSelected("checkbox1", true);
        checkboxesPage.verifyCheckboxIsSelected("checkbox2", false);
    }

    @Test
    public void BothCheckboxesSelected(){
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.clickCheckbox1();

        checkboxesPage.verifyCheckboxIsSelected("checkbox1", true);
        checkboxesPage.verifyCheckboxIsSelected("checkbox2", true);
    }

}
