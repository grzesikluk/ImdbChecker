package pageobjects.imdb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Lukasz on 2017-01-21.
 */
public class WesternGenreImdbPage extends AbstractPage {

    public WesternGenreImdbPage(WebDriver driver, String url) {
        super(driver, url);

        addToXPathMap("RankTableXPath", "//*[@id=\"main\"]/div/div/div[3]");
        addToXPathMap("RankTableWebElementListXPath", "//*[@id=\"main\"]/div/div/div[3]/div");
        addToXPathMap("SortingOptionXPath", "//*[@id=\"main\"]/div/div/div[2]/a[%d]");

    }

    /**
     * This enum is used to ease more the sorting options. It has some details in it to update XPath.
     */
    public enum WesternGenreImdbPageSortingType {
        POPULARITY(1), ALPHABETICAL(2), IMDBRATING(3), NUMBEROFVOTES(4), USBOXOFFICE(5), RUNTINE(6), YEAR(7), RELEASE(8);

        private int divNumber;

        WesternGenreImdbPageSortingType(int divNo) {
            divNumber = divNo;
        }

        public int getDivNumber() {
            return divNumber;
        }
    }

    public WebElement getRankTable() {
        return findElement("RankTableXPath");
    }

    public List<WebElement> getRankTableWebElementLists() {
        return getRankTable().findElements(By.xpath(getXPathValue("RankTableWebElementListXPath")));
    }

    public void selectRankTableSortingOption(WesternGenreImdbPageSortingType sortingType) {
        driver.findElement(By.xpath(String.format(getXPathValue("RankTableWebElementListXPath"), sortingType.getDivNumber()))).click();
        waitForPageToLoad(10);
    }

    private void waitForPageToLoad(int secondsToWait) {
        waitForElementToLoad("RankTableXPath", secondsToWait);
    }
}
