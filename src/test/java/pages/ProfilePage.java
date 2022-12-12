package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ProfilePage extends TestBase {
    private static final By lastAddedMovie = By.xpath("//div[@class='broadPosterBlock__title']");

    public static String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(20, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.presenceOfElementLocated(lastAddedMovie));
        return driver.findElement(By.xpath("//div[@class='broadPosterBlock__title']")).getText();
    }
}
