package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.DropdownPage;
import org.junit.Test;

public class DropdownTest extends BaseTest {

    public DropdownTest(){
        super();
    }

    @Test
    public void SelectOption1SelectOption2() throws Exception{
        DropdownPage dropdownPage = new DropdownPage(driver);

        dropdownPage.selectOptionDropdown("Option 1");
        dropdownPage.selectOptionDropdown("Option 2");
    }
}
