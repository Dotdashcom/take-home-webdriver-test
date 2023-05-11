package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import task.pages.DragAndDropPage;
import task.utilities.Driver;

public class DragAndDrop {

    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/drag_and_drop");
    }


    @Test
    public void testDragAndDrop(){


        String boxAbefore =  dragAndDropPage.firstColumn.getText(); //first column == A
        String boxBbefore =  dragAndDropPage.secondColumn.getText(); //second column == B

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(dragAndDropPage.firstColumn, dragAndDropPage.secondColumn).perform();

        String boxAafter =  dragAndDropPage.secondColumn.getText(); //second column == A
        String boxBafter =  dragAndDropPage.firstColumn.getText(); //first column == B



        Assertions.assertEquals(boxAbefore,boxBafter); //A swapped with B
        Assertions.assertEquals(boxBbefore, boxAafter); //B in the first column(A)

    }


    @AfterEach
    public void tearDown(){
        Driver.closeDriver();
    }
}
