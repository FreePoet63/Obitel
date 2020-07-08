import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://obitel-minsk.ru/");
        String mainTab = driver.getWindowHandle();
        mainPage = new MainPage(driver);
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

    }

    @Test
    public void obitelSearch() {
        mainPage.obitelSearch();
        mainPage.typeword("Батюшка");
        mainPage.clickSearch();
        mainPage.YouTube();
        mainPage.OK();
    }
    @Test
    public void obitel() {
        mainPage.Link1();
        mainPage.Link2();
        mainPage.Link3();
    }
    @Test
    public void pages() {
        mainPage.pagesObitel();
        mainPage.paginatsya();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
