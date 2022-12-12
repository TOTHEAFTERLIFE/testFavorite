package pages;

import base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MostPopularMovie extends TestBase {
    private static final By favoriteButton = By.xpath("//div[@class='userButtons__item userButtons__item_wide userButtons__item_favorite']");
    private static final By profile = By.xpath("//a[@class='headerAvatar__link']");
    private static final By watchLater = By.xpath("//div[text()='Смотреть позже']");
    private static final By movieTitle = By.xpath("//div[@class='nbl-slimPosterBlock__title']");
    private static final By closeWindow = By.xpath("//div[@class='nbl-icon nbl-icon_closeCircle_20 nbl-simpleControlButton__nbl-icon']");
    private static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT));

    @Step("get a movie title")
    public static String getName() {
        return driver.findElement(movieTitle).getText();
    }

    @Step("add the movie to \"Смотреть позже\" list")
    public static void clickOnFavoriteButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(favoriteButton));
        driver.findElement(favoriteButton).click();
    }

    public static void clickOnCloseWindow() {
        wait.until(ExpectedConditions.presenceOfElementLocated(closeWindow));
        driver.findElement(closeWindow).click();
    }

    @Step("move a mouse courser to a profile icon")
    public static void moveToProfile() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(profile)).build().perform();
    }

    @Step("open a \"Смотреть позже\" list")
    public static ProfilePage clickOnWatchLater() {
        wait.until(ExpectedConditions.presenceOfElementLocated(watchLater));
        driver.findElement(watchLater).click();
        return new ProfilePage();
    }
}
