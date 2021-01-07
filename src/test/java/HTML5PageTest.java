import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HTML5PageTest {

    private WebDriver driver;
    private HTML5Page html5Page;
    private static String[] links= null;
    private static int linksCount = 0;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://obitel-minsk.ru/");
        String mainTab = driver.getWindowHandle();
        html5Page = new HTML5Page(driver);
    }
    @Test
    public void links()  {
        html5Page.openVideo();
        html5Page.fieldLinks();
        List<WebElement> linksize = driver.findElements(By.tagName("a"));
        linksCount = linksize.size();
        System.out.println("Total no of links Available: "+ linksCount);
        links = new String[linksCount];
        System.out.println("List of links Available: ");
        for (int i=0; i<linksCount; i++) {
            links[i] = linksize.get(i).getAttribute("href");
            System.out.println(linksize.get(i).getAttribute("href"));
            Assert.assertTrue(linksize.get(i).getAttribute("href"), true);
        }
    }

    @Test
    public void videoPlay() throws InterruptedException {
        html5Page.openVideo();
        html5Page.videoFrame();
        html5Page.videoPlayer();
        Thread.sleep(10000);
        html5Page.videoPlayer();
    }

    @Test
    public void audioObitel() {
        html5Page.openAudio();
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        html5Page.audioCross();
        html5Page.openAction();
        html5Page.volumePlay();
         try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        html5Page.openAudio();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
