package page.obitel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static page.dafault.MethodsToDefault.clickJS;
import static page.dafault.MethodsToDefault.setValueJS;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private By nameObitel = By.id("searchR");
    private By setOK = By.xpath("//span[@class=\"caret\"]");
    private By setLink1 = By.xpath("//a[contains(text(), \"О монастыре\")]");
    private By setFieldLink1 = By.xpath("//a[text() = \"Святая Елисавета\"]");
    private By setLink2 = By.xpath("//a[contains(text(), \"Cлужение\")]");
    private By setFieldLink2 = By.xpath("//a[text() = \"Патронажная служба\"]");
    private By setLink3 = By.xpath("//a[contains(text(), \"Прихожанам\")]");
    private By setFieldLink3 = By.xpath("//a[text() = \"Спросите батюшку\"]");
    private By setHeadlines2 = By.xpath("//ul[@class=\"news-headlines\"]/li[2]");
    private By setHeadlines3 = By.xpath("//ul[@class=\"news-headlines\"]/li[3]");
    private By setHeadlines6 = By.xpath("//ul[@class=\"news-headlines\"]/li[6]");

    public void obitelSearch() {
        String name = "Батюшка";
        WebElement myElement = driver.findElement(nameObitel);
        setValueJS(driver, name, myElement);
    }

    public void seeMenuOK() {
       WebElement e2 =  driver.findElement(setOK);
       clickJS(driver, e2);
    }

    public void pageLink1() {
        WebElement link = driver.findElement(setLink1);
        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();
        driver.findElement(setFieldLink1).click();
        driver.navigate().back();
    }

    public void pageLink2() {
        WebElement link1 = driver.findElement(setLink2);
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(link1).build().perform();
        driver.findElement(setFieldLink2).click();
        driver.navigate().back();
    }

    public void pageLink3() {
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
}
