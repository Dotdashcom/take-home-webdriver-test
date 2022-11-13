package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.DragAndDropPageModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class DragAndDropPageTest extends MainTest {

    public static final String COLUMN_A_INNER_TEXT = "A";
    public static final String COLUMN_B_INNER_TEXT = "B";
    DragAndDropPageModel page;

    private void init() {
        page = new DragAndDropPageModel(driver);
        driver.get(BASE_URL + DragAndDropPageModel.PAGE_URL);
    }

    @Test
    void WHEN_drag_and_drop_THEN_columns_swap_places() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(DragAndDropPageModel.PAGE_URL));

        Assert.assertTrue(page.getColumnA().getText().contains(COLUMN_A_INNER_TEXT));
        Assert.assertTrue(page.getColumnB().getText().contains(COLUMN_B_INNER_TEXT));
        // Introducing a short delay for action visibility
        try {
            sleep(300L);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
        page.dragAndDrop(page.getColumnA(), page.getColumnB());
        try {
            sleep(300L);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
        Assert.assertTrue(page.getColumnA().getText().contains(COLUMN_B_INNER_TEXT));
        Assert.assertTrue(page.getColumnB().getText().contains(COLUMN_A_INNER_TEXT));
    }
}
