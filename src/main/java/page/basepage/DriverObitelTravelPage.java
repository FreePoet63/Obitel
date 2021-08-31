package page.basepage;

import org.junit.After;
import org.junit.Before;
import page.obitel.OrderPage;

import static page.driver.WebDriverStart.driver;
import static page.driver.WebDriverStart.openDriver;

public class DriverObitelTravelPage {
    public OrderPage orderPage;

    @Before
    public void setUp() {
        openDriver("Firefox");
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
