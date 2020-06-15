import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HTML5PageTest {

    private WebDriver driver;
    private HTML5Page html5Page;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://obitel-minsk.ru/");
        String mainTab = driver.getWindowHandle();
        html5Page = new HTML5Page(driver);
    }

    @Test
    public void videoPlay() {
        html5Page.openVideo();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        html5Page.videoFrame();
        html5Page.videoPlayer();
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        html5Page.videoPlayer();
        Assert.assertTrue(true);
    }
    @Test
    public void audioObitel() {
        html5Page.openAudio();
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        html5Page.openAction();
        html5Page.volumePlay();
         try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        html5Page.openAudio();
         Assert.assertTrue(true);

    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
