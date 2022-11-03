package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.DragAndDropPage;
import org.junit.Test;

public class DragAndDropTest extends BaseTest {

    public DragAndDropTest(){
        super();
    }

    @Test
    public void DragAndDropBox1ToBox2(){

        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

        dragAndDropPage.dragAndDropBox1ToBox2();

    }
}
