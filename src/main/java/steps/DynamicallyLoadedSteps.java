package steps;

import pages.DynamicallyLoadedPage;

public class DynamicallyLoadedSteps {

    DynamicallyLoadedPage dynamicallyLoadedPage = new DynamicallyLoadedPage();

    public void checkDisplayTextOnLoadedPage(String text){
     dynamicallyLoadedPage.pressButtonStart();
     dynamicallyLoadedPage.textShouldBeVisible(text);
    }

}
