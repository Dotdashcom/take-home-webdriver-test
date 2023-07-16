package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.DragAndDropPage;
import testComponents.BaseTest;

public class DragAndDropTest extends BaseTest {

    @Test
    public void DragAndDrop() throws InterruptedException {
        DragAndDropPage dragndrop=new DragAndDropPage(driver);
        dragndrop.goTo();
        Thread.sleep(2000);
        dragndrop.dragBoxAToBoxB();
        String A=dragndrop.getTextBoxA();
        String B=dragndrop.getTextBoxB();
        System.out.println(dragndrop.getTextBoxA());
        Assert.assertEquals(B, "A");
        Assert.assertEquals(A,"B");


    }
}
