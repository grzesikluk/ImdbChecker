package testtools;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

/**
 * Created by Lukasz on 2017-01-21.
 *
 * Helper to create logging preferences for WebDriver.
 *
 */
public class TestLoggingHelper {

    public static LoggingPreferences getLoggingPreferencesForDriver(Level level) {
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.DRIVER, level);
        return loggingPreferences;
    }

}
