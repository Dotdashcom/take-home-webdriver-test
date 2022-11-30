package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.DragAndDropPage;
import com.dotdash.pageobjects.GeneratePage;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DragAndDropTests extends BaseTest {

    @Test
    public void shouldSwitchSquares() {
        DragAndDropPage dragAndDropPage = GeneratePage
                .dragAndDropPage()
                .goToDragAndDropPage()
                .dragSquare();

        assertThat(dragAndDropPage.getSwitchedSquareText(), is("A"));
    }
}
