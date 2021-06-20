package page.basepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.obitel.OrderPage;

public class DriverObitelTravelPage {
    public WebDriver driver;
    public OrderPage orderPage;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://palomniki-obitel.ru/bronirovanie-nomerov/");
        String mainTab1 = driver.getWindowHandle();
        orderPage = new OrderPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
