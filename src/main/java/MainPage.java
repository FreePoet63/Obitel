import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    private By nameObitel = By.xpath("//*[@id=\"searchR\"]");
    private By setClickSearch = By.xpath("//*[@id=\"sFilter\"]/input[2]");
    private By serSearch = By.xpath("/html/body/div[1]/div/div/div[2]/form/button/span");
    private By setYouTube = By.xpath("/html/body/div[1]/div/div/div[3]/a[4]/span");
    private By setOK = By.xpath("/html/body/div[1]/div/div/div[4]/li/a/span");
    private By setCheckbox = By.xpath("/html/body/div[1]/div/div/div[4]/li/ul");
    private By setLink1 = By.xpath("/html/body/div[3]/div[1]/div/ul/li[2]/a");
    private By setFieldLink1 = By.xpath("/html/body/div[3]/div[1]/div/ul/li[2]/ul/li[1]/a");
    private By getFieldLink1 = By.xpath("//*[@id=\"nav\"]/div/div/ul/li[5]/a");
    private By setLink2 = By.xpath("/html/body/div[3]/div[1]/div/ul/li[3]/a");
    private By setFieldLink2 = By.xpath("/html/body/div[3]/div[1]/div/ul/li[3]/ul/li[5]/a");
    private By setLink3 = By.xpath("/html/body/div[3]/div[1]/div/ul/li[4]/a");
    private By setFieldLink3 = By.xpath("/html/body/div[3]/div[1]/div/ul/li[4]/ul/li[8]/a");
    private By setHeadlines2 = By.xpath("//ul[@class=\"news-headlines\"]/li[2]");
    private By setHeadlines3 = By.xpath("//ul[@class=\"news-headlines\"]/li[3]");
    private By setHeadlines6 = By.xpath("//ul[@class=\"news-headlines\"]/li[6]");
    private By setPaginatsya = By.xpath("//*[@id=\"ancore\"]/div[10]/div/ul/li[7]/a");




    public void obitelSearch() {
        WebElement myElement = driver.findElement(nameObitel);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='Батюшка';", myElement);

    }

    public MainPage typeword(String word) {
        driver.findElement(setClickSearch).click();
        return this;
    }

    public void clickSearch() {
        driver.findElement(serSearch).click();
        driver.navigate().back();
    }

    public void YouTube() {
        WebElement e1 = driver.findElement(setYouTube);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("aeguments[0].click();",e1);
    }

    public void OK() {
       WebElement e2 =  driver.findElement(setOK);
       JavascriptExecutor ex = (JavascriptExecutor) driver;
       ex.executeScript("arguments[0].click();",e2);
    }

    public void checkboxes() {
        List<WebElement> checkboxes = driver.findElements(setCheckbox);
        checkboxes.get(0).click();
    }

    public void Link1() {
        WebElement link = driver.findElement(setLink1);
        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();
        driver.findElement(setFieldLink1).click();
        driver.navigate().back();
    }

    public void Link2() {
        WebElement link1 = driver.findElement(setLink2);
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(link1).build().perform();
        driver.findElement(setFieldLink2).click();
        driver.navigate().back();
    }

    public void Link3() {
        WebElement link2 = driver.findElement(setLink3);
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(link2).build().perform();
        driver.findElement(setFieldLink3).click();
        JavascriptExecutor jsex = (JavascriptExecutor) driver;
        jsex.executeScript("window.scrollBy(0, 1000)", "");
    }

    public void pagesObitel() {
        driver.findElement(setHeadlines2).click();
        driver.findElement(setHeadlines3).click();
        driver.findElement(setHeadlines6).click();
    }

    public void paginatsya() {
        WebDriverWait waitt = new WebDriverWait(driver, 5);
        waitt.until(ExpectedConditions.visibilityOfElementLocated(setPaginatsya)).click();
    }

}
