package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.DragAndDrop;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropTest extends BasePage {

    DragAndDrop dp;

    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.drag_and_drop);
        dp=new DragAndDrop();
    }
    @Test
    public boolean contextClickAndAlert()
    {
        return dp.draggingElement();
    }

    @AfterTest
    public void tearDown()
    {
        quit();
    }


}
