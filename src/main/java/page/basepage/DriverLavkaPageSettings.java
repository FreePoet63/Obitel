package page.basepage;

import org.junit.After;
import org.junit.Before;
import page.obitel.LavkaPage;
import page.obitel.RegisterPage;

import static page.driver.WebDriverStart.driver;
import static page.driver.WebDriverStart.openDriver;

public class DriverLavkaPageSettings {
    public RegisterPage registerPage;
    public LavkaPage lavkaPage;

    @Before
    public void setUp() {
        //WORKED IN SELENOID
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
        driver.get("https://lavka-obitel.ru/");
        String mainTab2 = driver.getWindowHandle();
        registerPage = new RegisterPage(driver);
        lavkaPage = new LavkaPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
