import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class IFrameCases extends Hooks {



    @Test(dataProvider = "IFrame")
    public  void Iframe(int index,String text) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.Frames.getOption());
        App.iFramePage.clickIFrameButton();
        App.iFramePage.changeToIFrame();
        App.iFramePage.writeTextEditor(text);
        Assert.assertTrue(App.iFramePage.validateWrittenText(text));

    }
}
