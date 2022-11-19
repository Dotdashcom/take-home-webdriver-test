package com.dotdash.scripts;

import com.dotdash.pages.DragAndDrop;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class DragAndDropTest extends BaseWebTest<DragAndDrop> {

    @Test
    public void dragAndDropBoxes() {
        DragAndDrop dragAndDropPage = getInitialPage();

        String firstBoxName = dragAndDropPage.getBoxName(0);

        dragAndDropPage.dragAndDropFirstBoxToRight();

        checkThat("Left box is switched to the right", dragAndDropPage.getBoxName(1), equalTo(firstBoxName));

        dragAndDropPage.dragAndDropSecondBoxToLeft();

        checkThat("Right box is switched to the left", dragAndDropPage.getBoxName(0), equalTo(firstBoxName));
    }
}
