package hover_test;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.hover_page.HoverPage;

import static org.testng.Assert.assertEquals;

public class HoverTest extends Base {
    @Test
    public void hoverTest() {
        HoverPage hoverPage = new HoverPage();
        //index should be 1 or greater
        int index = 1;
        String username = "name: user1";
        hoverPage.selectProfile(index);
        assertEquals(hoverPage.userName(index), username);

    }
}
