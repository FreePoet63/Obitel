import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class LavkaPage  {

    private static WebDriver driver;



    public LavkaPage(WebDriver driver) {
        this.driver = driver;
    }
    private By setShop = By.xpath("//nav//li//span[normalize-space(.)='Утварь']");
    private By setObject = By.xpath("//span[contains(text(), \"Четки\")]");
    private By setCustomer = By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/div[3]/ol/li[4]");
    private By setFieldnumber = By.xpath("//*[@id=\"qty\"]");
    private By setButtoncustom = By.xpath("//*[contains(text(), \"Выбрать\")]");
    private By setWindowfield = By.xpath("//a[@class=\"action showcart\"]");
    private By setDeleteCustom = By.xpath("//a[@class=\"action delete\"]");
    private By setAllert = By.xpath("//button[@class=\"action-primary action-accept\"]");
    private By setCandle = By.xpath("//span[contains(text(), 'Церковные свечи')]");
    private By setObjectNew = By.xpath("/html/body/div[2]/div/div/div[2]/nav/ul/li[6]/ul/li[10]/a/span");
    private By setSlider = By.xpath("//*[@id=\"narrow-by-list\"]/div/div[2]/div/div[1]");
    private By slaiderField = By.xpath("/html/body/div[2]/main/div[4]/div[2]/div/div[2]/div/div/div[2]/div/div[3]/a[1]");
    private By stringSlay = By.xpath("//*[@id=\"narrow-by-list\"]/div/div[2]/div/div[2]");
    private By newSlayderField = By.xpath("/html/body/div[2]/main/div[4]/div[2]/div/div[2]/div/div/div[2]/div/div[3]/a[2]");
    private By menuItemsCandles = By.xpath("//div[@class=\"product details product-item-details\"]");
    private By getItemsProduct = By.xpath("//ol[@class = \"products list items product-items\"]/li");
    private By getCandleProduct = By.xpath("//span[contains(text(), \"210\")]");
    private By getStringMenu = By.xpath("//div[@class = \"column main\"]");


    public void fieldUtvar() {
        Actions act = new Actions(driver);
        WebElement e = driver.findElement(setShop);
        act.moveToElement(e).click().build().perform();
       }

    public LavkaPage fieldChetki() {
        driver.findElement(setObject).click();
        return this;
    }

    public LavkaPage fieldTovar() {
        driver.findElement(setCustomer).click();
        return this;
    }

    public void fieldNumber() {
        driver.findElement(setFieldnumber).clear();
    }

    public LavkaPage fielfSetNumber(String number) {
        driver.findElement(setFieldnumber).sendKeys(number);
        return this;
    }

    public LavkaPage buttonCustomer() {
        System.out.println(driver.findElement(setFieldnumber).getText());
        driver.findElement(setButtoncustom).click();
        return this;
    }

    public LavkaPage fieldWindow() {
        driver.findElement(setWindowfield).click();
        return this;
    }

    public void fieldDelete() {
        driver.findElement(setDeleteCustom).click();
    }

    public void fieldAlert() {
        driver.findElement(setAllert).click();
    }

    public void fieldNewObject() {
        driver.findElement(setObjectNew).click();
    }


    public static void formatOption(String name) {
        System.out.println(driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", name))).getText());
        driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", name))).click();
    }

    public void candleField() {
        driver.findElement(setCandle).click();
    }

    public String slaiderNew() {
        return driver.findElement(setSlider).getText();
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