package page.basepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.obitel.FormPage;
import page.obitel.HTML5Page;
import page.obitel.MainPage;

public class DriverObitelPageSettings {
    public WebDriver driver;
    public FormPage formPage;
    public HTML5Page html5Page;
    public MainPage mainPage;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://obitel-minsk.ru/");
        formPage = new FormPage(driver);
        String mainTab = driver.getWindowHandle();
        html5Page = new HTML5Page(driver);
        mainPage = new MainPage(driver);
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
