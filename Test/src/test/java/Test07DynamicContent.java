

import org.testng.annotations.Test;

import java.util.List;
import java.util.ArrayList;
import org.testng.Assert;
import pageObject.DynamicContentPage;

public class Test07DynamicContent extends TestBase{
    
    @Test
    public void test07DynamicContent() throws InterruptedException{
        DynamicContentPage dynamicContentPage = new DynamicContentPage(webDriver);

        List<String> oldContents = new ArrayList<String>();  
        List<String> newContents = new ArrayList<String>();  

        for (int i=0; i<5 ;i++){
            oldContents = newContents;
            newContents = new ArrayList<String>(); 
            for (int j=0; j<3; j++){
                newContents.add(dynamicContentPage.getContentByIndex(j));
            }
            Assert.assertFalse(newContents.equals(oldContents));
            dynamicContentPage.refresh();
            Thread.sleep(1000);
        }

    }
}
