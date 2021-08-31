package page.obitel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static page.dafault.MethodsToDefault.waitToClicable;
import static page.logger.Log.*;
import static page.settings.TestConfig.LINKCOUNT_HTMLPAGE;
import static page.settings.TestConfig.LINKS_HTMLPAGE;

public class HTML5Page {

    private WebDriver driver;

    public HTML5Page(WebDriver driver) {
        this.driver = driver;
    }
    private By setOpenVideo = By.xpath("//a[contains(text(), \"Медиа\")]");
    private By setOpenVideoPage = By.xpath("//a[text() = \"Видео\"]");
    private By setMediaVideo = By.xpath("//a[text() = \"Беседа с батюшкой\"]");
    private By setLinks = By.tagName("a");
    private By setPlay = By.id("player");
    private By setFrame = By.xpath("//iframe[starts-with(@class,\"embed\")]");

    public void openVideo() {
        waitToClicable(driver, 10, setOpenVideo);
        WebElement openPage = driver.findElement(setOpenVideo);
        Actions actions = new Actions(driver);
        actions.moveToElement(openPage).build().perform();
        waitToClicable(driver, 10, setOpenVideoPage);
        WebElement openLink = driver.findElement(setOpenVideoPage);
        openLink.click();
    }

    public void clickVideo() {
        driver.findElement(setMediaVideo).click();
    }

    public void videoFrame() {
        WebElement frramm = driver.findElement(setFrame);
        driver.switchTo().frame(frramm);
    }

    public HTML5Page videoPlayer() {
        driver.findElement(setPlay).click();
        return this;
    }

    public void openLinks() {
        List<WebElement> linksize = driver.findElements(setLinks);
        LINKCOUNT_HTMLPAGE = linksize.size();
        info("Total no of links Available: " + LINKS_HTMLPAGE);
        LINKS_HTMLPAGE = new String[LINKCOUNT_HTMLPAGE];
        info("List of links Available: ");
        for (int i = 0; i < LINKCOUNT_HTMLPAGE; i++) {
            LINKS_HTMLPAGE[i] = linksize.get(i).getAttribute("href");
            info(linksize.get(i).getAttribute("href"));
        }
    }

    public void searchBrokenLinks() {
        List<WebElement> allLinks = driver.findElements(setLinks);
        info("All Links Size: " + allLinks.size());
        for(WebElement link:allLinks){
            try {
                String urlLink = link.getAttribute("href");
                URL url = new URL(urlLink);
                HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
                httpURLConnect.setConnectTimeout(5000);
                httpURLConnect.connect();
                if(httpURLConnect.getResponseCode()>=400)
                {
                    error(urlLink+" - "+httpURLConnect.getResponseMessage() +"is a broken link");
                }
                else{
                    warn(urlLink+" - "+httpURLConnect.getResponseMessage());
                }
            }catch (Exception e) {
            }
        }
    }
}
