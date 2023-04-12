import org.benjamin.pages.DragAndDrop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DragAndDropTest extends DragAndDrop {
    @Test
    public void dragAndDrop_dragAOverB_textSwapped(){
        String text = dragAndDrop();

        Assertions.assertEquals("B", text);
    }
}
