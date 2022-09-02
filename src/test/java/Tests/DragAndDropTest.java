package Tests;

import Pages.DragAndDropPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class DragAndDropTest {

    @Test
    public void dragAndDrop(){
        String baseURL="http://localhost:7080";
        DragAndDropPage dragAndDropPage=new DragAndDropPage();
        Driver.getDriver().get(baseURL+"/drag_and_drop");
        Actions actions=new Actions(Driver.getDriver());
        actions.dragAndDrop(dragAndDropPage.WindowA,dragAndDropPage.WindowB);
    }
}
