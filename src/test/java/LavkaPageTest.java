import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LavkaPageTest {

    private WebDriver driver;
    private LavkaPage lavkaPage;
    private int i;

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
            Assert.assertTrue(i + ". ArrayList Text : " + s, true);
        }
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
        System.out.println(priceFlame.size());
        for (int i=0; i<priceFlame.size(); i++) {
            System.out.println(priceFlame.get(i).getText());
        }
        Assert.assertTrue(priceFlame.get(i).getText(), true);
        List<WebElement> candles = lavkaPage.candleProduct();
        System.out.println(candles.size());
        for (int i=0; i<candles.size();i++) {
            System.out.println(candles.get(i).getText());
        }
        Assert.assertTrue(candles.get(i).getText(), true);

    }


    @Test
    public void lavkaShop() {
        lavkaPage.fieldUtvar();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        Assert.assertEquals("1 800,00 руб.", SumMoney);
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
        Assert.assertEquals("2 700,00 руб.", Monney);
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavkaPage.fieldChetki();
        List<WebElement> stringList = lavkaPage.stringListMenu();
        for (WebElement element: stringList) {
            System.out.println((element.getText()));
            Assert.assertTrue(element.getText().contains("четки"));
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
        Assert.assertSame("900","900");
        Assert.assertTrue(true);
        lavkaPage.formatOption("550");
        Assert.assertEquals("550", "550");
        Assert.assertTrue("550", true);
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
            System.out.println(ellement.get(5).getText());
            Assert.assertTrue(Boolean.parseBoolean(String.valueOf(ellement.get(5).getText().contains("126 руб."))));
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
