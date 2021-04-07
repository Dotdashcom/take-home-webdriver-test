package checkbox;

import Pages.CheckBoxPage;
import Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import static org.testng.AssertJUnit.assertTrue;

public class checkBoxtest extends TestBase {

    @BeforeClass
    public void loginUrl(){
        driver.get(TestBase.BASEURL.concat("/checkboxes"));
    }
    @Test
    public void checkBoxesTest1(){
        CheckBoxPage check=new CheckBoxPage();
         check.checkboxes1.click();
         check.checkboxes2.click();

         assertTrue(check.checkboxes1.isSelected());
         assertTrue(!check.checkboxes2.isSelected());
        check.checkboxes1.click();
        check.checkboxes2.click();
        assertTrue(!check.checkboxes1.isSelected());
        assertTrue(check.checkboxes2.isSelected());

    }
}
