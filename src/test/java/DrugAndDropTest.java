import Pages.DrugAndDropPage;
import Utils.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DrugAndDropTest {

    DrugAndDropPage dragAndDrop= new DrugAndDropPage();

    @Test
    public void Switch () throws InterruptedException {

        Driver.getDriver().get("http://localhost:7080/drag_and_drop");

        Driver.getDriver().manage().window().maximize();

        Actions actions = new Actions(Driver.getDriver());

        actions.clickAndHold(dragAndDrop.FirstColumn).moveToElement(dragAndDrop.SecondColumn).release().build().perform();

        Thread.sleep(4000);

        System.out.println(dragAndDrop.FirstColumn.getText());

        Thread.sleep(4000);

        Assert.assertEquals(dragAndDrop.SecondColumn.getText(),"B");

        Assert.assertEquals(dragAndDrop.FirstColumn.getText(),"A");

        Driver.closeDriver();

    }



}