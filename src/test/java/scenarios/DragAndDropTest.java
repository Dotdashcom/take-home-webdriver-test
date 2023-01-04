package scenarios;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.DragAndDropPage;


public class DragAndDropTest extends BaseTest {
    private DragAndDropPage dragAndDropPage;

    @BeforeMethod
    public void setup() {
        dragAndDropPage = homePage.gotoDragAndDropPage();
    }

    @Test
    public void dragColumnAToB() {
        String column1HeaderText = dragAndDropPage.getColumnHeaderText(1);
        String column2HeaderText = dragAndDropPage.getColumnHeaderText(2);
        dragAndDropPage.dragColumnToColumn("a", "b");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dragAndDropPage.getColumnHeaderText(1), column2HeaderText, "Column 1 after first drag should be equal to column 2 before drag!");
        softAssert.assertEquals(dragAndDropPage.getColumnHeaderText(2), column1HeaderText, "Column 2 after first drag should be equal to column 1 before drag!");


        dragAndDropPage.dragColumnToColumn("a", "b");

        softAssert.assertEquals(dragAndDropPage.getColumnHeaderText(2), column2HeaderText, "Column 2 after second drag should be equal to column 2 before first drag!");
        softAssert.assertEquals(dragAndDropPage.getColumnHeaderText(1), column1HeaderText, "Column 1 after second drag should be equal to column 1 before first drag!");
        softAssert.assertAll();
    }
}