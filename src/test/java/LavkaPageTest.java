import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class LavkaPageTest {

    private WebDriver driver;
    private LavkaPage lavkaPage;
    private int i;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://lavka-obitel.ru/");
        String mainTab2 = driver.getWindowHandle();
        lavkaPage = new LavkaPage(driver);
    }
    @Test
    public void sumElement() {
        lavkaPage.fieldUtvar();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LavkaPage clickSlay=lavkaPage.fieldChetki();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String firstSlay = clickSlay.slaiderNew();
        Assert.assertEquals("105 руб.", firstSlay);
        String secondSlay = clickSlay.fieldStringSlay();
        Assert.assertEquals("1 200,99 руб.", secondSlay);
        LavkaPage cliderNow = lavkaPage.sliderClick();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String slaiderText = cliderNow.slaiderNew();
        Assert.assertEquals("505 руб.", slaiderText);
        LavkaPage clayNow = lavkaPage.newSlayderClick();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String newSlayderText = clayNow.fieldStringSlay();
        Assert.assertEquals("821,99 руб.", newSlayderText);
    }
    @Test
    public void arrayListItems() {
        lavkaPage.fieldUtvar();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavkaPage.candleField();
        List<WebElement> items24 = lavkaPage.itemsCandlesMenu();
        System.out.println("Size of the elenents : "+items24.size());
        ArrayList<String> itemsText = new ArrayList<String>();
        for (WebElement ele : items24)
        {
            try {
                itemsText.add(ele.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("************************************");
        System.out.println("Size of the ArrayList "+itemsText.size());
        int i=1;
        for (String s : itemsText) {
            System.out.println(i + ". ArrayList Text : " + s);
            i++;
        }
        assertThat(itemsText, hasItems(containsString("Набор паломника"),
                containsString("Свечи для домашней молитвы"),
                containsString("Поминальные свечи для домашней молитвы")));
    }
    @Test
    public void itemsFlame() {
        lavkaPage.fieldUtvar();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavkaPage.candleField();
        List<WebElement> priceFlame = lavkaPage.itemsProduct();
        ArrayList<String> priceFlameText = new ArrayList<String>();
        System.out.println(priceFlame.size());
        for (WebElement elementFlame : priceFlame)
            priceFlameText.add(elementFlame.getText());
        for (int i=0; i<priceFlame.size(); i++) {
            System.out.println(priceFlame.get(i).getText());
        }
        assertThat(priceFlameText, hasItem("Свечи для домашней молитвы к святому" +
                " Спиридону Тримифунтскому (40 шт)\n" +
                "210 руб."));

        List<WebElement> candles = lavkaPage.candleProduct();
        ArrayList<String> candlesText = new ArrayList<String>();
        for (WebElement eleCandle : candles)
            candlesText.add(eleCandle.getText());
        System.out.println(candles.size());
        for (int i=0; i<candles.size();i++) {
            System.out.println(candles.get(i).getText());
        }
        assertThat(candlesText, hasItem("210 руб."));
    }


    @Test
    public void lavkaShop() throws InterruptedException {
        lavkaPage.fieldUtvar();
        Thread.sleep(7000);
        lavkaPage.fieldChetki();
        lavkaPage.fieldTovar();
        lavkaPage.fieldNumber();
        lavkaPage.fielfSetNumber("2");
        LavkaPage lav = lavkaPage.buttonCustomer();
        Thread.sleep(3000);
        String number1 = lav.numberCustom();
        Assert.assertEquals("2", number1);
        LavkaPage Mon = lavkaPage.fieldWindow();
        String SumMoney = Mon.money();
        Assert.assertEquals("1 800,00 руб.", SumMoney);
        lavkaPage.fieldDelete();
        lavkaPage.fieldAlert();
    }

    @Test
    public void fieldMenu() {
        lavkaPage.fieldUtvar();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavkaPage.fieldChetki();
        List<WebElement> stringList = lavkaPage.stringListMenu();
        for (WebElement element: stringList) {
            System.out.println((element.getText()));
            Assert.assertTrue(element.getText().contains("Четки"));
        }

    }
    @Test
    public void formatmenu() {
        lavkaPage.fieldUtvar();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavkaPage.fieldChetki();
        lavkaPage.formatOption("900");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("900","900");
        lavkaPage.formatOption("550");
        Assert.assertEquals("550", "550");
    }
    @Test
    public void menuFieldItems() {
        lavkaPage.fieldUtvar();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavkaPage.fieldChetki();
        List<WebElement> ellement = lavkaPage.itemsProduct();
        System.out.println(ellement.size());
        for (WebElement element: ellement) {
            System.out.println(element.getText());
            System.out.println(ellement.get(5).getText());
            Assert.assertTrue(ellement.get(5).getText().contains("126"));
        }

    }
    @Test
    public void itemsTeam() {
        lavkaPage.fieldUtvar();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavkaPage.fieldChetki();
        List<WebElement> ellements = lavkaPage.itemsProduct();
        ArrayList<String> ellementsText =new ArrayList<String>();
        for (WebElement elllle : ellements)
            ellementsText.add(elllle.getText());
        System.out.println(ellements.size());
        for (WebElement ellement : ellements) {
            System.out.println(ellement.getText());
            if (ellements.size() == 11) System.out.println("EllementTrue");
            else System.out.println("Non");
        }
        assertThat(ellementsText, hasItems(containsString("Браслет"),
                containsString("Четки")));

    }

   @After
   public void tearDown(){
        driver.quit();
    }
}
