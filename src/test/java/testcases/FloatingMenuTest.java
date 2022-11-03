package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.FloatingMenuPage;
import org.junit.Test;

public class FloatingMenuTest extends BaseTest {

    public FloatingMenuTest(){
        super();
    }

    @Test
    public void ScrollDownAndAssertFloatingMenuIsDisplayed(){

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        floatingMenuPage.scrollDownAndAssertFloatingMenuIsDisplayed();

    }

}
