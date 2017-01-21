package pageobjects.imdb;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lukasz on 2017-01-21.
 * <p>
 * The PageObject model starts with this class. It is considered to be a common point to implement some methods and be
 * inherited by other page objects. It might be further derived and extended to cover standard actions.
 * <p>
 * The point is to cover all WebDriver actions with page objects classes, so that we can easily perform actions on the
 * page itself.
 * <p>
 * Not all getters/setters used but this is just example of possible class.
 */
public abstract class AbstractPage {

    private final static Logger logger = Logger.getLogger(AbstractPage.class);
    protected WebDriver driver;
    protected String url;
    /**
     * This object will hold all XPaths - it might be autowired by Spring I guess.
     */
    protected Map<String, String> xPathMap;

    public AbstractPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        xPathMap = new HashMap<>();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void loadPage() {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void addToXPathMap(String k, String v) {
        xPathMap.put(k, v);
    }

    public String getXPathValue(String k) {
        return xPathMap.get(k);
    }

    public WebElement findElement(String xPathKey) {
        logger.info("Getting element " + xPathKey);
        return driver.findElement(By.xpath(getXPathValue(xPathKey)));
    }


    public void waitForElementToLoad(String xPathKey, int secondsToWait) {
        WebDriverWait waitDriver = new WebDriverWait(driver, secondsToWait);
        logger.info("Waiting for element " + xPathKey+ " for " + secondsToWait + " seconds");
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath(getXPathValue(xPathKey))));
    }


}
