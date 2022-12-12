package test;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;


public class LastAddedMovieTest extends TestBase {

    public LastAddedMovieTest() {
        super();
    }

    @Test(description = "Test if the movie was added to favorites")
    public void movieAdded() {
        MainPage.clickOnFilms();
        FilmsPage.clickOnBestMovies();
        BestMovies.setFilter();
        BestMovies.clickOnMostPopularMovie();
        String title = MostPopularMovie.getName();
        MostPopularMovie.clickOnFavoriteButton();
        MostPopularMovie.clickOnCloseWindow();
        MostPopularMovie.moveToProfile();
        MostPopularMovie.clickOnWatchLater();
        Assert.assertEquals(ProfilePage.getTitle(), title);
    }
}
