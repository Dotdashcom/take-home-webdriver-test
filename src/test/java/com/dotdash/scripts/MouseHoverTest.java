package com.dotdash.scripts;

import com.dotdash.pages.MouseHover;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class MouseHoverTest extends BaseWebTest<MouseHover> {

    @Test
    public void validateTextOnMouseHover() {
        MouseHover mouseHoverPage = getInitialPage();

        for (int i = 0; i < mouseHoverPage.getNumberOfImages(); i++) {
            checkThat("Text is displayed on mouse hover", mouseHoverPage.getHoverText(i), equalTo("name: user" + (i + 1)));
        }
    }
}
