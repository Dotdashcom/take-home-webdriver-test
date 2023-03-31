package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDrop;

public class DragAndDropTest extends TestBase {
    @Test
    public void test() {
        driver.get("http://localhost:7080/drag_and_drop");
        DragAndDrop aTob = new DragAndDrop(driver);
        //aTob.atoB(driver);
        Assert.assertTrue(aTob.atoB(driver).contains("B"));
    }
}
