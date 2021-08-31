package page.basepage;

import org.junit.After;
import org.junit.Before;
import page.obitel.FormPage;
import page.obitel.HTML5Page;
import page.obitel.MainPage;

import static page.driver.WebDriverStart.driver;
import static page.driver.WebDriverStart.openDriver;

public class DriverObitelPageSettings {
    public FormPage formPage;
    public HTML5Page html5Page;
    public MainPage mainPage;

    @Before
    public void setUp() {
        ////WORKED IN SELENOID
        /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("89.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                capabilities
        );*/
        openDriver("Firefox");
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
