package library;
import lombok.Getter;
import org.apache.logging.log4j.*;

import java.io.File;

public class Log {
   @Getter
   private static Logger log;

   public static void startLog(String className) {
       File dir = new File("/.Logs");
       log  = LogManager.getLogger(className);
       ThreadContext.put("logFileName " , className);
   }
  public static void info(Object message) {
      getLog().info(getCallInfo() + message);
  }

  public static String getCallInfo(){
      String className = Thread.currentThread().getStackTrace()[3].getClassName();
      String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
      int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
      return(className + methodName + lineNumber);
  }

}
