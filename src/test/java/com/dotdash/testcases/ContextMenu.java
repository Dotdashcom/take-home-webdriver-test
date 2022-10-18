package com.dotdash.testcases;

import com.dotdash.pageObject.ContextMenuPage;
import com.framework.libraries.I;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.Test;

public class ContextMenu extends Setup {
    ContextMenuPage contextMenuPage;

    public ContextMenu(){
        this.contextMenuPage= MyTestClasses.getObject(ContextMenuPage.class);
    }

    @Test(testName = "Right click on page")
    public void clickOnContext(){
        navigateTo("context_menu");
    contextMenuPage.rightClick();
    contextMenuPage.assertContextClick("You selected a context menu");
    }

}
