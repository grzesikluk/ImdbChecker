package tests;

import testtools.DriverFactory;
import testtools.DriverType;
import testtools.SystemPropertiesHelper;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Lukasz on 2017-01-21.
 *
 * Abstract class for
 *
 */
public abstract class AbstractPageTest {

    protected static WebDriver driver;

    /**
     * This is hardcoded but the idea is to use maven profiles to set up proper driver in future.
     */
    protected static final DriverType driverType = DriverType.CHROME;

    public static void initialiseDriver() {
        SystemPropertiesHelper.setSystemPropertiesForDriver(driverType);
        driver = DriverFactory.getWebDriver(driverType);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
