package com.project.pom;

import com.project.pom.test.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginTest.class, LoginTestFail.class, CheckBoxesTest.class, ContextMenuTest.class, DragAndDropTest.class, DropDownListTest. class,
        DynamicContentTest.class, DynamicControlsTest.class, DynamicLoadingTest.class, FileDownloadTest.class, FileUploadTest.class, FloatingMenuTest.class,
        IFrameTest.class, MouseHoverTest.class, JSAlertsTest.class, JSErrorTest.class, WindowTest.class, NotificationMessageTest.class})
public class TestSuite {
}
