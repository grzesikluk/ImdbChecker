package testtools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.logging.Level;

/**
 * Created by Lukasz on 2017-01-21.
 * <p>
 * Factory class to help with creation of WebDriver.
 * It is also the point to define logging preferences.
 */
public class DriverFactory {

    public static final Level level = Level.ALL;

    private DriverFactory() {
    }

    public static WebDriver getWebDriver(DriverType driverType) {

        switch (driverType) {

            case CHROME:
                return new ChromeDriver(DriverCapabilitiesFactory.getCapabilities(driverType, TestLoggingHelper.getLoggingPreferencesForDriver(level)));
            case FIREFOX:
                return new FirefoxDriver(DriverCapabilitiesFactory.getCapabilities(driverType, TestLoggingHelper.getLoggingPreferencesForDriver(level)));
            case HTMLUNIT:
                return new HtmlUnitDriver(DriverCapabilitiesFactory.getCapabilities(driverType, TestLoggingHelper.getLoggingPreferencesForDriver(level)));
            case IE:
                return new InternetExplorerDriver(DriverCapabilitiesFactory.getCapabilities(driverType, TestLoggingHelper.getLoggingPreferencesForDriver(level)));
            case PHANTOMJS:
                return new PhantomJSDriver(DriverCapabilitiesFactory.getCapabilities(driverType, TestLoggingHelper.getLoggingPreferencesForDriver(level)));
            default:
                throw new IllegalArgumentException("No such driver type supported");

        }
    }


}
