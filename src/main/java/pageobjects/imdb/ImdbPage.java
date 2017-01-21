package pageobjects.imdb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Lukasz on 2017-01-21.
 *
 * This page object covers tha main IMDB page. It's url is fixed.
 *
 * This page can create WesternGenreImdbPage object by navigating to it.
 *
 */
public class ImdbPage extends AbstractPage {
    public static final String fixedUrl = "http://www.imdb.com/chart/top";

    public ImdbPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public ImdbPage(WebDriver driver) {
        super(driver, fixedUrl);

        /*this is the point where we are coupled to xPaths - might be in Spring context*/
        addToXPathMap("RankTableXPath","//*[@id=\"main\"]/div/span/div/div/div[3]/table");
        addToXPathMap("RankTableListXPath","//*[@id=\"main\"]/div/span/div/div/div[3]/table/thead/tr");
        addToXPathMap("SortingOptionXPath","//*[@id=\"main\"]/div/span/div/div/div[3]/div/div/div[1]/select");
        addToXPathMap("MovieCategoryXPath","//*[@id=\"sidebar\"]/div[6]/span/ul/li[21]/a");

    }

    public enum ImdbPageSortingType {
        RANKING("rk:ascending"), IMDB_RATING("ir:descending"), RELEASE_DATE("us:descending"), NUMBER_OF_RATINGS("nv:descending"), YOUR_RATING("ur:descending");

        private String optionValue;

        ImdbPageSortingType(String optionVal) {
            optionValue = optionVal;
        }

        public String getOptionValue() {
            return optionValue;
        }
    }

    public WebElement getRankTable() {
        return driver.findElement(By.xpath(getXPathValue("RankTableXPath")));
    }

    public List<WebElement> getRankTableWebElementLists() {
        return getRankTable().findElements(By.xpath(getXPathValue("RankTableListXPath")));
    }

    public WebElement getRankTableSortingOptionWebElement() {
        return findElement("SortingOptionXPath");
    }


    public void selectRangTableSortingOption(ImdbPageSortingType sortingType) {
        new Select(getRankTableSortingOptionWebElement()).selectByValue(sortingType.getOptionValue());
    }

    public WesternGenreImdbPage getWesternGenreImdbPage() {
        getMovieCategoryWesternWebElement().click();
        return new WesternGenreImdbPage(driver, driver.getCurrentUrl());
    }

    private WebElement getMovieCategoryWesternWebElement() {
        return findElement("MovieCategoryXPath");
    }


}
