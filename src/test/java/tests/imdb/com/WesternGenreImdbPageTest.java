package tests.imdb.com;

import pageobjects.imdb.ImdbPage;
import pageobjects.imdb.WesternGenreImdbPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.AbstractPageTest;

/**
 * Created by Lukasz on 2017-01-21.
 */
public class WesternGenreImdbPageTest extends AbstractPageTest {
    private static WesternGenreImdbPage westernCategoryImdbPage;

    @BeforeClass
    public static void init() throws Exception {
        initialiseDriver();
        ImdbPage imdbPage = new ImdbPage(driver);
        imdbPage.loadPage();
        westernCategoryImdbPage = imdbPage.getWesternGenreImdbPage();
        westernCategoryImdbPage.loadPage();
    }

    @Test
    public void shouldContainAtLeastOneMovieInListWhenLoaded() throws Exception {
        Assert.assertTrue(westernCategoryImdbPage.getRankTableWebElementLists().size() > 0);
    }

    @Test
    public void shouldContainAtLeastOneMovieInListForEachSortingOption() throws Exception {

        for (WesternGenreImdbPage.WesternGenreImdbPageSortingType sortingType : WesternGenreImdbPage.WesternGenreImdbPageSortingType.values()) {
            westernCategoryImdbPage.selectRankTableSortingOption(sortingType);
            Assert.assertTrue(westernCategoryImdbPage.getRankTableWebElementLists().size() > 0);
        }
    }


}
