package page.basepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.obitel.LavkaPage;
import page.obitel.RegisterPage;

public class DriverLavkaPageSettings {
    public WebDriver driver;
    public RegisterPage registerPage;
    public LavkaPage lavkaPage;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
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
