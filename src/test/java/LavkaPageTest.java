import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://lavka-obitel.ru/");
        String mainTab2 = driver.getWindowHandle();
        lavkaPage = new LavkaPage(driver);
    }

    @Test
    public void sumElement() throws InterruptedException {
        Thread.sleep(7000);
        lavkaPage.fieldUtvar();
        LavkaPage clickSlay=lavkaPage.fieldChetki();
        Thread.sleep(5000);
        String firstSlay = clickSlay.slaiderNew();
        Assert.assertEquals("105 руб.", firstSlay);
        String secondSlay = clickSlay.fieldStringSlay();
        Assert.assertEquals("1 200,99 руб.", secondSlay);
        LavkaPage cliderNow = lavkaPage.sliderClick();
        Thread.sleep(7000);
        String slaiderText = cliderNow.slaiderNew();
        Assert.assertEquals("642 руб.", slaiderText);
        LavkaPage clayNow = lavkaPage.newSlayderClick();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String newSlayderText = clayNow.fieldStringSlay();
        Assert.assertEquals("700,99 руб.", newSlayderText);
    }

    @Test
    public void arrayListItems() throws InterruptedException {
        Thread.sleep(7000);
        lavkaPage.fieldUtvar();
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
    public void itemsFlame() throws InterruptedException {
        Thread.sleep(7000);
        lavkaPage.fieldUtvar();
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
    public void fieldMenu() throws InterruptedException {
        Thread.sleep(8000);
        lavkaPage.fieldUtvar();
        lavkaPage.fieldChetki();
        List<WebElement> stringList = lavkaPage.stringListMenu();
        for (WebElement element: stringList) {
            System.out.println((element.getText()));
            Assert.assertTrue(element.getText().contains("Четки"));
        }
    }

    @Test
    public void formatmenu() throws InterruptedException {
        Thread.sleep(7000);
        lavkaPage.fieldUtvar();
        lavkaPage.fieldChetki();
        lavkaPage.formatOption("900");
        Thread.sleep(5000);
        Assert.assertEquals("900","900");
        lavkaPage.formatOption("550");
        Assert.assertEquals("550", "550");
    }

    @Test
    public void menuFieldItems() throws InterruptedException {
        Thread.sleep(7000);
        lavkaPage.fieldUtvar();
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
    public void itemsTeam() throws InterruptedException {
        Thread.sleep(7000);
        lavkaPage.fieldUtvar();
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
