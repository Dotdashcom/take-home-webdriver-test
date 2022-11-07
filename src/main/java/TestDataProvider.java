import org.testng.annotations.DataProvider;

public class TestDataProvider {

    public enum URLs{
        Home("http://localhost:7080/");

        private String option;
        URLs(String s) {
            option=s;
        }
        public String getOption() {
            return option;
        }
    }
   public enum HomeOptions{
        DragandDrop("Drag and Drop"),
        Login("Form Authentication"),
       ContextMenu("Context Menu"),
       CheckBox("Checkboxes"),
       DropDown("Dropdown"),
       DynamicContent("Dynamic Content"),
       DynamicControls("Dynamic Controls"),
       DynamicLoading("Dynamic Loading"),
       FileDownload("File Download"),
       FileUpload("File Upload"),
       FloatingMenu("Floating Menu"),
       Frames("Frames"),
       Hover("Hovers"),
       JSAlert("JavaScript Alerts"),
       JSErrorLoad("JavaScript onload event error"),
       MultipleWindows("Multiple Windows"),
       NotificationMessages("Notification Messages");
        private String option;
       HomeOptions(String s) {
           option=s;
       }
       public String getOption() {
           return option;
       }
   }
    @DataProvider(name = "Login")
    public Object[][] LoginData() {
        return new Object[][]{{"tomsmith","SuperSecretPassword!","You logged into a secure area!"}, {"wrong","wrongpaas","Your username is invalid!"}};
    }

    @DataProvider(name = "Checkbox")
    public Object[][] CheckboxData() {
        return new Object[][]{{0,false}, {1,true}};
    }

    @DataProvider(name = "Contextmenu")
    public Object[][] ContextMenuData() {
        return new Object[][]{{"You selected a context menu"}};
    }

    @DataProvider(name = "Dragdrop")
    public Object[][] DragDropData() {
        return new Object[][]{{0,1}};
    }

    @DataProvider(name = "DropDown")
    public Object[][] DropDownData() {
        return new Object[][]{{"Option 1"},{"Option 2"}};
    }

    @DataProvider(name = "DynamicContent")
    public Object[][] DynamicContentData() {
        return new Object[][]{{5}};
    }

    @DataProvider(name = "DynamicLoading")
    public Object[][] DynamicLoadingData() {
        return new Object[][]{{"Hello World!"}};
    }

    @DataProvider(name = "FileDownload")
    public Object[][] FileDownloadData() {
        return new Object[][]{{"C:\\Users\\lwiss\\Downloads","some-file.txt"}};
    }

    @DataProvider(name = "FileUpload")
    public Object[][] FileUploadData() {
        return new Object[][]{{"C:\\Users\\lwiss\\Downloads\\DragdropTest.java"}};
    }

    @DataProvider(name = "IFrame")
    public  Object[][] IFrameData() {
        return new Object[][]{{1,"Hello world"}};
    }

    @DataProvider(name = "JSAlert")
    public  Object[][] JSAlertData() {
        return new Object[][]{
                {"simple","accept","You successfuly clicked an alert"},
                {"mixed","accept","You clicked: Ok"},
                {"mixed","dismiss","You clicked: Cancel"},
                {"prompt","accept","sample"}
        };
    }
    @DataProvider(name = "JSLoadError")
    public static Object[][] JSLoadErrorData() {
        return new Object[][]{{"Cannot read properties of undefined (reading 'xyz')"}};
    }

    @DataProvider(name = "MultiWindows")
    public static Object[][] MultiWindowsData() {
        return new Object[][]{{1,"New Window"}};
    }

    @DataProvider(name = "Notification")
    public static Object[][] NotificationData() {
        return new Object[][]{{"Action successful"},{"Action unsuccesful"}};
    }
}
