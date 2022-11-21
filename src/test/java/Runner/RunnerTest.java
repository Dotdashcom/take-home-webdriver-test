package Runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginSuccessTest.class,
        LoginFailureTest.class,
        CheckBoxTest.class,
        ContextMenuTest.class,
        DragAndDropTest.class,
        DropDownListTest.class,
        DynamicContentTest.class,
        DynamicLoadingTest.class,
        DownLoadTest.class,
        UploadFileTest.class,
        FloatingMenuTest.class,
        IFrameTest.class,
        HoversTest.class,
        JavaScriptAlertTest.class,
        JsLogErrorTest.class,
        WindowsTest.class,
        NotificationMsgRenderedTest.class
})
public class RunnerTest {
}
