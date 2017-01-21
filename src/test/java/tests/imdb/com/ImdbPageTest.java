package tests.imdb.com;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobjects.imdb.ImdbPage;
import tests.AbstractPageTest;

/**
 * Created by Lukasz on 2017-01-21.
 */
public class ImdbPageTest extends AbstractPageTest {

    private static ImdbPage imdbPage;

    @BeforeClass
    public static void init() throws Exception {
        initialiseDriver();

        imdbPage = new ImdbPage(driver);
        imdbPage.loadPage();
    }

    @Test
    public void shouldPageBeAvailable() throws Exception {
        Assert.assertEquals(imdbPage.getPageTitle(),"IMDb Top 250 - IMDb");
    }

    @Test
    public void shouldContainAtLeastOneMovieInListWhenLoaded() throws Exception {
        Assert.assertTrue(imdbPage.getRankTableWebElementLists().size()>0);
    }

    @Test
    public void shouldContainAtLeastOneMovieInListForEachSortingOption() throws Exception {

        for(ImdbPage.ImdbPageSortingType sortingType: ImdbPage.ImdbPageSortingType.values()) {
            imdbPage.selectRangTableSortingOption(sortingType);
            Assert.assertTrue(imdbPage.getRankTableWebElementLists().size()>0);
        }
    }

}
