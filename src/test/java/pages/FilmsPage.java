package pages;

import base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class FilmsPage extends TestBase {

    @Step("Open \"Лучшее в подборке\" list")
    public static BestMovies clickOnBestMovies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Премьеры на Иви']")));
        driver.findElement(By.xpath("//a[@title='Премьеры на Иви']")).click();
        return new BestMovies();
    }

}
