package com.dotdash.scripts;

import com.dotdash.pages.DynamicContent;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class DynamicContentTest extends BaseWebTest<DynamicContent> {

    @Test
    public void contentChangeOnPageRefresh() {
        DynamicContent dynamicContentPage = getInitialPage();

        List<String> initialItemsDescription = dynamicContentPage.getItemsDescription();
        List<String> initialImagesSrc = dynamicContentPage.getImagesSrc();
        dynamicContentPage.refreshPage();

        List<String> newItemsDescription = dynamicContentPage.getItemsDescription();
        List<String> newImagesSrc = dynamicContentPage.getImagesSrc();

        for (int i = 0; i < newItemsDescription.size(); i++) {
            checkThat("Item description changes after page refresh", newItemsDescription.get(i).equals(initialItemsDescription.get(i)), is(false));
            checkThat("Item image changes after page refresh", newImagesSrc.get(i).equals(initialImagesSrc.get(i)), is(false));
        }
    }
}
