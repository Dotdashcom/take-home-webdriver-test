package task.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import task.pages.ContextMenuPage;
import task.utilities.Driver;

public class ContextMenu {


    ContextMenuPage contextMenuPage = new ContextMenuPage();
    String expectedText = "You selected a context menu";
    String actualText;


    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/context_menu");


    }


    @Test
    public void verifyContextClickTest(){


        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(contextMenuPage.contextMenuIcon).perform();

        Alert alert = Driver.getDriver().switchTo().alert();
        actualText = alert.getText();

        alert.dismiss();

        Assertions.assertEquals(actualText, expectedText);



    }



    @AfterEach
    public void tearDown(){

        Driver.closeDriver();

    }

}
