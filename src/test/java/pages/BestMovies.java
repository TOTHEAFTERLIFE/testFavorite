package pages;

import base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BestMovies extends TestBase {

    private static final By filter = By.xpath("//div[@class='nbl-arrowButton__caption']");
    private static final By byPopularity = By.xpath("//div[text()='Популярности']");

    @Step("open filters and choose \"По поплуярности\" option")
    public static void setFilter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(20, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.presenceOfElementLocated(filter));
        driver.findElement(filter).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(byPopularity));
        driver.findElement(byPopularity).click();
    }

    @Step("choose the first movie in the sorted list")
    public static MostPopularMovie clickOnMostPopularMovie() {
        driver.findElement(By.xpath("//li[@index='0']")).click();
        return new MostPopularMovie();
    }
}
