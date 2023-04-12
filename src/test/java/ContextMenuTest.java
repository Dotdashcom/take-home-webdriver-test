import org.benjamin.pages.ContextMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContextMenuTest extends ContextMenu {
    @Test
    public void contextMenu_rightClick_popupMessageEquals(){
        String message = rightClick();
        Assertions.assertEquals("You selected a context menu", message);
    }
}
