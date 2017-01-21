package testtools;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Lukasz on 2017-01-21.
 */
public class DriverCapabilitiesFactory {

    public static DesiredCapabilities getCapabilities(DriverType driverType, LoggingPreferences loggingPreferences) {
        DesiredCapabilities caps;

        switch (driverType) {
            case CHROME:
                caps = DesiredCapabilities.chrome();
                break;
            case FIREFOX:
                caps = DesiredCapabilities.firefox();
                break;
            case HTMLUNIT:
                caps = DesiredCapabilities.htmlUnit();
                break;
            case IE:
                caps = DesiredCapabilities.internetExplorer();
                break;
            case PHANTOMJS:
                caps = DesiredCapabilities.phantomjs();
                break;
            default:
                throw new InvalidArgumentException("Option is not supported ");

        }

        caps.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
        return caps;
    }


}
