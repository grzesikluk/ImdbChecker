package testtools;

/**
 * Created by Lukasz on 2017-01-21.
 *
 * This class is intended to simplify some initial actions. In this case it sets drivers for Firefox and Chrome.
 *
 */
public class SystemPropertiesHelper {

    public static void setSystemPropertiesForDriver(DriverType driver ){
        switch (driver) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\testtools\\geckodriver.exe");
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\testtools\\chromedriver.exe");
                break;
            default:
                //no special settings
        }
    }
}
