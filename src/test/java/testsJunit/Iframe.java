package testsJunit;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Driver;

public class Iframe extends BaseClass {
    @Test
    public void i_switch_to_Iframe_and_type_some_text_verify_that_the_typed_text_is_as_expected() throws InterruptedException {
        String expected = "Test switches to Iframe and types some text.Test asserts that the typed text is as expected.";

        Driver.getDriver().get("http://localhost:7080/iframe");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().switchTo().frame(0);
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("// p[text()='Your content goes here.']")).clear();
        Driver.getDriver().findElement(By.xpath("//p")).sendKeys(expected);
        String actual = Driver.getDriver().findElement(By.xpath("//p")).getText();
        Assert.assertEquals(expected, actual);
        System.out.println("The actual text is as expected" + actual);
    }

}
