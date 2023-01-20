package Tests;

import Baseclass.BaseClass;
import Pages.DynamicLoadingPage;
import org.testng.annotations.Test;

public class TestsDynamicLoading extends BaseClass {

    @Test
    public void T010_DynamicLoading_Example1() {
         DynamicLoadingPage dynamic_loadingPage = new DynamicLoadingPage(driver);
         dynamic_loadingPage.GoToDynamicLoading();
         dynamic_loadingPage.Element_on_page_that_is_hidden();

    } @Test
    public void T011_DynamicLoading_Example2() {
         DynamicLoadingPage dynamic_loadingPage = new DynamicLoadingPage(driver);
         dynamic_loadingPage.GoToDynamicLoading();
         dynamic_loadingPage.Element_rendered_after_the_fact();

    }
}
