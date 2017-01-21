package testtools;

/**
 * Created by Lukasz on 2017-01-21.
 */
public enum DriverType {
    CHROME("Chrome driver"), FIREFOX("Firefox driver"), HTMLUNIT("Html unit driver"), IE("Internet Explorer driver"), PHANTOMJS("Phantom JS driver");

    private String description;

    DriverType(String desc) {
        description = desc;
    }

}
