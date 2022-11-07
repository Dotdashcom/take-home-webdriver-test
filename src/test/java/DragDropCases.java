import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropCases extends Hooks {

    @Test(dataProvider = "Dragdrop")
    public  void DragDrop(int indexA,int indexB) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.DragandDrop.getOption());
        Assert.assertTrue(App.dragDropPage.dropColumnAToB(indexA,indexB));
    }
}
