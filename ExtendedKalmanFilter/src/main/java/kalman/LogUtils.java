package kalman;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Handler;

//TODO: add logging to file
//TODO: maybe add a set package level functionality.

/**
 * Java log tool to help with debugging
 *
 * NOTES:
 * Logger Levels (in order from least important to most): FINEST, FINER, FINE, CONFIG, INFO, WARNING, SEVERE
 *
 * To use logger:
 * Logger logger = LogUtils.getLogger(ClassName.class.getName());
 *
 * What levels to use:
 * SEVERE - an error that prohibits the program from running correctly
 * WARNING - a warning of a potential problem
 * INFO - important updates
 * CONFIG - less important updates
 * FINE - main debug
 * FINER - more detailed debug
 * FINEST - extremely detailed debug
 */

public class LogUtils {
    //set logging format
    static {
        System.setProperty(
                "java.util.logging.SimpleFormatter.format",
                "[%4$-7s] [%3$-20s] %5$s %n"
                //"[%1$tF %1$tT] [%4$-7s] [%3$-20s] %5$s %n" for date
        );
    }

    /**
     * the logger for LogUtils
     */
    private static final Logger ROOT = Logger.getLogger("root");

    /**
     * creates or finds the logger for the particular subsystem
     * @param cname name of the subsystem
     * @return logger
     */
    public static Logger getLogger(String cname) {

        return Logger.getLogger(cname);

    }

    /**
     * sets logger to desired logging level
     * @param logger the logger that is to be modified
     * @param targetLevel the new logging level
     */
    public static void setLoggerLevel(Logger logger, Level targetLevel)
    {
        logger.setLevel(targetLevel);

        for (Handler h : logger.getHandlers())
        {
            h.setLevel(targetLevel);
        }

        ROOT.log(Level.INFO, "(" + logger.getName() + ") level set: " + targetLevel.getName());
    }
}