package testsJunit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;



import utils.Driver;

public class ContextMenu extends BaseClass {


    //I am on the context menu page
    //I right click on the context menu
    //I verify the alert menu text

    @Test
    public void verification_of_the_context_menu() {
        Driver.getDriver().get("http://localhost:7080/context_menu");
        Actions action = new Actions(Driver.getDriver());
        action.contextClick(Driver.getDriver().findElement(By.xpath("//*[@id='hot-spot']"))).build().perform();
        String alerText = "You selected a context menu";
        String actualAlerText = Driver.getDriver().switchTo().alert().getText();
        assertEquals(alerText, actualAlerText);
        System.out.println(actualAlerText);
    }

}
