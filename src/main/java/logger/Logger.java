package logger;


import java.io.File;
import org.apache.log4j.PropertyConfigurator;


public class Logger {
    static{        
        File propertiesFile = new File("/log4j.properties");
        PropertyConfigurator.configure(propertiesFile.toString());
    }
}
