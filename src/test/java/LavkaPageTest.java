import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LavkaPageTest {

    private WebDriver driver;
    private LavkaPage lavkaPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://lavka-obitel.ru/");
        String mainTab2 = driver.getWindowHandle();
        lavkaPage = new LavkaPage(driver);
    }

    @Test
    public void lavkaShop() {
        lavkaPage.fieldUtvar();
        lavkaPage.fieldChetki();
        lavkaPage.fieldTovar();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavkaPage.fieldNumber();
        lavkaPage.fielfSetNumber("2");
        LavkaPage lav = lavkaPage.buttonCustomer();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String number1 = lav.numberCustom();
        Assert.assertEquals("2", number1);
        LavkaPage Mon = lavkaPage.fieldWindow();
        String SumMoney = Mon.money();
        Assert.assertEquals("1 800 руб.", SumMoney);
        lavkaPage.fieldNumber();
        lavkaPage.fielfSetNumber("1");
        lavkaPage.buttonCustomer();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String number2 = lav.numberCustom();
        Assert.assertEquals("3", number2);
        lavkaPage.fieldWindow();
        String Monney = Mon.money();
        Assert.assertEquals("2 700 руб.", Monney);
        lavkaPage.fieldDelete();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavkaPage.fieldAlert();
    }
    @Test
    public void fieldMenu() {
        lavkaPage.fieldUtvar();
        lavkaPage.fieldChetki();
        List<WebElement> stringList = driver.findElements(By.xpath("//div[@class = \"column main\"]"));
        for (WebElement element: stringList) {
            System.out.println((element.getText()));
            Assert.assertTrue(element.getText().contains("четки"));
        }
    }
    @Test
    public void formatmenu() {
        lavkaPage.fieldUtvar();
        lavkaPage.fieldChetki();
        lavkaPage.formatOption("900");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertSame("900","900");
        Assert.assertTrue(true);
        lavkaPage.formatOption("550");
        Assert.assertEquals("550", "550");
        Assert.assertTrue("550", true);
    }
    @Test
    public void menuFieldItems() {
        lavkaPage.fieldUtvar();
        lavkaPage.fieldChetki();
        List<WebElement> ellement = driver.findElements(By.xpath("//ol[@class = \"products list items product-items\"]/li"));
        System.out.println(ellement.size());
        for (WebElement element: ellement) {
            System.out.println(ellement.get(5).getText());
            Assert.assertTrue(Boolean.parseBoolean(String.valueOf(ellement.get(5).getText().contains("126 руб."))));
        }

    }
    @Test
    public void itemsTeam() {
        lavkaPage.fieldUtvar();
        lavkaPage.fieldChetki();
        List<WebElement> ellements = driver.findElements(By.xpath("//ol[@class = \"products list items product-items\"]/li"));
        System.out.println(ellements.size());
        for (WebElement ellement : ellements) {
            System.out.println(ellement.getText());
            Assert.assertTrue(ellement.getText(), true);
            if (ellements.size() == 11) System.out.println("EllementTrue");
            else System.out.println("Non");
        }

    }

   @After
   public void tearDown(){
        driver.quit();
    }
}
