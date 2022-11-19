package com.dotdash.scripts;

import com.dotdash.pages.ContextMenu;
import org.junit.Test;
import org.openqa.selenium.Alert;

import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ContextMenuTest extends BaseWebTest<ContextMenu> {

    @Test
    public void jsAlertOnRightClick() {
        Alert alert = getInitialPage().openContextMenu();

        checkThat("JS Alert message is displayed", alert.getText(), equalToIgnoringCase("You selected a context menu"));
    }
}
