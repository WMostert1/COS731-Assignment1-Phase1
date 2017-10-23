package za.co.wernerm.squekyclean.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class DebugProperties {
    private static final Logger logger = LoggerFactory.getLogger(DebugProperties.class);
    /**
     * @param property
     * @return  read back a property from the debug.properties file.
     *
     *          - if value not available in debug.properties then retrieve from System.getProperty()
     */
    public static String getProperty(String property) {
        String result = "";
        java.io.InputStream is = null;
        try {
            is = new FileInputStream("debug.properties");
            Properties p = new Properties();
            p.load(is);
            if (null != p.getProperty(property)) {
                result = p.getProperty(property);
            } else {
                result = System.getProperty(property);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
            logger.error(String.valueOf(e1));
        }
        return result;
    }

    /**
     *  reads in 'debug.properties' in the project base directory. This will set all
     *  system properties so System.getProperty() can be used in integration tests.
     */
    public static void readInDebugProperties () {
        java.io.InputStream is = null;
        try {
            is = new FileInputStream("target/debug.properties");
            Properties properties = new Properties();
            properties.load(is);

            for(String key : properties.stringPropertyNames()) {
                String value = properties.getProperty(key);
                System.setProperty(key,value);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(String.valueOf(e));
        }
    }
}
