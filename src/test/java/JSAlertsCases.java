import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class JSAlertsCases extends Hooks {


    @Test(dataProvider = "JSAlert")
    public  void JSAlert(String alert,String action,String message) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.JSAlert.getOption());
        if(alert.equalsIgnoreCase("simple")){
            App.jsAlertPage.clickJSAlert();
            App.jsAlertPage.selectAlertOption(action);
        }
        else if(alert.equalsIgnoreCase("mixed")){
            App.jsAlertPage.clickJSConfirmAlert();
            App.jsAlertPage.selectAlertOption(action);
        }
        else {
            App.jsAlertPage.clickJSPromptAlert();
            App.jsAlertPage.writeOnPromptAlert(message);
            App.jsAlertPage.selectAlertOption(action);
        }
        Assert.assertTrue(App.jsAlertPage.validateTextValue(message));
    }
}
