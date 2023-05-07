import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ Checkboxes.class, ContextMenu.class, Download.class, DragAndDrop.class, DropDown.class,
		DynamicContent.class, DynamicControl.class, DynamicLoading.class, FloatingMenu.class, IFrame.class,
		JavascriptAlert.class, JavascriptError.class, Login.class, MouseOver.class, NotificationMessage.class,
		OpenInNewTab.class, Upload.class })
public class AllTests {

}
