import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OrderPageTest {
    private WebDriver driver;
    private OrderPage orderPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://palomniki-obitel.ru/bronirovanie-nomerov/");
        String mainTab1 = driver.getWindowHandle();
        orderPage = new OrderPage(driver);
    }
    @Test
    public void orderForm() {
        orderPage.Name1("Иван");
        orderPage.Middle("Васильевич");
        orderPage.Last("Терехов");
        orderPage.Country("Испания, Мадрид");
        orderPage.Mail("gatelia@mail.ru");
        orderPage.Phone("2346161");
        orderPage.Mans("3");
        orderPage.Click1();
        orderPage.Data("18 июля");
    }
    @Test
    public void orderError() {
        orderPage.Button1();
        OrderPage autoOrder = orderPage.Button1();
        String ErrorName = autoOrder.nameError();
        Assert.assertEquals("Это поле обязательное.", ErrorName);
        String ErrorLast = orderPage.lastError();
        Assert.assertEquals("Это поле обязательное.", ErrorLast);
        String ErrorMail = orderPage.mailError();
        Assert.assertEquals("Это поле обязательное.", ErrorMail);
        String ErrorPhone = orderPage.phoneError();
        Assert.assertEquals("Это поле обязательное.", ErrorPhone);
        String ErrorMans = orderPage.mansError();
        Assert.assertEquals("Это поле обязательное.", ErrorMans);
    }
    @Test
    public void mailTextRow() {
        orderPage.Mail("///");
        orderPage.Button1();
        OrderPage mom = orderPage.Button1();
        String mailblack = mom.MailTextErrow();
        Assert.assertEquals("Пожалуйста, введите правильный email адрес.", mailblack);
    }
    @Test
    public void HeaderOrderObitel() {
        OrderPage Mam = orderPage.headerOrder();
        String header = Mam.orderHeader();
        Assert.assertEquals("Бронирование номеров", header);
        orderPage.clickHeader();


    }
    @After
    public void tearDown() {
        driver.quit();
    }

}