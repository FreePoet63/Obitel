package page.dafault;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class MethodsToDefault {

    public static void waitToClicable(WebDriver driver, int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitToVisibility(WebDriver driver, int sec, WebElement name) {
        WebDriverWait newWait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        newWait.until(ExpectedConditions.visibilityOf(name));
    }

    public static void waitTimeoutFluent(WebDriver driver, int x, int y, By newBy) {
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(x))
                .pollingEvery(Duration.ofSeconds(y))
                .ignoring(NoSuchElementException.class);
        WebElement superWait = (WebElement) fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement superWait = driver.findElement(newBy);
                return superWait;
            }
        });
    }

    public static void clickJS(WebDriver driver, WebElement e) {
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();",e);
    }

    public static void setValueJS(WebDriver driver, String string, WebElement myElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value= '" + string + "';", myElement, string);

    }
}
