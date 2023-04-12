import org.benjamin.pages.DynamicContent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DynamicContentTest extends DynamicContent {
    @Test
    public void dynamicContent_refresh_changed() {
        List<Content>[] allContents = refreshAndGetContents(true);

        List<Content> before = allContents[0];
        List<Content> after = allContents[1];

        boolean equals = true;
        for (int i = 0; i < before.size(); i++) {
            if (!before.get(i).equals(after.get(i))) {
                equals = false;
                break;
            }
        }

        Assertions.assertFalse(equals);
    }
}
