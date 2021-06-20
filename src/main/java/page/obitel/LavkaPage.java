package page.obitel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LavkaPage  {

    private static WebDriver driver;
    private int i;

    public LavkaPage(WebDriver driver) {
        this.driver = driver;
    }
    private By setShop = By.xpath("//nav//li//span[normalize-space(.)='Утварь']");
    private By setSuperShop = By.id("ui-id-8");
    private By setObject = By.xpath("//span[contains(text(), \"Четки\")]");
    private By setCandle = By.xpath("//span[contains(text(), 'Церковные свечи')]");
    private By setSlider = By.id("//*[@id=\"narrow-by-list\"]/div/div[2]/div/div[1]");
    private By slaiderField = By.xpath("//a[starts-with(@class, \"ui-slider-handle\")][1]");
    private By stringSlay = By.xpath("//*[@id=\"narrow-by-list\"]/div/div[2]/div/div[2]");
    private By newSlayderField = By.xpath("//a[starts-with(@class, \"ui-slider-handle\")][2]");
    private By menuItemsCandles = By.xpath("//div[@class=\"product details product-item-details\"]");
    private By getItemsProduct = By.xpath("//ol[@class = \"products list items product-items\"]/li");
    private By getCandleProduct = By.xpath("//span[contains(text(), \"210\")]");
    private By getStringMenu = By.xpath("//div[@class = \"column main\"]");

    public LavkaPage setUtvar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(setSuperShop));
        ele.click();
        return this;
    }

    public LavkaPage fieldChetki() {
        driver.findElement(setObject).click();
        return this;
    }

    public static void formatOption(String name) {
        System.out.println(driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", name))).getText());
        driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", name))).click();
    }

    public void candleField() {
        driver.findElement(setCandle).click();
    }

    public String slaiderNew() {
        WebDriverWait newWait = new WebDriverWait(driver, Duration.ofSeconds(7));
        WebElement webEle = driver.findElement(setSlider);
        return newWait.until(ExpectedConditions.visibilityOf(webEle)).getText();
    }

    public LavkaPage sliderClick() {
        Actions actionsEle = new Actions(driver);
        WebElement slider = driver.findElement(slaiderField);
        actionsEle.dragAndDropBy(slider,74, 0).perform();
        return this;
    }

    public String fieldStringSlay() {
        return driver.findElement(stringSlay).getText();
    }

    public LavkaPage newSlayderClick() {
        Actions actionsElemm = new Actions(driver);
        WebElement newSlider = driver.findElement(newSlayderField);
        actionsElemm.dragAndDropBy(newSlider,-70,0).perform();
        return this;
    }

    public List<WebElement> itemsCandlesMenu() {
        return driver.findElements(menuItemsCandles);
    }

    public List<WebElement> itemsProduct() {
       return driver.findElements(getItemsProduct);
    }

    public List<WebElement> candleProduct() {
       return driver.findElements(getCandleProduct);
    }

    public List<WebElement> stringListMenu() {
       return driver.findElements(getStringMenu);
    }
}