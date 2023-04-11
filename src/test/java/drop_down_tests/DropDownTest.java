package drop_down_tests;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.drop_down_page.DropDownPage;

import static org.testng.Assert.assertTrue;

public class DropDownTest extends Base {

    @Test
    public void selectOptionOneTest(){
        DropDownPage dropDownPage = new DropDownPage();
        String optionOne = "Option 1";
        dropDownPage.selectOptions(optionOne);
        assertTrue(DropDownPage.optionOne.isSelected());
    }
    @Test
    public void selectOptionTwoTest(){
        DropDownPage dropDownPage = new DropDownPage();
        String optionTwo = "Option 2";
        dropDownPage.selectOptions(optionTwo);
        assertTrue(DropDownPage.optionTwo.isSelected());
    }
}
