package seleniumutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Waits {

    private static <T> T waitForCondition(WebDriver driver, Integer timeOutSeconds, Function<WebDriver, T> condition) {
        return new WebDriverWait(driver, timeOutSeconds)
                .ignoring(WebDriverException.class)
                .until(condition);
    }

    public static void waitForElementToBeVisible(WebDriver driver, final WebElement element, int seconds) {
        waitForCondition(driver, seconds, d -> element.isDisplayed());
    }

    public static void waitForElementToBeEnable(WebDriver driver, final WebElement element, int seconds) {
        waitForCondition(driver, seconds, d -> element.isEnabled());
    }

    public static void waitForElementToBeClickable(final WebElement element) {
        ExpectedConditions.elementToBeClickable(element);
    }
}
