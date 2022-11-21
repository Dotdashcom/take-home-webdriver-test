package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;;
import com.qa.pages.DynamicLoading;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicLoadingPageTest extends BasePage {

        DynamicLoading dl;
        @BeforeTest
        public void setUp()
        {
            webDriver_init("chrome");
            navigateToSite(DirectoryPage.dynamicLoading);
            dl=new DynamicLoading();
        }
        @Test
        public boolean loadDynamicPage()
        {
            return dl.loadedPageDynamically();
        }

        @AfterTest
        public void tearDown()
        {
            quit();
        }
    }
