import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }
    private By nameObitel = By.xpath("//*[@id=\"searchR\"]");



    public void testObitel() {
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[3]/div[1]/a/img")).click();
        WebElement frame = driver.findElement(By.xpath("//div[@class=\"playbuzz\"]/iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//p[contains(text(), \"Оптина пустынь\")]")).click();
        System.out.println(driver.findElement(By.xpath("//p[contains(text(), \"Оптина пустынь\")]")).getText());
        driver.switchTo().defaultContent();
    }
    public void obitelSearch() {
        driver.findElement(By.xpath("//*[@id=\"searchR\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"sFilter\"]/input[2]")).click();
    }
    public MainPage typeword(String word) {
        driver.findElement(nameObitel).sendKeys(word);
        return this;
    }

    public void clickSearch() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/button/span")).click();
        driver.navigate().back();
    }
    public void YouTube() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/a[4]/span")).click();
    }
    public void OK() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/li/a/span")).click();
    }
    public void checkboxes() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("/html/body/div[1]/div/div/div[4]/li/ul"));
        checkboxes.get(0).click();
    }
    public void Link1() {
        WebElement link = driver.findElement(By.xpath("//*[@id=\"top_navNew\"]/div/ul/li[2]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul/li[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"nav\"]/div/div/ul/li[5]/a")).click();
        driver.navigate().back();
    }
    public void Link2() {
        WebElement link1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul/li[3]/a"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(link1).build().perform();
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul/li[3]/ul/li[5]/a")).click();
        driver.navigate().back();
    }
    public void Link3() {
        WebElement link2 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul/li[4]/a"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(link2).build().perform();
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul/li[4]/ul/li[8]/a")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
    }
    public void pagesObitel() {
        driver.findElement(By.xpath("//ul[@class=\"news-headlines\"]/li[2]")).click();
        driver.findElement(By.xpath("//ul[@class=\"news-headlines\"]/li[3]")).click();
        driver.findElement(By.xpath("//ul[@class=\"news-headlines\"]/li[6]")).click();
    }
    public void paginatsya() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"mainPageP\"]//ul//li[6]"))).click();
    }
}
